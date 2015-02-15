<%@ page import="qiniu.demo.util.Token" %>
<%@ page import="com.qiniu.api.io.PutRet" %>
<%@ page import="qiniu.demo.util.UploadUtil" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <div class="container">
    <div class="header">
        <h3 class="text-muted">QiNiu Demo</h3>
    </div>

    <div class="jumbotron">
        <h1>Form upload</h1>
        <form action="/FormUpload" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="label1">Label 1</label>
                <input type="label1" class="form-control" id="label1" placeholder="demo...">
            </div>
            <div class="form-group">
                <label for="label2">Label 2</label>
                <input type="label2" class="form-control" id="label2" placeholder="demo...">
            </div>
            <div class="form-group">
                <label for="upload">File input</label>
                <input type="file" name="filePath" id="upload">
                <p class="help-block"></p>
            </div>
            <button type="submit" class="btn btn-lg btn-success">Submit</button>
        </form>
    </div>

    <div class="row marketing">
        <div class="col-lg-6">
            <h4>Subheading</h4>
            <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>

            <h4>Subheading</h4>
            <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>

            <h4>Subheading</h4>
            <p>Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
        </div>

        <div class="col-lg-6">
            <h4>Subheading</h4>
            <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>

            <h4>Subheading</h4>
            <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>

            <h4>Subheading</h4>
            <p>Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
        </div>
    </div>

    <footer class="footer">
        <p>&copy; Company 2014</p>
    </footer>

</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>