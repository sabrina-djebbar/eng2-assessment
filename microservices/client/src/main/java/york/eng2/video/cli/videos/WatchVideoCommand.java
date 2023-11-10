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

	@Override
	public void run() {
		// Add userId to this to send event
		HttpResponse<Void> response = client.watchVideo(videoId);
		System.out.println("Server responded with: " + response.getStatus());

	}
}
