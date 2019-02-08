package com.wrq.vo;

import lombok.Data;

import java.util.Date;

/**
 * Created by wangqian on 2019/2/3.
 */
@Data
public class DetailVo {

    private Integer id;

    private String title;

    private Integer userId;

    private String userName;

    private String headPic;

    private Date createTime;

    private String img;

    private Integer isHot;

    private String categoryName;

    private String tags;

    private String content;

}
