package york.eng2.video.cli.users;

import io.micronaut.http.HttpResponse;
import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "delete-user", description = "Deletes a user", mixinStandardHelpOptions = true)
public class DeleteUserCommand implements Runnable {
	@Inject
	private UsersClient client;

	@Parameters(index = "0")
	private Long userId;

	@Override
	public void run() {
		HttpResponse<Void> response = client.deleteUser(userId);
		System.out.println("Server responded with: " + response.getStatus());
	}
}
