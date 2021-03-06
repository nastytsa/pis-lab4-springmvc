<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Order Records</title>
</head>
<body>
<h1>List of your orders:</h1>
<table style="border: 1px solid black;">
    <thead>
    <tr>
        <th style="border: 1px solid black;">  </th>
        <th style="border: 1px solid black;"> Content </th>
        <th style="border: 1px solid black;"> Status </th>
        <th style="border: 1px solid black;"> Price </th>
        <th style="border: 1px solid black;"> Comment </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${orders}">
        <tr style="border: 1px solid black;">
            <td style="border: 1px solid black;"></td>
            <td style="border: 1px solid black;">${order.content}</td>
            <td style="border: 1px solid black;">${order.status}</td>
            <td style="border: 1px solid black;">${order.price}</td>
            <td style="border: 1px solid black;">${order.comment}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form action="/orders/create", method="get">
    <button>Create new order</button>
</form>
</body>
</html>