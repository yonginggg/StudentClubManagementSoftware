<template>
  <el-container >
    <div style="margin: 20px;"></div>
    <el-form :label-position="left" label-width="150px" :model="personInformation">
      <el-form-item label="账户名称: ">
        <el-input v-model="personInformation.userId" placeholder="请输入账户名称"></el-input>
      </el-form-item>
      <el-form-item label="账户密码:">
        <el-input v-model="personInformation.userPwd" placeholder="请输入账户密码"></el-input>
      </el-form-item>
      <el-form-item label="确认密码:">
        <el-input v-model="personInformation.userPwd2" placeholder="请在此确认密码"></el-input>
      </el-form-item>
      <el-form-item label="联系方式:">
        <el-input v-model="personInformation.userTel" placeholder="请输入手机号"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
        <el-button @click="resetForm('ruleForm')">取消</el-button>
      </el-form-item>
    </el-form>
  </el-container>
</template>

<script>
export default {
  name: 'PerInformation',
  data () {
    return {
      labelPosition: 'right',
      personInformation: {
        userId: '',
        userPwd: '',
        userPwd2: '',
        userTel: ''
      }
    }
  }
//   return {
//     ruleForm: {
//       pass: '',
//       checkPass: '',
//       age: ''
//     },
//     rules: {
//       pass: [
//         { validator: validatePass, trigger: 'blur' }
//       ],
//       checkPass: [
//         { validator: validatePass2, trigger: 'blur' }
//       ],
//       age: [
//         { validator: checkAge, trigger: 'blur' }
//       ]
//     }
//   };
// },
  // methods: {
  //   submitForm (formName) {
  //     this.$refs[formName].validate((valid) => {
  //       if (valid) {
  //         alert('submit!')
  //       } else {
  //         console.log('error submit!!')
  //         return false
  //       }
  //     })
  //   },
  //   resetForm (formName) {
  //     this.$refs[formName].resetFields()
  //   }
  // }
}
</script>

<style scoped>

</style>
