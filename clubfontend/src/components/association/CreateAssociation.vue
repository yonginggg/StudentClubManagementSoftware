<template>
  <el-container style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <el-header style="text-align: center; font-size: 20px; background-color: lightsteelblue">
      <span style="letter-spacing: 20px; ">创建社团</span>
    </el-header>
    <el-main >
      <el-form label-width="100px">
        <el-form-item label="社团名称">
          <el-input placeholder="请输入社团名称" v-model="formInline.associationsName" type="text">
          </el-input>
        </el-form-item>
        <el-row>
          <el-col :span="12">
            <el-form-item label="成立人">
              <el-input v-model="formInline.userName1" placeholder="请输入内容"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-select v-model="formInline.memberPost1" placeholder="职务">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="成立人">
              <el-input v-model="formInline.userName2" placeholder="请输入内容"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-select v-model="formInline.memberPost2" placeholder="职务">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="成立人">
              <el-input v-model="formInline.userName3" placeholder="请输入内容"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-select v-model="formInline.memberPost3" placeholder="职务">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-col>
        </el-row>
        <el-form-item label="社团类型" label-width="115px">
          <el-radio-group v-model="formInline.radioGroup">
            <el-radio label="学术类" border>学术类</el-radio>
            <el-radio label="体育类" border>体育类</el-radio>
            <el-radio label=" 艺术类" border>艺术类</el-radio>
            <el-radio label="公益类" border>公益类</el-radio>
            <el-radio label="科技类" border>科技类</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-row justify="center">
          <el-col :span="15" :offset="2" >
            <el-input v-model="formInline.associationsIntroduction" placeholder="请输入社团描述内容" type="textarea" show-word-limit>
            </el-input>
          </el-col>
        </el-row>
        <el-form-item>
          <el-row>
            <el-col :span="12">
              <el-button type="primary" :native-type="submit">提交</el-button>
            </el-col>
            <el-col :span="12">
              <el-button >取消</el-button>
            </el-col>
          </el-row>
        </el-form-item>
      </el-form>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'AssociationIndex',
  data () {
    return {
      formInline: {
        userId: '',
        userName1: '',
        userName2: '',
        userName3: '',
        memberPost1: '',
        memberPost2: '',
        memberPost3: '',
        associationsName1: '',
        associationsIntroduction: '',
        radioGroup: ''
      },
      options: [{
        value: '选项1',
        label: '宣传部部长'
      }, {
        value: '选项2',
        label: '组织部部长'
      }, {
        value: '选项3',
        label: '财务部部长'
      }],
      value: ''
    }
  }
  // methods: {
  //   onSubmit () {
  //     console.log('submit!')
  //   }
  // }
}
</script>

<style scoped>
</style>
