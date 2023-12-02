package york.eng2.video.cli.trending;

import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import york.eng2.video.cli.domain.Hashtag;

@Command(name = "get-hashtags", description = "list all hashtags", mixinStandardHelpOptions = true)
public class GetHashtagsCommand implements Runnable {
	@Inject
	TrendingClient client;

	@Override
	public void run() {
		for (Hashtag t : client.list()) {
			System.out.println(t);
		}
	}
}
