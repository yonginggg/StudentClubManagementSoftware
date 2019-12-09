<!--通讯录-->
<template>
  <el-container style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <el-header style="text-align: center; font-size: 20px; height: 50px;line-height: 50px; background-color: lightsteelblue">
      <span style="letter-spacing: 20px; ">通讯录</span>
    </el-header>
    <el-main>
      <span style="letter-spacing: 20px; ">社长</span>
      <el-table
        :data="tableData"
        style="width: 100%">
        <el-table-column
          prop="id"
          label="学号"
          width="180">
        </el-table-column>
        <el-table-column
          prop="name"
          label="姓名"
          width="180">
        </el-table-column>
        <el-table-column
          prop="major"
          label="专业"
          width="180">
        </el-table-column>
        <el-table-column
          prop="class"
          label="班级">
        </el-table-column>
        <el-table-column
          prop="club"
          label="社团">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="success"
              @click="handleEdit(scope.$index, scope.row)">转让社长</el-button>
          </template>
        </el-table-column>
      </el-table>
      <span style="letter-spacing: 20px; ">部长</span>
      <el-table
        :data="tableData2"
        style="width: 100%">
        <el-table-column
          prop="id"
          label="学号"
          width="180">
        </el-table-column>
        <el-table-column
          prop="name"
          label="姓名"
          width="180">
        </el-table-column>
        <el-table-column
          prop="major"
          label="专业"
          width="180">
        </el-table-column>
        <el-table-column
          prop="class"
          label="班级">
        </el-table-column>
        <el-table-column
          prop="department"
          label="部门">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="primary"
              @click="handleEdit(scope.$index, scope.row)">更改部长</el-button>
          </template>
        </el-table-column>
      </el-table>
      <span style="letter-spacing: 20px; ">社员</span>
      <el-table
        :data="tableData3"
        style="width: 100%">
        <el-table-column
          prop="id"
          label="学号"
          width="180">
        </el-table-column>
        <el-table-column
          prop="name"
          label="姓名"
          width="180">
        </el-table-column>
        <el-table-column
          prop="major"
          label="专业"
          width="180">
        </el-table-column>
        <el-table-column
          prop="class"
          label="班级">
        </el-table-column>
        <el-table-column
          prop="department"
          label="部门">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="warning"
              @click="handleEdit(scope.$index, scope.row)">分配部门</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'contacts',
  data () {
    return {
      tableData: [{
        id: '31701011',
        name: '王小虎',
        major: '计算机',
        class: '1702',
        club: 'xx社团'
      }],
      tableData2: [{
        id: '31701011',
        name: '王小虎',
        major: '计算机',
        class: '1702',
        department: 'xx部门'
      },{
        id: '31701011',
        name: '王小虎',
        major: '计算机',
        class: '1702',
        department: 'xx部门'
      },{
        id: '31701011',
        name: '王小虎',
        major: '计算机',
        class: '1702',
        department: 'xx部门'
      }],
      tableData3: [{
        id: '31701011',
        name: '王小虎',
        major: '计算机',
        class: '1702',
        department: 'xx部门'
      },{
        id: '31701011',
        name: '王小虎',
        major: '计算机',
        class: '1702',
        department: 'xx部门'
      },{
        id: '31701011',
        name: '王小虎',
        major: '计算机',
        class: '1702',
        department: 'xx部门'
      },{
        id: '31701011',
        name: '王小虎',
        major: '计算机',
        class: '1702',
        department: 'xx部门'
      },{
        id: '31701011',
        name: '王小虎',
        major: '计算机',
        class: '1702',
        department: 'xx部门'
      }]
    }
  }
}
</script>

<style scoped>

</style>
