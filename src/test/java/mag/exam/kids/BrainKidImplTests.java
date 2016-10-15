package mag.exam.kids;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import mag.exam.rest.MazeRestClient;
import mag.exam.rest.dto.Position;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BrainKidImplTests {

	@MockBean
	private RunnerKid runnerKid;

	@MockBean
	private MazeRestClient mazeRestClient;

	@SpyBean
	private BrainKidImpl brainKid;

	@Test
	public void brainKidHelpsFriendProperly() {

		Position position = new Position();
		position.setX(2);
		position.setY(1);
		Position[] expectedPath = new Position[] { position };

		when(mazeRestClient.getMazeMap()).thenReturn("OOXXOO");		
		when(mazeRestClient.getWayOutPath()).thenReturn(expectedPath);
		when(mazeRestClient.isItOut()).thenReturn(true);
		when(runnerKid.move(position)).thenReturn(new AsyncResult<Boolean>(Boolean.TRUE));
		doNothing().when(brainKid).shutdownProgram();
		
		brainKid.helpYourFriend();
	}

}
