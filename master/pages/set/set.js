// pages/set/set.js
var app=getApp();
 app.listdata = [{
      id: 0,
      recharge: 50,
      freecath: 10,
      hiddenchange: true,
    },
    {
      id: 1,
      recharge: 100,
      freecath: 30,
      hiddenchange: true,
    },
    {
      id: 2,
      recharge: 200,
      freecath: 70,
      hiddenchange: true,
    },
    {
      id: 3,
      recharge: 500,
      freecath: 200,
      hiddenchange: true,
    },
    {
      id: 4,
      recharge: 1000,
      freecath: 500,
      hiddenchange: true,
    }]
Page({
  /**
   * 页面的初始数据
   */
  data: {    
    warnning: '',
    hiddenchange: true,
    recharge: 0,
    freecath: 0,
    listdata: [],
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
    var list = app.listdata;
    this.setData({
      listdata: list
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
  addNew:function(){
    wx.navigateTo({
      url: '/pages/change/change'
    })
  },
  bindKeyInputR(e) {    
    var that=this;
    var list = this.data.listdata;
    for(var i = 0 ,  len = list.length; i < len; ++i){
      if(list[i].recharge==e.detail.value){
        that.setData({
          warnning: '已包含这个值'
        })
      }
    }
    this.setData({
      recharge: e.detail.value
    })
  },
  bindKeyInputC(e) {
    this.setData({
      freecath: e.detail.value
    })    
  },
  click: function(e){//点击展开
    this.launchlist(e.currentTarget.id);
    var that=this;
    var list=this.data.listdata;
    for(var i = 0 , len=list.length; i<len;++i){
      if(list[i].id==e.currentTarget.id){
        this.setData({
          freecath: list[i].freecath,
          recharge: list[i].recharge,
        })

      }
    }
  },
  submitit: function(e){//提交修改
    this.launchlist(e.currentTarget.id);
    console.log(e.currentTarget.id)
    var that = this;
    var list = this.data.listdata;
    for (var i = 0, len = list.length; i < len; ++i) {
    var listRkey = 'listdata[' + i + '].recharge'
    var listFkey = 'listdata[' + i + '].freecash'
    var listHkey = 'listdata[' + i + '].hiddenchange'
      if (list[i].id == e.currentTarget.id) {
        that.setData({
          [listRkey]: this.data.recharge,
          [listFkey]: this.data.freecath,
          [listHkey]: ![listHkey]
        })
      }
    }   
    this.data.listdata=list
    this.launchlist(e.currentTarget.id); 
  },
  launchlist: function(a){//展开，收起
    var that = this;
    var thisId = a;
    var list = this.data.listdata;
    for (var i = 0, len = list.length; i < len; ++i) {
      var listkey = 'listdata[' + i + '].hiddenchange';
      if (thisId == list[i].id) {
        that.setData({
          [listkey]: !list[i].hiddenchange
        })
        console.log(thisId)
        console.log(list[i].id)
      }
    }
  }
})