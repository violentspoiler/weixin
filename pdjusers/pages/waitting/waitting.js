// pages/waitting/waitting.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    image: ""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.login({
      success: function (res) {
        var code = res.code;
        if (res.code) {
          wx.request({
             url:'http://192.168.254.237:8084/wxservlet/User',
            data: {
              code: code
            },
            success(res) {
              console.log('ok')
            },
            fail(res) {
              console.log(code)
            }
          })

          wxbarcode.qrcode('qrcode', code, 420, 420);
        } else {
          console.log('登录失败！' + res.errMsg)
        }
      }
    })
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