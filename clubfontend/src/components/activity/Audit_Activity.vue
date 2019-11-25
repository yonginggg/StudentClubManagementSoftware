<template>
    <el-table
      :data="tableData"
      border
      style="width: 100%">
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
        prop="data"
        label="活动时间"
        width="120">
      </el-table-column>
      <el-table-column
        prop="community"
        label="申请社团"
        width="120">
      </el-table-column>
      <el-table-column
        prop="address"
        label="活动地点"
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
  import AdminNavMenu from '../admin/AdminNavMenu'
  export default {
    name: 'Audit_Activity'
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
          id: 1000,
          name: '音乐会',
          data: '2019-12-1',
          community: '吉他社',
          address: '南校区风雨操场'
        }, {
          id: 1001,
          name: '篮球比赛',
          data: '2019-12-2',
          community: '篮球社',
          address: '南校区篮球场',
        }]
      }
    }
  }
</script>

<style scoped>

</style>
