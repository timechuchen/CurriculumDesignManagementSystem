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
        $(".right").children().eq(index).show().siblings().hide();
    });
})

function check(){
    const id = $("#id").val();
    const name = $("#name").val();
    const grade = $("#grade").val();
    const file = $("#file").val();

    if (isNaN(Number(id)) || id.length === 0) {
        alert("课设编号输入有误！");
        return false;
    }
    if (name.length === 0) {
        alert("课设名称输入为空！");
        return false;
    }

    if (grade.length === 0) {
        alert("课设年级输入为空！");
        return false;
    }

    if (file !== "") {
        const fileExt = file.substring(file.lastIndexOf('.') + 1);
        //const card = $("#ucard").val();
        if (fileExt !== "rar" && fileExt !== "zip") {
            alert("文件只能是压缩文件");
            return false;
        }
    }
    return true;
}
