<template>
  <el-container style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
  <el-header style="text-align: center; font-size: 20px; height: 50px;line-height: 50px; background-color: lightsteelblue">
    <span style="letter-spacing: 20px; ">社团招新</span>
  </el-header>
  <el-main>
      <template>
        <el-table
          :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
          style="width: 100%">
          <el-table-column
            label="社团名字"
            prop="associationsname">
          </el-table-column>
          <el-table-column
            label="招新内容"
            prop="recruitNoticeContent">
          </el-table-column>
          <el-table-column
            label="招新开始时间"
            prop="recruitNoticeStartTime">
          </el-table-column>
          <el-table-column
            label="招新截止时间"
            prop="recruitNoticeEndTime">
          </el-table-column>
          <el-table-column
            align="right">
            <template slot="header" slot-scope="scope">
              <el-input
                v-model="search"
                size="mini"
                placeholder="输入关键字搜索"/>
            </template>
            <template slot-scope="scope">
              <el-button
                size="middle"
                type="primary"
                @click="signin(scope.$index, scope.row)">
                报名社团
              </el-button>
            </template>
          </el-table-column>
        </el-table>
      </template>
  </el-main>
  </el-container>
</template>

<script>
  import qs from 'qs'
    export default {
        name: "RecruitNotice",
        data() {
            return {
                tableData: [],
                search: ''
            }
        },
        mounted() {
            this.$axios.get("/allrecruitnotice1")
                .then(response => {
                    this.tableData = response.data.allrecruitnotice1
                    // console.log(this.tableData)
                })
        },
        methods : {
            signin(index, rows){
                rows.userId = this.$store.state.user.userId
                rows.recruitSignContent = '这是个人介绍'
                var dataObj = qs.stringify(rows);
                this.$axios({
                        method: 'post',
                        url: '/createrecruitsign',
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded'
                        },
                        data: dataObj, // 直接提交转换后的数据即可
                    },
                ).then(successResponse => {
                    // console.log(successResponse.data);
                    if (successResponse.data.port === 200) {
                        this.$message({
                            message: '报名成功',
                            type: 'success'
                        });
                    }
                    if(successResponse.data.port === 401){
                        // this.$alert(successResponse.data.ErrorResult, '登录失败', {
                        //     confirmButtonText: '确定',
                        // })
                      this.$message({
                        message: '报名失败:  '+successResponse.data.ErrorResult,
                        type: 'error'
                      });
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>
