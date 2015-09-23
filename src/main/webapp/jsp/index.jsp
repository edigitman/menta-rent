<%@ taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<mtw:useI18N prefix="index"/>
<t:appTemplate>

    <h3><mtw:i18n key="title"/></h3>
    <hr/>
    <div class="row">
        <div class="col-md-6">
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                </span>
                <input type="text" class="form-control" placeholder="criterii" aria-describedby="basic-addon1">
            </div>
        </div>
        <div class="col-md-1">
            <button class="btn btn-primary">search</button>
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
    </div>

    <br/><br/>

    <mtw:paginator size="2" value="myList">

        <table class="table table-condensed">
            <mtw:loop var="item">
                <tr>
                    <td>${item.description}</td>
                </tr>
            </mtw:loop>
        </table>

        <div class="row">
            <div class="col-md-6 pull-right" style="text-align: right">

                <mtw:hasPrevious>
                    <a href="/Index.mtw?page=<mtw:out />"><b>Prev</b></a>
                </mtw:hasPrevious>

                <mtw:pageNumbers pagesToShow="3">
                    <mtw:isCurrPage> <mtw:out/> </mtw:isCurrPage>
                    <mtw:isCurrPage negate="true">
                        <a href="/Index.mtw?page=<mtw:out />"><mtw:out/></a>
                    </mtw:isCurrPage>
                </mtw:pageNumbers>

                <mtw:hasNext>
                    <a href="/Index.mtw?page=<mtw:out />"><b>Next</b></a>
                </mtw:hasNext>
            </div>
        </div>
    </mtw:paginator>
</t:appTemplate>

