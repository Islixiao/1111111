import com.imooc.spring.car.Audi;
import com.imooc.spring.car.Buick;
import com.imooc.spring.human.Humen;
import com.imooc.spring.human.LiSi;
import com.imooc.spring.human.ZhangSan;
import org.junit.Before;
import org.junit.Test;
public class ClassTest {
    private  IoCContainer  ioCContainer=new IoCContainer();
    @Before
    public void before(){
        ioCContainer.setBean(Audi.class,"audi");
        ioCContainer.setBean(Buick.class,"buick");
        ioCContainer.setBean(ZhangSan.class,"zhangsan",
                "audi");
        ioCContainer.setBean(LiSi.class,"lisi",
                "buick");
    }
    @Test
    public void test(){
        Humen zhangsan=(Humen) ioCContainer.getBean("zhangsan");
        zhangsan.goHome();
        Humen lisi=(Humen) ioCContainer.getBean("lisi");
        lisi.goHome();
    }
}
