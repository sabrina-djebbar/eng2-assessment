package york.eng2.video.cli.users;

import io.micronaut.http.HttpResponse;
import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import york.eng2.video.cli.dto.UserDTO;

@Command(name = "add-user", description = "Adds a user", mixinStandardHelpOptions = true)
public class AddUserCommand implements Runnable {

	@Inject
	private UsersClient client;

	@Parameters(index = "0")
	private String username;

	@Override
	public void run() {
		UserDTO dto = new UserDTO();
		dto.setUsername(username);
		System.out.println("#User DTO: " + dto);
		HttpResponse<Void> response = client.add(dto);
		System.out.println("Server responded with: " + response.getStatus());
	}

}
