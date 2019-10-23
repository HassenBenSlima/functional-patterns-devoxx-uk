package victor.clean.lambdas;

import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

import lombok.Data;

// get the list of users to UI

class UserFacade {
	
	private UserRepo userRepo;
	
	public List<UserDto> getAllUsers() {
		return userRepo.findAll().stream().map(UserDto::new).collect(toList());
	}

}










// VVVVVVVVV ==== supporting (dummy) code ==== VVVVVVVVV
interface UserRepo {
	List<User> findAll();
}

@Data
class User {
	private String firstName;
	private String lastName;
	private String username;
	private LocalDate deactivationDate;
}

@Data
class UserDto {
	private String fullName;
	private String username;
	private boolean active;

	public UserDto(User user) {
		setUsername(user.getUsername());
		setFullName(user.getFirstName() + " " + user.getLastName().toUpperCase());
		setActive(user.getDeactivationDate() == null);
	}
}
