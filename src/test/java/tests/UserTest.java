package tests;

import org.junit.jupiter.api.Test;
import services.UserService;

class UserTest {

	@Test
	void postUser() {
		UserService.postUser();
	}

	@Test
	void getUser() {
		UserService.getUser();
	}

}
