package OnlyConsole;

import org.springframework.stereotype.Component;



public class AppleSpeaker implements Speaker{
    public void volumeUp() {
        System.out.println("애플스피커 켬~~");
    }

    public void abc() {
        System.out.println("애플스키퍼~333");
    }
}
