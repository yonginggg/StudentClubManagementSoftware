<template>
  <div>
    <user-nav-menu></user-nav-menu>
    <router-view/>
  </div>
</template>

<script>
  import AdminHomeNavMenu from './admin/AdminNavMenu'
  export default {
    name: 'AdminHome',
    components: {AdminNavMenu}
  }
</script>

<style scoped>

</style>
