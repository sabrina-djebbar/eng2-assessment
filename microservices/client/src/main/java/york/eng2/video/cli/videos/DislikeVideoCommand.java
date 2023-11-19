package york.eng2.video.cli.videos;

import io.micronaut.http.HttpResponse;
import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "dislike-video", description = "dislike a video", mixinStandardHelpOptions = true)
public class DislikeVideoCommand implements Runnable {
	@Inject
	VideosClient client;

	@Parameters(index = "0")
	Long id;

	@Override
	public void run() {
		HttpResponse<Void> response = client.dislikeVideo(id);
		System.out.println("Server responded with: " + response.getStatus());
	}
}
