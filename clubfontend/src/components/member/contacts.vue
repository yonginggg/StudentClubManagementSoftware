<!--通讯录-->
<template>
  <el-container style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <el-header style="text-align: center; font-size: 20px; height: 50px;line-height: 50px; background-color: lightsteelblue">
      <span style="letter-spacing: 20px; ">通讯录</span>
    </el-header>
    <el-main>
      <el-table
        :data="tableData"
        style="width: 100%;">
        <el-table-column
          prop="userid"
          label="学号"
          width="180">
        </el-table-column>
        <el-table-column
          prop="username"
          label="姓名"
          width="180">
        </el-table-column>
        <el-table-column
          prop="usersex"
          label="性别"
          width="180">
        </el-table-column>
        <el-table-column
          prop="usermajor"
          label="专业"
          width="180">
        </el-table-column>
        <el-table-column
          prop="userclass"
          label="班级"
          width="180">
        </el-table-column>
        <el-table-column
          prop="usertel"
          label="手机"
          width="180">
        </el-table-column>
        <el-table-column
          prop="memberintroduction"
          label="职务"
          width="180">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="success"
              @click="handleEdit(scope.$index, scope.row)">转让社长</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-main>
  </el-container>
</template>

<script>
  import qs from 'qs'
export default {
  name: 'contacts',
  data () {
    return {
      data:{
      },
      tableData: [],
    }
  },
  mounted () {
    this.data.associationId = sessionStorage.getItem("associationId")
    var dataObj = qs.stringify(this.data)
    console.log(dataObj)
    this.$axios({
        method: 'post',
        url: '/selectMemberByAssociationsId',
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        },
        data: dataObj, // 直接提交转换后的数据即可
      },
    ).then(successResponse => {
      console.log(successResponse.data)
      // {"member":[{"port":200,"memberpost":"社长","departmentid":999999,"membertime":1575952423000,"associationsid":3,"memberintroduction":"Leader","userid":"31701055","memberid":3}]}
      this.tableData = successResponse.data.member
    })
  }
}
</script>

<style scoped>

</style>
