package OnlyConsole;

import org.springframework.stereotype.Component;


public class SonySpeaker implements Speaker {

    public void volumeUp() {
        System.out.println("소니 스피커 볼륨업~~");
    }

    public void abc() {
        System.out.println("소니스피커~");
    }

}
