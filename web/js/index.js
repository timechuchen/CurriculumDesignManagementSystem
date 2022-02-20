window.addEventListener('load', function() {
    let timer;
    let circle;
    let num;
//获取元素
    const arrow_l = this.document.querySelector('.arrow-l');
    const arrow_r = this.document.querySelector('.arrow-r');
    const focus = this.document.querySelector('.focus');
    const focusWidth = focus.offsetWidth;
    //鼠标经过影藏左右按钮
    focus.addEventListener('mouseenter', function() {
        arrow_l.style.display = 'block';
        arrow_r.style.display = 'block';
        clearInterval(timer);
        timer = null;
    });
    focus.addEventListener('mouseleave', function() {
        arrow_l.style.display = 'none';
        arrow_r.style.display = 'none';
        timer = setInterval(function() {
            arrow_r.click();
        }, 3000);
    });
    //动态生成小圈
    const ul = focus.querySelector('ul');
    const ol = focus.querySelector('.circle');
    for (let i = 0; i < ul.children.length; i++) {
        const li = this.document.createElement('li');
        //通过自定义属性设置当前li的索引号
        li.setAttribute('index', i);
        ol.appendChild(li);
        li.addEventListener('click', function() {
            for (let i = 0; i < ol.children.length; i++) {
                ol.children[i].className = '';
            }
            this.className = 'current';
            //点击圆圈移动图片
            const index = this.getAttribute('index');
            //当我们点击了li，就要把索引号给num
            circle = num = index;
            //console.log(focusWidth);
            animate(ul, -focusWidth * index);
        });
    }
    ol.children[0].className = 'current';
    //克隆第一张图片放在最后面
    const first = ul.children[0].cloneNode(true);
    ul.appendChild(first);
    //点击右侧按钮滚动一张图片
    num = 0;
    circle = 0; //控制小圆圈的播放
    // 设置节流阀
    let flag = true;
    arrow_r.addEventListener('click', function() {
        if (flag === true) {
            flag = false;
            if (num === ul.children.length - 1) {
                ul.style.left = 0;
                num = 0;
            }
            num++;
            animate(ul, -num * focusWidth, function() {
                flag = true;
            });
            circle++;
            if (circle === ol.children.length) {
                circle = 0;
            }
            //排他
            circleChange();
        }
    });
    arrow_l.addEventListener('click', function() {
        if (flag === true) {
            flag = false;
            if (num === 0) {
                num = ul.children.length - 1;
                ul.style.left = -num * focusWidth + 'px';
            }
            num--;
            animate(ul, -num * focusWidth, function() {
                flag = true;
            });
            circle--;
            if (circle < 0) {
                circle = ol.children.length - 1;
            }
            //排他
            circleChange();
        }
    });

    function circleChange() {
        for (let i = 0; i < ol.children.length; i++) {
            ol.children[i].className = '';
        }
        ol.children[circle].className = 'current';
    }
    //用定时器实现自动播放功能，其实这就相当于点击了右侧按钮
    timer = setInterval(function () {
        arrow_r.click();
    }, 3000);
});

//点击图片重新加载
function reloadCheckImg(){
    //将img标签的src属性重新请求
    $(".img2").attr("src","images/image.jsp?t="+(new Date().getTime()));
}

function check(){
    const id = $("#uid").val();
    const pwd = $("#upwd").val();
    const $checkcode = $("#checkcodeId").val();
    if(id.length !== 10){
        alert("学号输入有误！");
        return false;
    }
    if(pwd.length === 0){
        alert("请输入密码！");
        return false;
    }
    //校验：文本框中输入值，发送到服务器
    //服务端将其与图片中真实的值进行对比，并返回验证结果,这里用Ajax的方法来发送
    $.post(
        "CheckCodeServlet",//服务端的地址
        "checkcode="+$checkcode,
        function (result){
            if ("false" === result) {
                alert("验证码不正确！！");
                window.location.href="index.jsp";
                return false;
            }
        }
    )
    return true;
}