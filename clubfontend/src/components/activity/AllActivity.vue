<!--所有全校活动-->
<template>
  <el-table
    :data="tableData.filter(data => !search || data.noticename.toLowerCase().includes(search.toLowerCase()))"
    stripe
    style="width: 100%">
    <el-table-column type="expand">
      <template slot-scope="props">
        <el-form label-position="left" inline class="demo-table-expand">
          <el-form-item label="活动内容">
            <span>{{ props.row.shop }}</span>
          </el-form-item>
        </el-form>
      </template>
    </el-table-column>
    <el-table-column
      label="活动名称"
      prop="noticename">
    </el-table-column>
    <el-table-column
      label="发布时间"
      prop="noticetime">
    </el-table-column>
    <el-table-column
      align="right">
      <template slot-scope="scope">
        <el-button
          size="middle"
          type="primary" plain
          @click="handleEdit(scope.$index, scope.row)">报名参与活动</el-button>
      </template>
      <template slot="header" slot-scope="scope">
        <el-input
          v-model="search"
          size="mini"
          placeholder="输入关键字搜索"/>
      </template>
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
