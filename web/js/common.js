window.addEventListener('load', function()  {
    // $("body").css({"background-size":"100% "+$(document).height()+"px"});
    let pic = localStorage.getItem('picture');
    if(pic === null){
        pic = "images/背景1.png"
    }
    const url = "url("+pic+") no-repeat center top";
    $("body").css("background",url);
    //获取元素
    const images = document.querySelector('.baidu').querySelectorAll('img');
    for (let i = 0; i < images.length; i++) {
        images[i].onclick = function() {
            document.body.style.backgroundImage = 'url(' + this.src + ')';
            localStorage.setItem("picture",this.src);
        }
        $(images[i]).mouseover(function (){
            $(".baidu").stop().fadeIn(1000);
        });
        $(images[i]).mouseout(function (){
            $(".baidu").stop().fadeOut(1000);
        });
    }
})

$(function () {
    $(".changePF").mouseenter(function (){
        $(this).siblings(".baidu").stop().fadeIn(1000);
    }).mouseleave(function (){
        $(this).siblings(".baidu").stop().fadeOut(1000);
    });
    // $(".changePF").mouseout(function (){
    //     $(this).siblings(".baidu").slideDown(1000);
    // });
    // $(".changePF").hover(function (){
    //     //鼠标经过函数
    //     $(this).siblings(".baidu").slideDown(300);
    // },function (){
    //     //鼠标离开函数
    //     $(this).siblings(".baidu").slideUp(300);
    // });
    // $(".changePF").hover(function (){
    //     //stop是防止动画排队
    //     $(this).siblings(".baidu").stop().slideToggle(300);
    // });
});
