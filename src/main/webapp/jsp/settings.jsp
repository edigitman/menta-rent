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

<mtw:requiresAuthentication/>
<mtw:useI18N prefix="account"/>

<t:appTemplate>

    <div class="bs-example bs-example-tabs" data-example-id="togglable-tabs">
        <ul id="myTabs" class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active">
                <a href="#home" role="tab" id="home-tab" data-toggle="tab" aria-controls="home" aria-expanded="true">Home</a>
            </li>
            <li role="presentation" class="">
                <a href="#advert" role="tab" id="advert-tab" data-toggle="tab" aria-controls="advert" aria-expanded="false">Adverts</a>
            </li>
            <li role="presentation" class="">
                <a href="#favs" role="tab" id="favs-tab" data-toggle="tab" aria-controls="favs" aria-expanded="false">Favorites</a>
            </li>
        </ul>
        <div id="myTabContent" class="tab-content">
            <div role="tabpanel" class="tab-pane fade active in" id="home" aria-labelledby="home-tab">
                <%--Home settings--%>

                    <mtw:form action="Account.update.mtw" method="post" klass="form-settings" style="width: 330px">
                        <h2 class="form-signin-heading"><mtw:i18n key="title"/></h2>

                        <div id="usernameGroup" class="form-group">
                            <span class="form-control"> ${email} </span>
                        </div>

                        <div id="aliasGroup" class="form-group">
                            <label for="inputAlias" class="sr-only"><mtw:i18n key="alias"/></label>
                            <mtw:input name="alias" type="text" id="inputAlias" klass="form-control"/>
                        </div>

                        <div id="phoneGroup" class="form-group">
                            <label for="inputPhone" class="sr-only"><mtw:i18n key="phone"/></label>
                            <mtw:input name="phone" type="text" id="inputPhone" klass="form-control"/>
                        </div>

                        <button class="btn btn-lg btn-primary btn-block" type="submit"><mtw:i18n key="update"/></button>
                    </mtw:form>

            </div>
            <div role="tabpanel" class="tab-pane fade" id="advert" aria-labelledby="advert-tab">
                    <%--My Adverts--%>

                        <t:advertList adverts="myList" prefix="/Index.mtw?page="/>




            </div>
            <div role="tabpanel" class="tab-pane fade" id="favs" aria-labelledby="favs-tab">
                <p>favs</p>
            </div>
        </div>
    </div>

</t:appTemplate>


<script type="text/javascript">

    $(document).ready(function () {
        $('#menuSettings').addClass('active');

        $('#myTabs a').click(function (e) {
            e.preventDefault();
            $(this).tab('show')
        })
    });

</script>

