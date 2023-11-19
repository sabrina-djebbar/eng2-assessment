package york.eng2.video.cli;

import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import york.eng2.video.cli.videos.AddVideoCommand;
import york.eng2.video.cli.videos.DislikeVideoCommand;
import york.eng2.video.cli.videos.GetVideoCommand;
import york.eng2.video.cli.videos.GetVideosCommand;
import york.eng2.video.cli.videos.LikeVideoCommand;
import york.eng2.video.cli.videos.WatchVideoCommand;

@Command(name = "client", description = "...", mixinStandardHelpOptions = true, subcommands = { GetVideosCommand.class,
		AddVideoCommand.class, GetVideoCommand.class, WatchVideoCommand.class, LikeVideoCommand.class,
		DislikeVideoCommand.class })
public class ClientCommand implements Runnable {

	@Option(names = { "-v", "--verbose" }, description = "...")
	boolean verbose;

	public static void main(String[] args) throws Exception {
		PicocliRunner.run(ClientCommand.class, args);
	}

	@Override
	public void run() {
		// business logic here
		if (verbose) {
			System.out.println("Hi!");
		}
	}
}
