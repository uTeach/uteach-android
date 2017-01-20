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
public class LocationTest {

    @Test
    public void testResponseFromHttpCreatesModel() throws Exception {
        Location location = ResourceUtils.fromRaw("model_location.json", Location.class);

        Assert.assertNotNull(location);
        Assert.assertEquals(1.234567890, location.latitude(), 0);
        Assert.assertEquals(0.987654321, location.longitude(), 0);
    }

    @Test
    public void testCreateModelFromBuilder() {
        Location location = new Location.Builder()
            .latitude(1)
            .longitude(2)
            .build();

        Assert.assertEquals(1, location.latitude(), 0);
        Assert.assertEquals(2, location.longitude(), 0);
    }

    @Test
    public void testMalformedBuilderThrowsException() {
        try {
            new Location.Builder()
                .build();

            Assert.fail();
        } catch (IllegalStateException ex) {
        }
    }

    @Test
    public void testBuilderAndClassBackAndForth() {
        Location location = new Location.Builder()
            .latitude(1)
            .longitude(0)
            .build();

        Assert.assertEquals(1, location.latitude(), 0);

        location = location.newBuilder().latitude(2).build();

        Assert.assertEquals(2, location.latitude(), 0);
    }

}
