package york.eng2.video.cli.videos;

import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import york.eng2.video.cli.domain.Video;

@Command(name = "list-videos-by-user", description = "list all videos by user id", mixinStandardHelpOptions = true)
public class GetVideosByUserId implements Runnable {
	@Inject
	VideosClient client;

	@Parameters(index = "0")
	private Long userId;

	@Override
	public void run() {
		for (Video v : client.listByUserId(userId)) {
			System.out.println(v);
		}
	}
}
