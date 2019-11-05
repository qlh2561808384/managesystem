var API = $.extend({}, BaseApi, {
});
var BaseApi = {
    isDebug: false,
    prefix: '../',
    doConnection: function (method, url, data, options, callback) {
        $.dajax($.extend({
            url: url,
            data: data,
            method: method,
            dataType: 'json',
            cache: false,
            success: function (res) {
                if (res.success) {
                    callback && callback(res.content);
                } else {
                    if (!API.isDebug) {
                        $.dalert({text: res.content, icon: 2});
                    } else {
                        $.dalert({
                            text: url + ',' + res.content, icon: 2
                        });
                    }
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                try {
                    var response = JSON.parse(XMLHttpRequest.responseText);
                    $.alert({text: response.msg + "," + response.data, icon: 2});
                } catch (e) {
                    $.alert({text: "服务器异常", icon: 2});
                }
            }
        }, options));
    },
    doGet: function (url, query, callback, options) {
        this.doConnection("GET", url, query, options || {}, callback);
    },
    doPost: function (url, data, callback, options) {
        this.doConnection("POST", url, data, options || {}, callback);
    },
    doJsonPost: function (url, data, callback, options) {
        this.doPost(url, JSON.stringify(data), callback, $.extend({
            contentType: "application/json"
        }, options));
    }
};
function GetRequest() {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    //返回某个指定字符串在字符串中的首次出现的位置
    if (url.indexOf("?") != -1) {
        //截取第二个字符以后的字符串
        var str = url.substr(1);
        strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
        }
    }
    return theRequest;
};

const getUsername = () => {
    return new Promise((resolve, reject) => {
        $.get("../login/getUsername", {}, (data) => {
            resolve(data);
        });
    });
};

