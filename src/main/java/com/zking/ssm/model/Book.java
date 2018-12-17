package com.zking.ssm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@ToString
//@JsonIgnoreProperties(value = {"bookid","fileId"})
public class Book  implements Serializable{

    // 书本验证分组
    public static interface ValidateGroups {
        // 新增/修改
        public static interface add {
        }

        // 删除
        public static interface del {
        }
    }


    private Integer bookid;

    @NotBlank(message = "书本名字不能为空",groups = {ValidateGroups.add.class})
    private String bookname;

    @NotNull(message = "书本价格不能为空",groups = {ValidateGroups.add.class})
    @Range( min = 10,max = 100,message = "请输入正确的价格",groups = {ValidateGroups.del.class})
    private Float price;

    @JsonProperty("btype")
    private String booktype;

   // @JsonIgnore
    private String fileId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Book(Integer bookid, String bookname, Float price, String booktype) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.price = price;
        this.booktype = booktype;
    }

    public Book() {
        super();
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}