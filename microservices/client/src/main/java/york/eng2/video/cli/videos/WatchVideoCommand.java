package york.eng2.video.cli.videos;

import io.micronaut.http.HttpResponse;
import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "watch-video", description = "watch a video", mixinStandardHelpOptions = true)
public class WatchVideoCommand implements Runnable {
	@Inject
	VideosClient client;

	@Parameters(index = "0")
	private Long videoId;

	@Parameters(index = "1")
	private String userId;

	@Override
	public void run() {
		HttpResponse<Void> response = client.watchVideo(videoId, userId);
		System.out.println("Server responded with: " + response.getStatus());

	}
}
