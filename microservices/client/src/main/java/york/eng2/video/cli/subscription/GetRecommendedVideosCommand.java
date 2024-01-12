package york.eng2.video.cli.subscription;

import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import york.eng2.video.cli.domain.Video;
import york.eng2.video.cli.videos.VideosClient;

@Command(name = "get-videos-to-watch", description = "recommends ten videos to watch given a tag and user", mixinStandardHelpOptions = true)
public class GetRecommendedVideosCommand implements Runnable {
	@Inject
	SubscriptionClient client;

	@Inject
	VideosClient videoClient;

	@Parameters(index = "0")
	private String username;

	@Parameters(index = "1")
	private String tag;

	@Override
	public void run() {
		for (Video v : client.getNextVideosToWatch(username, tag)) {
			System.out.println(v);
		}
	}
}
