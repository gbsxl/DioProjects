abstract class IphoneFunctions implements MusicalReproducer, PhoneDevice, InternetNavigator{
    //MusicalReproducer
    @Override
    public void playMusic(){
        System.out.println("Playing music");
    }

    @Override
    public void selectMusic(String music){
        System.out.println("Select (" + music + ")");
    }

    @Override
    public void stopMusic(){
        System.out.println("Stoping music");
    }

    //PhoneDevice
    @Override
    public void call(String number){
        System.out.println("Calling for " + number);
    }

    @Override
    public void acceptCall(){
        System.out.println("Recieve's call accept");
    }

    @Override
    public void startVoiceMail(){
        System.out.println("Starting Voice Mail");
    }

    //InternetNavigator
    @Override
    public void showPage(String url){
        System.out.println("Acessing " + url);
    }
    public void addNewTab(){
        System.out.println("Openning a new tab");
    }
    public void updatePage(){
        System.out.println("Updating page");
    }
}
