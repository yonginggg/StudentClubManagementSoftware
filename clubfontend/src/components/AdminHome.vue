<template>
  <div>
    <admin-home-nav-menu></admin-home-nav-menu>
    <router-view id="index" style="background-color: #f0f2f5"/>
  </div>
</template>

<script>
import AdminHomeNavMenu from './admin/AdminNavMenu'
export default {
  name: 'AdminHome',
  components: {AdminHomeNavMenu}
}
</script>

<style scoped>
  #index {
    background: url("../assets/zhuye.jpg") no-repeat;
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }
</style>
