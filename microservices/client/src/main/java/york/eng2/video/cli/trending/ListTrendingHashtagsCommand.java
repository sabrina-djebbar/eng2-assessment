package york.eng2.video.cli.trending;

import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import york.eng2.video.cli.domain.Hashtag;

@Command(name = "list-trending-hashtags", description = "list all hashtags", mixinStandardHelpOptions = true)
public class ListTrendingHashtagsCommand implements Runnable {
	@Inject
	TrendingClient client;

	@Override
	public void run() {
		for (Hashtag t : client.listTrendingHashtags()) {
			System.out.println(t);
		}
	}
}
