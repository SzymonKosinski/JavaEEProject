<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
   <head>
      <title>File Uploading Form</title>
   </head>
   
   <body>
      <h3>File Upload:</h3>
      Select a file to upload: <br />
      <form action= "NewServlet" method = "POST"
         enctype = "multipart/form-data">
         <input type = "file" name = "file" />
         <br />
        opis pliku: <input type="text" name="description"/>
        <br />
        <input type = "submit" value = "Upload File"/>
      </form>
         <br />
          <br />
        <br />
         <br />
                 <form action="ListOfFiles.jsp">
    <input type="submit" value="Show files">
</form>
   </body>
   
</html>