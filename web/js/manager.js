$(function() {
    $(".left ul li").click(function() {
        //点击的同时获得按钮的索引号
        const index = $(this).index();
        //显示相应的模块
        $(".right table").eq(index).show().siblings().hide();
    });
})