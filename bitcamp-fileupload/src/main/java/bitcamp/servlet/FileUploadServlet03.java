package bitcamp.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/fileupload03")
public class FileUploadServlet03 extends HttpServlet {
    @Override
    protected void doPost(
            HttpServletRequest req, 
            HttpServletResponse resp) throws ServletException, IOException {
        
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
    
        InputStream fileContent = null;
        OutputStream fileOut = null;
        try {
            Map<String, List<FileItem>> paramMap = 
                    upload.parseParameterMap(req);
            
            String name = paramMap.get("name").get(0).getString("UTF-8");
            String age = paramMap.get("age").get(0).getString();
            FileItem photoItem = paramMap.get("photo").get(0);
            
            // 새 파일명 준비
            String newfilename = UUID.randomUUID().toString(); 
            String path = this.getServletContext().getRealPath(
                    "/files/" + newfilename);
            
            // 입력 스트림을 통해 데이터를 읽고 출력 스트림으로 저장하기
            fileContent = photoItem.getInputStream();
            fileOut = new FileOutputStream(path);
            
            byte[] buf = new byte[1024];
            int len = 0;
            
            while ((len = fileContent.read(buf)) != -1) {
                fileOut.write(buf, 0, len);
            }
            
            fileOut.flush();
            
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.println("<html><head><title>파일업로드</title></head><body>");
            out.printf("name = %s<br>\n", name);
            out.printf("age = %s<br>\n", age);
            out.printf("photo = <a href='files/%s'>%s</a><br>\n", 
                    newfilename,
                    newfilename);
            out.printf("<p><img src='files/%s'></p>", newfilename);
            out.println("<p><img id='img1'></p>");
            out.println("<script>");
            out.println("    setTimeout(() => {");
            out.printf(
                    "        document.getElementById('img1').src = 'files/%s';", 
                    newfilename);
            out.println("    }, 5000);");
            out.println("</script>");
            out.println("</body></html>");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {fileContent.close();} catch (Exception e) {}
            try {fileOut.close();} catch (Exception e) {}
        }
    }
}









