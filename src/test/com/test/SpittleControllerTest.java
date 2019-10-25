package com.test;

import com.springmvc.controller.SpittleController;
import com.springmvc.entity.Spitter;
import com.springmvc.entity.Spittle;
import com.springmvc.itf.SpittleRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpittleControllerTest {
    @Test
    public void shouldShowRecentSpittles() throws Exception{
        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(Long.MAX_VALUE,20)).thenReturn(expectedSpittles);

        SpittleController spittleController = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(spittleController).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
        mockMvc.perform(get("/spittles"))//对"/spittles"发起GET请求
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList",hasItems(expectedSpittles.toArray())));
    }

    @Test
    public void shouldShowRecentSpittles2() throws Exception{
        List<Spittle> expectedSpittles = createSpittleList(50);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(238900,50)).thenReturn(expectedSpittles);

        SpittleController spittleController = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(spittleController).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
        mockMvc.perform(get("/spittles?max=238900&count=50"))//对"/spittles"发起GET请求
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList",hasItems(expectedSpittles.toArray())));
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle"+i,new Date()));
        }
        return spittles;
    }

    @Test
    public void testSpittle() throws Exception{
        Spittle spittle = new Spittle("Hello",new Date());
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findOne(12345)).thenReturn(spittle);

        SpittleController spittleController = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(spittleController).build();
        mockMvc.perform(get("/spittles/12345"))//对"/spittles"发起GET请求
                .andExpect(view().name("spittle"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle",spittle));
    }

    @Test
    public void showRegistrationFormTest() throws Exception {
        SpittleController spittleController = new SpittleController();
        MockMvc mockMvc = standaloneSetup(spittleController).build();
        mockMvc.perform(get("/spittles/register")).andExpect(view().name("registerForm"));
    }

    @Test
    public void processRegistrationTest() throws Exception {
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        Spitter unsaved = new Spitter("Jack","Bauer","jbauer","24hours");
        Spitter saved = new Spitter(24L,"Jack","Bauer","jbauer","24hours");
        when(mockRepository.save(unsaved)).thenReturn(saved);

        SpittleController spittleController = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(spittleController).build();
        mockMvc.perform(post("/spittles/register")
                .param("firstName","Jack")
                .param("lastName","Bauer")
                .param("username","jbauer")
                .param("password","24hours")).andExpect(redirectedUrl("/spittles/jbauer"));
        verify(mockRepository, atLeastOnce()).save(unsaved);
    }
}
