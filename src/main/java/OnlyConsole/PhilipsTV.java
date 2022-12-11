package OnlyConsole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("tv")
public class PhilipsTV implements TV {


    @Resource
    private Speaker speaker;

    public PhilipsTV() {
        System.out.println("필립티비입니당~~~");
    }

    public void turnOn() {
        System.out.println("필리스 티비를 켰습니다~~");
        speaker.volumeUp();
    }

    public void turnOff() {

    }

    public void volumeUp() {

    }

    public void volumeDown() {

    }
}
