package mag.exam.rest;

import mag.exam.rest.dto.Position;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MazeRestClientImpl implements MazeRestClient {

	private static final String MAZE_IS_OUT = "/rest/maze/isOut";

	private static final String MAZE_MAP = "/rest/maze/map";

	private static final String MAZE_MOVE = "/rest/maze/move";

	private static final String MAZE_PATH = "/rest/maze/path";

	private final RestTemplate restTemplate;

	public MazeRestClientImpl(final RestTemplateBuilder builder,
			final @Value("${maze.server.host}") String rootUri) {
		restTemplate = builder.rootUri(rootUri).build();
	}

	public String getMazeMap() {
		return restTemplate.getForObject(MAZE_MAP, String.class);
	}

	public Position[] getWayOutPath() {
		return restTemplate.getForObject(MAZE_PATH, Position[].class);
	}

	public boolean isItOut() {
		return restTemplate.getForObject(MAZE_IS_OUT, Boolean.class);
	}

	public void moveRunner(final Position position) {
		restTemplate.postForLocation(MAZE_MOVE, position);
	}

}
