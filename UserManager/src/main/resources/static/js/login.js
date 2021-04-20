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
            error: function (jqXHR){
                console.log(jqXHR);
                alert(jqXHR.responseJSON.Msg);
            },
            success: function (res){
                console.log(res);
                alert(res.Msg);
                window.location.replace("index.html");
            }
        });
    })

})