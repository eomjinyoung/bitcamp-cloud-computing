package bitcamp.mvc.web;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;

@RestController
@RequestMapping("/ajax")
public class FileUploadRestController02 {
    
    @Autowired ServletContext sc;
    
    @RequestMapping("upload01")
    public Object upload01(
            String name, 
            String age, 
            MultipartFile[] files) {
        
        System.out.println("upload01()...호출됨!");
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("name", name);
        result.put("age", age);
        
        ArrayList<String> filenames = new ArrayList<>();
        result.put("filenames", filenames);
        
        try {
            for (MultipartFile file : files) {
                if (file.isEmpty()) continue;
                String newfilename = UUID.randomUUID().toString(); 
                String path = sc.getRealPath("/files/" + newfilename);
                file.transferTo(new File(path));
                filenames.add(newfilename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    @RequestMapping("upload02")
    public Object upload02(
            String name, 
            String age, 
            MultipartFile[] files) {
        
        System.out.println("upload01()...호출됨!");
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("name", name);
        result.put("age", age);
        
        ArrayList<String> filenames = new ArrayList<>();
        result.put("filenames", filenames);
        
        try {
            for (MultipartFile file : files) {
                if (file.isEmpty()) continue;
                String newfilename = UUID.randomUUID().toString(); 
                String path = sc.getRealPath("/files/" + newfilename);
                file.transferTo(new File(path));
                filenames.add(newfilename);
                
                Thumbnails.of(path)
                          .size(20, 20)
                          .outputFormat("jpg")
                          .toFile(path + "_20x20");
                Thumbnails.of(path)
                          .size(80, 80)
                          .outputFormat("jpg")
                          .toFile(path + "_80x80");
                Thumbnails.of(path)
                          .size(120, 120)
                          .outputFormat("jpg")
                          .toFile(path + "_120x120");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
}






