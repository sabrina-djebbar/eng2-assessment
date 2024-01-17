package york.eng2.video.events;

import java.util.HashMap;
import java.util.Map;

import york.eng2.video.domain.Hashtag;
import york.eng2.video.dto.VideoDTO;

public interface MockVideosProducer extends VideosProducer {
	Map<Long, VideoDTO> postVideo = new HashMap<>();
	Map<Long, Hashtag> likeVideo = new HashMap<>();
	Map<Long, String> watchVideo = new HashMap<>();
	Map<Long, Hashtag> dislikeVideo = new HashMap<>();

	@Override
	default void postVideo(Long id, VideoDTO video) {
		postVideo.put(id, video);
	}

	@Override
	default void likeVideo(Long id, Hashtag tag) {
		likeVideo.put(id, tag);
	}

	@Override
	default void dislikeVideo(Long id, Hashtag tag) {
		dislikeVideo.put(id, tag);
	}

	@Override
	default void watchVideo(Long id, String username) {
		watchVideo.put(id, username);
	}
}
