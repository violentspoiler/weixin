// pages/service/service.js
var app=getApp();
Page({

  /** 
   * 页面的初始数据
   */
  data: {
    userId: 'not now',
    method: 'consume',
    cash:0,
    mscash:0,
    hiddentype: true,
    listdata: [],
    service:[{
      name: '充值', value: '0', method:'recharge'
    },{
        name: '消费', value: '1', method: 'consume', checked: true
    }]
  },
  radioChange: function (e) {
    console.log('radio发生change事件');
    var that=this;
    var service = this.data.service;
    for (var i = 0, len = service.length; i < len; ++i) {
      service[i].checked = service[i].value == e.detail.value;
      if(service[i].checked){
        that.setData({
          method: service[i].method
        })
      }
    }

    this.setData({
      service: service,
    });
    console.log(this.data.method);
  },
  /**
   * 提交
   */
  serviceSubmit:function(e) {
    var that=this;
    wx.login({
      success: function (res) {
        var code = res.code;
        if (res.code) {
          var service = that.data.service;     
          wx.request({
            url: 'http://192.168.252.239:8084/wxservlet//Master',            
            data: {
              code: that.data.userId,
              method: that.data.method,
              cash: that.data.mscash
            },
            success(res) {
              console.log('ok')
              console.log('code=' + that.data.userId)
              console.log('cash=' + that.data.mscash)
              console.log('method=' + that.data.method)
            },
            fail(res) {
              console.log('no')
              console.log(code)
              console.log('userId=' + that.data.userId)
              console.log('cash=' + that.data.cash)
              console.log('mscash=' + that.data.mscash)
              console.log('method=' + that.data.method)
            }
          })          
        } else {
          console.log('登录失败！' + res.errMsg)
        }
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载 
   */
  
  onLoad: function (options) {
    var that=this
    console.log(that.data.userId)
    this.setData({
      userId: options.userId
    });    
    console.log(that.data.cash)
    console.log(that.data.method)
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
    var list = app.listdata;
    this.setData({
      listdata: list
    })
    // if(this.data.method=='recharge'){
    //   this.setData({
    //     hiddentype: false
    //   })
    // }else{
    //   this.setData({
    //     hiddentype: true
    //   })
    // }
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

  },
  findMS: function(a){

    var b=0;
    var list = this.data.listdata
    for (var i = 0, len = list.length; i < len; ++i){
      if (a >= list[i].recharge && b <= list[i].freecath){
        b = list[i].freecath
      }
    }
        this.setData({          
          mscash: parseFloat(b) + parseFloat(a)
        })
    // return b;
  },
  bindKeyInput(e) {
    var that=this;
    if (this.data.method =='recharge'){
      this.setData({
        cash: e.detail.value,
        // mscash: this.findMS(e.detail.value)
        hiddentype: false
      })
      that.findMS(e.detail.value)     
    } 
  },
})