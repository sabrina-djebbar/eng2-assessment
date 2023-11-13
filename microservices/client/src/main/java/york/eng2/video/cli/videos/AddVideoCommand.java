package york.eng2.video.cli.videos;

import io.micronaut.http.HttpResponse;
import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import york.eng2.video.cli.dto.VideoDTO;

@Command(name = "add-video", description = "post a new video", mixinStandardHelpOptions = true)
public class AddVideoCommand implements Runnable {
	@Inject
	VideosClient client;

	@Parameters(index = "0")
	String title;

	@Parameters(index = "1")
	String[] tags;

	@Parameters(index = "2")
	String userId;

	@Override
	public void run() {
		VideoDTO dto = new VideoDTO();
		dto.setTitle(title);
		dto.setTags(tags);
		dto.setUserId(userId);
		dto.setDislikes(0);
		dto.setLikes(0);
		dto.setViews(0);
		HttpResponse<Void> response = client.post(dto);
		System.out.println("Server responded with: " + response.getStatus());
	}
}
