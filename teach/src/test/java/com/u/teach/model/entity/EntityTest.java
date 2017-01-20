package com.u.teach.model.entity;

import com.u.teach.BuildConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by saguilera on 1/19/17.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class EntityTest {

    @Test
    public void testEntityCantBeBuilt() throws Exception {
        try {
            new Entity.Builder<>()
                .build();

            Assert.fail();
        } catch (IllegalStateException ex) {
            Assert.assertEquals("Entity cant be instantiated via Build pattern", ex.getMessage());
        }
    }

}