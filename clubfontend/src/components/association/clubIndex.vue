<template>
  <el-container style="position: fixed;width: 85%;height: 100%;top: 0;right: 0; border: 1px solid #eee">
    <el-header
      style="text-align: center; font-size: 20px; height: 50px;line-height: 50px; background-color: lightsteelblue">
      <span id=assName style="letter-spacing: 20px; ">XX社团</span>
    </el-header>
    <el-main>
      <el-row style="height: 30%">
        <el-button plain type="primary" icon="el-icon-message-solid"
                   style="width: 20% ;height: 70%;font-size: 30px"
                   v-on:click="tonotice">
          公告
        </el-button>
        <el-button plain type="success" icon="el-icon-s-order" style="width: 20% ;height: 70%;font-size: 30px"
                   v-on:click="toactivity">活动
        </el-button>
        <el-button plain type="warning" icon="el-icon-s-custom" style="width: 20% ;height: 70%;font-size: 30px"
                   v-on:click="totacts">通讯录
        </el-button>
        <el-button plain type="danger" icon="el-icon-s-tools" style="width: 20% ;height: 70%;font-size: 30px"
                   @click="operation = true">社团操作
        </el-button>
        <el-dialog title="社团操作" :visible.sync="operation" style="width:1000px;margin-left: 250px" :modal-append-to-body="false">
          <el-row>
            <el-button type="primary" plain @click="announcement = true">公告发布</el-button>
            <el-button type="success" plain @click="activityreleased = true">活动发布</el-button>
            <el-button type="info" plain @click="createdepartment = true">部门创建</el-button>
            <el-button type="warning" plain @click="audit = true">招新审核</el-button>
          </el-row>
        </el-dialog>
        <!--公告发布-->
        <el-dialog title="公告发布" :visible.sync="announcement" style="width:1000px;margin-left: 250px" :modal-append-to-body="false">
          <el-form :model="form">
            <el-form-item label="公告名称" style="width: 400px">
              <el-input v-model="form.name" placeholder="请输入内容 10字以内" maxlength="10" show-word-limit></el-input>
            </el-form-item>
            <el-form-item label="公告内容">
              <el-input type="textarea" v-model="form.content" :autosize="{ minRows: 5, maxRows: 10}"
                        placeholder="请输入内容,200字以内" maxlength="200" show-word-limit>>
              </el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="createdepartment = false">取 消</el-button>
            <el-button type="primary" @click="createdepartment = false">确 定</el-button>
          </div>
        </el-dialog>
        <!--活动发布-->
        <el-dialog title="活动发布" :visible.sync="activityreleased" style="height:800px; width:1000px;margin-left: 250px;margin-top: -100px" :modal-append-to-body="false">
          <el-form :model="form2">
            <el-form-item label="活动名称" style="width: 400px">
              <el-input v-model="createActivity.name" placeholder="请输入内容 10字以内" maxlength="10" show-word-limit></el-input>
            </el-form-item>
            <el-form-item label="活动范围" style="width: 400px">
              <el-select v-model="createActivity.range" placeholder="请选择" style="width: 400px">
                <el-option
                  v-for="item in createActivity.rangeoption"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="活动地点" style="width: 400px">
              <el-select v-model="createActivity.palaceid" placeholder="请选择" style="width: 400px">
                <el-option
                  v-for="item in createActivity.place"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
