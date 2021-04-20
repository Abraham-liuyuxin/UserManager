$(function ($){
    $("#loginbtn").on("click",function (e){
        var userName = $("#username").val();
        var passwd = $("#userpwd").val();
        $.ajax({
            url: '/security-signin',
            type: 'post',
            contentType: 'application/json',
            dataType: "json",
            cache: false,
            data: JSON.stringify({
                uname: userName,
                ucode: passwd
            }),
            error: function (){
                alert("用户名或密码错误！")
            },
            success: function (res){
                console.log(res);
                window.location.replace("index.html");
            }
        });
    })

})