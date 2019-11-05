const nowDate = new Date();
const Time = {
    parseNowDate: function () {
        let year = nowDate.getFullYear();
        let month = nowDate.getMonth();
        let day = nowDate.getDay();
        return year + "-" + month + "-" + day;
    },
    compareTimeYMR:function (parma) {
        let nowtime = new Date(nowDate.getFullYear(), nowDate.getMonth() + 1, nowDate.getDate());
        let Deadline = new Date(parma.substr(0, 4),parma.substr(4, 2) , parma.substr(6, 2));
        if (nowtime > Deadline) {
            return true;
        } else {
            return false;
        }
    }
};