package york.eng2.video.cli.videos;

import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import york.eng2.video.cli.domain.Video;

@Command(name = "get-videos", description = "list next videos to watch", mixinStandardHelpOptions = true)
public class GetVideosCommand implements Runnable {

	@Inject
	VideosClient client;

	@Override
	public void run() {
		for (Video v : client.list()) {
			System.out.println(v);
		}
	}

}
