<!--审核社团-->
<template>
  <div id="app" style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="社团编号">
              <span>{{ props.row.id }}</span>
            </el-form-item>
            <el-form-item label="社团名称">
              <span>{{ props.row.name }}</span>
            </el-form-item>
            <el-form-item label="申请人学号">
              <span>{{ props.row.applicant }}</span>
            </el-form-item>
            <el-form-item label="社团类别">
              <span>{{ props.row.category }}</span>
            </el-form-item>
            <el-form-item label="社团简介">
              <span>{{ props.row.content }}</span>
            </el-form-item>
          </el-form>
        </template>

      </el-table-column>
      <el-table-column
        label="社团编号"
        prop="associationsId">
      </el-table-column>
      <el-table-column
        label="社团名称"
        prop="associationsName">
      </el-table-column>
      <el-table-column
        label="申请人学号"
        prop="associationsLeader">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="success"
            @click="ok(scope.$index, scope.row)">通过
          </el-button>
          <el-button
            size="mini"
            type="danger"
            @click="no(scope.$index, scope.row)">不通过
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
    import qs from 'qs'

    export default {

        name: 'applyClub',
        data() {
            return {
                tableData: [],
                search: ''
            }
        },
        mounted() {
            var dataObj = qs.stringify({associationstate: '等待审核'});
            this.$axios({
                    method: 'post',
                    url: '/allassociationsbystate',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    },
                    data: dataObj, // 直接提交转换后的数据即可
                },
            ).then(successResponse => {
                // console.log(successResponse.data.allassociationsbystate[0].port);
                if (successResponse.data.allassociationsbystate[0].port === 200) {
                    this.tableData = successResponse.data.allassociationsbystate
                }
                if (successResponse.data.port === 401) {
                    this.$message.error('获取社团申请失败');
                }
            })
        },
        methods: {
            ok(index, rows) {
                rows.associationstate = '审核通过'
                // console.log(rows)
                var data = qs.stringify(rows);
                // console.log(data)
                this.$axios({
                        method: 'post',
                        url: '/modifyassociationsstatebyid',
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded'
                        },
                        data: data, // 直接提交转换后的数据即可
                    },
                )
            },
            no(index, rows) {
                rows.associationstate = '审核失败'
                // console.log(rows)
                var data = qs.stringify(rows);
                // console.log(data)
                this.$axios({
                        method: 'post',
                        url: '/modifyassociationsstatebyid',
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded'
                        },
                        data: data, // 直接提交转换后的数据即可
                    },
                )
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
