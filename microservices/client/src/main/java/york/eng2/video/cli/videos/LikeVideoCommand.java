package york.eng2.video.cli.videos;

import io.micronaut.http.HttpResponse;
import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "like-video", description = "like a video", mixinStandardHelpOptions = true)
public class LikeVideoCommand implements Runnable {
	@Inject
	VideosClient client;

	@Parameters(index = "0")
	Long id;

	@Parameters(index = "1")
	private String username;

	@Override
	public void run() {
		HttpResponse<Void> response = client.likeVideo(id, username);
		System.out.println("Server responded with: " + response.getStatus());
	}
}
