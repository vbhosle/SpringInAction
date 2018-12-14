package spittr;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Spittle {
	private final Long id;
	private final String message;
	private final Date postedTime;
	private Spitter spitter;

	public Spittle(String message, Date time) {
		this.id = null;
		this.message = message;
		this.postedTime = time;
	}

	// for convenience, till we actually get the data from db
	public Spittle(Long id, String message, Date time) {
		this.id = id;
		this.message = message;
		this.postedTime = time;
	}

	public Spittle(Long id, Spitter spitter, String message, Date postedTime) {
		this.id = id;
		this.spitter = spitter;
		this.message = message;
		this.postedTime = postedTime;
	}

	public Long getId() {
		return this.id;
	}

	public String getMessage() {
		return this.message;
	}

	public Date getPostedTime() {
		return this.postedTime;
	}

	public Spitter getSpitter() {
		return this.spitter;
	}

	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "id", "postedTime");
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id", "postedTime");
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}