<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nome sito</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        :root {
            --primary-color: #3498db;
            --secondary-color: #2c3e50;
            --background-color: #ecf0f1;
            --text-color: #34495e;
            --hover-color: #2980b9;
            --accent-color: #e74c3c;
        }

        body {
            background-color: var(--background-color);
            color: var(--text-color);
        }

        .navbar {
            background-color: white;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }

        .navbar-brand img {
            height: 40px;
        }

        .nav-link {
            color: var(--secondary-color);
            font-weight: 500;
            transition: color 0.3s ease;
        }

        .nav-link:hover, .nav-link:focus {
            color: var(--primary-color);
        }

        .navbar-toggler {
            border-color: var(--primary-color);
        }

        .search-form {
            width: 100%;
            max-width: 300px;
        }

        .search-form .form-control {
            border: 2px solid var(--primary-color);
            border-right: none;
            border-radius: 20px 0 0 20px;
        }

        .search-form .btn {
            background-color: var(--primary-color);
            color: white;
            border: 2px solid var(--primary-color);
            border-radius: 0 20px 20px 0;
            transition: background-color 0.3s ease;
        }

        .search-form .btn:hover {
            background-color: var(--hover-color);
        }

        .user-actions .btn {
            color: var(--text-color);
            transition: color 0.3s ease;
        }

        .user-actions .btn:hover {
            color: var(--primary-color);
        }

        .btn-primary {
            background-color: var(--accent-color);
            border-color: var(--accent-color);
            transition: background-color 0.3s ease;
        }

        .btn-primary:hover {
            background-color: #c0392b;
            border-color: #c0392b;
        }
    </style>
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-lg">
            <div class="container">
                <a class="navbar-brand" href="index.jsp">
                   <img src="<%=request.getContextPath()+ "/media/LogoSitoTreno.png"%>" alt="Foto Logo">
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="index.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="about.jsp">Chi siamo</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="contact.jsp">Contatti</a>
                        </li>
                    </ul>
                    <form class="search-form d-flex mx-auto mb-2 mb-lg-0">
                        <div class="input-group">
                            <input class="form-control" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn" type="submit">
                                <i class="bi bi-search"></i>
                            </button>
                        </div>
                    </form>
                    <div class="user-actions">
                        <a href="login.jsp" class="btn">Login</a>
                        <a href="register.jsp" class="btn btn-primary ms-2">Registrati</a>
                    </div>
                </div>
            </div>
        </nav>
    </header>

    <!-- Your page content goes here -->

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>