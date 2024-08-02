<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrazione Utente</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        form {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input[type="text"], input[type="email"], input[type="password"], input[type="date"] {
            width: 100%;
            padding: 8px;
            margin: 5px 0 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 15px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .container {
            width: 90%;
            margin: auto;
        }
        .message {
            color: #d44;
            font-size: 1.2em;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Registrazione Utente</h2>
        <form action="${pageContext.request.contextPath}/utente" method="post">
            <!-- Se ci sono messaggi di errore, mostrali qui -->
            <c:if test="${not empty errorMessage}">
                <div class="message">${errorMessage}</div>
            </c:if>
            
            <!-- Campo Nome -->
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" value="${utente.nome}" required />
            
            <!-- Campo Cognome -->
            <label for="cognome">Cognome:</label>
            <input type="text" id="cognome" name="cognome" value="${utente.cognome}" required />
            
            <!-- Campo Email -->
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${utente.email}" required />
            
            <!-- Campo Data di Nascita -->
            <label for="dataNascita">Data di Nascita:</label>
            <input type="date" id="dataNascita" name="dataNascita" value="${utente.dataNascita}" required />
            
            <!-- Campo Username -->
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="${utente.username}" required />
            
            <!-- Campo Password -->
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" value="${utente.password}" required />
            
            <!-- Pulsante di Invio -->
            <input type="submit" value="Registrati" />
        </form>
    </div>
</body>
</html>