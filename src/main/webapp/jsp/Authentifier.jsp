<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">@import url(css/styles.css);</style>
    <title>
        <s:property value="%{getText('authentifier')}"/>
    </title>
</head>
<body>

<%--    <s:url action="authentifier_Client" id="langueFr">--%>
<%--        <s:param name="request_locale">fr</s:param>--%>
<%--    </s:url>--%>

<%--    <s:url action="authentifier_Developpeur" id="langueDe">--%>
<%--        <s:param name="request_locale">de</s:param>--%>
<%--    </s:url>--%>

<%--    <s:a href="%{langueFr}"><IMG SRC="./images/pngfr.gif" border="0"></IMG> </s:a>--%>
<%--    <s:a href="%{langueDe}"><IMG SRC="./images/pngde.gif" border="0"></IMG> </s:a>--%>

    <h2><s:property value="%{getText('bienvenue')}"/></h2>


<%--    <s:if test="errorMessages.size()>0">--%>
<%--        <div id="msg_erreur">--%>
<%--            <label><s:property value="%{getText('developpez.erreur.msgerror')}"/></label>--%>
<%--            <s:actionerror/>--%>
<%--        </div>--%>
<%--    </s:if>--%>
<%--    <s:if test="errors.size()>0">--%>
<%--        <div id="msg_erreur">--%>
<%--            <label><s:property value="%{getText('developpez.erreur.msgerror')}"/></label>--%>
<%--            <s:fielderror/>--%>
<%--        </div>--%>
<%--    </s:if>--%>



    <div id="formulaire">
        <h3><s:property value="%{getText('authentifier')}"></s:property></h3>
        <s:form method ="post" action="authentifier_Client">

            <s:textfield name="login" id="login"
                         label="%{getText('login')}" labelposition="left">
            </s:textfield>

            <s:password name="password" id="password"
                        label="%{getText('password')}" labelposition="left">
            </s:password>

            <s:textfield name="compte" id="compte"
                         label="%{getText('compte')}" labelposition="left">
            </s:textfield>

            <s:submit value = "%{getText('authentifier')}"></s:submit>

        </s:form>

    </div>
    <s:debug/>
</body>
</html>