
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Smart Traffic & Road Hazard Reporter</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            text-align: center;
            margin-top: 100px;
        }

        .container {
            background-color: white;
            width: 500px;
            margin: auto;
            padding: 30px;
            border-radius: 10px;
        }

        button {
            padding: 12px 25px;
            margin: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        .register {
            background-color: #1677d2;
            color: white;
        }

        .login {
            background-color: #28a745;
            color: white;
        }
    </style>
</head>

<body>

<div class="container">

    <h1>Smart Traffic & Road Hazard Reporter</h1>

    <p>Report road hazards and help make roads safer.</p>

    <a href="<%= request.getContextPath() %>/register">
        <button class="register">Register</button>
    </a>

    <a href="<%= request.getContextPath() %>/login.jsp">
        <button class="login">Login</button>
    </a>

</div>

</body>
</html>
