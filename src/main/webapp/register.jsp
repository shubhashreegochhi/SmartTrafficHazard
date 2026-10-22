
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register - Smart Traffic</title>

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

        .error {
            color: red;
            text-align: center;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>Create Account</h2>
    <p style="text-align:center;">
        Smart Traffic & Road Hazard Reporter
    </p>

    <% if (request.getAttribute("error") != null) { %>
    <p class="error">
        <%= request.getAttribute("error") %>
    </p>
    <% } %>

    <form action="<%= request.getContextPath() %>/register"
          method="post">

        <label>Full Name</label>
        <input type="text" name="fullName" required>

        <label>Email</label>
        <input type="email" name="email" required>

        <label>Password</label>
        <input type="password" name="password"
               minlength="8" required>

        <label>Phone</label>
        <input type="tel" name="phone">

        <button type="submit">Register</button>

    </form>

    <p style="text-align:center;">
        Already registered?
        <a href="<%= request.getContextPath() %>/login.jsp">
            Login
        </a>
    </p>

</div>

</body>
</html>
