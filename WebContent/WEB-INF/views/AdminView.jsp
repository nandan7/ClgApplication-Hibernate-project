<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
    <link rel="stylesheet" href="./css/style.css">
</head>
<body>
<nav>
        <img src="./assets/klu.png" alt="logo" />
     
        <ul>
            <li> <a href="${pageContext.request.contextPath}/login">Logout</a></li>
        </ul>
    </nav>
    <br>
    <div>
        <h2 id="h2">Details of registered students</h2>
    </div>
    <table>
        <tr>
          <th>FirstName</th>
          <th>LastName</th>
          <th>Course</th>
          <th>Email</th>
          <th>phnumber</th>
          <th>Age</th>
          <th>Gender</th>
        </tr>
        
        <c:forEach var = "i" items="${listview}">
           <tr>
              <td><c:out value="${i.firstname}" /></td>
              <td><c:out value="${i.lastname}" /></td>
              <td><c:out value="${i.course}" /></td>
              <td><c:out value="${i.email}" /></td>
              <td><c:out value="${i.phnumber}" /></td>
              <td><c:out value="${i.age}" /></td>
              <td><c:out value="${i.gender}" /></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <br>
    <br>
    <br>
    <br>
     <div>
            <h2 id="h2">Delete any student details</h2>
            </div>
             <form action="${pageContext.request.contextPath}/delete" method="post">
            <label class="label" for="firstname">FirstName: </label>
            <input type="text" name="firstname" id="firstname">
             <button class="button1" type="submit">Delete</button>
            </form>
</body>
</html>