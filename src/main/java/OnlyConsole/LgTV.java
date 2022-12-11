package OnlyConsole;

public class LgTV implements TV {

    public LgTV(){
        System.out.println("이거는");
    }

    public void turnOn() {
        System.out.println("엘지 TV를 켰드아");
    }

    public void turnOff() {

    }

    public void volumeUp() {

    }

    public void volumeDown() {

    }

    public String abc() {
        System.out.println("안냐아앙~");
        return "";
    }

    public String bbc() {
        System.out.println("바아아이~");
        return "";
    }

}
