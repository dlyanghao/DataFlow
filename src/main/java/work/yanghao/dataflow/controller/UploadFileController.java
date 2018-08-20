package work.yanghao.dataflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import work.yanghao.dataflow.service.DataImportService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadFileController {

    //上传文件路径
    private static String path ="E:\\ideaWorkspace\\dataflow\\src\\main\\upload";

    @Autowired
    private DataImportService dataImportService;

    @RequestMapping(method = RequestMethod.POST,value = "upload")
    public String uploadFile(HttpServletRequest request, MultipartFile file){

        //如果文件不为空，写入上传路径
        if(!file.isEmpty()) {

            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            try {
                file.transferTo(new File(path+"/"+filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //调用导入数据服务
            dataImportService.importDatabase(filepath);
            return "success";
        } else {
            System.out.println("上传文件失败，请重新尝试！");
            return "error";
        }
    }


}
