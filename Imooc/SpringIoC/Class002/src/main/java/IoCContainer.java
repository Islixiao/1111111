import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
* 实例化bean
* 保存bean
* 提供bean
* 每一个bean要产生一个唯一的id与之相对应
* */
public class IoCContainer {
    private Map<String,Object> beans=new ConcurrentHashMap<String, Object>();
/*
* 根据beanId获取一个Bean
* 返回Bean*/
    public Object getBean(String beanId) {
        return beans.get(beanId);
    }
    /*
    * 委托ioc容器创造一个bean
    * 指定要创造的bean的class，以及Id，
    * 要创造的bean的class的构造方法所需的参数的beanId们
    * */
    public void setBean(Class<?> clazz,String beanId,String ...parambeanIds) {
        //1、组装构造方法所需的参数值
        Object[] paramValues=new Object[parambeanIds.length];
        for (int i = 0; i < parambeanIds.length; i++) {
            paramValues[i]=beans.get(parambeanIds[i]);
        }
        //2.调用构造方法实例化bean
        Object bean=null;
        for (Constructor<?> constructor : clazz.getConstructors()) {
            try {
                bean=constructor.newInstance(paramValues);
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
        }
        if(bean==null) {
            throw new RuntimeException("找不到合适的构造方法");
        }
        //3.将实例化的bean放入beans中
        beans.put(beanId,bean);
    }
}
