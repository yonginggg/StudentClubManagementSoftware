const app = getApp()
Page({
  /**
   * 页面的初始数据
   */
  data: {
    disabled:false,
    no:'',
    pwd:'',
    noinput:false,
    pwdinput:false,
  },
  noinput:function(e){
    this.setData({no:e.detail.value});
    this.setData({noinput:true});
    if(this.data.noinput==true && this.data.pwdinput==true){
      this.setData({ disabled: false });
    }
 
  },
  pwdinput: function (e) {
    this.setData({ pwd: e.detail.value });
    this.setData({ pwdinput: true });
    if (this.data.noinput == true && this.data.pwdinput == true) {
      this.setData({ disabled: false });
    }
  },
  formSubmit: function (e) {
    wx.showLoading({
      title: '登录中...',
    })
    console.log(e);
    this.setData({ disabled: true});
    wx.request({
      url: 'http://localhost:8880/api/login', //仅为示例，并非真实的接口地址
      data: {
        "type": "学生",
        "userId": e.detail.value.no,
        "userPwd": e.detail.value.pwd
      },
      header:{
        "Content-Type": "application/x-www-form-urlencoded"
      },
      method: 'POST',
      success: function (res) {
        // console.log(data);
        if (res.statusCode == 200) {
          if (res.data.port == 401) {
            wx.showToast({
              title: res.data.ErrorResult,
              icon: 'none',
              duration: 2000
            })
          } else {
            wx.setStorageSync('user', res.data);
            wx.showToast({
              title: "Hello "+res.data.username,
              icon: 'success',
              duration: 1500
            })
            setTimeout(function(){
              // app.globalData.userInfo = res.data;
              wx.switchTab({
                url: '../index/index',
              })
            },2000)
          }
        }else{
          wx.showToast({
            title: '服务器出现错误',
            icon: 'none',
            duration: 2000
          })
        }
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({disabled:false});
    var student = wx.getStorageSync('student');
    if (typeof (student) == 'object' && student.no != '' && student.classid != '') {
      wx.switchTab({
        url: '../teacher/teacher',
      })
    }
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
    if(this.data.no=='' || this.data.pwd==''){
      this.setData({ disabled: true });
    }else{
      this.setData({ disabled: false });
    }
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
  onPullDownRefresh: function () {
 
  },
 
  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
 
  },
 
  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
 
  }
})