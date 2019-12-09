<!--社团活动-->
<template>
  <!--社团活动-->
  <div id="app" style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <span style="letter-spacing: 20px; ">社团活动</span>
    <el-table
      :data="tableData.filter(data => !search || tableData.activityname.toLowerCase().includes(search.toLowerCase()))"
      stripe
      style="width: 100%">
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="活动名称">
              <span>{{ props.row.activityname }}</span>
            </el-form-item>
            <el-form-item label="活动内容">
              <span>{{ props.row.activityintroduction }}</span>
            </el-form-item>
            <el-form-item label="活动社团">
              <span>{{ props.row.associationsname }}</span>
            </el-form-item>
            <el-form-item label="活动部门">
              <span>{{ props.row.departmentname }}</span>
            </el-form-item>
            <el-form-item label="活动开始时间">
              <span>{{ props.row.activitystarttime }}</span>
            </el-form-item>
            <el-form-item label="活动结束时间">
              <span>{{ props.row.activityendtime }}</span>
            </el-form-item>
            <el-form-item label="报名截止时间">
              <span>{{ props.row.activityreleasetime }}</span>
            </el-form-item>
            <el-form-item label="活动地点">
              <span>{{ props.row.activitypalce}}</span>
            </el-form-item>

          </el-form>
        </template>
      </el-table-column>
      <el-table-column
        label="活动名称"
        prop="activityname">
      </el-table-column>
      <el-table-column
        label="活动社团"
        prop="associationsname">
      </el-table-column>
      <el-table-column
        label="活动时间"
        prop="activitystarttime">
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
      </el-table-column>
    </el-table>
<!--    <span style="letter-spacing: 20px; ">部门活动</span>-->
<!--    <el-table-->
<!--      :data="tableData"-->
<!--      style="width: 100%; height: 40% ">-->
<!--      <el-table-column type="expand">-->
<!--        <template slot-scope="props">-->
<!--          <el-form label-position="left" inline class="demo-table-expand">-->
<!--            <el-form-item label="活动名称">-->
<!--              <span>{{ props.row.name }}</span>-->
<!--            </el-form-item>-->
<!--            <el-form-item label="活动社团">-->
<!--              <span>{{ props.row.club }}</span>-->
<!--            </el-form-item>-->
<!--            <el-form-item label="活动时间">-->
<!--              <span>{{ props.row.activityTime }}</span>-->
<!--            </el-form-item>-->
<!--            <el-form-item label="发布时间">-->
<!--              <span>{{ props.row.releaseTime }}</span>-->
<!--            </el-form-item>-->
<!--            <el-form-item label="活动地点">-->
<!--              <span>{{ props.row.place}}</span>-->
<!--            </el-form-item>-->
<!--            <el-form-item label="活动内容">-->
<!--              <span>{{ props.row.content }}</span>-->
<!--            </el-form-item>-->
<!--          </el-form>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--      <el-table-column-->
<!--        label="活动名称"-->
<!--        prop="name">-->
<!--      </el-table-column>-->
<!--      <el-table-column-->
<!--        label="活动社团"-->
<!--        prop="club">-->
<!--      </el-table-column>-->
<!--      <el-table-column-->
<!--        label="活动时间"-->
<!--        prop="activityTime">-->
<!--      </el-table-column>-->
<!--      <el-table-column label="操作">-->
<!--        <template slot-scope="scope">-->
<!--          <el-button-->
<!--            size="mini"-->
<!--            type="search"-->
<!--            @click="handleEdit(scope.$index, scope.row)">通过-->
<!--          </el-button>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--      <el-table-column-->
<!--        align="right">-->
<!--        <template slot="header" slot-scope="scope">-->
<!--          <el-input-->
<!--            v-model="search"-->
<!--            size="mini"-->
<!--            placeholder="输入关键字搜索"/>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--    </el-table>-->
  </div>
</template>

<script>
  import qs from 'qs'
    export default {
        name: 'ClubActivity',
        data() {
            return {
                data:{
                },
                tableData: [],
                departmentActivity: [],
                search: ''
            }
        },
        mounted() {
            // console.log(this.$store.state.associationName),
            this.data.post = this.$store.state.memberPost
            this.data.associationName = this.$store.state.associationName
            this.data.departmentId = this.$store.state.departmentId
            var dataObj = qs.stringify(this.data)
            console.log(dataObj)
            this.$axios({
                    method: 'post',
                    url: '/associationactivity',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    },
                    data: dataObj, // 直接提交转换后的数据即可
                },
            ).then(successResponse => {
                // console.log(successResponse.data.associationactivity[0].port)
                if (successResponse.data.associationactivity[0].port === 200) {
                    // this.$router.replace({path: '/login'})
                    // console.log("success")
                    this.tableData = successResponse.data.associationactivity
                    // console.log(successResponse.data.associationactivity[0])
                    this.$message({
                        message: '获取数据成功',
                        type: 'success'
                    });
                }
                if (successResponse.data.port === 401) {
                    this.$message.error({
                        message: '获取数据失败'
                    });
                }

            })
        },
        methods : {
            createactivitysign(index, rows) {
                rows.userid = this.$store.state.user.userId
                var dataObj = qs.stringify(rows);
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
                    setTimeout(function(){  //使用  setTimeout（）方法设定定时2000毫秒
                        window.location.reload();//页面刷新
                    },1000);
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
