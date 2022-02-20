/**
 * onsubmit：返回true，表单正常提交，否则不提交
 */
// let flag = true;
function check() {
    //获取元素
    const id = $("#uid").val();
    const pwd1 = $("#upwd1").val();
    const pwd2 = $("#upwd2").val();
    const phone = $("#uphone").val();
    const name = $("#uname").val();
    const age = $("#uage").val();
    const gender = $("#ugender").val();
    const file = $("#file").val();

    if (name.length === 0) {
        alert("姓名输入为空！");
        return false;
    }
    if (age > 150 || age < 0) {
        alert("年龄输入有误！");
        return false;
    }
    if (age.length === 0) {
        alert("年龄输入为空！");
        return false;
    }
    if (gender.length === 0) {
        alert("性别输入为空！");
        return false;
    }
    if (!(gender === "男" || gender === "女")) {
        alert("性别输入错误！");
        return false;
    }
    if ((id.length !== 10) || isNaN(Number(id))) {
        alert("账号输入有误！");
        return false;
    }
    if (pwd1.length === 0) {
        alert("输入密码为空！");
        return false;
    }
    if (pwd2 === "") {
        alert("验证密码为空！");
        return false;
    }
    if (pwd1 !== pwd2) {
        alert("两次密码不一致");
        return false;
    }
    if (phone.length !== 11) {
        alert("电话号输入有误！");
        return false;
    }
    if (file !== "") {
        const fileExt = file.substring(file.lastIndexOf('.') + 1);
        //const card = $("#ucard").val();
        if (fileExt !== "jpg" && fileExt !== "png" && fileExt !== "jpeg" && fileExt !== "JPG" && fileExt !== "PNG" && fileExt !== "JPEG") {
            alert("图片输入有误！只能是.jpg、.png、.jpeg格式的图片");
            return false;
        }
    }
    // if(!flag){
    //     alert("注意：头像不能超过64K");
    //     return false;
    // }
    return true;
}

function handleFiles(files) {
    if(files.length){
        // const fileMaxSize = 1024*64;
        let file = files[0];
        // if(file.size >= fileMaxSize){
        //     alert("头像不能超过64K");
        //     flag = false;
        //     return false;
        // }
        const src = window.URL.createObjectURL(file);
        flag = true;
        $('.tx').attr('src',src);
    }
}