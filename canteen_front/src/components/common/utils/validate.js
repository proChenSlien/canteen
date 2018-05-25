const validate = {

  // 用户名验证
  userName: function (label) {
    let content = label || '用户名'

    return [
      {required: true, message: '请输入' + content, trigger: 'blur'},
      {
        validator: (rule, value, callback) => {
          if (!/^[0-9A-Za-z_]{5,15}$/.test(value)) {
            callback(new Error(content + '只能是5~15位的字母和数字组合'))
          } else {
            callback()
          }
        },
        trigger: 'blur'
      }
    ]
  },

  // 密码验证
  password: function (label) {
    let content = label || '密码'

    return [
      {required: true, message: '请输入' + content, trigger: 'blur'},
      {
        validator: (rule, value, callback) => {
          if (value.length < 5) {
            callback(new Error(content + '必须是5~12位'))
          } else {
            callback()
          }
        },
        trigger: 'blur'
      }
    ]
  }
}

export { validate }
