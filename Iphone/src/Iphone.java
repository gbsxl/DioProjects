public class Iphone extends IphoneFunctions{
    public static void main(String[] args) {
        Iphone iphone11 = new Iphone("Iphone 11", 2018, Color.BLACK);
        iphone11.call("(61)99139-9094");
        iphone11.playMusic();
        iphone11.selectMusic("Why'd only call me when you're high - Arctic Monkeys");
        iphone11.showPage("https://store.steampowered.com/?l=portuguese");
        iphone11.stopMusic();
    }
    String deviceName;
    int releaseYear;
    Color color;

    public Iphone(String deviceName, int releaseYear, Color color) {
        this.deviceName = deviceName;
        this.releaseYear = releaseYear;
        this.color = color;
    }
}
