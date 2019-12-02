<template>
  <div id="app" style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <el-form ref="form" :model="form" label-width="80px">
      <el-header style="text-align: center; font-size: 30px; background-color: lightsteelblue">
        <span style="letter-spacing: 30px; ">创建社团</span>
      </el-header>
      <dev id="create" style="position: relative; left: 250px; top:100px" >
      <el-form-item label="社团名称" style="width: 400px" >
        <el-input v-model="form.name"  placeholder="请输入内容 10字以内" maxlength="10" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="社团类型" style="width: 300px" >
        <el-select v-model="form.region" placeholder="请选择社团类型" >
          <el-option label="学术类" value="xueshu"></el-option>
          <el-option label="体育类" value="tiyu"></el-option>
          <el-option label="艺术类" value="yishu"></el-option>
          <el-option label="公益类" value="gongyi"></el-option>
          <el-option label="科技类" value="keji"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="社长学号" style="width: 200px" >
        <el-input placeholder="31701052"
                  v-model="form.input"
                  :disabled="true">
        </el-input>
      </el-form-item>
      <el-form-item label="申请理由"  style="width: 600px"  >
        <el-input  type="textarea" v-model="form.desc" :autosize="{ minRows: 5, maxRows: 10}" placeholder="请输入内容,200字以内" maxlength="200" show-word-limit>></el-input>
      </el-form-item>
        <el-form-item style="width: 600px">
        <el-button type="primary" v-on:click="onSubmit">立即创建</el-button>
        <el-button>取消</el-button>
      </el-form-item>
      </dev>
    </el-form>

  </div>
</template>

<script>
// src="//unpkg.com/vue/dist/vue.js"
// src="//unpkg.com/element-ui@2.12.0/lib/index.js"
export default {
  name: 'clone',
  data () {
    return {
      form: {
        name: '',
        input: '',
        region: '',
        desc: ''
      },
      responseResult: []
    }
  },
  methods: {
    onSubmit () {
    }
  }
}
</script>

<style scoped>
</style>
