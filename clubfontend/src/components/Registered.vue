<template>
  <body id="poster">
  <el-form class="register-container" label-position="left"
           label-width="0px">
    <h3 class="login_title">用户注册</h3>
    <el-form-item>
      <el-input type="text" v-model="Registered.userId"
                auto-complete="off" placeholder="学号"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="text" v-model="Registered.userName"
                auto-complete="off" placeholder="名字"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="password" v-model="Registered.userPwd"
                auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="text" v-model="Registered.userSex"
                auto-complete="off" placeholder="性别"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="text" v-model="Registered.userMajor"
                auto-complete="off" placeholder="专业"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="text" v-model="Registered.userClass"
                auto-complete="off" placeholder="班级"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="text" v-model="Registered.userTel"
                auto-complete="off" placeholder="电话"></el-input>
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 100%;background: #505458;border: none" v-on:click="registered">注册</el-button>
    </el-form-item>
  </el-form>
  </body>
</template>

<script>
export default {
  name: 'Registered',
  data () {
    return {
      Registered: {
        userId: '',
        userName: '',
        userPwd: '',
        userSex: '',
        userMajor: '',
        userClass: '',
        userTel: ''
      },
      responseResult: []
    }
  },
  methods: {
    registered () {
      this.$router.replace({path: '/login'})
    }
  }
}
</script>

<style>
  .register-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 90px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }

  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }

  #poster {
    background:url("../assets/batman.jpg") no-repeat;
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }
  body{
    margin: 0px;
  }
</style>
