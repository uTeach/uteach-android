package com.u.teach.model;

import com.u.teach.BuildConfig;
import com.u.teach.test_utils.ResourceUtils;
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
public class ExpertiseTest {

    @Test
    public void testResponseFromHttpCreatesModel() throws Exception {
        Expertise expertise = ResourceUtils.fromRaw("model_expertise.json", Expertise.class);

        Assert.assertNotNull(expertise);
        Assert.assertEquals(Expertise.Type.ORANGE.name(), expertise.value().name());
    }

}