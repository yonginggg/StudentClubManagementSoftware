<template>
  <body id="poster">
  <el-form class="login-container" label-position="left"
           label-width="0px">
    <h3 class="login_title">系统登录</h3>



    <el-form-item>
      <el-input type="text" v-model="loginForm.userId"
                auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="password" v-model="loginForm.userPwd"
                auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>

    <el-form-item >
      <el-select v-model="loginForm.type" placeholder="登录用户">
        <el-option label="学生" value="学生"></el-option>
        <el-option label="管理员" value="管理员"></el-option>
      </el-select>
    </el-form-item>

    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 100%;background: #505458;border: none; float: left" v-on:click="login">
        登录
      </el-button>
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 100%;background: #505458;border: none; float: right"
                 v-on:click="registered">注册
      </el-button>
    </el-form-item>
  </el-form>
  </body>
</template>

<script>
    import qs from 'qs'

    export default {
        name: 'Login',
        data() {
            return {
                loginForm: {
                    userId: '',
                    userPwd: '',
                    type:''
                },
            }
        },
        methods: {
            login() {
                var dataObj = qs.stringify(this.loginForm);
                var _this = this
                // console.log(this.$store.state.user.userId)
                this.$axios({
                        method: 'post',
                        url: '/login',
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded'
                        },
                        data: dataObj, // 直接提交转换后的数据即可
                    },
                ).then(successResponse => {
                    // console.log(successResponse.data);
                    if (successResponse.data.port === 200) {
                      console.log(successResponse.data)
                        // _this.$store.commit('login', _this.loginForm)
                        this.$router.replace({path: '/index'})
                    }
                    if(successResponse.data.port === 401){
                        this.$alert(successResponse.data.ErrorResult, '登录失败', {
                            confirmButtonText: '确定',
                        })
                    }
                })
            },
            registered() {
                this.$router
                    .replace({path: '/registered'})
            }
        }
    }
</script>

<style>
  .login-container {
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
    background: url("../assets/batman.jpg") no-repeat;
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }

  body {
    margin: 0px;
  }
</style>
