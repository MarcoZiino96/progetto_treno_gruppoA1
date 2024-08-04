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
    <h1>Benvenuto nella HomePage!</h1>
    <h2>Lista Treni</h2>

   
     <table>
        <thead>
            <tr>
            	<th>Foto</th>
            	<th>Compagnia</th>
                <th>Sigla</th>
                <th>Lunghezza</th>
                <th>Peso</th>
                <th>Prezzo</th>
                                      
            </tr>
        </thead>
        <tbody>
            <c:forEach var="treno" items="${treni}">
                <tr>
                	<td>${treno.foto}</td>
                	<td>${treno.compagnia}</td>
                    <td>${treno.sigla}</td>
                    <td>${treno.lunghezza}</td>
                    <td>${treno.peso}</td>
                    <td>${treno.prezzo}</td>               
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
        <!-- Barra di ricerca generale -->
    <form id="search-form" method="GET" action="${pageContext.request.contextPath}/home">
        <input type="text" name="search" placeholder="Cerca per sigla, compagnia o utente" value="${param.search}">
        <button type="submit">Cerca</button>
    </form>
    

    
</body>
</html>