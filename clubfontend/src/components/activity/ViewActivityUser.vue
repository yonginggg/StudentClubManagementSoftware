<!--学生查看全校活动-->
<template>
  <el-container style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <el-header style="text-align: center; font-size: 20px; height: 50px;line-height: 50px; background-color: lightsteelblue">
      <span style="letter-spacing: 20px; ">学校活动</span>
    </el-header>
    <el-main>
      <all-activity></all-activity>
    </el-main>
  </el-container>
</template>

<script>
    import AllActivity from "./AllActivity";
    export default {
        name: "ViewActivityUser",
        components: {AllActivity}
    }
</script>

<style scoped>

</style>
