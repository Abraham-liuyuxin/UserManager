$(function ($){
    var table = $("#usertab")
    table.bootstrapTable({
        height:'600px',
        data:[
            {
                "id":1,
                "username":"李明",
                "sex":"男",
                "age":12,
                "phone":155252529639,
                "address":"HUST"
            },
            {
                "id":2,
                "username":"李明",
                "sex":"男",
                "age":12,
                "phone":155252529639,
                "address":"HUST"
            },
            {
                "id":3,
                "username":"李明",
                "sex":"男",
                "age":12,
                "phone":155252529639,
                "address":"HUST"
            },
            {
                "id":4,
                "username":"李明",
                "sex":"男",
                "age":12,
                "phone":155252529639,
                "address":"HUST"
            }

        ],
        columns:[
            {
                field: 'select',
                checkbox: true,
                align: 'center',
                valign: 'middle',
            },
            {
                field: 'uid',
                title: '编号',
                align: 'center',
                valign: 'middle',
            },
            {
                field: 'uname',
                title: '用户名',
                align: 'center',
                valign: 'middle',
            },
            {
                field: 'sex',
                title: '性别',
                align: 'center',
                valign: 'middle',
            },
            {
                field: 'age',
                title: '年龄',
                align: 'center',
                valign: 'middle',
            },
            {
                field: 'phone',
                title: '电话',
                align: 'center',
                valign: 'middle',
            },
            {
                field: 'address',
                title: '住址',
                align: 'center',
                valign: 'middle',
            }
        ],
        url: "/getusers",
        method: "get",
        async: true
    })

    $("#delete").on("click", function () {
        var selectionsnums = table.bootstrapTable('getSelections')
        console.log(selectionsnums)
        // for (let row of selectionsnums){
        //     var uid = row.id.toString()
        //     table.bootstrapTable('remove', {field:'id', values:uid})
        // }

        $.ajax({
            url: '/delete',
            type: 'post',
            contentType: "application/json",
            data: JSON.stringify(selectionsnums),
            success: function () {
                alert("删除用户成功");
                table.bootstrapTable('refresh');
            },
            error: function () {
                alert("删除用户失败");
            }
        })

    })

    $("#adduser").on("click", function () {
        var uname = $("#name").val();
        var sex = $("#sex").val();
        var age = $("#age").val();
        var phone = $("#phone").val();
        var address = $("#address").val();

        $.ajax({
            url: '/add',
            type: 'post',
            contentType: "application/json",
            dataType: "json",
            cache: false,
            data: JSON.stringify({
                "uname": uname,
                "sex": sex,
                "age": age,
                "phone": phone,
                "address": address
            }),
            success: function () {
                alert("添加用户成功");
                table.bootstrapTable('refresh');
            },
            error: function () {
                alert("添加用户失败");
            }
        })


    })

})