$(function ($){
    $("#loginbtn").on("click",function (e){
        var userName = $("#username").val()
        var passwd = $("#userpwd").val()
        $.ajax({
            url: '/test/login',
            type: 'post',
            data: {
                username: userName,
                passwd: passwd
            },
            error: function (){
                alert("服务器超时！")
            },
            success: function (res){
                alert(res)
            }
        })
    })

})