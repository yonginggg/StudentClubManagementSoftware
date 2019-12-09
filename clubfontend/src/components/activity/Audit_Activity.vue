<!--管理员查看所有活动-->
<template>
  <div id="app" style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="活动编号">
              <span>{{ props.row.activityid }}</span>
            </el-form-item>
            <el-form-item label="活动名称">
              <span>{{ props.row.activityname }}</span>
            </el-form-item>
            <el-form-item label="活动内容">
              <span>{{ props.row.activityintroduction }}</span>
            </el-form-item>
            <el-form-item label="活动地点">
              <span>{{ props.row.activitypalce}}</span>
            </el-form-item>
            <el-form-item label="申请社团">
              <span>{{ props.row.associationsname }}</span>
            </el-form-item>
            <el-form-item label="申请部门">
              <span>{{ props.row.departmentid }}</span>
            </el-form-item>
            <el-form-item label="开始时间">
              <span>{{ props.row.activitystarttime }}</span>
            </el-form-item>
            <el-form-item label="结束时间">
              <span>{{ props.row.activityendtime }}</span>
            </el-form-item>
            <el-form-item label="发布时间">
              <span>{{ props.row.activitiesapplicationtime }}</span>
            </el-form-item>
            <el-form-item label="截止时间">
              <span>{{ props.row.activitydeadline }}</span>
            </el-form-item>
          </el-form>
        </template>

      </el-table-column>
      <el-table-column
        label="活动编号"
        prop="activityid">
      </el-table-column>
      <el-table-column
        label="活动名称"
        prop="activityname">
      </el-table-column>
      <el-table-column
        label="申请社团"
        prop="associationsname">
      </el-table-column>

      <el-table-column>
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="success"
            @click="ok(scope.$index, scope.row)">通过
          </el-button>
          <el-button
            size="mini"
            type="danger"
            v-on:click="no(scope.$index, scope.row)">不通过
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
    import qs from 'qs'
    export default {
        name: 'Audit_Activity',
        data () {
            return {
                data:{

                },
                tableData: [],
            }
        },
        mounted() {
            this.data.type= 1
            var dataObj = qs.stringify(this.data)
            console.log(dataObj)
            this.$axios({
                    method: 'post',
                    url: '/allactivity',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    },
                    data: dataObj, // 直接提交转换后的数据即可
                },
            ).then(successResponse => {
                // console.log(successResponse.data.allactivity[0].port)
                if (successResponse.data.allactivity[0].port === 200) {
                    this.tableData = successResponse.data.allactivity
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
        methods: {
            ok(index, rows) {
                rows.answer = true
                // console.log(rows)
                var data = qs.stringify(rows);
                // console.log(data)
                this.$axios({
                        method: 'post',
                        url: '/examineactivity',
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded'
                        },
                        data: data, // 直接提交转换后的数据即可
                    },
                ).then(successResponse => {
                    if (successResponse.data.port === 200) {
                        // this.$router.replace({path: '/login'})
                        // console.log("success")
                        this.$message({
                            message: '审核通过',
                            type: 'success'
                        });
                    }
                    if (successResponse.data.port === 401) {
                        this.$message.error({
                            message: successResponse.data.ErrorResult
                        });
                    }
                    setTimeout(function(){  //使用  setTimeout（）方法设定定时2000毫秒
                        window.location.reload();//页面刷新
                    },1000);
                })
            },
            no(index, rows) {
                rows.answer = false
                // console.log(rows)
                var data = qs.stringify(rows);
                // console.log(data)
                this.$axios({
                        method: 'post',
                        url: '/examineactivity',
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded'
                        },
                        data: data, // 直接提交转换后的数据即可
                    },
                ).then(successResponse => {
                    if (successResponse.data.port === 200) {
                        // this.$router.replace({path: '/login'})
                        // console.log("success")
                        this.$message({
                            message: '审核拒绝',
                            type: 'success'
                        });
                    }
                    if (successResponse.data.port === 401) {
                        this.$message.error({
                            message: successResponse.data.ErrorResult
                        });
                    }
                    setTimeout(function(){  //使用  setTimeout（）方法设定定时2000毫秒
                        window.location.reload();//页面刷新
                    },1000);
                })
            }
        }
    }
</script>
<style>
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
