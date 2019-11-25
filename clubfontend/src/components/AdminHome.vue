<template>
  <div>
    <admin-home-nav-menu></admin-home-nav-menu>
    <router-view/>
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

</style>
