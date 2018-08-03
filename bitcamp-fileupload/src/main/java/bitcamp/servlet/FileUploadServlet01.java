package bitcamp.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/fileupload01")
public class FileUploadServlet01 extends HttpServlet {
    @Override
    protected void doPost(
            HttpServletRequest req, 
            HttpServletResponse resp) throws ServletException, IOException {
        
        // 일반 폼으로 전송된 한글 데이터가 유니코드로 바뀔 때 깨지지 않게 하려면
        // getParameter()를 호출하기 전에 다음 명령을 먼저 실행해야 한다.
        // 그러나 멀티파트 전송인 경우는 소용없다!
        //req.setCharacterEncoding("UTF-8");
        
        // 업로드 파일을 외장 하드에 저장하는 역할을 수행
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // 멀티파트 데이터를 파싱한다.
        // 업로드된 파일은 위에서 설정한 factory를 이용하여 다룬다.
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        // 클라이언트가 보낸 데이터를 분석한다.
        HashMap<String,Object> paramMap = new HashMap<>();
        try {
            List<FileItem> items = upload.parseRequest(req);
            for (FileItem item : items) {
                if (item.isFormField()) { // 일반 폼 데이터인 경우,
                    paramMap.put(item.getFieldName(), 
                            item.getString("UTF-8"));
                } else { // 파일 데이터
                    // 새 파일명 준비
                    String newfilename = UUID.randomUUID().toString(); 
                    String path = this.getServletContext().getRealPath(
                            "/files/" + newfilename);
                    item.write(new File(path));
                    paramMap.put(item.getFieldName(), 
                            newfilename);
                }
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>파일업로드</title></head><body>");
        out.printf("name = %s<br>\n", paramMap.get("name"));
        out.printf("age = %s<br>\n", paramMap.get("age"));
        out.printf("photo = <a href='files/%s'>%s</a><br>\n", 
                paramMap.get("photo"),
                paramMap.get("photo"));
        out.printf("<p><img src='files/%s'></p>", paramMap.get("photo"));
        out.println("<p><img id='img1'></p>");
        out.println("<script>");
        out.println("    setTimeout(() => {");
        out.printf(
                "        document.getElementById('img1').src = 'files/%s';", 
                paramMap.get("photo"));
        out.println("    }, 5000);");
        out.println("</script>");
        out.println("</body></html>");
    }
}









