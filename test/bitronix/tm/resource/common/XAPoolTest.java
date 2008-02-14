package bitronix.tm.resource.common;

import bitronix.tm.mock.resource.jdbc.MockXADataSource;
import bitronix.tm.mock.resource.jms.MockXAConnectionFactory;
import bitronix.tm.resource.jdbc.PoolingDataSource;
import bitronix.tm.resource.jms.PoolingConnectionFactory;
import bitronix.tm.resource.ResourceLoader;
import bitronix.tm.resource.ResourceConfigurationException;
import bitronix.tm.internal.CryptoEngine;
import junit.framework.TestCase;

import javax.sql.XADataSource;
import java.util.Map;
import java.util.Properties;
import java.lang.reflect.Field;

/**
 * Created by IntelliJ IDEA.
 * User: OrbanL
 * Date: 16-mrt-2006
 * Time: 18:27:34
 * To change this template use File | Settings | File Templates.
 */
public class XAPoolTest extends TestCase {

    public void testBuildXAFactory() throws Exception {
        ResourceBean rb = new ResourceBean() {
            public XAResourceProducer createResource() {
                return null;
            }
        };

        rb.setMaxPoolSize(1);
        rb.setClassName(MockXADataSource.class.getName());
        rb.getDriverProperties().setProperty("userName", "java");
        rb.getDriverProperties().setProperty("password", "{DES}" + CryptoEngine.crypt("DES", "java"));

        XAPool xaPool = new XAPool(null, rb);
        assertEquals(0, xaPool.totalPoolSize());
        assertEquals(0, xaPool.inPoolSize());

        MockXADataSource xads = (MockXADataSource) xaPool.getXAFactory();
        assertEquals("java", xads.getUserName());
        assertEquals("java", xads.getPassword());
    }

}