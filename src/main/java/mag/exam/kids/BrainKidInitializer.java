package mag.exam.kids;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BrainKidInitializer {

	@Autowired
	private BrainKid brainKid;

	@PostConstruct
	public void initialize() {
		brainKid.helpYourFriend();
	}

}
