<template>
  <!--  <el-container>-->
  <!--    <el-aside>-->
  <el-menu
    :default-active="'/index'"
    router
    class="el-menu-vertical-demo"
    @open="handleOpen"
    @close="handleClose"
    background-color="#486586"
    text-color="#fff"
    active-text-color="#1890ff">
    <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
    <el-submenu index="1">
      <template slot="title">
        <i class="el-icon-menu"></i>
        <span>基本功能</span>
      </template>
      <el-menu-item index="recruitnotice">社团招新</el-menu-item>
      <el-menu-item index="createAssociation">社团创建</el-menu-item>
      <el-menu-item index="viewActivityUser">全校活动</el-menu-item>
      <el-menu-item index="SignedActivity">已报名的活动</el-menu-item>
      <el-menu-item index="ViewAnnouncementUser">全校公告</el-menu-item>
      <el-menu-item index="changePwd">修改密码</el-menu-item>
    </el-submenu>
    <el-submenu index="association">
      <template slot="title">
        <i class="el-icon-s-custom"></i>
        <span>我的社团</span>
      </template>
      <template v-for="ass in association">
        <el-menu-item index="clubIndex" v-on:click="get(ass.associationid)" >{{ass.associationname}}</el-menu-item>
      </template>
    </el-submenu>
    <el-button id="back" type="primary" icon="el-icon-back" v-on:click="back">退出登录</el-button>
  </el-menu>
</template>

<script>
    import qs from 'qs'

    export default {
        name: 'UserNavMenu',
        data() {
            return {
                user: {
                    userId: ''
                },
                association: []
            }
        },
        mounted() {
            this.user.userId = this.$store.state.user.userId
            var dataObj = qs.stringify(this.user);
            this.$axios({
                    method: 'post',
                    url: '/allassociationbyuserid',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    },
                    data: dataObj, // 直接提交转换后的数据即可
                },
            ).then(successResponse => {
                for (var i = 0; i < successResponse.data.allassociationbyuserid.length; i++) {
                    this.association.push({
                        associationname: successResponse.data.allassociationbyuserid[i].associationsName,
                        associationid: successResponse.data.allassociationbyuserid[i].associationsId
                    })
                }

            })
        },
        methods: {
            club(rows) {
                // var _this = this
                // _this.$store.commit('association', _this.association.associationname)
                // console.log(this.$store.state.association.associationname)
                // console.log(this.associationname)
                console.log(rows)
            },
            back() {
                this.$router.replace({path: '/login'})
            },
            get(message){
                console.log(message)
            }
        }

    }
</script>

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

  #back {
    position: fixed;
    left: 55px;
    top: 90%
  }
</style>
