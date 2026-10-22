
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login - Smart Traffic</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .container {
            width: 350px;
            margin: 60px auto;
            padding: 25px;
            background-color: white;
            border-radius: 8px;
        }

        h2 {
            text-align: center;
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 8px 0 15px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #1677d2;
            color: white;
            border: none;
            cursor: pointer;
        }

        .message {
            text-align: center;
            color: green;
        }

        .error {
            text-align: center;
            color: red;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>Login</h2>
    <p style="text-align:center;">
        Smart Traffic & Road Hazard Reporter
    </p>

    <% if ("true".equals(request.getParameter("registered"))) { %>
    <p class="message">Registration successful! Please login.</p>
    <% } %>

    <% if (request.getAttribute("error") != null) { %>
    <p class="error">
        <%= request.getAttribute("error") %>
    </p>
    <% } %>

    <form action="<%= request.getContextPath() %>/login"
          method="post">

        <label>Email</label>
        <input type="email" name="email" required>

        <label>Password</label>
        <input type="password" name="password" required>

        <button type="submit">Login</button>

    </form>

    <p style="text-align:center;">
        Don't have an account?
        <a href="<%= request.getContextPath() %>/register.jsp">
            Register
        </a>
    </p>

</div>

</body>
</html>
