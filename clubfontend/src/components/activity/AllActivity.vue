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
        </el-form>
      </template>
    </el-table-column>
    <el-table-column
      label="活动名称"
      prop="activityname">
    </el-table-column>
    <el-table-column
      label="活动发布时间"
      prop="activitiesapplicationtime">
    </el-table-column>
    <el-table-column
      label="活动报名截止时间"
      prop="activitydeadline">
    </el-table-column>
    <el-table-column
      label="活动开始时间"
      prop="activitystarttime">
    </el-table-column>
    <el-table-column
      label="活动结束时间"
      prop="activityendtime">
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
                        this.$alert(successResponse.data.ErrorResult, '注册失败', {
                            confirmButtonText: '确定',
                        })
                    }
                })
            }
        }

    }
</script>

<style scoped>

</style>
