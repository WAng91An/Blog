/**
 * Created by wangqian on 2019/1/30.
 */

var vue = new Vue({
    el: "#detail",
    data: {
        id:""
    },
    methods: {
        getBlogInfo: function (pageNum, pageSize) {
            // 异步请求博客列表
            this.$http.get('/detail/').then(this.successCallback, this.errorCallback);
        },
        successCallback: function (res) {
            res = res.body;
            if( res.data && res.status == 200){
                console.log(res.data.list)
            }else {
                util.errorTips("获取博客失败，请稍后刷新重试")
            }
        }
    },
    computed: {
    },
    created: function () {
        this.getBlogInfo(1, util.pageSize());
    }
})