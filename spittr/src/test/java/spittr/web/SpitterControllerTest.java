package spittr.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import spittr.data.SpitterRepository;
import spittr.domain.Spitter;

public class SpitterControllerTest {

	@Test
	public void shouldShowRegistration() throws Exception {
		SpitterRepository spitterRepository = mock(SpitterRepository.class);
		SpitterController controller = new SpitterController(spitterRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/spitter/register")).andExpect(view().name("registerForm"));
	}

	@Test
	public void shouldProcessRegistration() throws Exception {
		SpitterRepository spitterRepository = mock(SpitterRepository.class);
		Spitter unsaved = new Spitter(null,"jbauer", "24hours", "Jack Bauer", null, true);
		Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack Bauer", null, true);
		
		when(spitterRepository.save(unsaved)).thenReturn(saved);
		
		SpitterController spitterController = new SpitterController(spitterRepository);
		MockMvc mockMvc = standaloneSetup(spitterController).build();
		
		mockMvc.perform(post("/spitter/register")
			   .param("firstName", "Jack")
		       .param("lastName", "Bauer")
		       .param("username", "jbauer")
		       .param("password", "24hours"))
		       .andExpect(redirectedUrl("/spitter/jbauer"));
		verify(spitterRepository, atLeastOnce()).save(unsaved);
	}
}
