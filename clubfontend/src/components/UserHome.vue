<template>
  <div>
    <user-nav-menu></user-nav-menu>
    <router-view/>
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

</style>
