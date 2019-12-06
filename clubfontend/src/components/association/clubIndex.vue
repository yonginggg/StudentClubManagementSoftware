<template>
    <el-container style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <el-header style="text-align: center; font-size: 20px; height: 50px;line-height: 50px; background-color: lightsteelblue">
      <span style="letter-spacing: 20px; ">XX社团</span>
    </el-header>
    <el-main>
    <el-row style="height: 30%">
      <el-button plain  type="primary" icon="el-icon-message-solid" style="width: 20% ;height: 70%;font-size: 30px" >公告</el-button>
      <el-button plain type="success" icon="el-icon-s-order" style="width: 20% ;height: 70%;font-size: 30px">活动</el-button>
      <el-button plain type="warning" icon="el-icon-s-custom" style="width: 20% ;height: 70%;font-size: 30px">通讯录</el-button>
      <el-button plain type="danger" icon="el-icon-s-tools" style="width: 20% ;height: 70%;font-size: 30px">社团操作</el-button>
    </el-row>
    <el-card style="font-size: 20px;text-align: left" >
      <div slot="header" style="font-size: 30px;text-align: center">
        <span>社团介绍</span>
      </div>
        UTALK 友谈协会，下方是一个笑脸，表明我们社团十分有爱，是一个很欢乐的大家庭，同时笑脸里面表明了社团名称和社团创建时间。最后是我们社团的口号，激励大家积极勇敢说英语。
    </el-card>
  </el-main>

  </el-container>
</template>

<script>
export default {
  name: 'clubIndex'
}
</script>

<style scoped>

</style>
