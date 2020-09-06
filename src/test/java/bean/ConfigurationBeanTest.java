package bean;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigurationBeanTest {

    private ConfigurationBean bean = new ConfigurationBean();
    @Test
    public void test(){
        assertNotNull(bean);
    }

}