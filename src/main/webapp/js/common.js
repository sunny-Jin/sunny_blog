//格式化时间
function formatterTime(value) {
    var jsDate = new Date(value);
    var year = jsDate.getFullYear();
    var month = jsDate.getMonth()+1;
    var day = jsDate.getDate();
    var hour = jsDate.getHours();
    var minutes = jsDate.getMinutes();
    var second = jsDate.getSeconds();
    if(month.toString().length == 1)
    {
        month = '0'+month;
    }
    if(day.toString().length == 1)
    {
        day='0'+day;
    }
    if(hour.toString().length == 1)
    {
        hour = '0'+hour;
    }
    if(minutes.toString().length == 1)
    {
        minutes = '0'+minutes;
    }
    if(second.toString().length == 1)
    {
        second = '0'+second;
    }
    var converttime = year+'-'+month+'-'+day+' '+hour+":"+minutes+':'+second;
    return converttime;
}