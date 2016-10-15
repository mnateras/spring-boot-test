package mag.exam.kids;

import java.util.concurrent.Future;

import mag.exam.rest.dto.Position;

public interface RunnerKid {

	public Future<Boolean> move(Position position);

}
