window.addEventListener("load", function (){
    const enroll = document.querySelector(".enroll")
    const set = document.querySelector(".set");

    enroll.onmouseover = function() {
        set.style.display = 'block';
    }
    enroll.onmouseout = function() {
        set.style.display = 'none';
    }
    set.onmouseover = function (){
        this.style.display = 'block';
    }
    set.onmouseout = function (){
        this.style.display = 'none';
    }
})

$(function() {
    $(".left ul li").click(function() {
        //点击的同时获得按钮的索引号
        const index = $(this).index();
        //显示相应的模块
        $(".right table").eq(index).show().siblings().hide();
    });
})

