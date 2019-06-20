$().ready(function () {
    // 提交按钮图片
    $("#submitBtn").mouseover(function () {
       this.src = "images/login_submitBtn2.gif";
    }).mouseout(function () {
        this.src = "images/login_submitBtn1.gif";
    });
    // 定位验证码图片位置
    var vcode = $("input[name=vcode]");
    var pos = getAbsPosition(vcode);
    var left = pos.left;
    var top = pos.top + vcode[0].offsetTop+vcode[0].offsetHeight+2;
    $("div.validateCodeDiv").css("top", top).css("left",left);
    // 设置验证码图片的显示风格
    showHiddenImg();
    // 绑定验证码图片框点击事件实现更换功能
    $("div.validateCodeDiv").click(function (event) {
        changeVCode();
        $("div.validateCodeDiv").css("display","block");
        event.stopPropagation();
    })
});
function showHiddenImg() {
    // 隐藏验证码框
    $("input[name=account], input[name=passwd], #submitBtn").click(function () {
        $("div.validateCodeDiv").css("display","none");
    }).focus(function () {
        $("div.validateCodeDiv").css("display","none");
    });
    // 显示验证码框
    $("input[name=vcode]").click(function (event) {
        $("div.validateCodeDiv").css("display","block");
        event.stopPropagation();
    }).focus(function() {
        $("div.validateCodeDiv").css("display","block");
    });
    // 点击其他地方隐藏验证码框
    $(document).click(function () {
        $("div.validateCodeDiv").css("display","none");
    })
}

function changeVCode() {

}