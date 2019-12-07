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
              @click.native.console="console(scope.$index, scope.row)">重置密码</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-main>
  </el-container>
</template>

<script>
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
            console(index, rows) {
                console.log(rows.userid)
            }
        }
    }
</script>

<style scoped>

</style>
