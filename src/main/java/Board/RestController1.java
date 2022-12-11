package Board;


import org.apache.ibatis.javassist.tools.rmi.Sample;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class RestController1 {

    @RequestMapping(value = "/aaa", produces = "text/plain; charset=EUC-KR")
    public String home(Model model){
        System.out.println("되요123??");
        return "aaawdwd";
    }



    @RequestMapping(value = "/a1", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public SampleVo1 a1(Model model){
        System.out.println("되요123??정말로??");
        return new SampleVo1(112, "스타", "로드");
    }


    @RequestMapping(value = "/a2")
    public List<SampleVo1> a2(Model model){
        System.out.println("되요123??정말로??");
        return IntStream.range(1, 10).mapToObj(i -> new SampleVo1(i, i + "First", i + " Last")).collect(Collectors.toList());
    }


    @RequestMapping(value = "/a3")
    public Map<String, SampleVo1> a3() {

        Map<String, SampleVo1> map = new HashMap<>();

        map.put("First", new SampleVo1(111, "그루트", "주니어"));

        return map;
    }

    @RequestMapping(value = "/a4", params = { "height", "weight"})
    public ResponseEntity<SampleVo1> a4(Double height, Double weight) {

        SampleVo1 vo = new SampleVo1(0, "" + height, "" + weight);

        ResponseEntity<SampleVo1> result = null;

        if (height < 150) {
            result = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(vo);
        } else {
            result = ResponseEntity.status(HttpStatus.OK).body(vo);
        }

        return result;

    }

    @RequestMapping(value = "/a5/{aaa}/{bbb}")
    public String[] a5(@PathVariable("aaa") String aaa, @PathVariable("bbb") Integer bbb) {


        return new String[] { "category: " + aaa, "productid: " + bbb };
    }

    @PostMapping("/a6")
    public SampleVo1 a6(@RequestBody SampleVo1 sampleVo1) {

        System.out.println("convert....티켓은 " + sampleVo1);

        return  sampleVo1;
    }

}
