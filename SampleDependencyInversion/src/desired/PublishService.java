package desired;

public class PublishService {

    public void publishPost(SocialMedia socialMedia,String header, String content){
        socialMedia.publishPost(header,content);
    }
}
