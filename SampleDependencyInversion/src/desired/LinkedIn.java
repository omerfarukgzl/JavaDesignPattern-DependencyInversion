package desired;

public class LinkedIn implements SocialMedia {
    @Override
    public void publishPost(String header, String content) {
        System.out.println("Header: " + header);
        System.out.println("Content: " + content );
        System.out.println("The post has been prepared for LinkedIn");
        System.out.println("The post has been published on LinkedIn");

    }
}
