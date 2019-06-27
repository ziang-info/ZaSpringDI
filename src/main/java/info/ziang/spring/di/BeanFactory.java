package info.ziang.spring.di;

import java.lang.reflect.Field;

public class BeanFactory {

    public static <Q> Q getBean(Class<Q> clazz) {
        Q result = null;
        try {
            result = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            System.out.println("get the " + clazz.getName() + "failed!!");
            return null;
        } catch (IllegalAccessException e) {
            System.out.println("get the " + clazz.getName() + "failed!!");
            e.printStackTrace();
            return null;
        }

        //查找所有的字段
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {//查找字段中含有依赖注入的字段 存在就进行注入
            Inject inject = field.getAnnotation(Inject.class);
            if (inject != null) {
                System.out.println("Inject Value: " + inject.value() + " for " + clazz.getName());

                Object object = getBean(field.getType());
                if (!field.isAccessible())
                    field.setAccessible(true);
                try {
                    field.set(result, object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    System.out.println("Inject the " + field.getName() + "failed!!");
                }
            }
        }
        return result;
    }
}
