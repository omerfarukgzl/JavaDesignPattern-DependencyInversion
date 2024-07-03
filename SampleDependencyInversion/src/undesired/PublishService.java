package undesired;

public class PublishService {

    public void publishPostOnLinkedIn(LinkedIn linkedin, String header, String content){
        linkedin.publishPost(header,content);
    }
    public void publishPostOnTwitter(Twitter twitter, String header, String content){
        twitter.publishPost(header,content);
    }
    public void publishPostOnFacebook(Facebook facebook, String header, String content){
        facebook.publishPost(header,content);
    }
}
