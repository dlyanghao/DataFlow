<#import "spring.ftl" as s />
<!DOCTYPE>
<html>
<head>
    <title>Welcome!</title>
    <script type="text/javascript" src="<@s.url '/js/jquery-3.3.1.min.js'/>"></script>
    <script type="text/javascript" src="<@s.url '/js/bootstrap.min.js'/>"></script>
    <link rel="stylesheet" href="<@s.url '/css/bootstrap.min.css'/>">
</head>
<body>
    <h1>
        Welcome to use dataFlow engine!
    </h1>
    <form action="upload" enctype="multipart/form-data" method="post" >
        <div class="form-group">
            <label for="exampleInputFile">导入数据库</label>
            <input type="file" name="file" id="exampleInputFile">
            <p class="help-block">请选择文件</p>
            <input type="submit" class="btn btn-default" value="上传">
        </div>
    </form>
</body>
</html>