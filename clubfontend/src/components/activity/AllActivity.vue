<template>
  <el-table
    :data="tableData.filter(data => !search || data.noticename.toLowerCase().includes(search.toLowerCase()))"
    stripe
    style="width: 100%">
    <el-table-column
      label="公告名称"
      prop="noticename">
    </el-table-column>
    <el-table-column
      label="公告内容"
      prop="noticetcontent">
    </el-table-column>
    <el-table-column
      label="发布时间"
      prop="noticetime">
    </el-table-column>
    <el-table-column
      align="right">
      <template slot="header" slot-scope="scope">
        <el-input
          v-model="search"
          size="mini"
          placeholder="输入关键字搜索"/>
      </template>
<!--      <template slot-scope="scope">-->
<!--        <el-button-->
<!--          size="middle"-->
<!--          @click="handleEdit(scope.$index, scope.row)">重置密码</el-button>-->
<!--      </template>-->
    </el-table-column>
  </el-table>
</template>

<script>
    export default {
        name: "AllActivity",
        data() {
            return {
                tableData: [],
                search: ''
            }
        },
        mounted() {
            this.$axios.get("/noticebyschool")
                .then(response => {
                    this.tableData = response.data.noticebyschool
                    console.log(this.tableData)
                })
        }

    }
</script>

<style scoped>

</style>
