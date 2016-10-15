package mag.exam;

import mag.exam.config.ThreadPoolsConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ThreadPoolsConfig.class)
public class MainTests {

	@Test
	public void contextLoads() {
	}

}
