//index.js
//获取应用实例
const app = getApp()
var wxbarcode = require('../../utils/index.js');
Page({
  data: {
    motto: '欢迎使用',
    userInfo: {},
    hasUserInfo: false,
    code: '77777',
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
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
    var state=this.loginweb();
    this.data.motto=state
    
  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },
  loginweb:function(){    
    wx.login({
      success: function (res) {
        if (res.code) {
          wx.request({
            url: 'http://192.168.252.239:8084/wxservlet/User',
            data: {
              code: res.code
            },
            success(res) {
              console.log('ok')
              if (res.data = 'login') {
                console.log('state=' + res.data)                
              } else {
                wxbarcode.qrcode('qrcode', 'url:/pages/waitting/waitting?code='+res.code, 420, 420);
              }   
              return res.data
            },
            fail(res) {
              console.log(code)              
            }
          })

        } else {
          console.log('登录失败！' + res.errMsg)
        }
      }
    })      
  }
})
