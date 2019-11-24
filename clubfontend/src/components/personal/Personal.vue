<template>
<!--  <div>-->
<!--    <el-container style="position: fixed;width: 100%;height: 100%;top: 0;right: 0; border: 1px solid #eee">-->
<!--      &lt;!&ndash;    <el-aside style="width: 200px;margin-top: 20px">&ndash;&gt;-->
<!--      &lt;!&ndash;      <switch></switch>&ndash;&gt;-->
<!--      &lt;!&ndash;      &lt;!&ndash;<SideMenu></SideMenu>&ndash;&gt;&ndash;&gt;-->
<!--      &lt;!&ndash;    </el-aside>&ndash;&gt;-->
<!--      &lt;!&ndash;    <el-aside>&ndash;&gt;-->
<!--      &lt;!&ndash;      <user-nav-menu></user-nav-menu>&ndash;&gt;-->
<!--      &lt;!&ndash;    </el-aside>&ndash;&gt;-->
<!--      <el-header>-->
<!--      </el-header>-->
<!--      <el-main>-->
<!--        &lt;!&ndash;<books></books>&ndash;&gt;-->
<!--      </el-main>-->
<!--    </el-container>-->
<!--  </div>-->
      <el-container style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
        <!--    <el-aside style="width: 200px;margin-top: 20px">-->
        <!--      <switch></switch>-->
        <!--      &lt;!&ndash;<SideMenu></SideMenu>&ndash;&gt;-->
        <!--    </el-aside>-->
<!--        <el-aside>-->
<!--&lt;!&ndash;          <user-nav-menu></user-nav-menu>&ndash;&gt;-->
<!--        </el-aside>-->
            <el-header style="text-align: center; font-size: 20px; background-color: lightsteelblue">
              <span style="letter-spacing: 20px; ">所有公告</span>
            </el-header>
        <el-main>
          <!--<books></books>-->
        </el-main>
      </el-container>
</template>

<script>
import UserNavMenu from '../user/UserNavMenu'
export default {
  name: 'Personal',
  components: {UserNavMenu}
}
</script>

<style scoped>

</style>
