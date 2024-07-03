package desired;

public class Facebook implements SocialMedia {
    @Override
    public void publishPost(String header, String content) {
        System.out.println("Header: " + header);
        System.out.println("Content: " + content );
        System.out.println("The post has been prepared for Facebook");
        System.out.println("The post has been published on Facebook");

    }
}
