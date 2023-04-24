package dto.request;

import common.AbstractDTO;
import common.NotNull;

public class UserRequestDTO extends AbstractDTO<UserRequestDTO> {

	@NotNull
	private String name;
	private String job;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
}
