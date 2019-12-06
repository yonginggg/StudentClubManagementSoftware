<template>
  <div id="app" style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
  <el-table
    :data="tableData"
    style="width: 100%">
    <el-table-column type="expand">
      <template slot-scope="props">
        <el-form label-position="left" inline class="demo-table-expand">
          <el-form-item label="活动编号">
            <span>{{ props.row.id }}</span>
          </el-form-item>
          <el-form-item label="活动名称">
            <span>{{ props.row.name }}</span>
          </el-form-item>
          <el-form-item label="申请社团">
            <span>{{ props.row.club }}</span>
          </el-form-item>
          <el-form-item label="活动时间">
            <span>{{ props.row.activityTime }}</span>
          </el-form-item>
          <el-form-item label="发布时间">
            <span>{{ props.row.releaseTime }}</span>
          </el-form-item>
          <el-form-item label="活动地点">
            <span>{{ props.row.place}}</span>
          </el-form-item>
          <el-form-item label="活动内容">
            <span>{{ props.row.content }}</span>
          </el-form-item>
        </el-form>
      </template>

    </el-table-column>
    <el-table-column
      label="活动编号"
      prop="id">
    </el-table-column>
    <el-table-column
      label="活动名称"
      prop="name">
    </el-table-column>
    <el-table-column
      label="申请社团"
      prop="club">
    </el-table-column>
    <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button
          size="mini"
          type="success"
          @click="handleEdit(scope.$index, scope.row)">通过</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">不通过</el-button>
      </template>
    </el-table-column>
  </el-table>
  </div>
</template>/

<script>
    export default {
        name: "Audit_Activity",
        data() {
            return {
               /* tableData: [{
                    id: '12987122',
                    name: '足球赛',
                    club: '足球社',
                    activityTime: '2019-1-20',
                    releaseTime: '2019-1-10',
                    place: '足球场',
                    content: '足球比赛'
                },{
                id: '12987122',
                    name: '足球赛',
                    club: '足球社',
                    activityTime: '2019-1-20',
                    releaseTime: '2019-1-10',
                    place: '足球场',
                    content: '足球比赛'
            }]    */
               Registered: {
                    id: '',
                    name: '',
                    club: '',
                    activityTime: '',
                    releaseTime: '',
                    deadline: '',
                    content: ''
                }
            }
        },
        methods: {
            confirm() {
                var dataObj = 1;
                var _this = this
                console.log(this.pwdInformation)
                this.$axios({
                        method: 'post',
                        url: '/',
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded'
                        },
                        data: dataObj, // 直接提交转换后的数据即可
                    },
                ).then(successResponse => {
                    if (successResponse.data.port === 200) {
                        // _this.$store.commit('login', _this.loginForm)
                        this.$alert("请重新登陆", '修改成功', {
                            confirmButtonText: '确定',
                        }).then(() => {
                            this.$router.replace({path: '/login'})
                        })

                    }
                    if(successResponse.data.port === 401){
                        this.$alert(successResponse.data.ErrorResult, '修改失败', {
                            confirmButtonText: '确定',
                        })
                    }
                })
            },
            cancel() {
                this.$router
                    .replace({path: '/index'})
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
