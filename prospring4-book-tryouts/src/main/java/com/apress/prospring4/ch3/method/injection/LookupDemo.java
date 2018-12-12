package com.apress.prospring4.ch3.method.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StopWatch;

/**
 * @author Vadym Mitin
 */
public class LookupDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "com/apress/prospring4/ch3/method/injection/method-injection.xml");
        StandardLookupDemoBeen standardBeen = ctx.getBean("standardBeen", StandardLookupDemoBeen.class);
        AbstractLookupDemoBean abstractBean = ctx.getBean("abstractBean", AbstractLookupDemoBean.class);

        displayInfo(standardBeen);
        displayInfo(abstractBean);
        System.out.println("The end!");

    }

    public static void displayInfo(DemoBeen been) {

        MyHelper myHelper1 = new MyHelper();
        MyHelper myHelper2 = new MyHelper();

        System.out.println("are helper instance the same? = " + (myHelper1 == myHelper2));

        int count = 100000;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("LookupDemo");
        for (int i = 0; i < count; i++) {
            MyHelper helper = been.getMyHelper();
            helper.doSomethingHelpful();
        }
        stopWatch.stop();
        System.out.println(count + " gets took: "
                + stopWatch.getTotalTimeMillis() + "ms");
    }
}
