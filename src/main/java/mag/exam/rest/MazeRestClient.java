package mag.exam.rest;

import mag.exam.rest.dto.Position;

public interface MazeRestClient {

	public String getMazeMap();

	public Position[] getWayOutPath();

	public boolean isItOut();

	public void moveRunner(Position position);

}
