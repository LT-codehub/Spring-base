package com.tao;

import com.tao.component.BeanLive;
import com.tao.component.Cat;
import com.tao.component.XmlComponent;
import com.tao.component.Zoo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
public class IOCTest {

    // 创建 IOC 容器对象，为便于其他实验方法使用声明为成员变量
    private ApplicationContext iocContainer = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testExperiment01() {

        //通过类获取组件
        XmlComponent xmlComponent1 = (XmlComponent) iocContainer.getBean(XmlComponent.class);
        //如果组件类实现了接口，根据接口类型可以获取 bean 吗？
        //> 可以，前提是bean唯一

        //如果一个接口有多个实现类，这些实现类都配置了 bean，根据接口类型可以获取 bean 吗？
        //> 不行，因为bean不唯一
        //XmlComponent xmlComponent2 = (XmlComponent) iocContainer.getBean(XmlComponent.class);

        //通过id获取组件
        // 从 IOC 容器对象中获取bean，也就是组件对象
        XmlComponent xmlComponent = (XmlComponent) iocContainer.getBean("xmlComponent");
        xmlComponent.info();

    }
    @Test
    public void testExperiment02() {

        Cat cat = (Cat) iocContainer.getBean("cat");
        System.out.println(cat.toString());


    }
    @Test
    public void testExperiment03() {

        Zoo zoo = (Zoo) iocContainer.getBean("zoo");
        System.out.println(zoo.toString());


    }
    @Test
    public void testExperiment04() {

        Zoo zoo = (Zoo) iocContainer.getBean("zoo1");
        System.out.println(zoo.toString());


    }
    @Test
    public void testExperiment06() throws SQLException {
        DataSource dataSource = iocContainer.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        log.debug("connection = " + connection);
    }
    @Test
    public void testExperiment07(){
        BeanLive bean = iocContainer.getBean(BeanLive.class);
        System.out.println(bean);

    }



}