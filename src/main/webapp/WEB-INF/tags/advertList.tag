<!DOCTYPE html>
<%@ tag description="Simple Wrapper Tag" pageEncoding="UTF-8" %>
<%@ taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ attribute name="adverts" required="true" %>
<%@ attribute name="prefix" type="java.lang.String" required="true" %>

<mtw:paginator size="2" value="${adverts}">

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
                <a href="${prefix}<mtw:out />"><b>Prev</b></a>
            </mtw:hasPrevious>

            <mtw:pageNumbers pagesToShow="3">
                <mtw:isCurrPage> <mtw:out/> </mtw:isCurrPage>
                <mtw:isCurrPage negate="true">
                    <a href="${prefix}<mtw:out />"><mtw:out/></a>
                </mtw:isCurrPage>
            </mtw:pageNumbers>

            <mtw:hasNext>
                <a href="${prefix}<mtw:out />"><b>Next</b></a>
            </mtw:hasNext>
        </div>
    </div>
</mtw:paginator>