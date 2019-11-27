<template>
  <body id="poster">
  <el-form class="register-container" label-position="left"
           label-width="0px">
    <h3 class="register_title">用户注册</h3>
    <el-form-item>
      <el-input type="text" v-model="Registered.userId"
                auto-complete="off" placeholder="学号"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="text" v-model="Registered.userName"
                auto-complete="off" placeholder="名字"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="password" v-model="Registered.newPwd"
                auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="password" v-model="Registered.oldPwd"
                auto-complete="off" placeholder="请重复密码"></el-input>
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
  import  qs from 'qs'
export default {
  name: 'Registered',
  data () {
    return {
      Registered: {
        userId: '',
        userName: '',
        newPwd: '',
        oldPwd:'',
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
        var dataObj = qs.stringify(this.Registered);
        this.$axios({
                method: 'post',
                url: '/register',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                data: dataObj, // 直接提交转换后的数据即可
            },
        ).then(successResponse => {
            if (successResponse.data.port === 200) {
                this.$router.replace({path: '/login'})
            }
            if(successResponse.data.port ===401){
                this.$alert(successResponse.data.ErrorResult, '注册失败', {
                    confirmButtonText: '确定',
                })
            }
        })
    }
  }
}
</script>

<style>
  .register-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 40px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }

  .register_title {
    margin: 0px auto 20px auto;
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
