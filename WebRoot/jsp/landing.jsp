<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">            
        <link rel="stylesheet" href="css/min.css" />     
</head>
    <body>  
      <div id="content" class="white">
       <div>
                  开始时间：
          <input placeholder="请输入日期" readonly="readonly"  onclick="WdatePicker()"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
                  结束日期：
         <input placeholder="请输入日期" readonly="readonly"  onclick="WdatePicker()"/>
          &nbsp;&nbsp;&nbsp;&nbsp;      
                 服务器选择：
          <select id ="serverChoice" style="width: 129px">
          		<option style="display:none;"></option>
                <option>1</option>
                <option>2</option>
                <option>3</option>
          </select> 
           &nbsp;&nbsp;&nbsp;&nbsp; 
          <input type="submit" value ="查询" class="seek" style="width: 129px"/><br> 
        </div>
         &nbsp;&nbsp;&nbsp;&nbsp; 
        <div id="chooseDate">
                    快捷选择：<a>[今天]</a> &nbsp;&nbsp;<a>[昨天]</a> &nbsp;&nbsp;<a>[最近十天]</a> &nbsp;&nbsp;
                    <a>[最近二十天]</a> &nbsp;&nbsp;<a>[本月]</a> &nbsp;&nbsp;<a>[上月]</a> &nbsp;&nbsp;<a>[上周]</a>
        </div>
         &nbsp;&nbsp;&nbsp;&nbsp; 
           <table width="100%" class="main_table" cellspacing="2">
		<tr class="main_head">
			<th>日期</th><th>星期</th><th>排重登陆（DAU）</th><th>月排重登陆（MAU）</th><th>DAU/MAU</th>
               <th>排重IP数</th><th>新登录数</th><th>新建角色用户数</th><th>总新登录数</th><th>次日登陆率</th>
               <th>本日冲入金额</th><th>IOS记入金额</th><th>安卓充值金额</th><th>本日消耗金额</th><th>账户剩余金额</th>
               <th>消耗ARPPU</th><th>充值ARPPU</th><th>新付费账户数</th><th>充值账户数</th><th>付费账户/排重登陆</th>  
		</tr>
		<c:choose>
			<c:when test="${not empty landingList }">
				<c:forEach items="${landingList }" var="landing">
					<tr class="main_info">
						<td>${landing.landingId }</td>
						<td>${landing.landing1 }</td>
						<td>${landing.landing2 }</td>
						<td>${landing.landing3 }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
					<td colspan="4">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<div class="page_and_btn">
		${page.pageStr }
	</div>
      </div>            
<script type="text/javascript" src="js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="js/datePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/laydate/clickdate.js"></script>  
<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
</script>
</body>
</html>