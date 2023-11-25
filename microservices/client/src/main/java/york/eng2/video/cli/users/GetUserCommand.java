package york.eng2.video.cli.users;

import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import york.eng2.video.cli.dto.UserDTO;

@Command(name = "get-user", description = "Finds a user by an id", mixinStandardHelpOptions = true)
public class GetUserCommand implements Runnable {
	@Inject
	private UsersClient client;

	@Parameters(index = "0")
	private Long userId;

	@Override
	public void run() {
		UserDTO user = client.getUser(userId);
		if (user == null) {
			System.err.println("User not found!");
			System.exit(1);
		} else {
			System.out.println(user);
		}
	}
}
