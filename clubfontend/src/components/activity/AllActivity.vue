<template>
  <el-table
    :data="tableData"
    height="250"
    border
    style="width: 100%">
    <el-table-column
      prop="date"
      label="日期"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="活动名称"
      width="180">
    </el-table-column>
    <el-table-column
      prop="address"
      label="活动地址">
    </el-table-column>
    <el-table-column
      prop="introduction"
      label="活动内容">
    </el-table-column>
  </el-table>
</template>

<script>
    export default {
        name: "AllActivity",
        data() {
            return {
                tableData: [{
                    date: '2016-05-03',
                    name: '踏青',
                    address: '上海市普陀区金沙江路 1518 弄',
                    introduction: '去胡同踏青'
                }, {
                    date: '2016-05-02',
                    name: '郊游',
                    address: '上海市普陀区金沙江路 1518 弄',
                    introduction: '去郊游'
                }]
            }
        }

    }
</script>

<style scoped>

</style>
