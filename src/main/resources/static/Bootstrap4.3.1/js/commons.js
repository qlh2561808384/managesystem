function Logout() {
    layer.msg('确定退出本系统吗?', {
        time: 0 //不自动关闭
        , btn: ['确定', '取消']
        , yes: function (index) {
            window.location.href = "../../index.html";
        }
    });
}
const updatePwd = () => {
    layer.open({
        type: 2,
        title: '密码修改',
        maxmin: true,
        area: ['450px', '450px'],
        content: '../updatePwd/updatePwd.html?' + 'username=' + username,
        end: function () {
            layer.tips('Hi', '#about', {tips: 1})
        },
    });
};