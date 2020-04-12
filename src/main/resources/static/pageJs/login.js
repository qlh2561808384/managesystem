let getUserName = (data) => {
    return new Promise((resolve, reject) => {
        AjaxPost('', data, "", () => {
        }, (res) => {
            resolve(res);
        });
    });
};
function Logout() {
    layer.msg('确定退出本系统吗?', {
        time: 0 //不自动关闭
        , btn: ['确定', '取消']
        , yes: function (index) {
            localStorage.clear();
            window.location.href = "../index.html";
        }
    });
}

let html = '<div class="nav_upload">\n' +
    '    <input type="file" multiple id="ssi-upload"/>\n' +
    '</div>\n' +
    '<script>\n' +
    '    $(\'#ssi-upload\').ssi_uploader({\n' +
    '        url: \'../upload/uploadImg\',\n' +
    '        locale: "cn",\n' +
    '        preview: "true",\n' +
    '        maxNumberOfFiles:10,//每次允许上传多少个文件。\n' +
    '        data: {\'username\': localStorage.getItem(\'username\')},\n' +
    '        maxFileSize:10,//允许上传的最大文件尺寸。\n' +
    '        allowed:[\'jpg\', \'jpeg\', \'png\', \'bmp\', \'gif\'],//允许上传的文件类型。\n' +
    '        dropZone: false,\n' +
    '        onUpload: function () {\n' +
    '        layer.msg(\"上传成功/successful upload\",{time: 0,btn:[\"确定\"],success:function(layero) { layero.find(\'.layui-layer-btn\').css(\'text-align\', \'center\') },yes:function(index) { let par = parent.layer.getFrameIndex(window.name);parent.layer.close(par);window.parent.location.reload(); }})' +
    '        },\n' +
    '        onEachUpload: function (fileInfo) {\n' +
    '            console.log(fileInfo);\n' +
    '        },\n' +
    '        beforeUpload: function () {\n' +
    '        },\n' +
    '        beforeEachUpload: function (fileInfo, xhr) {\n' +
    '            console.log(fileInfo);\n' +
    '            console.log(xhr);\n' +
    '        }\n' +
    '    });\n' +
    '</script>';
function openUploadImg() {
    //在这里面输入任何合法的js语句
      layer.open({
          type: 1 //Page层类型
          ,area: ['720px', '500px']
          ,offset:'auto'
          // ,title: '照片上传'//title默认显示在左边，能拖动了
          ,title: ['照片上传','text-align:center']//传一个数组，第一个参数标题，第二个参数可以写任何css样式，能拖动
          // ,title: false//不显示title，但是不能拖动了
          ,shade: 0.6 //遮罩透明度
          ,maxmin: true //允许全屏最小化
          ,anim: 1 //0-6的动画形式，-1不开启
          , content: html
      });
}
