<!--社团活动-->
<template>
  <!--社团活动-->
  <div id="app" style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <span style="letter-spacing: 20px; ">社团活动</span>
    <el-table
      :data="tableData"
      style="width: 100%; height: 40% ">
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="活动名称">
              <span>{{ props.row.name }}</span>
            </el-form-item>
            <el-form-item label="活动社团">
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
        label="活动名称"
        prop="name">
      </el-table-column>
      <el-table-column
        label="活动社团"
        prop="club">
      </el-table-column>
      <el-table-column
        label="活动时间"
        prop="activityTime">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="search"
            @click="handleEdit(scope.$index, scope.row)">通过</el-button>
        </template>
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
    <span style="letter-spacing: 20px; ">部门活动</span>
    <el-table
      :data="tableData"
      style="width: 100%; height: 40% ">
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="活动名称">
              <span>{{ props.row.name }}</span>
            </el-form-item>
            <el-form-item label="活动社团">
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
        label="活动名称"
        prop="name">
      </el-table-column>
      <el-table-column
        label="活动社团"
        prop="club">
      </el-table-column>
      <el-table-column
        label="活动时间"
        prop="activityTime">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="search"
            @click="handleEdit(scope.$index, scope.row)">通过</el-button>
        </template>
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
  </div>
</template>

<script>
  export default {
    name: 'ClubActivity'
  }
</script>

<style scoped>

</style>
