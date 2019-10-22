package com.test;

import com.springmvc.controller.HomeController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

public class HomeControllerTest {

    @Test
    public void testHomePage(){
        HomeController controller = new HomeController();
        assertEquals("index",controller.index());
    }

    @Test
    public void testHomePage2() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("index"));
    }
}
