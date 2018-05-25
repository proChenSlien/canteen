export default {
  props: {
    visible: {
      type: Boolean,
      default: false
    },
  },

  data() {
    return {
      opened: this.visible,
    }
  },
  mounted: function () {
    // console.log(this.opened)
  },

  watch: {
    visible(val) {
      this.opened = val
    },
    opened(val){
      this.$emit("update:visible", val)
    }
  }

}
