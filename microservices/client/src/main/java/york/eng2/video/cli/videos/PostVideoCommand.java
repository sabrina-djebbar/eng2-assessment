package york.eng2.video.cli.videos;

import io.micronaut.http.HttpResponse;
import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import york.eng2.video.cli.dto.VideoDTO;

@Command(name = "post-video", description = "post a new video", mixinStandardHelpOptions = true)
public class PostVideoCommand implements Runnable {
	@Inject
	VideosClient client;

	@Parameters(index = "0")
	String title;

	@Parameters(index = "1")
	String tags;

	@Parameters(index = "2")
	String username;

	@Override
	public void run() {
		VideoDTO dto = new VideoDTO();
		dto.setTitle(title);
		dto.setTags(tags);
		dto.setUsername(username);
		HttpResponse<Void> response = client.post(dto);
		System.out.println("Tags " + tags);
		System.out.println("Server responded with: " + response.getStatus());
	}
}
