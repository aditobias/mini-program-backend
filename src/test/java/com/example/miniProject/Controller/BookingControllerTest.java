package com.example.miniProject.Controller;

import com.example.miniProject.Model.Booking;
import com.example.miniProject.Sevice.BookingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(BookingController.class)
@ActiveProfiles(profiles = "test")
public class BookingControllerTest {

    @MockBean
    BookingService bookingService;

    @Autowired
    private BookingController bookingController;

    @Autowired
    private MockMvc mvc;

    @Test
    public void should_return_company_when_given_part_of_string() throws Exception {
        Booking booking = new Booking();

        booking.setWayBillNumber("Test");

        when(bookingService.findByWayBillNumber("Test")).thenReturn(booking);

        ResultActions resultOfExecution = mvc.perform(post("/booking")
                .content(asJsonString(booking)));

        resultOfExecution.andExpect(status().isCreated()).andExpect(jsonPath("$.wayBillNumber", is("Test")));
    }

    public static String asJsonString(final Booking obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}