/**
 * Created by gajdzis on 6/7/17.
 */

import general.DataProvider;
import general.VarstarsIG;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import pl.ls.objects.compound.base.IReferenceObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class DataProviderTest {
    @Test
    public void instanceShouldBeCreated() {
        DataProvider dataProvider = DataProvider.getInstance();
        assertNotNull("data provider missing", dataProvider);
    }

    @Test
    public void instanceShouldBeUnique() {
        DataProvider dataProvider1 = DataProvider.getInstance();
        DataProvider dataProvider2 = DataProvider.getInstance();
        assertSame("multiple data providers created", dataProvider1, dataProvider2);
    }

    @Test
    public void nonNullDataShouldBeReturned() {
        DataProvider dataProvider = DataProvider.getInstance();
        Set<IReferenceObject> refSet = dataProvider.getRefSet();
        assertNotNull("reference set missing", refSet);
        assertFalse("reference set empty", refSet.isEmpty());
        List<VarstarsIG> igList = dataProvider.getIgList();
        assertNotNull("input granule set missing", igList);
        assertFalse("input granule set empty", igList.isEmpty());
        System.out.println(igList.get(0).getOrigObject().getClass().getDeclaredFields().length);
        Field[] fields = igList.get(0).getOrigObject().getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                System.out.println(fields[i].getName());
                assertNotNull("field is null: " + fields[i].getName(), BeanUtils.getProperty(igList.get(0).getOrigObject(), fields[i].getName()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void resultsShouldBeInserted() {
        DataProvider dataProvider = DataProvider.getInstance();
        dataProvider.saveResult("test40", "test7");
        dataProvider.saveResult("test41", "test8");
        dataProvider.saveResult("test42", "test9");
        dataProvider.saveResult("test43", "test0");
        dataProvider.commitResult();
    }
}
