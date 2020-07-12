//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    user:[wx.getStorageSync('user').username,wx.getStorageSync('user').usersex,wx.getStorageSync('user').userclass,wx.getStorageSync('user').usertel],
    associationsList:[],
    activityList:[],
    list: [1,2],
    activeName: '1',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    isshow: true,
  },
  //事件处理函数
  bindViewTap: function() {
    wx.switchTab({
      url: '../list/list'
    })
  },
  onLoad: function () {
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse){
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },
  onChange(event) {
    this.setData({
      activeName: event.detail
    });
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
      url: 'http://localhost:8880/api/allassociationbyuserid',
      method: 'POST',
      data: {"userId": wx.getStorageSync('user').userid},
      header:{
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: function(res) {
        var list = res.data.allassociationbyuserid;
        that.setData({
          associationsList: list
        });
      }
    }),
    wx.request({
      url: 'http://localhost:8880/api/myactivity',
      method: 'POST',
      data: {"userId": wx.getStorageSync('user').userid},
      header:{
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: function(res) {
        var list = res.data.myactivity;
        that.setData({
          activityList: list
        });
      }
    })

  },
})
