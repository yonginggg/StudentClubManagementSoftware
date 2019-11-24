<template>
  <el-container>
    <el-aside>
      <el-menu
        :default-active="'/index'"
        router
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose">
        <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-menu"></i>
            <span>基本功能</span>
          </template>
          <el-menu-item index="1-1">个人信息</el-menu-item>
          <el-menu-item index="1-2">讨论区</el-menu-item>
          <el-menu-item index="1-3">社团招新</el-menu-item>
          <el-menu-item index="1-4">社团创建</el-menu-item>
          <el-menu-item index="1-5">社团活动</el-menu-item>
        </el-submenu>
        <el-submenu index="2">
          <template slot="title">
            <i class="el-icon-s-custom"></i>
            <span>我的社团</span>
          </template>
          <el-menu-item index="2-1">轮滑社</el-menu-item>
          <el-menu-item index="2-2">推理社</el-menu-item>
          <el-menu-item index="2-3">新知社</el-menu-item>
        </el-submenu>
        <el-submenu index="3">
          <template slot="title">
            <i class="el-icon-s-custom"></i>
            <span>社长功能</span>
          </template>
          <el-menu-item index="3-1">公告管理</el-menu-item>
          <el-menu-item index="3-2">活动管理</el-menu-item>
          <el-menu-item index="3-3">招新管理</el-menu-item>
          <el-menu-item index="3-3">职务任命</el-menu-item>
        </el-submenu>
        <el-submenu index="4">
          <template slot="title">
            <i class="el-icon-s-custom"></i>
            <span>部长功能</span>
          </template>
          <el-menu-item index="4-1">活动管理</el-menu-item>
          <el-menu-item index="4-2">公告管理</el-menu-item>
        </el-submenu>
      </el-menu>
    </el-aside>
  </el-container>
</template>

<script>
export default {
  name: 'UserNavMenu'
}
</script>

<style scoped>
  .el-menu-vertical-demo {
    position: fixed;
    /*margin-left: 50%;*/
    left: 0px;
    top: 0px;
    width: 230px;
    height: 100%;
    overflow: scroll;
  }
</style>
<!--<template>-->
<!--<el-container style="position: fixed;width: 100%;height: 100%;top: 0;right: 0; border: 1px solid #eee"-->
<!--              :default-active="'/index'"-->
<!--              router>-->
<!--  <el-aside width="200px" style="background-color: rgb(238, 241, 246)">-->
<!--    <el-menu :default-openeds="['1', '3']">-->
<!--      <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>-->
<!--      <el-submenu index="1">-->
<!--        <template slot="title">-->
<!--          <i class="el-icon-menu"></i>-->
<!--          <span>基本功能</span>-->
<!--        </template>-->
<!--        <el-menu-item index="1-1">个人信息</el-menu-item>-->
<!--        <el-menu-item index="1-2">讨论区</el-menu-item>-->
<!--        <el-menu-item index="1-3">社团招新</el-menu-item>-->
<!--        <el-menu-item index="1-4">社团创建</el-menu-item>-->
<!--        <el-menu-item index="1-5">社团活动</el-menu-item>-->
<!--      </el-submenu>-->
<!--      <el-submenu index="2">-->
<!--        <template slot="title">-->
<!--          <i class="el-icon-s-custom"></i>-->
<!--          <span>我的社团</span>-->
<!--        </template>-->
<!--        <el-menu-item index="2-1">轮滑社</el-menu-item>-->
<!--        <el-menu-item index="2-2">推理社</el-menu-item>-->
<!--        <el-menu-item index="2-3">新知社</el-menu-item>-->
<!--      </el-submenu>-->
<!--      <el-submenu index="3">-->
<!--        <template slot="title">-->
<!--          <i class="el-icon-s-custom"></i>-->
<!--          <span>社长功能</span>-->
<!--        </template>-->
<!--        <el-menu-item index="3-1">公告管理</el-menu-item>-->
<!--        <el-menu-item index="3-2">活动管理</el-menu-item>-->
<!--        <el-menu-item index="3-3">招新管理</el-menu-item>-->
<!--        <el-menu-item index="3-3">职务任命</el-menu-item>-->
<!--      </el-submenu>-->
<!--      <el-submenu index="4">-->
<!--        <template slot="title">-->
<!--          <i class="el-icon-s-custom"></i>-->
<!--          <span>部长功能</span>-->
<!--        </template>-->
<!--        <el-menu-item index="4-1">活动管理</el-menu-item>-->
<!--        <el-menu-item index="4-2">公告管理</el-menu-item>-->
<!--      </el-submenu>-->
<!--    </el-menu>-->
<!--  </el-aside>-->

<!--  <el-container>-->
<!--    <el-header style="text-align: center; font-size: 20px">-->
<!--      <span style="letter-spacing: 20px">所有公告</span>-->
<!--    </el-header>-->

<!--    <el-main>-->
<!--      <el-table :data="tableData">-->
<!--        <el-table-column prop="date" label="发布时间" width="150px">-->
<!--        </el-table-column>-->
<!--        <el-table-column prop="content" label="公告内容" width="400px">-->
<!--        </el-table-column>-->
<!--      </el-table>-->
<!--    </el-main>-->
<!--  </el-container>-->
<!--</el-container>-->
<!--</template>-->
<!--<style>-->
<!--  .el-header {-->
<!--    background-color: #B3C0D1;-->
<!--    color: #333;-->
<!--    line-height: 60px;-->
<!--  }-->

<!--  .el-aside {-->
<!--    color: #333;-->
<!--  }-->
<!--</style>-->

<!--<script>-->
<!--export default {-->
<!--  data () {-->
<!--    const item = {-->
<!--      date: '2016-05-02',-->
<!--      content: '王小虎'-->
<!--    }-->
<!--    return {-->
<!--      tableData: Array(20).fill(item)-->
<!--    }-->
<!--  }-->
<!--}-->
<!--</script>-->
