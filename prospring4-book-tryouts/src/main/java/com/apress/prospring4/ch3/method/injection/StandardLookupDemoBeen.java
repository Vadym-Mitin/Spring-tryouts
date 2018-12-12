package com.apress.prospring4.ch3.method.injection;

/**
 * @author Vadym Mitin
 */
public class StandardLookupDemoBeen implements DemoBeen {
    private MyHelper myHelper;

    public void setMyHelper(MyHelper myHelper) {
        this.myHelper = myHelper;
    }

    @Override
    public MyHelper getMyHelper() {
        return this.myHelper;
    }

    @Override
    public void someOperation() {
        myHelper.doSomethingHelpful();
    }
}
