package OnlyConsole;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SamsungTV implements TV {

    Speaker speaker;
    int price;
    List<String> addrList;

    Set<String> addrList2;

    Map<String,String> addrList3;

    Properties addrList4;

    public SamsungTV() {
        System.out.println("Hello There~111");
    }

    public void setSpeakerr(Speaker speaker) {
        this.speaker = speaker;
    }

    public void setAddrList(List<String> addrList) {
        this.addrList = addrList;
    }

    public void setAddrList2(Set<String> addrList2) {
        this.addrList2 = addrList2;
    }

    public void setAddrList3(Map<String, String> addrList3) {
        this.addrList3 = addrList3;
    }

    public void setAddrList4(Properties addrList4) {
        this.addrList4 = addrList4;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public SamsungTV(Speaker speaker, int price) {
        System.out.println("Hello There~222");
        this.speaker = speaker;
        this.price = price;
    }

    public void turnOn() {
        System.out.println("삼성 TV 켰다");

        System.out.println("리스트는 " + addrList);

        System.out.println("리스트는 " + addrList2);

        System.out.println("리스트는 " + addrList3 + " " + addrList3.get("고길동"));

        System.out.println("리스트는 " + addrList4 + " " + addrList4.get("abc"));

        //if(speaker != null) {
            speaker.volumeUp();
            System.out.println("가격은 " + price);
        //}


    }

    public void turnOff() {

    }

    public void volumeUp() {

    }

    public void volumeDown() {

    }

}
