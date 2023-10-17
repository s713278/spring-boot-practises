<%@ include file="./common/header.jsp" %>


<%
String name=request.getParameter("name");
if(name==null || name.trim().length()==0){
	name="K Swamy";
}
out.println("Hello World!! JSPs after long time "+name);
%>


<p><%= name %></p>

<p>Define a Method</p>
<%!
public int add(int a ,int b){
return a+b;
}
%>


<p>Invoke Method </p>
<% int sum=add(10,23);%>

<p>Print the value</p>
<%=sum%>

<br>
<%@ include file="./common/footer.jsp" %>