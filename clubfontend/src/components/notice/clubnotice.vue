<!--社团公告-->
<template>
  <el-container style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <el-header style="text-align: center; font-size: 20px; height: 50px;line-height: 50px; background-color: lightsteelblue">
      <span style="letter-spacing: 20px; ">社团活动公告</span>
    </el-header>
    <el-main>
      <el-table
        :data="associationData.filter(data => !search || data.username.toLowerCase().includes(search.toLowerCase()))"
        ref="filterTable"
        stripe
        height="305"
        style="width: 100%; margin: 10px">
        <el-table-column type="expand">
          <template slot-scope="props">
            <el-form label-position="left" inline class="demo-table-expand">
              <el-form-item label="公告内容">
                <span>{{ props.row.noticetcontent}}</span>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column  type="index" label="编号" width="300">
        </el-table-column>
        <el-table-column
          label="公告名称"
          prop="noticename">
        </el-table-column>
        <el-table-column
          label="发布时间"
          prop="noticetime"
          sortable>
        </el-table-column>
      </el-table>
    </el-main>
  </el-container>
</template>

<script>
  import qs from 'qs'
    export default {
        name: "clubnotice",
        data () {
            return {
                assName:{

                },
                associationData: [

                ],
            }
        },
      mounted () {
        var that = this;
        that.assName.associationsId = sessionStorage.getItem("associationId");
        var an = qs.stringify(that.assName)
        this.$axios({
            method: 'post',
            url: '/noticebyassociations',
            headers: {
              'Content-Type': 'application/x-www-form-urlencoded'
            },
            data: an , // 直接提交转换后的数据即可
          },
        ).then(successResponse => {
            this.associationData  = successResponse.data.noticebyassociations;
        })
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
