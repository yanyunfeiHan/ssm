package com.zking.ssm.controller;

import com.zking.ssm.model.Book;
import com.zking.ssm.model.BookFile;
import com.zking.ssm.service.IBookFileService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.Response;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/bookFile")
public class BookFileController {

    @Autowired
    public IBookFileService bookFileService;

    @RequestMapping("toBookFile")
    public String toBookFile(@RequestParam String bookId, Model model){

        model.addAttribute("bookId",bookId);
        return "book/bookFileUpload";
    }

    @RequestMapping("bookFileUpload")
    public String upLoad(@RequestParam Integer bookid, @RequestParam MultipartFile img) throws Exception {
        System.out.println(bookid);
        System.out.println(img.getContentType());
        System.out.println(img.getOriginalFilename());

        String fileid = UUID.randomUUID().toString().replace("-", "");
        Book book=new Book();
        book.setFileId(fileid);
        book.setBookid(bookid);

        //文件存放目标路径
        String targetUrl="D://"+img.getOriginalFilename();

        BookFile bookFile=new BookFile();
        bookFile.setFileId(fileid);
        bookFile.setContentType(img.getContentType());
        bookFile.setRealName(img.getOriginalFilename());
        bookFile.setUrl(targetUrl);


        bookFileService.insert(bookFile,book);

        //文件上传
        String filename = img.getOriginalFilename();
        img.transferTo(new File(targetUrl));


        return "redirect:/book/list";
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> downLoad(@RequestParam String fileId) throws Exception {
        //先根据文件id查询对应图片信息
        BookFile bookFile = bookFileService.selectByPrimaryKey(fileId);
        //下载关键代码
        File file=new File(bookFile.getUrl());
        HttpHeaders headers = new HttpHeaders();//http头信息
        String downloadFileName = new String(bookFile.getRealName().getBytes("UTF-8"),"iso-8859-1");//设置编码
        headers.setContentDispositionFormData("attachment", downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //MediaType:互联网媒介类型  contentType：具体请求中的媒体类型信息
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);

    }
}
