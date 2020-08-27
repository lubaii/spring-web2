package ru.easyum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class FileUploadController {
    @RequestMapping(path = "/courseUpload",method = RequestMethod.POST)
    public String handFormUpload(@RequestParam("file")MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
              try(FileOutputStream stream = new FileOutputStream("uploaded.jsp"))  {
                  stream.write(file.getBytes());
              }
                    return "redirect:uploadSuccess";
            }
            return "redirect:uploadFailure";
        }
}

