<%@ taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<mtw:useI18N prefix="index"/>
<t:appTemplate>

    <h3><mtw:i18n key="title"/></h3>
    <hr/>
    <div class="row">
        <mtw:form action="Index.mtw" method="post">
            <div class="col-md-6">
                <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                </span>
                    <mtw:input type="text" klass="form-control" name="search" />
                </div>
            </div>
            <div class="col-md-1">
                <button class="btn btn-primary" type="submit">search</button>
            </div>
            <div class="col-md-5">
                <div class="btn-group pull-right" role="group" aria-label="...">
                    <button type="button" class="btn btn-default">Left</button>
                    <button type="button" class="btn btn-default">Middle</button>
                    <button type="button" class="btn btn-default">Right</button>
                    <button type="button" class="btn btn-default">Right</button>
                    <button type="button" class="btn btn-default">Right</button>
                </div>
            </div>
        </mtw:form>
    </div>

    <br/><br/>

    <t:advertList adverts="myList" prefix="/Index.mtw?page="/>

</t:appTemplate>

<script type="text/javascript">
    $(document).ready(function () {
        $('#menuHome').addClass('active');
    });
</script>

