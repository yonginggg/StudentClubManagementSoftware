<template>
  <el-container id="shuru">
    <el-form :label-position="left" label-width="150px" :model="pwdInformation">
      <el-form-item label="原密码: ">
        <el-input v-model="pwdInformation.userPwd" placeholder="请输入新密码" type="password"></el-input>
      </el-form-item>
      <el-form-item label="新密码:">
        <el-input v-model="pwdInformation.userNewPwd" placeholder="请输入原密码" type="password"></el-input>
      </el-form-item>
      <el-form-item label="确认密码:">
        <el-input v-model="pwdInformation.userNewPwd2" placeholder="请在此确认密码" type="password"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="confirm('ruleForm')">提交</el-button>
        <el-button @click="cancel('ruleForm')">取消</el-button>
      </el-form-item>
    </el-form>
  </el-container>
</template>

<script>
  import qs from 'qs'
  export default {
    name: 'PasswordInformation',
    data () {
      return {
        pwdInformation: {
          userPwd: '',
          userNewPwd: '',
          userNewPwd2: '',
          userId: this.$store.state.user.userId
        }
      }
    },
    methods: {
      confirm() {
        var dataObj = qs.stringify(this.pwdInformation);
        var _this = this
        // console.log(this.pwdInformation)
        if(this.pwdInformation.userPwd==''||this.pwdInformation.userNewPwd==''||this.pwdInformation.userNewPwd2==''){
          this.$message({
            message: '信息不能为空',
            type: 'error'
          });
        }else{
          this.$axios({
              method: 'post',
              url: '/changePwd',
              headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
              },
              data: dataObj, // 直接提交转换后的数据即可
            },
          ).then(successResponse => {
            if (successResponse.data.port === 200) {
              // _this.$store.commit('login', _this.loginForm)
              // this.$alert("请重新登陆", '修改成功', {
              //   confirmButtonText: '确定',
              // })
              this.$message({
                message: '修改成功，请重新登陆',
                type: 'success'
              })
                // .then(() => {
                  this.$router.replace({path: '/login'})
                // })

            }
            if(successResponse.data.port === 401){
              // this.$alert(successResponse.data.ErrorResult, '修改失败', {
              //   confirmButtonText: '确定',
              // })
              this.$message({
                message: '修改失败： '+successResponse.data.ErrorResult,
                type: 'error'
              });
            }
          })
        }

      },
      cancel() {
        this.$router
          .replace({path: '/index'})
      }
    }
  }
</script>

<style>
  #shuru{
    margin: 20px; margin-left: 350px; margin-top: 200px
  }
</style>
