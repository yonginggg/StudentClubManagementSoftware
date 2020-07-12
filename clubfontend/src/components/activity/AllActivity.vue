<!--学生查看全校活动-->
<template>
  <el-table
    :data="tableData.filter(data => !search || data.noticename.toLowerCase().includes(search.toLowerCase()))"
    stripe
    style="width: 100%">
    <el-table-column type="expand">
      <template slot-scope="props">
        <el-form label-position="left" inline class="demo-table-expand">
          <el-form-item label="活动内容">
            <span>{{ props.row.activityintroduction }}</span>
          </el-form-item>
          <el-form-item label="活动发布时间">
            <span>{{ props.row.activitiesapplicationtime }}</span>
          </el-form-item>
          <el-form-item label="活动截止时间">
            <span>{{ props.row.activityendtime }}</span>
          </el-form-item>
        </el-form>
      </template>
    </el-table-column>
    <el-table-column
      label="活动名称"
      prop="activityname">
    </el-table-column>
    <el-table-column
      label="发布者"
      prop="associationsname">
    </el-table-column>
    <el-table-column
      label="地点"
      prop="activitypalce">
    </el-table-column>
    <el-table-column
      label="活动开始时间"
      prop="activitystarttime">
    </el-table-column>
    <el-table-column
      label="报名截止时间"
      prop="activitydeadline">
    </el-table-column>
    <el-table-column
      align="right">
      <template slot-scope="scope">
        <el-button
          size="middle"
          type="primary"
          plain
          @click.native.console="createactivitysign(scope.$index, scope.row)">报名参与活动</el-button>
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
  import qs from 'qs'
    export default {
        name: "AllActivity",
        data() {
            return {
                tableData: [
                ],
                search: ''
            }
        },
        mounted() {
            // console.log(this.$store.state.associationName),
            this.$axios.get("/schoolactivity")
                .then(response => {
                    this.tableData = response.data.schoolactivity
                    // console.log(this.tableData)
                    // console.log(response.data)
                })
        },
        methods : {
            createactivitysign(index, rows) {
                rows.userid = this.$store.state.user.userId
                // console.log(rows)
                var dataObj = qs.stringify(rows);
                // console.log(typeof(dataObj))
                // console.log(dataObj)
                this.$axios({
                        method: 'post',
                        url: '/createactivitysign',
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded'
                        },
                        data: dataObj, // 直接提交转换后的数据即可
                    },
                ).then(successResponse => {
                    if (successResponse.data.port === 200) {
                        // this.$router.replace({path: '/login'})
                        // console.log("success")
                        this.$message({
                            message: '报名活动成功',
                            type: 'success'
                        });
                    }
                    if (successResponse.data.port === 401) {
                        // this.$alert(successResponse.data.ErrorResult, '报名失败', {
                        //     confirmButtonText: '确定',
                        // })
                      this.$message({
                        message: '报名失败： '+successResponse.data.ErrorResult,
                        type: 'error'
                      });
                    }
                })
            }
        }

    }
</script>

<style scoped>
  .demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }
</style>
