<template>
  <el-table
    :data="tableData"
    border
    style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <el-table-column
      fixed
      prop="id"
      label="活动编号"
      width="150">
    </el-table-column>
    <el-table-column
      prop="name"
      label="活动名称"
      width="120">
    </el-table-column>
    <el-table-column
      prop="community"
      label="申请社团"
      width="120">
    </el-table-column>
    <el-table-column
      prop="state"
      label="活动状态"
      width="120">
    </el-table-column>
    <el-table-column
      prop="change"
      label="修改描述"
      width="300">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="100">
      <template slot-scope="scope">
        <el-button @click="handleClick(scope.row)" type="text" size="small">查看详情</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  name: 'Modify_Activity',
  methods: {
    handleClick (row) {
      console.log(row)
    }
  },
  data () {
    return {
      tableData: [{
        id: 1005,
        name: '足球赛',
        community: '足球社',
        state: '已通过',
        change: '活动地址更改'
      }, {
        id: 1006,
        name: '读书会',
        community: '文学社',
        state: '未通过',
        change: '活动时间更改'
      }]
    }
  }
}
</script>

<style scoped>

</style>