<!--            <el-form-item label="活动时间" style="width: 400px">-->
<!--              <el-date-picker-->
<!--                v-model="createActivity.valuetime1"-->
<!--                type="daterange"-->
<!--                range-separator="至"-->
<!--                start-placeholder="开始日期"-->
<!--                end-placeholder="结束日期"-->
<!--                style="width: 400px">-->
<!--              </el-date-picker>-->
<!--            </el-form-item>-->
            <el-form-item label="活动开始时间" style="width: 400px">
              <el-date-picker
                v-model="createActivity.startTime"
                type="datetime"
                placeholder="活动开始时间"
                style="width: 400px">
              </el-date-picker>
            </el-form-item>
            <el-form-item label="活动结束时间" style="width: 400px">
              <el-date-picker
                v-model="createActivity.endTime"
                type="datetime"
                placeholder="活动结束时间"
                style="width: 400px">
              </el-date-picker>
            </el-form-item>
            <el-form-item label="活动报名截止时间" style="width: 400px">
              <el-date-picker
                v-model="createActivity.deadLine"
                type="datetime"
                placeholder="活动报名截止时间"
                style="width: 400px">
              </el-date-picker>
            </el-form-item>

            <el-form-item label="活动内容">
              <el-input type="textarea" v-model="createActivity.introduction" :autosize="{ minRows: 5, maxRows: 10}"
                        placeholder="请输入内容,200字以内" maxlength="200" show-word-limit>>
              </el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="createdepartment = false">取 消</el-button>
            <el-button type="primary" v-on:click="createactivity">确 定</el-button>
          </div>
        </el-dialog>
        <!--部门创建-->
        <el-dialog title="部门创建" :visible.sync="createdepartment" style="width:1000px;margin-left: 250px" :modal-append-to-body="false">
          <el-form :model="form3">
            <el-form-item label="部门名称" :label-width="formLabelWidth">
              <el-input v-model="form3.name" autocomplete="off" style="width: 200px"></el-input>
            </el-form-item>
            <el-form-item label="候选人" :label-width="formLabelWidth">
              <el-select v-model="form3.user" placeholder="请选择活动区域" style="width: 200px">
                <el-option label="区域一" value="shanghai"></el-option>
                <el-option label="区域二" value="beijing"></el-option>
              </el-select>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="createdepartment = false">取 消</el-button>
            <el-button type="primary" @click="createdepartment = false">确 定</el-button>
          </div>
        </el-dialog>
        <!--招新审核-->
        <el-dialog title="招新审核" :visible.sync="audit" style="width:1000px;margin-left: 250px" :modal-append-to-body="false">
          <el-table :data="gridData">
            <el-table-column property="id" label="学号" width="150"></el-table-column>
            <el-table-column property="name" label="姓名" width="150"></el-table-column>
            <el-table-column label="操作">
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  type="success"
                  @click="handleEdit(scope.$index, scope.row)">通过
                </el-button>
                <el-button
                  size="mini"
                  type="danger"
                  @click="handleDelete(scope.$index, scope.row)">不通过
                </el-button>
              </template>
            </el-table-column>
          </el-table>
          <div slot="footer" class="dialog-footer">
            <el-button @click="createdepartment = false">取 消</el-button>
            <el-button type="primary" @click="createdepartment = false">确 定</el-button>
          </div>
        </el-dialog>
      </el-row>
      <el-card style="font-size: 20px;text-align: left">
        <div slot="header" style="font-size: 30px;text-align: center">
          <span>社团介绍</span>
        </div>
        <div id=introduction>
        UTALK 友谈协会，下方是一个笑脸，表明我们社团十分有爱，是一个很欢乐的大家庭，同时笑脸里面表明了社团名称和社团创建时间。最后是我们社团的口号，激励大家积极勇敢说英语。
        </div>
      </el-card>
    </el-main>

  </el-container>
</template>

<script>
    import qs from 'qs'
    export default {
        name: 'clubIndex',
        data() {
            return {
                createdepartment: false,
                form: {
                    name: '',
                    user: ''
                },
                formLabelWidth: '120px',
                operation: false,
                announcement: false,
                activityreleased: false,
                // form2: {
                //     name: '',
                //     date: '',
                //     place: '',
                //     content: ''
                // },
                form3: {
                    name: '',
                    user: ''
                },
                audit: false,
                gridData: [{
                    id: '211',
                    name: '王小虎',
                }],
                createActivity:{
                    name: '',
                    date: '',
                    place: '',
                    introduction: '',
                    startTime:'',
                    endTime:'',
                    deadLine:'',
                    rangeoption: [{
                        value: '全校',
                        label: '全校'
                    }, {
                        value: '社团',
                        label: '社团'
                    }, {
                        value: '部门',
                        label: '部门'
                    }],
                    range: '',
                    place:[
                        {
                            value: '1',
                            label: '理四1楼大教室'
                        }, {
                            value: '2',
                            label: '南校操场'
                        }, {
                            value: '3',
                            label: '北校操场'
                        },{
                            value: '4',
                            label: '风雨操场'
                        }
                    ],
                    palaceid:''

                }
            }
        },
        methods: {
            tonotice() {
                this.$router.replace({path: '/clubnotice'})
            },
            totacts() {
                this.$router.replace({path: '/contacts'})
            },
            toactivity(){
                this.$router.replace({path: '/ClubActivity'})
            },
            createactivity(){

                this.createActivity.associationid = this.$store.state.associationId
                this.createActivity.departmentid = this.$store.state.departmentId
                console.log(this.createActivity)
                var ca = qs.stringify(this.createActivity)

                this.$axios({
                        method: 'post',
                        url: '/createActivity',
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded'
                        },
                        data: ca, // 直接提交转换后的数据即可
                    },
                ).then(successResponse => {
                    // console.log(successResponse.data);
                    if (successResponse.data.port === 200) {


                    }
                    if(successResponse.data.port === 401){

                    }
                })
            }
        },
        mounted() {
            document.getElementById("assName").innerHTML = this.$store.state.associationName;
            document.getElementById("introduction").innerHTML = this.$store.state.associationsIntroduction;
        }
    }
</script>

<style scoped>

</style>
