<template>
  <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      fixed
      prop="date"
      label="审核日期"
      width="150">
    </el-table-column>
    <el-table-column
      prop="id"
      label="活动编号"
      width="120">
    </el-table-column>
    <el-table-column
      prop="name"
      label="活动名称"
      width="120">
    </el-table-column>
    <el-table-column
      prop="community"
      label="社团"
      width="120">
    </el-table-column>
    <el-table-column
      prop="state"
      label="状态"
      width="150">
    </el-table-column>
    <el-table-column
      prop="adminId"
      label="审核人"
      width="120">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="100">
      <template slot-scope="scope">
        <el-button @click="handleClick(scope.row)" type="text" size="small">查看详细信息</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
  export default {
    name: 'Query_Activity'
  }
  export default {
    methods: {
      handleClick(row) {
        console.log(row);
      }
    },
    data() {
      return {
        tableData: [{
          date: '2019-10-02',
          id: '899',
          name: '辩论会',
          community: '辩论社',
          state: '已通过',
          adminId : '管理员1'
        },{
          date: '2019-10-04',
          id: '900',
          name: '音乐会',
          community: '吉他社',
          state: '未通过',
          adminId : '管理员2'
        } ]
      }
    }
  }
</script>

<style scoped>

</style>
