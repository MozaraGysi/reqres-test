package validators;

import common.validators.ResponseDTOValidator;
import common.validators.Validator;
import dto.response.UserResponseDTO;
import io.restassured.response.Response;

public class UserValidator implements Validator, ResponseDTOValidator {

	@Override
	public void validate(Response response) {
		UserResponseDTO userResponseDTO = new UserResponseDTO().fromJsonString(response.getBody().asString());
		validateNotNull(userResponseDTO);
	}
}
