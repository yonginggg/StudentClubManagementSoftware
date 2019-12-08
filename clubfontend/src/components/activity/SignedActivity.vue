<!--学生已经报名的活动-->
<template>
  <el-container style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <el-header style="text-align: center; font-size: 20px; height: 50px;line-height: 50px; background-color: lightsteelblue">
      <span style="letter-spacing: 20px; ">已报名活动</span>
    </el-header>
    <el-main>
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
          label="活动开始时间"
          prop="activitystarttime">
        </el-table-column>
        <el-table-column
          label="活动结束时间"
          prop="activityendtime">
        </el-table-column>
        <el-table-column
          align="right">
          <template slot="header" slot-scope="scope">
            <el-input
              v-model="search"
              size="mini"
              placeholder="输入关键字搜索"/>
          </template>
        </el-table-column>
      </el-table>
    </el-main>
  </el-container>
</template>

<script>
    export default {
        name: "SignedActivity",
        data() {
            return {
                tableData: [],
                search: ''
            }
        },
    }
</script>

<style scoped>

</style>
