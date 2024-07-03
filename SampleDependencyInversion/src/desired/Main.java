package desired;

public class Main {
    public static void main(String[] args) {


        SocialMedia twitter = new Twitter();
        SocialMedia linkedIn = new LinkedIn();
        SocialMedia facebook = new Facebook();

        PublishService publishService = new PublishService();

        publishService.publishPost(twitter,"What is the Turkish kebap? ","Turkish kebap is diverse category of grilled meat dishes originating from Turkiye. ..");
        //publishService.publishPost(linkedIn,"What is the Turkish kebap? ","Turkish kebap is diverse category of grilled meat dishes originating from Turkiye. ..");
        //publishService.publishPost(facebook,"What is the Turkish kebap? ","Turkish kebap is diverse category of grilled meat dishes originating from Turkiye. ..");

    }
}