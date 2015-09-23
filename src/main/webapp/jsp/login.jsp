<%--
  Created by IntelliJ IDEA.
  User: gitmaal
  Date: 23/09/2015
  Time: 09:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<mtw:useI18N prefix="login" />

<t:appTemplate>


    <mtw:form action="Login.mtw" method="post" klass="form-signin">
        <h2 class="form-signin-heading"> <mtw:i18n key="title"/> </h2>
        <label for="inputEmail" class="sr-only"><mtw:i18n key="email"/></label>
        <mtw:input name="username" type="email" id="inputEmail" klass="form-control" />
        <label for="inputPassword" class="sr-only"><mtw:i18n key="password"/></label>
        <mtw:input name="password" type="password" id="inputPassword" klass="form-control" />
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> <mtw:i18n key="rememberMe"/>
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit"><mtw:i18n key="signIn"/></button>
    </mtw:form>

</t:appTemplate>

<script type="text/javascript">

    $( document ).ready(function() {
        $("#inputEmail").attr("placeholder", $("label[for='inputEmail']").html());
        $("#inputPassword").attr("placeholder", $("label[for='inputPassword']").html());
    });

</script>