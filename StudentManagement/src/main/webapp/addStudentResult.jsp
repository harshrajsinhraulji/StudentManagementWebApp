<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student Result Page</title>
    <style>
        table { border-collapse: collapse; width: 90%; margin: auto; }
        th, td { border: 1px solid #000; padding: 8px; text-align: center; }
        th { background-color: #007bff; color: white; }
        h2 { text-align: center; color: green; }
    </style>
</head>
<body>

<h2>${message}</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>Gender</th>
        <th>Date Of Birth</th>
        <th>Course</th>
        <th>Year Of Study</th>
    </tr>

    <tr>
        <td>${studentId}</td>
        <td>${student.name}</td>
        <td>${student.email}</td>
        <td>${student.phoneNumber}</td>
        <td>${student.gender}</td>
        <td>${student.dob}</td>
        <td>${student.course}</td>
        <td>${student.year}</td>
    </tr>

</table>

<a href="add-Student.html" style="display:block; text-align:center; margin-top:30px;">← Back to Add Student Form</a>
<a href="index.html" style="display:block; text-align:center; margin-top:30px;">← Back to HomePage</a>

</body>
</html>
