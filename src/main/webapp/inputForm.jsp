<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
    <style>
        .container {
            flex-direction: column;
        }
    </style>
</head>

<body>
    <div class="container mt-5">
        <form action="" method="post">
            <div class="table_container d-flex justify-content-center">
                <table border=1>
                    <tr>
                        <th colspan="2" style="text-align: center;">Input Message</th>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="writer" placeholder="Input your name"></td>
                    </tr>
                    <tr>
                        <td>Message</td>
                        <td><input type="text" name="msg" placeholder="Input messages"></td>
                    </tr>
                </table>
            </div>

            <div class="btn_container d-flex justify-content-center mt-2">
                <button class="me-2">Done</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </div>
</body>

</html>