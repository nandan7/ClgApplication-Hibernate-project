<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register here</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<nav>
        <img src="./assets/klu.png" alt="logo" />
     
        <ul>
            <li> <a href="${pageContext.request.contextPath}/login">Logout</a></li>
        </ul>
    </nav>
    <div class="register-form">
        <div class="title">Register</div>
        <form action="${pageContext.request.contextPath}/register" method="post">
             <label class="label" for="firstname">First name:</label>
             <input type="text" name="firstname" id="firstname">
             <label class="label" for="lastname">Last name:</label>
             <input type="text" name="lastname" id="lastname">
             <label for="course">Course:</label>
               <select id="course" name="course">
                <option value="cse">Computer Science and Engineering</option>
                  <option value="ece">Electronics and Communication Engineering</option>
                <option value="ce">Civil Engineering</option>
                <option value="bt">BioTechnology</option>
               <option value="me"> Mechanical Engineering</option>
              </select><br>
             <label class="label" for="email">Email</label>
             <input type="text" name="email" id="email">
             <label class="label" for="phnumber">Phone number:</label>
             <input type="number" name="phnumber" id="phnumber">
             <label class="label" for="age">Age:</label>
             <input type="number" name="age" id="age"><br>     
             <div class="gender">
                  Gender:
             <label for="male">Male</label><input type="radio" id="male" name="gender" value="male">
              <label for="female">Female</label><input type="radio" id="female" name="gender" value="female"><br> 
               </div>    
            <button class="button" type="submit">Submit</button>         
        </form>
    </div>
</body>
</html>