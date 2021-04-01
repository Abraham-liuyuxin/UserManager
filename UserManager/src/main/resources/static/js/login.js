$(function ($){
    $("#loginbtn").on("click",function (e){
        var userName = $("#username").val();
        var passwd = $("#userpwd").val();
        $.ajax({
            url: '/signin',
            type: 'post',
            dataType: "json",
            cache: false,
            data: {
                uname: userName,
                ucode: passwd
            },
            error: function (){
                alert("用户名或密码错误！")
            },
            success: function (res){
                console.log(res);
                if (res.auth === "1"){
                    window.location.replace("index.html");
                }else {
                    alert("用户名或密码错误！");
                }
            }
        });
    })

})