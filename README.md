# Eng2-assessment

## Microservices
### Running the microservices

To run the microservices
- `cd` into each microservice folder: [video-microservice](./microservices/video-microservice),  [trending-microservice](./microservices/trending-microservice) and [subscription-microservice](./microservices/subscription-microservice) and run `./gradlew dockerBuild`
- `cd` back into the root [microservices](./microservices) folder and run `docker compose up -d`

### Testing commands
- in a new command prompt terminal `cd` into the  [microservices/client](./microservices/client) folder and run `gradlew run --args="command [arguments]"

### CLI commands
- post a new video
>- `gradlew run --args="post-video 'video-title' 'some,hashtags,in,a,comma,separated,list' 'username'"`
- list all videos
>- `gradlew run --args="list-videos"`
- list videos posted by a specific user
>- `gradlew run --args="list-videos-by-user"`
- like a video
>- `gradlew run --args="like-video video_id 'username'"`
- dislike a video
>- `gradlew run --args="dislike-video video_id 'username'"`
- watch a video
>- `gradlew run --args="watch-video video_id 'username'"`
- list trending hashtags
>- `gradlew run --args="list-trending-hashtags"`
- user subscribe to a hashtag
>- `gradlew run --args="subscribe-to-hashtag 'username' 'hashtag_name'"`
- user unsubscribe to a hashtag
>- `gradlew run --args="unsubscribe-to-hashtag 'username' 'hashtag_name'"`
- list next ten recommended videos
>- `gradlew run --args="get-videos-to-watch 'username' 'hashtag_name'"`
