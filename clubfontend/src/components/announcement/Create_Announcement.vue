<template>
  <div style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <el-form :model="ruleForm" ref="ruleForm" label-width="100px" class="demo-ruleForm" style="width: 70%; margin-left: 15%; margin-top: 15%" >
      <el-form-item label="公告名称" prop="name" style="margin-bottom: 7%">
        <el-input v-model="ruleForm.noticeName"></el-input>
      </el-form-item>
      <el-form-item label="公告内容" prop="desc" style="margin-bottom: 7%">
<!--        <el-input type="textarea" v-model="ruleForm.noticeContent"></el-input>-->
        <el-input
          type="textarea"
          placeholder="请输入内容"
          v-model="ruleForm.noticeContent"
          maxlength="100"
          show-word-limit
          :rows="10"
        >
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')" style="">立即创建</el-button>
      </el-form-item>
    </el-form>
  </div>

</template>
<script>
  import  qs from 'qs'
export default {
  name: 'Create_Announcement',
  data () {
    return {
      ruleForm: {
        noticeName: '',
        noticeContent: ''
      },
    }
  },
  methods: {
    submitForm () {
      var that = this;
      var nd = qs.stringify(that.ruleForm);
      // alert(nd.toString())
      this.$axios({
          method: 'post',
          url: '/createmanagernotice',
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
          },
          data: nd, // 直接提交转换后的数据即可
        },
      ).then(successResponse => {
        this.$message({
          message: '公告发布成功',
          type: 'success'
        });
        setTimeout(function(){  //使用  setTimeout（）方法设定定时2000毫秒
          window.location.reload();//页面刷新
        },1000);
      })
    },
  }
}
</script>

<style scoped>

</style>
