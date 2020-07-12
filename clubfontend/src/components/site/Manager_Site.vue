<template>
  <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      fixed
      prop="id"
      label="场地编号"
      width="120">
    </el-table-column>
    <el-table-column
      prop="name"
      label="场地名称"
      width="150">
    </el-table-column>
    <el-table-column
      prop="principal"
      label="场地负责人"
      width="150">
    </el-table-column>
    <el-table-column
      prop="property"
      label="场地属性"
      width="150">
    </el-table-column>
    <el-table-column
      prop="state"
      label="场地状态"
      width="150">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="120">
      <template slot-scope="scope">
        <el-button @click="handleClick(scope.row)" type="text" size="small">查看详细安排</el-button>

      </template>
    </el-table-column>
  </el-table>
</template>

<script>
  export default {
    name: 'Manager_Site'
  }
  export default {
    methods: {
      handleClick(row) {
        console.log(row);
      }
    },
    data() {
      return {
        ruleForm: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        rules: {
          name: [
            { required: true, message: '请输入公告名称', trigger: 'blur' },
            { min: 1, max: 10, message: '长度在 1 到 10 个字符', trigger: 'blur' }
          ],
          date1: [
            { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
          ],
          date2: [
            { type: 'date', required: true, message: '请选择时间', trigger: 'change' }
          ],
          desc: [
            { required: true, message: '请填写公告内容', trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style scoped>

</style>
