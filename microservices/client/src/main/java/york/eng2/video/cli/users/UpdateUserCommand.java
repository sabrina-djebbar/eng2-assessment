package york.eng2.video.cli.users;

import io.micronaut.http.HttpResponse;
import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import york.eng2.video.cli.dto.UserDTO;

@Command(name = "update-user", description = "Updates a book", mixinStandardHelpOptions = true)
public class UpdateUserCommand implements Runnable {
	@Inject
	private UsersClient client;

	@Parameters(index = "0")
	private Long id;

	@Option(names = { "-u", "--username" }, description = "Username of the user")
	private String username;

	@Override
	public void run() {
		UserDTO userDetails = new UserDTO();
		if (username != null) {
			userDetails.setUsername(username);
		}

		HttpResponse<Void> response = client.updateUser(id, userDetails);
		System.out.println("Server responded with: " + response.getStatus());
	}

}
