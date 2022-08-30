package com.pkg.code.mutant;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pkg.code.mutant.controller.MutanteController;
import com.pkg.code.mutant.dto.JsonDNA;
import com.pkg.code.mutant.dto.JsonResult;
import com.pkg.code.mutant.service.MutanteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(value = MutanteController.class)
public class MutantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //@Test
    public void testMutanteMsg() throws Exception {

        List<String> lista = new ArrayList<>();
        lista.add("ATGCGA");
        lista.add("CCGTTC");
        lista.add("TTAAGT");
        lista.add("AGAAGG");
        lista.add("CACTTA");
        lista.add("TCACTG");

        JsonDNA adn =new JsonDNA(lista);
        ObjectMapper mapper = new ObjectMapper();
        String json  =  mapper.writeValueAsString(adn);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/mutant/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        ResultActions perform = mockMvc.perform(requestBuilder);
        MvcResult mvcResult = perform.andReturn();
        MockHttpServletResponse response  =mvcResult.getResponse();
        int status = response.getStatus();
        Assertions.assertEquals(200,status);
    }
}
