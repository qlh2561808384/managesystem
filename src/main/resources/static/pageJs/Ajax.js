let AjaxPost = (url,jsonData,contentType,lodingFun,returnFun) => {
    if (contentType === "") {
        $.ajax({
            type: "post",
            url: url,
            data: jsonData,
            dataType:"json",
            async: 'false',
            beforeSend: lodingFun,
            success: returnFun,
            error: (XMLHttpRequest, textStatus, errorThrown) => {
                try {
                    let response = JSON.parse(XMLHttpRequest.responseText);
                    layer.alert(response.msg + "," + response.data, {icon: 2});
                } catch (e) {
                    layer.alert('服务器异常', {icon: 2});
                }
            }
        });
    }else {
        $.ajax({
            type: "post",
            url: url,
            data: jsonData,
            dataType:"json",
            async: 'false',
            contentType: contentType,
            beforeSend: lodingFun,
            success: returnFun,
            error: (XMLHttpRequest, textStatus, errorThrown) => {
                try {
                    let response = JSON.parse(XMLHttpRequest.responseText);
                    layer.alert(response.msg + "," + response.data, {icon: 2});
                } catch (e) {
                    layer.alert('服务器异常', {icon: 2});
                }
            }
        });
    }
};
//生成验证码
let code = "";
let canGetCookie = 0; //是否支持存储Cookie 0 不支持 1 支持
let creatCode = () => {
    code = "";
    let codeLength = 4;
    let selectChar = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
    for (let i = 0; i < codeLength; i++) {
        let charIndex = Math.floor(Math.random() * 60);
        code += selectChar[charIndex];
    }
    if (code.length != codeLength) {
        createCode(e);
    }
    if(canGetCookie === 1){
        setCookie(e, code, 60 * 60 * 60, '/');
    }else{
        return code;
    }
};


//hours为空字符串时,cookie的生存期至浏览器会话结束。
//hours为数字0时,建立的是一个失效的cookie,
//这个cookie会覆盖已经建立过的同名、同path的cookie（如果这个cookie存在）。
let setCookie = (name, value, hours, path) => {
    var name = escape(name);
    var value = escape(value);
    var expires = new Date();
    expires.setTime(expires.getTime() + hours * 3600000);
    path = path == "" ? "" : ";path=" + path;
    _expires = (typeof hours) == "string" ? "" : ";expires=" + expires.toUTCString();
    document.cookie = name + "=" + value + _expires + path;
};