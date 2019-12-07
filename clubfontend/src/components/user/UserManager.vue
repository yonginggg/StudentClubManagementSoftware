<template>
  <el-container id="app" style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <el-header style="text-align: center; font-size: 20px; height: 50px;line-height: 50px; background-color: lightsteelblue">
      <span style="letter-spacing: 20px; ">用户管理</span>
    </el-header>
    <el-main>
      <el-table
        :data="tableData.filter(data => !search || data.username.toLowerCase().includes(search.toLowerCase()))"
        stripe
        style="width: 100%">
        <el-table-column
          label="学号"
          prop="userid">
        </el-table-column>
        <el-table-column
          label="姓名"
          prop="username">
        </el-table-column>
        <el-table-column
          label="专业"
          prop="usermajor">
        </el-table-column>
        <el-table-column
          label="班级"
          prop="userclass">
        </el-table-column>
        <el-table-column
          label="联系方式"
          prop="usertel">
        </el-table-column>
        <el-table-column
          align="right">
          <template slot="header" slot-scope="scope">
            <el-input
              v-model="search"
              size="mini"
              placeholder="用户名字查询"/>
          </template>
          <template slot-scope="scope">
            <el-button
              size="middle"
              @click.native.console="resetpwd(scope.$index, scope.row)">重置密码</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-main>
  </el-container>
</template>

<script>
    import qs from 'qs'
    export default {
        name: "UserManager",
        data() {
            return {
                tableData: [],
                search: ''
            }
        },
        mounted() {
            this.$axios.get("/alluser")
                .then(response => {
                    this.tableData = response.data.alluser
                    // console.log(this.tableData)
                })
        },
        methods : {

            resetpwd(index, rows) {
                var dataObj = qs.stringify(rows);
                // console.log(dataObj)
                this.$axios({
                        method: 'post',
                        url: '/resetPwd',
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded'
                        },
                        data: dataObj, // 直接提交转换后的数据即可
                    },
                ).then(successResponse => {
                    if (successResponse.data.port === 200) {
                        // this.$router.replace({path: '/login'})
                        // console.log("success")
                        this.$message({
                            message: '密码修改成功',
                            type: 'success'
                        });
                    }
                    if (successResponse.data.port === 401) {
                        this.$alert(successResponse.data.ErrorResult, '注册失败', {
                            confirmButtonText: '确定',
                        })
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>
