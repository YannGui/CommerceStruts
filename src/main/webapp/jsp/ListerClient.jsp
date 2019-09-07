<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Liste des clients</title>
<style type="text/css">@import url(css/styles.css);</style>
</head>
<body>
<!-- Message d'erreur -->
<s:if test="errors.size()>0">
<div id="message_erreur">
	<label>Les erreurs suivantes se sont produites : </label>
	<ul><s:fielderror/></ul>
</div>
</s:if>

<div id="index">
	<h2><s:property
			value="%{getText('Ajouterunclient')}"></s:property>
	</h2>
	<s:form method="post" action="Ajouter_Client">
		<s:textfield name="client.identifiant" id="client.identifiant" label="%{getText('identifiant')}" labelposition="top" cssClass="input"/>
		<s:textfield name="client.motdepasse" id="client.motdepasse" label="%{getText('motdepasse')}" labelposition="top" cssClass="input"/>
		<s:submit value="%{getText('Ajouterunclient')}"/>
	</s:form>


	<h2><s:property
			value="%{getText('listedesclients')}"></s:property>
	</h2>
	<table border="0" id="tableau" cellpadding="0" cellspacing="0">
	<tr><td><b><s:property value="%{getText('idClient')}"/></b></td><td><b><s:property value="%{getText('identifiant')}"/></b></td>
		<td><b><s:property value="%{getText('motdepasse')}"/></b></td><td colspan="2" align="center"><b><s:property value="%{getText('traitement')}"/></b></td></tr>
	<s:iterator value="listeClients" status="ligne">
	<s:if test="#ligne.odd"><tr class="ligne1"></s:if>
	<s:if test="#ligne.even"><tr class="ligne2"></s:if>
		<td><s:property value="idClient"/></td>
		<td><s:property value="identifiant"/></td>
		<td><s:property value="motdepasse"/></td>
    	<td align="center"><a href="Editer_Client.action?idClientEnCours=${idClient}"/><img src="images/editerclient.png" alt="Editer" title="Editer" border="0"/></a></td>
    	<td align="center"><a href="Supprimer_Client.action?idClientEnCours=${idClient}"/><img src="images/supprimerclient.png" alt="Supprimer" title="Supprimer" border="0"/></a></td>
  	</tr>
	</s:iterator>
	</table>	
</div>
</body>

<footer>
	<s:a action="Lister_Client">
		<s:param name="request_locale">en</s:param>
		[English]
	</s:a>
	<s:a action="Lister_Client">
		<s:param name="request_locale">fr</s:param>
		[Francais]
	</s:a>
</footer>
</html>
