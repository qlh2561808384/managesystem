let loading;
const api = {
    login: (username,password) => {
        return new Promise((resolve, reject) => {
            $.ajax({
                url: "login/login/101",
                type: "POST",
                data: JSON.stringify({
                    username: username,
                    password: password
                }),
                headers:{'token':localStorage.getItem("token")},
                contentType: 'application/json',
                dataType: 'json',
                cache: false,
                //加载倒计时
                /*               beforeSend: () => {
                                   //20S倒计时，一般time的值跟i值保持一致，例如倒计时5s，=5,time=5,i只是起始的数字
                                   loading = layer.msg("加载中。。。", {
                                       time: 20000,
                                       shade: 0.6,
                                       success: function (layero, index) {
                                           var msg = layero.text();
                                           var i = 60;
                                           var timer = null;
                                           var fn = function () {
                                               layero.find(".layui-layer-content").text(msg + '(' + i + ')');
                                               if (!i) {
                                                   // layer.close(index);
                                                   clearInterval(timer);
                                               }
                                               i--;
                                           };
                                           timer = setInterval(fn, 1000);
                                           fn();
                                       },
                                   });
                               },*/
                success: (data) => {
                    // layer.close(loading);
                    resolve(data);
                },
                error: (XMLHttpRequest, textStatus, errorThrown) => {
                    try {
                        let response = JSON.parse(XMLHttpRequest.responseText);
                        layer.alert(response.msg + "," + response.data, {icon: 2});
                    } catch (e) {
                        layer.alert('服务器异常', {icon: 2});
                    }
                }
            });
        });
    },
    keyDowm: () => {
        $("body").keydown(function () {
            if (event.keyCode == "13") {
                $("#submitLogin").click();
            }
        });
    },
    regist: () => {

    }
};
$(function () {
    api.keyDowm();
    $("#firstname").focus();
});
