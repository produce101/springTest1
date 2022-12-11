package Board;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;



@Data

public class BoardVO {

    @XmlAttribute
    private int seq;
    @XmlTransient
    private String title;
    private String writer;
    @JsonIgnore
    private String content;
    private Date regDate;
    @JsonIgnore
    private int cnt;
    private int allRowCount;
    private String str1;

    private String name;

    private int age;
    @XmlTransient
    private MultipartFile uploadFile;





}
