<template>
  <el-container style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <el-header style="text-align: center; font-size: 20px; height: 50px;line-height: 50px; background-color: lightsteelblue">
      <span style="letter-spacing: 20px; ">个人信息</span>
    </el-header>
    <el-main>
       <per-information></per-information>
    </el-main>
  </el-container>
</template>

<script>
import PerInformation from './PerInformation'
export default {
  name: 'Personal',
  components: {PerInformation}
}
</script>

<style scoped>

</style>
