<template >
  <div >
    <user-nav-menu></user-nav-menu>
    <router-view id="index" style="background-color: #f0f2f5"/>
  </div>
</template>

<script>
import UserNavMenu from './user/UserNavMenu'
export default {
  name: 'Home',
  components: {UserNavMenu}
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
