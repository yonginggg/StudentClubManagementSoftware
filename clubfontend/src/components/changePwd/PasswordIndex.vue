<template>
  <el-container style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <el-header style="text-align: center; font-size: 20px; background-color: lightsteelblue">
      <span style="letter-spacing: 20px; ">密码修改</span>
    </el-header>
    <el-main>
       <pwd-information></pwd-information>
    </el-main>
  </el-container>
</template>

<script>
import PwdInformation from './PwdInformation'
export default {
  name: 'Pwd',
  components: {PwdInformation}
}
</script>

<style scoped>

</style>
