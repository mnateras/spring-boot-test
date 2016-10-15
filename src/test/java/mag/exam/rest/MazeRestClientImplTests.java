package mag.exam.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import mag.exam.rest.dto.Position;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@RestClientTest(MazeRestClient.class)
public class MazeRestClientImplTests {

	@Autowired
	private MazeRestClientImpl mazeRestClient;

	@Autowired
	private MockRestServiceServer mockServer;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void getMazeMapIsSuccessAndReturnsTheMap() throws Exception {
		String expectedMap = "XXOOXX";
		mockServer.expect(requestTo("/rest/maze/map")).andExpect(method(GET))
				.andRespond(withSuccess(expectedMap, MediaType.TEXT_PLAIN));
		String returnedMap = mazeRestClient.getMazeMap();
		mockServer.verify();
		assertThat(expectedMap).isEqualTo(returnedMap);
	}

	@Test
	public void getMazePathIsSuccessAndReturnsThePath()
			throws JsonProcessingException {
		Position position = new Position();
		position.setX(2);
		position.setY(1);
		Position[] expectedPath = new Position[] { position };
		mockServer
				.expect(requestTo("/rest/maze/path"))
				.andExpect(method(GET))
				.andRespond(
						withSuccess(
								objectMapper.writeValueAsString(expectedPath),
								MediaType.APPLICATION_JSON));
		Position[] returnedPath = mazeRestClient.getWayOutPath();
		mockServer.verify();
		assertThat(expectedPath).isEqualTo(returnedPath);
	}

	@Test
	public void moveRunnerIsSuccess() {
		Position position = new Position();
		position.setX(2);
		position.setY(1);
		mockServer.expect(requestTo("/rest/maze/move")).andExpect(method(POST))
				.andRespond(withSuccess());
		mazeRestClient.moveRunner(position);
		mockServer.verify();
	}

	@Test
	public void isItOutIsSuccessAndReturnsTrue() {
		mockServer
				.expect(requestTo("/rest/maze/isOut"))
				.andExpect(method(GET))
				.andRespond(
						withSuccess(Boolean.TRUE.toString(),
								MediaType.APPLICATION_JSON));
		boolean isItOutResponse = mazeRestClient.isItOut();
		mockServer.verify();
		Assert.assertTrue(isItOutResponse);
	}

}