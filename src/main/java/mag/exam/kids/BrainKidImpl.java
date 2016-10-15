package mag.exam.kids;

import mag.exam.rest.MazeRestClient;
import mag.exam.rest.dto.Position;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Async("brainKidTaskExecutor")
public class BrainKidImpl implements BrainKid {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(BrainKidImpl.class);

	@Autowired
	private RunnerKid runnerKid;

	@Autowired
	private MazeRestClient mazeRestClient;

	@Autowired
	private ApplicationContext appContext;

	@Override
	public void helpYourFriend() {

		LOGGER.info("Stating to help friend...");

		try {

			final String mazeMap = mazeRestClient.getMazeMap();

			Assert.hasText(mazeMap, "mazeMap can not be empty");
			
			final Position[] wayOutPath = mazeRestClient.getWayOutPath();

			Assert.notEmpty(wayOutPath, "wayOutPath can not be empty");
			Assert.noNullElements(wayOutPath,
					"wayOutPath can not have null elements");

			for (final Position position : wayOutPath) {
				runnerKid.move(position).get();
			}

			LOGGER.info("Friend scaped the maze: {}", mazeRestClient.isItOut());

		} catch (final Exception ex) {
			LOGGER.error("Error happened while helping friend", ex);
		} finally {
			shutdownProgram();
		}
	}

	@Override
	public void shutdownProgram() {
		SpringApplication.exit(appContext);
	}

}
