package undesired;

public class Main {
    public static void main(String[] args) {


        Twitter twitter = new Twitter();
        LinkedIn linkedIn = new LinkedIn();
        Facebook facebook = new Facebook();

        PublishService publishService = new PublishService();

        publishService.publishPostOnTwitter(twitter,"What is the Turkish kebap? ","Turkish kebap is diverse category of grilled meat dishes originating from Turkiye. ..");
        //publishService.publishPostOnLinkedIn(linkedIn,"What is the Turkish kebap? ","Turkish kebap is diverse category of grilled meat dishes originating from Turkiye. ..");
        //publishService.publishPostOnFacebook(facebook,"What is the Turkish kebap? ","Turkish kebap is diverse category of grilled meat dishes originating from Turkiye. ..");




    }
}