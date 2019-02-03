package com.wrq.service.blog.impl;

import com.wrq.commons.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by wangqian on 2019/2/3.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class BlogServiceImplTest {

    @Autowired
    private  BlogServiceImpl blogService;

    @Test
    public void testQueryBlogAll() throws Exception {
        ServerResponse serverResponse = blogService.queryBlogs(0, 6);
        log.info("blog：{}", serverResponse);
    }

    @Test
    public void getBlogDetailById() throws Exception {
        ServerResponse serverResponse = blogService.getBlogDetailById(30);
        Assert.assertNotNull(serverResponse);
    }

    @Test
    public void testQueryBlogs() throws Exception {

    }

    @Test
    public void testSaveBlog() throws Exception {

    }

    @Test
    public void testUpdateBlog() throws Exception {

    }

    @Test
    public void testDeleteBlogById() throws Exception {

    }

    @Test
    public void testGetBlogById() throws Exception {

    }
}