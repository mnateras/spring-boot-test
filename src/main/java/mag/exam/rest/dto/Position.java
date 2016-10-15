package mag.exam.rest.dto;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Position {

	private int x;
	private int y;

	public int getX() {
		return x;
	}

	public void setX(final int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(final int y) {
		this.y = y;
	}

	public boolean equals(final Object o) {
		if (o instanceof Position) {
			final Position other = (Position) o;
			return (x == other.getX()) && (y == other.getY());
		}
		return false;
	}

	public int hascode() {
		return Objects.hashCode(x, y);
	}

	public String toString() {
		return MoreObjects.toStringHelper(this).add("x", x).add("y", y)
				.toString();
	}

}
