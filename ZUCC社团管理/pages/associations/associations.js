// pages/associations/associations.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list:[],
    isselect:true,//标志位,判断是否开启上拉刷新 true为开启false为关闭
    page:1,
    value: '',
    swiperList: [{
      id: 0,
      type: 'image',
      url: '/images/st1.jpg'
    }, {
      id: 1,
      type: 'image',
      url: '/images/st2.jpg'
    }, {
      id: 2,
      type: 'image',
      url: '/images/st3.jpg'
    }, {
      id: 3,
      type: 'image',
      url: '/images/st4.jpg'
    }, {
      id: 4,
      type: 'image',
      url: '/images/st5.jpg'
    }],
    act_array:[], //list数据
  },
  //搜索框事件
  onChange(e) {
    // console.log(e.detail)
    this.setData({
      value: e.detail
    });
  },
   onSearch() {
    var that = this;
    wx.showToast({
      icon: 'loading',
      duration: 200
    })
    wx.request({
      url: 'http://localhost:8880/api/searchActivity',
      data: {"keyword": this.data.value},
      header:{
        "Content-Type": "application/x-www-form-urlencoded"
      },
      method: 'POST',
      success: (res) => {
        var list = res.data.searchActivity;
        that.setData({
          list: list
        });
        // if (res.data.status == "success") {
        //   var list = res.data.data//传回来的数组对象
        //   if (list.length != 0) { //传回来的数组为空意味着没查到
        //     this.setData({
        //       act_array: list,
        //       page:1, //将page重新更新为1
        //       isselect: false //将上拉更新关闭
        //     })
        //   } else { //若是传回来的数组为空,那就给用户一个提示
        //     Toast('查询为空');
        //   }
        // }
        // else {
        //   Toast.fail(res.data.data.errorMsg);
        // }
      }, 
      fail: (res) => {
        // Toast.fail('刷新失败');
        console.log("failed ")
      }, 
      // complete: (res) => {
      //   wx.hideToast();
      // }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    var that = this;
    wx.request({
      url: 'http://localhost:8880/api/schoolactivity',
      method: 'GET',
      data: {},
      success: function(res) {
        var list = res.data.schoolactivity;
        that.setData({
          list: list
        });
      }
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {
    console.log("用户下拉刷新")
    wx.showToast({
      title:"刷新中",
      icon: 'loading',
    })
    wx.request({
      url: app.globalData.myserver_prefix + '/get/activity/byPage',
      method: 'GET',
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      data: {
        page: 0 //那么再次获取首页信息,页码数肯定为0
      },
      success: (res) => {
        console.log(res)
        if (res.data.status == "success") {
          var list = res.data.data
          this.setData({
            act_array: list,
            page:1,
            isselect:true//开启上拉刷新
          })
        }
        else {
          Toast.fail('刷新失败');
        }
      }, fail: (res) => {
        Toast.fail('刷新失败');
      }, complete: (res) => {
        wx.hideToast();
        wx.stopPullDownRefresh()
      }
    })
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {
    if (this.data.isselect){
      console.log("用户上拉加载")
      wx.showToast({
        icon: 'loading',
      })
      var pagedata = this.data.page + 1//获取最新页码数
      wx.request({
        url: app.globalData.myserver_prefix + '/get/activity/byPage',
        method: 'GET',
        header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        data: {
          page: pagedata //上拉加载需要查询页数可变,每次+1,并且需要写回数组中(以拼接方式),页面大于查询页面会返回空数组需要判断
        },
        success: (res) => {
          console.log(res)
          if (res.data.status == "success") {
            var list = res.data.data//传回来的数组对象
            if (list.length != 0) { //传回来的数组为空意味着没数据了
              //拼接现有数组
              var oldData = this.data.act_array;
              console.log("拼接后的数组", oldData.concat(list))
              this.setData({
                act_array: oldData.concat(list),
                page: pagedata
              })
            } else { //若是传回来的数组为空,那就给用户一个提示
              Toast('已经到底了哦~');
            }
          }
          else {
            Toast.fail(res.data.data.errorMsg);
          }
        }, fail: (res) => {
          Toast.fail('刷新失败');
        }, complete: (res) => {
          wx.hideToast();
        }
      })
    }
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  createActivitySign: function(e){
      var that = this;
      wx.showModal({
        title: '提示',
        content: '确认报名[' + e.target.dataset.associationsname + ']吗？',
        success: function(sm){
            wx.request({
              url: 'http://localhost:8880/api/createrecruitsign',
              data: {"userId": "31701055","associationsId": e.target.dataset.associationsid,
              "recruitSignContent": "我想入社"},
              header:{
                "Content-Type": "application/x-www-form-urlencoded"
              },
              method: 'POST',
              success: function(res){
                console.log(res)
                if(res.data.port == 200){
                  wx.showToast({
                    title: '报名成功',
                    icon: '',
                    duration: 2000
                  });
                }
                else if(res.data.port == 401){
                  console.log(res.data.ErrorResult)
                  wx.showToast({
                    title: res.data.ErrorResult,
                    icon: 'none',
                    duration: 2000
                  });
                }
              }
            })
        }
      })
  }
})