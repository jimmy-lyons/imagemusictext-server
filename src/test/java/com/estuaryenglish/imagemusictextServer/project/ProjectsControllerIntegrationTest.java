package com.estuaryenglish.imagemusictextServer.project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProjectsControllerIntegrationTest {
    @Autowired private MockMvc mvc;
    @Autowired private ProjectsRepository repository;
    @Autowired private ProjectsService service;

    @Test
    void whenNoProjectsSaved_indexReturnsEmptyIterable() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/projects").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    void add_savesProjectToDatabase() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/projects/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "\"name\": \"Blondie\", " +
                                "\"heading\": \"Against The Odds (1974-1882)\", " +
                                "\"client\": \"Universal Music\", " +
                                "\"description\": \"Foo Bar Baz\"}"
                        ))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath(".id").exists())
                .andExpect(jsonPath("$.name").value("Blondie"))
                .andExpect(jsonPath("$.heading").value("Against The Odds (1974-1882)"))
                .andExpect(jsonPath("$.client").value("Universal Music"))
                .andExpect(jsonPath("$.description").value("Foo Bar Baz"));

        mvc.perform(MockMvcRequestBuilders.get("/projects").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").value("Blondie"));
    }
}
