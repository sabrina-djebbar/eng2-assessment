package york.eng2.video.cli.videos;

import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import york.eng2.video.cli.domain.Video;

@Command(name = "get-videos-by-tag", description = "list videos by tag", mixinStandardHelpOptions = true)
public class GetVideosByTagCommand implements Runnable {
	@Inject
	VideosClient client;

	@Parameters(index = "0")
	private String tag;

	@Override
	public void run() {
		for (Video v : client.listVideoByTag(tag)) {
			System.out.println(v);
		}
	}
}
