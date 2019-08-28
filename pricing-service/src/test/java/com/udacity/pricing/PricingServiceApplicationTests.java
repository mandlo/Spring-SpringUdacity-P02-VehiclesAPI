package com.udacity.pricing;

import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.domain.price.PriceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.greaterThan;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class PricingServiceApplicationTests {

//	@Autowired
//	private JacksonTester<Price> json;
//
//	@MockBean
//	PriceRepository priceRepository;

	@Autowired
	PricingServiceApplication pricingServiceApplication;

	@Autowired
	private MockMvc mvc;

	@Before
	public void setup() {
        BigDecimal bd = BigDecimal.valueOf(10.0001);
		Price priceCar = getPrice();
		priceCar.setVehicleId(1L);
		priceCar.setCurrency("USD");
		priceCar.setPrice(bd);
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void findPrice() throws Exception {

		Price priceCar = getPrice();
		mvc.perform(
				get("/services/price?vehicleId={vehicleId}", String.valueOf(1L))
						//.content(json.write(priceCar).getJson())
						.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.vehicleId", is(1)))
				.andExpect(jsonPath("$.currency", is("USD")))
				.andExpect(jsonPath("$.price", greaterThan(0.0)));
	}

	/**
	 * Creates an example Price object for use in testing.
	 * @return an example Price object
	 */
	private Price getPrice() {
		Price priceCar = new Price();
		return priceCar;
	}
}
