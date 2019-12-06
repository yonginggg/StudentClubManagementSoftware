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
          prop="id">
        </el-table-column>
        <el-table-column
          label="社团名称"
          prop="name">
        </el-table-column>
        <el-table-column
          label="建立时间"
          prop="time"
          sortable>
        </el-table-column>
        <el-table-column
          label="社团类别"
          prop="category"
          :filters="[{text: '学术类', value: '学术类'}, {text: '体育类', value: '体育类'}, {text: '艺术类', value: '艺术类'}, {text: '公益类', value: '公益类'}, {text: '科技类', value: '科技类'}]"
          :filter-method="filterRange">
        </el-table-column>
        <el-table-column
          align="right">
          <template slot-scope="scope">
            <el-button
              size="middle"
              type="primary" plain
              @click="handleEdit(scope.$index, scope.row)">同意</el-button>
            <el-button
              size="middle"
              type="danger" plain
              @click="handleEdit(scope.$index, scope.row)">拒绝</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'clubManagement',
  data () {
    return {
      tableData: [ ]
    }
  },
  mounted () {
    this.$axios.get('/allnotice')
      .then(response => {
        this.tableData = response.data.allnotice
        console.log(this.tableData)
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
