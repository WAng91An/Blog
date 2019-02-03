package com.wrq.controller.blog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.ModelMap;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by wangqian on 2019/2/3.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BlogControllerTest {

    @Autowired
    private BlogController blogController;

    @Test
    public void testBlogDetail() throws Exception {
        blogController.blogDetail(34, new ModelMap());
    }
}