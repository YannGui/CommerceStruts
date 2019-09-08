<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

<header>
	<s:a action="Lister_Produit">
		<s:param name="request_locale">en</s:param>
		[English]
	</s:a>
	<s:a action="Lister_Produit">
		<s:param name="request_locale">fr</s:param>
		[Francais]
	</s:a>
</header>
<head>
<title>Liste des produits</title>
<style type="text/css">@import url(css/styles.css);</style>
</head>
<body>

<div id="index">
	<h2><s:property
			value="%{getText('listedesproduits')}"></s:property>
	</h2>


	<table border="0" id="tableau" cellpadding="0" cellspacing="0">
	<tr><td><b><s:property value="%{getText('idProduit')}"/></b></td>
		<td><b><s:property value="%{getText('nom')}"/></b></td>
		<td><b><s:property value="%{getText('marque')}"/></b></td>
		<td><b><s:property value="%{getText('caracteristique')}"/></b></td>
		<td colspan="2" align="center"><b><s:property value="%{getText('traitement')}"/></b></td></tr>
	<s:iterator value="listeProduits" status="ligne">
		<td><s:property value="idProduit"/></td>
		<td><s:property value="nom"/></td>
		<td><s:property value="marque"/></td>
		<td><s:property value="caracteristique"/></td>
<%--    	<td align="center"><a href="Editer_Client.action?idClientEnCours=${idClient}"/><img src="images/editerclient.png" alt="Editer" title="Editer" border="0"/></a></td>--%>
<%--    	<td align="center"><a href="Supprimer_Client.action?idClientEnCours=${idClient}"/><img src="images/supprimerclient.png" alt="Supprimer" title="Supprimer" border="0"/></a></td>--%>
  	</tr>
	</s:iterator>
	</table>	
</div>


</body>

<footer>
	<s:a action="Lister_Client">
		<s:param name="request_locale">fr</s:param>
		Retour au menu
	</s:a>
</footer>
</html>
