package mag.exam.kids;

import java.util.concurrent.Future;

import mag.exam.rest.MazeRestClient;
import mag.exam.rest.dto.Position;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
@Async("runnerKidTaskExecutor")
public class RunnerKidImpl implements RunnerKid {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(RunnerKidImpl.class);

	@Autowired
	MazeRestClient mazeRestClient;

	@Override
	public Future<Boolean> move(final Position position) {

		LOGGER.info("Moving to {}", position);

		mazeRestClient.moveRunner(position);

		LOGGER.info("Moved to {}", position);

		return new AsyncResult<Boolean>(Boolean.TRUE);
	}

}
