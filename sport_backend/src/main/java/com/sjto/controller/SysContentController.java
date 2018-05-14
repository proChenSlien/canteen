package com.sjto.controller;

import com.sjto.utils.PrimaryKeyUtil;
import com.sjto.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.apache.commons.io.FileUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author : lf
 * @Date : 2018-03-31
 */

@Api(value = "图片接口", tags = {"图片相关"})
@RestController
@RequestMapping("/app/sport")
public class SysContentController {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${imagePath}")
    private String imagePath;

    @Autowired
    private ResourceLoader resourceLoader;

    @ApiOperation(value = "针对小程序的图片上传")
    @PostMapping("/wxUploadImg")
    public Result uploadPicture(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<String> names = new ArrayList<>();
        File dir = new File(imagePath + "cache");

        request.setCharacterEncoding("utf-8");  //设置编码
        //获得磁盘文件条目工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();

        //如果没以下两行设置的话,上传大的文件会占用很多内存，
        //设置暂时存放的存储室,这个存储室可以和最终存储文件的目录不同
        /**
         * 原理: 它是先存到暂时存储室，然后再真正写到对应目录的硬盘上，
         * 按理来说当上传一个文件时，其实是上传了两份，第一个是以 .tem 格式的
         * 然后再将其真正写到对应目录的硬盘上
         */
        factory.setRepository(dir);
        //设置缓存的大小，当上传文件的容量超过该缓存时，直接放到暂时存储室
        factory.setSizeThreshold(1024 * 1024);
        //高水平的API文件上传处理
        ServletFileUpload upload = new ServletFileUpload(factory);
        FileItemIterator it = upload.getItemIterator(request);
        while (it.hasNext()) {
            FileItemStream item = it.next();
            String name = PrimaryKeyUtil.getTableID();
            this.uploadFileUtil(item.openStream(), name);
            names.add(name);
        }
        return Result.createBySuccess("data", names);
    }

    /**
     * 图片上传
     *
     * @param file
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "图片上传Form方式")
    @PostMapping("/uploadImg")
    public Result uploadImg(@RequestParam MultipartFile file[], MultipartHttpServletRequest request) throws Exception {
        Map<String, MultipartFile> map = request.getFileMap();

        List<String> names = new ArrayList<>();
        for (MultipartFile f : file) {
            // 图片的名字用毫秒数+图片原来的名字拼接
            String imgName = PrimaryKeyUtil.getTableID();
            names.add(imgName);
            //上传文件
            uploadFileUtil(f.getBytes(), imgName);
        }

        return Result.createBySuccess("data", names);
    }


    /**
     * 图片显示
     *
     * @param filename
     * @return
     */
    @ApiOperation(value = "图片删除")
    @GetMapping("/imgDelete/{filename:.+}")
    public Result imgDelete(@PathVariable String filename) {
        filename = filename.indexOf(".") > 0 ? filename.substring(0, filename.indexOf(".")) : filename;
        String path = this.getFilePath(filename);
        File file = new File(path + filename);
        if (file.exists()) {
            file.delete();
        } else {
            return Result.createByErrorCodeMessage(404,"文件不存在");
        }
        return Result.createBySuccess();
    }

    @ApiOperation(value = "图片对象")
    @GetMapping("/image/{filename:.+}")
    public ResponseEntity img(@PathVariable String filename, HttpServletResponse response) {
        response.setContentType("image/jpeg");
        try {
            filename = filename.substring(0, filename.indexOf("."));
            String path = this.getFilePath(filename);
            log.info("文件：" + "file:" + Paths.get(path, filename).toString());
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(path, filename)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiOperation(value = "图片流")
    @GetMapping("/imgStream/{filename:.+}")
    public ResponseEntity<byte[]> imgStream(@PathVariable String filename, HttpServletResponse response) throws IOException {
        filename = filename.substring(0, filename.indexOf("."));
        String path = this.getFilePath(filename);
        log.info("文件：" + "file:" + Paths.get(path, filename).toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", filename);
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(path + filename)),
                headers, HttpStatus.OK);
    }

    private String getFilePath(String filename) {
        int length = filename.length();
        return imagePath + filename.substring(length - 4, length - 2) + File.separator + filename.substring(length - 2, length) + File.separator;
    }

    /**
     * 上传文件的方法
     *
     * @param file：文件的字节
     * @param imgName：文件的名字
     * @throws Exception
     */
    private void uploadFileUtil(byte[] file, String imgName) throws Exception {
        String path = this.getFilePath(imgName);
        File targetFile = new File(path);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        log.info("图片上传：" + path + imgName);
        FileOutputStream out = new FileOutputStream(path + imgName);
        out.write(file);
        out.flush();
        out.close();
    }


    private void uploadFileUtil(InputStream in, String imgName) throws Exception {
        String path = this.getFilePath(imgName);
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        OutputStream out = new FileOutputStream(path + imgName);
        int length = 0;
        byte[] buf = new byte[1024];
        // in.read(buf) 每次读到的数据存放在buf 数组中
        while ((length = in.read(buf)) != -1) {
            //在buf数组中取出数据写到（输出流）磁盘上
            out.write(buf, 0, length);
        }
        in.close();
        out.close();
    }
}
