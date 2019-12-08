<template>
  <el-container style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <el-header
      style="text-align: center; font-size: 20px; height: 50px;line-height: 50px; background-color: lightsteelblue">
      <span id=assName style="letter-spacing: 20px; ">XX社团</span>
    </el-header>
    <el-main>
      <el-row style="height: 30%">
        <el-button plain type="primary" icon="el-icon-message-solid"
                   style="width: 20% ;height: 70%;font-size: 30px"
                    v-on:click="tonotice">
          公告
        </el-button>
        <el-button plain type="success" icon="el-icon-s-order" style="width: 20% ;height: 70%;font-size: 30px">活动
        </el-button>
        <el-button plain type="warning" icon="el-icon-s-custom" style="width: 20% ;height: 70%;font-size: 30px">通讯录
        </el-button>
        <el-button plain type="danger" icon="el-icon-s-tools" style="width: 20% ;height: 70%;font-size: 30px"
                   @click="createdepartment = true">创建部门
        </el-button>

        <el-dialog title="创建部门" :visible.sync="createdepartment" style="width:1000px;margin-left: 350px">
          <el-form :model="form" >
            <el-form-item label="部门名称" :label-width="formLabelWidth">
              <el-input v-model="form.name" autocomplete="off" style="width: 200px"></el-input>
            </el-form-item>
            <el-form-item label="候选人" :label-width="formLabelWidth">
              <el-select v-model="form.user" placeholder="请选择活动区域" style="width: 200px">
                <el-option label="区域一" value="shanghai" ></el-option>
                <el-option label="区域二" value="beijing"></el-option>
              </el-select>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="createdepartment = false">取 消</el-button>
            <el-button type="primary" @click="createdepartment = false">确 定</el-button>
          </div>
        </el-dialog>
      </el-row>
      <el-card style="font-size: 20px;text-align: left">
        <div slot="header" style="font-size: 30px;text-align: center">
          <span>社团介绍</span>
        </div>
        UTALK 友谈协会，下方是一个笑脸，表明我们社团十分有爱，是一个很欢乐的大家庭，同时笑脸里面表明了社团名称和社团创建时间。最后是我们社团的口号，激励大家积极勇敢说英语。
      </el-card>
    </el-main>

  </el-container>
</template>

<script>
    export default {
        name: 'clubIndex',
        data(){
            return{
                createdepartment:false,
                form: {
                    name: '',
                    user: ''
                },
                formLabelWidth: '120px'
            }
        },
        methods : {
            tonotice(){
                this.$router.replace({path: '/clubnotice'})
            }
        },
        mounted() {
            // console.log(this.$store.state.user.userPwd)
            document.getElementById("assName").innerHTML = this.$store.state.associationName;
        }
    }
</script>

<style scoped>

</style>
