package com.apress.prospring4.ch3.method.injection;

/**
 * @author Vadym Mitin
 */
public abstract class AbstractLookupDemoBean implements DemoBeen {
    public abstract MyHelper getMyHelper();

    @Override
    public void someOperation() {
        getMyHelper().doSomethingHelpful();
    }
}
