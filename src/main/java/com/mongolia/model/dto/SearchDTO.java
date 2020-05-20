package com.mongolia.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

/**
 * 搜索数据DTO
 *
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SearchDTO extends PageDTO {

    @Min(0)
    @Max(3)
    private Short sex;

    private String city;

    private String phone;

    @Max(200)
    private Short age;

    private String title;

    private String name;

    private String beName;

    @Max(9)
    @Min(0)
    private Short flag;

    @Max(9)
    @Min(0)
    private Short state;

    @Max(9)
    @Min(0)
    private Short rec;

    @Max(3)
    @Min(0)
    private Short rel;

    @Max(9)
    @Min(0)
    private Short heat;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date signStart;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date signEnd;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date start;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date end;

    private String range;

}
