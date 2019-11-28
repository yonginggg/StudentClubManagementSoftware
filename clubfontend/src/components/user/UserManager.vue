<template>
  <div id="app" style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <template>
      <el-table
        :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
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
              placeholder="输入关键字搜索"/>
          </template>
          <template slot-scope="scope">
            <el-button
              size="middle"
              @click="handleEdit(scope.$index, scope.row)">重置密码</el-button>
          </template>
        </el-table-column>
      </el-table>
    </template>
  </div>
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
                    console.log(this.tableData)
                })
        }
    }
</script>

<style scoped>

</style>
