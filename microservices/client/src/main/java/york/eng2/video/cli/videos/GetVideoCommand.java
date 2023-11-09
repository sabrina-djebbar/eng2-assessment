package york.eng2.video.cli.videos;

import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import york.eng2.video.cli.dto.VideoDTO;

@Command(name = "get-video", description = "gets a video", mixinStandardHelpOptions = true)
public class GetVideoCommand implements Runnable {
	@Inject
	VideosClient client;

	@Parameters(index = "0")
	private Long id;

	@Override
	public void run() {
		VideoDTO video = client.getVideoById(id);
		if (video == null) {
			System.err.println("Video not found!");
			System.exit(1);
		} else {
			System.out.println(video);
		}
	}
}
