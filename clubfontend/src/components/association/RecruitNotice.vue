<template>
  <el-container style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
  <el-header style="text-align: center; font-size: 20px; height: 50px;line-height: 50px; background-color: lightsteelblue">
    <span style="letter-spacing: 20px; ">社团招新</span>
  </el-header>
  <el-main>
      <template>
        <el-table
          :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
          style="width: 100%">
          <el-table-column
            label="社团名字"
            prop="userid">
          </el-table-column>
          <el-table-column
            label="招新内容"
            prop="username">
          </el-table-column>
          <el-table-column
            label="招新截止时间"
            prop="usermajor">
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
                @click="handleEdit(scope.$index, scope.row)">报名</el-button>
            </template>
          </el-table-column>
        </el-table>
      </template>
  </el-main>
  </el-container>
</template>

<script>
    export default {
        name: "RecruitNotice",
        data() {
            return {
                tableData: [],
                search: ''
            }
        },
        mounted() {
            this.$axios.get("/allrecruitnotice ")
                .then(response => {
                    this.tableData = response.data.alluser
                    console.log(this.tableData)
                })
        }
    }
</script>

<style scoped>

</style>
