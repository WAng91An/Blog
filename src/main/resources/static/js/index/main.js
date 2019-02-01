/**
 * Created by wangqian on 2019/1/30.
 */

var vue = new Vue({
    el: "#app",
    data: {
        list: [],
        pageNum: '',
        pages: '',
        hasNextPage: null,
        hasPreviousPage: null,
        isFirstPage: null,
        isLastPage: null,
        navigatepageNums: [],
    },
    methods: {
        getBlogInfo: function (pageNum, pageSize) {
            // 异步请求博客列表
            this.$http.get('/blog/list', {params: {pageNum: pageNum, pageSize: pageSize}}).then(this.successCallback, this.errorCallback);
        },
        successCallback: function (res) {
            res = res.body;
            if( res.data && res.status == 200){
                this.list = res.data.list;
                this.pageNum = res.data.pageNum;
                this.hasNextPage = res.data.hasNextPage;
                this.hasPreviousPage = res.data.hasPreviousPage;
                this.isFirstPage = res.data.isFirstPage;
                this.isLastPage = res.data.isLastPage;
                this.pages = res.data.pages;
                this.navigatepageNums = res.data.navigatepageNums;
            }else {
                util.errorTips("获取博客失败，请稍后刷新重试")
            }
        },
        errorCallback: function () {
            util.errorTips("获取博客失败，请稍后刷新重试")
        },
        handleFirstPage: function () {
            // 点击首页重新请求
            this.getBlogInfo(1, util.pageSize());
        },
        handleLastPage: function () {
            // 点击尾页重新请求
            this.getBlogInfo(this.pages, util.pageSize());
        },
        handleNumber: function (item) {
            // 点击数字请求
            this.getBlogInfo(item, util.pageSize());
        },
        isActive: function(item){
            // 当前是第几页，相应数字按钮class=active
            return item == this.pageNum;
        },
        handleLeftClick: function () {
            // 点击左箭头按钮
            this.getBlogInfo(this.pageNum - 1, util.pageSize());
        },
        handleRightClick: function () {
            // 点击右箭头按钮
            this.getBlogInfo(this.pageNum + 1, util.pageSize());
        }
    },
    filters: {
        dataFormat: function (time) {
            // 时间格式
            var d = new Date(time)
            var year = d.getFullYear();
            var month = d.getMonth() + 1;
            var day = d.getDate() <10 ? '0' + d.getDate() : '' + d.getDate();
            return  year+ '-' + month + '-' + day;
        }
    },
    computed: {
        notHasNextPage: function () {
            // 当没有上一页的时候按钮禁用
            return !this.hasNextPage;
        },
        notHasPreviousPage: function () {
            // 当没有下一页的时候按钮禁用
            return !this.hasPreviousPage;
        },
    },
    created: function () {
        this.getBlogInfo(1, util.pageSize());
    }
})