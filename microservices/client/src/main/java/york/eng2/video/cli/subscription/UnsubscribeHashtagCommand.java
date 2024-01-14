package york.eng2.video.cli.subscription;

import io.micronaut.http.HttpResponse;
import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "unsubscribe-to-hashtag", description = "unsubscribe to a specific hashtag", mixinStandardHelpOptions = true)
public class UnsubscribeHashtagCommand implements Runnable {
	@Inject
	SubscriptionClient client;

	@Parameters(index = "0")
	private String username;

	@Parameters(index = "1")
	private String tag;

	@Override
	public void run() {
		HttpResponse<Void> response = client.unsubscribeToHashtag(username, tag);
		System.out.println("Server responded with: " + response.getStatus());
	}
}
