<!--创建社团-->
<template>
  <div id="app" style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <el-form ref="form" :model="form" label-width="80px">
      <el-header style="text-align: center; font-size: 30px; background-color: lightsteelblue">
        <span style="letter-spacing: 30px; ">创建社团</span>
      </el-header>
      <dev id="create" style="position: relative; left: 250px; top:100px" >
        <el-form-item label="社团名称" style="width: 400px" >
          <el-input v-model="form.associationsName"  placeholder="请输入内容 10字以内" maxlength="10" show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="社团类型" style="width: 300px" >
          <el-select v-model="form.associationsType" placeholder="请选择社团类型" >
            <el-option label="学术类" value="学术类"></el-option>
            <el-option label="体育类" value="体育类"></el-option>
            <el-option label="艺术类" value="艺术类"></el-option>
            <el-option label="公益类" value="公益类"></el-option>
            <el-option label="科技类" value="科技类"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="社长学号" style="width: 200px" >
          <el-input placeholder="31701052"
                    v-model="form.associationsLeader"
                    :disabled="true">
          </el-input>
        </el-form-item>
        <el-form-item label="申请理由"  style="width: 600px"  >
          <el-input  type="textarea" v-model="form.associationsIntroduction" :autosize="{ minRows: 5, maxRows: 10}" placeholder="请输入社团介绍,200字以内" maxlength="200" show-word-limit>></el-input>
        </el-form-item>
        <el-form-item style="width: 600px">
          <el-button type="primary" v-on:click="onSubmit">立即创建</el-button>
          <el-button>取消</el-button>
        </el-form-item>
      </dev>
    </el-form>

  </div>
</template>

<script>
    // src="//unpkg.com/vue/dist/vue.js"
    // src="//unpkg.com/element-ui@2.12.0/lib/index.js"
    import  qs from 'qs'
    export default {
        name: 'createassociation',
        data () {
            return {
                form: {
                    associationsName: '',
                    associationsType: '',
                    associationsLeader: this.$store.state.user.userId,
                    associationsIntroduction: ''
                },
                responseResult: []
            }
        },
        methods: {
            onSubmit () {
                var dataObj = qs.stringify(this.form);
                if(this.form.associationsName==''||this.form.associationsType==''||this.form.associationsIntroduction==''){
                  this.$message({
                    message: '信息不能为空',
                    type: 'error'
                  });
                }else{
                  this.$axios({
                      method: 'post',
                      url: '/createassociation',
                      headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                      },
                      data: dataObj, // 直接提交转换后的数据即可
                    },
                  ).then(successResponse => {
                    if (successResponse.data.port === 200) {
                      // this.$alert("congratulations", '创建成功', {
                      //     confirmButtonText: '确定',
                      // })
                      this.$message({
                        message: '请求已发送，注意查收',
                        type: 'success'
                      });
                      setTimeout(function(){  //使用  setTimeout（）方法设定定时2000毫秒
                        window.location.reload();//页面刷新
                      },1000);
                    }
                  })
                }


                // console.log("hello")
            }
        }
    }
</script>

<style scoped>
</style>
