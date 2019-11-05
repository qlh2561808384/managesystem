const BaseApi = {
    doConnection : function (url,type,data,callback,option) {
        $.ajax($.extend({
            url: url,
            type: type,
            data: data,
            success: function (list) {
                callback && callback(list);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                try {
                    let res = JSON.parse(XMLHttpRequest.responseText);
                    layer.alert(res.msg + "," + res.data, {icon: 2});
                } catch (e) {
                    layer.alert("服务器异常", {icon: 2});
                }
            }
        }), option);
    },
    doPost: function (url,data,callback,option) {
        this.doConnection(url, "POST", data, callback, option || {});
    }
};