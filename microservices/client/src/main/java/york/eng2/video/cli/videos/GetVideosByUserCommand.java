package york.eng2.video.cli.videos;

import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import york.eng2.video.cli.domain.Video;

@Command(name = "get-videos-by-user", description = "list videos by userId", mixinStandardHelpOptions = true)
public class GetVideosByUserCommand implements Runnable {
	@Inject
	VideosClient client;

	@Parameters(index = "0")
	private Long userId;

	@Override
	public void run() {
		for (Video v : client.listVideoByUser(userId)) {
			System.out.println(v);
		}
	}
}