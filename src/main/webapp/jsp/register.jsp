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
<mtw:useI18N prefix="register"/>

<t:appTemplate>


    <mtw:form action="Register.add.mtw" method="post" klass="form-signin">
        <h2 class="form-signin-heading"><mtw:i18n key="title"/></h2>
        <div id="usernameGroup" class="form-group">
            <label for="inputEmail" class="sr-only"><mtw:i18n key="email"/></label>
            <mtw:input name="username" type="email" id="inputEmail" klass="form-control"/>
            <mtw:outError field="username"> <mtw:out/> </mtw:outError>
        </div>

        <div id="passwordGroup" class="form-group">
            <label for="inputPassword" class="sr-only"><mtw:i18n key="password"/></label>
            <mtw:input name="password" type="password" id="inputPassword" klass="form-control"/>
        </div>

        <div id="confirmGroup" class="form-group">
            <label for="confirmPassword" class="sr-only"><mtw:i18n key="confirm"/></label>
            <mtw:input name="confirmPassword" type="password" id="confirmPassword" klass="form-control"/>
        </div>

        <div class="checkbox">
            <label>
                captcha
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit"><mtw:i18n key="title"/></button>
    </mtw:form>

</t:appTemplate>

<script type="text/javascript">

    $(document).ready(function () {
        $("#inputEmail").attr("placeholder", $("label[for='inputEmail']").html());
        $("#inputPassword").attr("placeholder", $("label[for='inputPassword']").html());
        $("#confirmPassword").attr("placeholder", $("label[for='confirmPassword']").html());

        <mtw:outError field="username"> $("#usernameGroup").addClass('has-error'); </mtw:outError>
        <mtw:outError field="password"> $("#passwordGroup").addClass('has-error'); </mtw:outError>
        <mtw:outError field="confirmPassword"> $("#confirmGroup").addClass('has-error'); </mtw:outError>
    });


</script>