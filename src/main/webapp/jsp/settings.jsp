<%--
  Created by IntelliJ IDEA.
  User: gitmaal
  Date: 23/09/2015
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<mtw:requiresAuthentication />
<t:appTemplate>

  <mtw:form action="Hello.hi.mtw" method="post">
    Type something: <mtw:input type="text" name="msg" size="30" maxlength="30"/>
    <input type="submit" value="Go!"/>
  </mtw:form>

  <mtw:out value="msg" />

</t:appTemplate>
