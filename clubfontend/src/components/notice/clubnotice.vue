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
                <span>{{ props.row.shop }}</span>
              </el-form-item>
            </el-form>
          </template>
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
      <el-table
        :data="departmentData.filter(data => !search || data.username.toLowerCase().includes(search.toLowerCase()))"
        ref="filterTable"
        stripe
        height="305"
        style="width: 100%; margin: 10px">
        <el-table-column type="expand">
          <template slot-scope="props">
            <el-form label-position="left" inline class="demo-table-expand">
              <el-form-item label="公告内容">
                <span>{{ props.row.shop }}</span>
              </el-form-item>
            </el-form>
          </template>
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
        <el-table-column
          label="部门名称"
          prop="noticerange">
        </el-table-column>
      </el-table>
    </el-main>
  </el-container>
</template>

<script>
    export default {
        name: "clubnotice",
        data () {
            return {
                associationData: [
                    {noticename:'222',noticetcontent:'2222'},
                    {noticename:'111',noticetcontent:'2222'},
                    {noticename:'111',noticetcontent:'2222'},
                    {noticename:'111',noticetcontent:'2222'},
                    {noticename:'111',noticetcontent:'2222'},
                    {noticename:'111',noticetcontent:'2222'},
                    {noticename:'111',noticetcontent:'2222'},
                    {noticename:'111',noticetcontent:'2222'}
                ],
                departmentData:[
                    {noticename:'111',noticetcontent:'2222'},
                    {noticename:'111',noticetcontent:'2222'},
                    {noticename:'111',noticetcontent:'2222'},
                    {noticename:'111',noticetcontent:'2222'},
                    {noticename:'111',noticetcontent:'2222'},
                    {noticename:'111',noticetcontent:'2222'},
                    {noticename:'111',noticetcontent:'2222'},
                    {noticename:'111',noticetcontent:'2222'}
                ]
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
