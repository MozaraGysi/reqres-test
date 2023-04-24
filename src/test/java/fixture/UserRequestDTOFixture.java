package fixture;

import dto.request.UserRequestDTO;

public class UserRequestDTOFixture {

	private UserRequestDTO userRequestDTO;

	private UserRequestDTOFixture() {
		userRequestDTO = new UserRequestDTO();
	}

	public static UserRequestDTOFixture get() {
		return new UserRequestDTOFixture();
	}

	public UserRequestDTO build() {
		return userRequestDTO;
	}

	public UserRequestDTOFixture withData() {
		userRequestDTO.setName("Morfheus");
		userRequestDTO.setJob("QA Engineer");
		return this;
	}
}
