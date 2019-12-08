<template>
  <el-container style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <el-header style="text-align: center; font-size: 20px; height: 50px;line-height: 50px; background-color: lightsteelblue">
      <span style="letter-spacing: 20px; ">所有社团</span>
    </el-header>
    <el-main>
      <el-table
        :data="tableData.filter(data => !search || data.username.toLowerCase().includes(search.toLowerCase()))"
        ref="filterTable"
        stripe
        style="width: 100%">
        <el-table-column
          label="社团编号"
          prop="associationsId">
        </el-table-column>
        <el-table-column
          label="社团名称"
          prop="associationsName">
        </el-table-column>
        <el-table-column
          label="建立时间"
          prop="associationsApplicationTime"
          sortable>
        </el-table-column>
        <el-table-column
          label="社团类别"
          prop="associationsType"
          :filters="[{text: '学术类', value: '学术类'}, {text: '体育类', value: '体育类'}, {text: '艺术类', value: '艺术类'}, {text: '公益类', value: '公益类'}, {text: '科技类', value: '科技类'}]"
          :filter-method="filterRange">
        </el-table-column>
      </el-table>
    </el-main>
  </el-container>
</template>

<script>
  import qs from 'qs'
export default {
  name: 'clubManagement',
  data () {
    return {
      tableData: [ ]
    }
  },
  mounted () {
      var data = qs.stringify({associationstate:'审核通过'});
      // console.log(data)
      this.$axios({
              method: 'post',
              url: '/allassociationsbystate',
              headers: {
                  'Content-Type': 'application/x-www-form-urlencoded'
              },
              data: data, // 直接提交转换后的数据即可
          },
      ).then(successResponse => {
          // console.log(successResponse.data.allassociationsbystate[0].port)
          if (successResponse.data.allassociationsbystate[0].port) {
              this.tableData = successResponse.data.allassociationsbystate
          }
      })
  },
  methods: {
    filterState (value, row) {
      return row.noticestate === value
    },
    filterRange (value, row, column) {
      const property = column['property']
      return row[property] === value
    }
  }
}
</script>

<style scoped>

</style>
