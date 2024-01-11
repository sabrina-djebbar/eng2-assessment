package york.eng2.video.cli.videos;

import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import york.eng2.video.cli.domain.Video;

@Command(name = "list-videos-by-user", description = "lists all videos posted by a specfic user", mixinStandardHelpOptions = true)
public class ListVideosByUserCommand implements Runnable {
	@Inject
	VideosClient client;

	@Parameters(index = "0")
	private String username;

	@Override
	public void run() {
		for (Video v : client.listByUsername(username)) {
			System.out.println(v);
		}
	}
}
