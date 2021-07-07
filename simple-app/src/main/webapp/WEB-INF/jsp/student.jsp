<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"/>
    <title>Students</title>
</head>
<body>


<div class="container">
    <div class="row py-2">
        <div class="col-12">
            <a class="btn btn-primary" href="/student/new">Add Student</a>
        </div>

        <div class="col-12">
            <table class="table table-bordered my-2">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Age</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="student" items="${requestScope.students}">
                            <tr>
                                <th scope="row">
                                    <c:out value="${student.id}"/>
                                </th>
                                <td>
                                    <c:out value="${student.name}"/>
                                </td>
                                <td>
                                    <c:out value="${student.age}"/>
                                </td>

                                <td>
                                    <c:url value="/student/${student.id}" var="studentUrl"/>
                                    <a class="btn btn-success" href="${studentUrl}"><i class="fas fa-edit"></i></a>
                                    <c:url value="/student/delete/${student.id}" var="studentDelUrl"/>
                                    <a class="btn btn-danger" href="${studentDelUrl}"><i class="far fa-trash-alt"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>

</html>
