<template>
  <!--  <el-container>-->
  <!--    <el-aside>-->
  <el-menu
    :default-active="'/admin'"
    router
    class="el-menu-vertical-demo"
    @open="handleOpen"
    @close="handleClose">
    <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
    <el-menu-item index="usermanager">
      <template slot="title">
        <i class="el-icon-menu"></i>
        <span>人员管理</span>
      </template>
    </el-menu-item>
    <el-submenu index="5">
      <template slot="title">
        <i class="el-icon-menu"></i>
        <span>社团管理</span>
      </template>
      <el-menu-item index="5-1">审核社团申请</el-menu-item>
      <el-menu-item index="5-2">查看社团成员</el-menu-item>
      <el-menu-item index="5-3">删除社团</el-menu-item>
    </el-submenu>
    <el-submenu index="6">
      <template slot="title">
        <i class="el-icon-s-custom"></i>
        <span>活动管理</span>
      </template>
      <el-menu-item index="Audit_Activity">审核活动申请</el-menu-item>
      <el-menu-item index="Modify_Activity">审核活动修改</el-menu-item>
      <el-menu-item index="Query_Activity">查看活动</el-menu-item>
    </el-submenu>
    <el-submenu index="7">
      <template slot="title">
        <i class="el-icon-s-custom"></i>
        <span>公告管理</span>
      </template>
      <el-menu-item index="Create_Announcement">发布公告</el-menu-item>
      <el-menu-item index="Query_Announcement">查看公告</el-menu-item>
    </el-submenu>
    <el-submenu index="8">
      <template slot="title">
        <i class="el-icon-s-custom"></i>
        <span>财务场地管理</span>
      </template>
      <el-menu-item index="8-1">管理财务报销</el-menu-item>
      <el-menu-item index="8-2">管理场地使用</el-menu-item>
    </el-submenu>
  </el-menu>
  <!--    </el-aside>-->
  <!--  </el-container>-->
</template>

export default {
name: `AdminNavMenu`
}

<style scoped>
  .el-menu-vertical-demo {
    position: fixed;
    /*margin-left: 50%;*/
    left: 0px;
    top: 0px;
    width: 15%;
    height: 100%;
    overflow: scroll;
  }
</style>
