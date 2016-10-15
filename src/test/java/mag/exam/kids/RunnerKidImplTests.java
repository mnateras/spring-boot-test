package mag.exam.kids;

import mag.exam.rest.MazeRestClient;
import mag.exam.rest.dto.Position;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@MockBean(classes = MazeRestClient.class)
public class RunnerKidImplTests {

    @SpyBean
    private RunnerKidImpl runnerKid;

	@Test
	public void runnerKidMovesProperly() {
		runnerKid.move(new Position());
	}
	
}
