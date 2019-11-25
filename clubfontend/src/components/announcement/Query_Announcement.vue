<template>
  <el-table
    :data="tableData"
    border
    style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <el-table-column
      fixed
      prop="id"
      label="公告编号"
      width="150">
    </el-table-column>
    <el-table-column
      prop="name"
      label="公告名称"
      width="120">
    </el-table-column>
    <el-table-column
      prop="data1"
      label="开始日期"
      width="150">
    </el-table-column>
    <el-table-column
      prop="data2"
      label="结束时间"
      width="150">
    </el-table-column>
    <el-table-column
      prop="initiator"
      label="发起人"
      width="150">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="120">
      <template slot-scope="scope">
        <el-button @click="handleClick(scope.row)" type="text" size="small">查看详细信息</el-button>

      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  name: 'Query_Announcement',
  methods: {
    handleClick (row) {
      console.log(row)
    }
  },
  data () {
    return {
      tableData: [{
        id: '100',
        name: '服务器维护',
        data1: '2019-1-1',
        data2: '2019-1-10',
        initiator: '管理员1',
        adminId: '管理员1'
      }, {
        id: '101',
        name: '十一放假通知',
        data1: '2019-9-20',
        data2: '2019-10-10',
        initiator: '管理员2'
      } ]
    }
  }
}
</script>

<style scoped>

</style>
