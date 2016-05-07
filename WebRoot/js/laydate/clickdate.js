extend = function (a, b) { //合并对象
    if (typeof a !== "object" || typeof b !== "object") {
        return;
    }
    for (key in b) {
        a[key] = b[key];
    }
    return a;
};
 
extend(Date.prototype, {
    /***********格式化日期[YYYY|YY]-MM-DD hh:mm:ss*************/
    format: function (format) {
        var self = this;
        return format.replace(/([a-z]+)/ig, function (a, b, c, d) {
            if (/Y{2,}/.test(b)) {
                return b.length === 4 ? self.getFullYear() : ('' + self.getFullYear()).substr(2);
            } else if (/M{2}/.test(b)) {
                return (self.getMonth() + 1) < 10 ? '0' + (self.getMonth() + 1) : self.getMonth() + 1;
            } else if (/D{2}/.test(b)) {
                return (self.getDate()) < 10 ? '0' + self.getDate() : self.getDate();
            } else if (/h{2}/.test(b)) {
                return self.getHours() < 10 ? '0' + self.getHours() : self.getHours();
            } else if (/m{2}/.test(b)) {
                return self.getMinutes() < 10 ? '0' + self.getMinutes() : self.getMinutes();
            } else if (/s{2}/.test(b)) {
                return self.getSeconds() < 10 ? '0' + self.getSeconds() : self.getSeconds();
            } else {
                return 0;
            }
        })
    }
});
 
function setDayVal(val) {
    var now = new Date();
    if (!/-?\d+/.test(val)) {
        return now;
    }
    now.setDate(now.getDate() + parseInt(val));
    return now;
}
this.getPreviousWeek=function(){ 
        //起止日期数组  
        var startStop=new Array(); 
        //获取当前时间  
        var currentDate=new Date(); 
        //返回date是一周中的某一天  
        var week=currentDate.getDay(); 
        //返回date是一个月中的某一天  
        var month=currentDate.getDate(); 
        //一天的毫秒数  
        var millisecond=1000*60*60*24; 
        //减去的天数  
        var minusDay=week!=0?week-1:6; 
        //获得当前周的第一天  
        var currentWeekDayOne=new Date(currentDate.getTime()-(millisecond*minusDay)); 
        //上周最后一天即本周开始的前一天  
        var priorWeekLastDay=new Date(currentWeekDayOne.getTime()-millisecond); 
        //上周的第一天  
        var priorWeekFirstDay=new Date(priorWeekLastDay.getTime()-(millisecond*6)); 
        //添加至数组  
        startStop.push(priorWeekFirstDay); 
        startStop.push(priorWeekLastDay); 
        return startStop; 
};
this.getCurrentMonth=function(){ 
        //起止日期数组  
        var startStop=new Array(); 
        //获取当前时间  
        var currentDate=new Date(); 
        //获得当前月份0-11  
        var currentMonth=currentDate.getMonth(); 
        //获得当前年份4位年  
        var currentYear=currentDate.getFullYear(); 
        //求出本月第一天  
        var firstDay=new Date(currentYear,currentMonth,1); 
        //当为12月的时候年份需要加1  
        //月份需要更新为0 也就是下一年的第一个月  
        if(currentMonth==11){ 
            currentYear++; 
            currentMonth=0;//就为  
        }else{ 
            //否则只是月份增加,以便求的下一月的第一天  
            currentMonth++; 
        } 
        //一天的毫秒数  
        var millisecond=1000*60*60*24; 
        //下月的第一天  
        var nextMonthDayOne=new Date(currentYear,currentMonth,1); 
        //求出上月的最后一天  
        var lastDay=new Date(nextMonthDayOne.getTime()-millisecond); 
        //添加至数组中返回  
        startStop.push(firstDay); 
        startStop.push(lastDay); 
        //返回  
        return startStop; 
};  
this.getLastMonth=function(){ 
        var startStop=new Array(); 
        var currentDate=new Date(); 
        //获得当前月份0-11  
        var currentMonth=currentDate.getMonth()-1; 
        //获得当前年份4位年  
        var currentYear=currentDate.getFullYear(); 
        //求出本月第一天  
        var firstDay=new Date(currentYear,currentMonth,1); 
        //当为12月的时候年份需要加1  
        //月份需要更新为0 也就是下一年的第一个月  
        if(currentMonth==11){ 
            currentYear++; 
            currentMonth=0;//就为  
        }else{ 
            //否则只是月份增加,以便求的下一月的第一天  
            currentMonth++; 
        } 
        //一天的毫秒数  
        var millisecond=1000*60*60*24; 
        //月的第一天  
        var nextMonthDayOne=new Date(currentYear,currentMonth,1); 
        //求出上月的最后一天  
        var lastDay=new Date(nextMonthDayOne.getTime()-millisecond); 
        //添加至数组中返回  
        startStop.push(firstDay); 
        startStop.push(lastDay); 
        //返回  
        return startStop; 
};  
window.onload=function(){
	var choose=document.getElementById('chooseDate');
	var a=choose.getElementsByTagName('a');
	var input1=document.getElementsByTagName('input')[0];
	var input2=document.getElementsByTagName('input')[1];
	a[0].onclick=function(){
		var date= new Date();
		input1.value=setDayVal(0).format('YYYY-MM-DD');
		input2.value=setDayVal(0).format('YYYY-MM-DD');
	};
	a[1].onclick=function(){
		var date= new Date();
		input1.value=setDayVal(-1).format('YYYY-MM-DD');
		input2.value=setDayVal(-1).format('YYYY-MM-DD');
	};
	a[2].onclick=function(){
		var date= new Date();
		input1.value=setDayVal(-10).format('YYYY-MM-DD');
		input2.value=setDayVal(0).format('YYYY-MM-DD');
	};
	a[3].onclick=function(){
		var date= new Date();
		input1.value=setDayVal(-20).format('YYYY-MM-DD');
		input2.value=setDayVal(0).format('YYYY-MM-DD');
	};
	a[4].onclick=function(){
		var date= new Date();
		input1.value=getCurrentMonth()[0].format('YYYY-MM-DD');
		input2.value=getCurrentMonth()[1].format('YYYY-MM-DD');
	};
	a[5].onclick=function(){
		var date= new Date();
		input1.value=getLastMonth()[0].format('YYYY-MM-DD');
		input2.value=getLastMonth()[1].format('YYYY-MM-DD');
	};
	a[6].onclick=function(){
		var date= new Date();
		input1.value=getPreviousWeek()[0].format('YYYY-MM-DD');
		input2.value=getPreviousWeek()[1].format('YYYY-MM-DD');
	};
};
