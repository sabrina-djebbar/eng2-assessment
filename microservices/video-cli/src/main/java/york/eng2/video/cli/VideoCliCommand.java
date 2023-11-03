package york.eng2.video.cli;

import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import york.eng2.video.cli.videos.AddVideoCommand;
import york.eng2.video.cli.videos.GetVideosCommand;

@Command(name = "video-cli", description = "...", mixinStandardHelpOptions = true, subcommands = {
		GetVideosCommand.class, AddVideoCommand.class })
public class VideoCliCommand implements Runnable {

	@Option(names = { "-v", "--verbose" }, description = "...")
	boolean verbose;

	public static void main(String[] args) throws Exception {
		PicocliRunner.run(VideoCliCommand.class, args);
	}

	@Override
	public void run() {
		// business logic here
		if (verbose) {
			System.out.println("Hi!");
		}
	}
}
