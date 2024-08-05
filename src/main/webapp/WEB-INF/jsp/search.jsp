<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Lista Treni</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/home.css">
</head>

<body>
   <h1>Benvenuto nella pagina dei treni!</h1>
   
    <h2>Lista dei treni disponibili</h2>
    
    <!-- Barra di ricerca generale 
    <form action="${pageContext.request.contextPath}/search" method="get">
        <label for="termineRicerca">Cerca:</label>
        <input type="text" id="termineRicerca" name="termineRicerca" placeholder="Inserisci sigla, compagnia o utente">-->
        
         <form>
        <label for="ordinamento">Ordina per:</label>
    	<select id="ordinamento" name="ordinamento">
        <option value="compagnia">Compagnia</option>
        <option value="sigla">Sigla</option>
        <option value="lunghezza">Lunghezza</option>
        <option value="peso">Peso</option>
        <option value="prezzo">Prezzo</option>
    </select>
    
    <label for="direction">Direzione:</label>
    <select id="direction" name="direction">
        <option value="ASC">Crescente</option>
        <option value="DESC">Decrescente</option>
    </select>
    
        <button type="submit">Cerca</button>
    </form>
    
    
  <table>
    <thead>
        <tr>
            <th>Foto</th>
            <th>Compagnia</th>
            <th>Sigla</th>
            <th>Lunghezza</th>
            <th>Peso</th>
            <th>Prezzo</th>
            <th>Utente</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="treno" items="${treni}">
            <tr>
                <td><img src="${treno.foto}" alt="Foto del treno" /></td>
                <td>${treno.compagnia}</td>
                <td>${treno.sigla}</td>
                <td>${treno.lunghezza}</td>
                <td>${treno.peso}</td>
                <td>${treno.prezzo}</td>
                <td>${treno.utenteUsername}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
    

    
</body>
</html>