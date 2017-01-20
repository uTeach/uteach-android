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
public class RatingTest {

    @Test
    public void testResponseFromHttpCreatesModel() throws Exception {
        Rating rating = ResourceUtils.fromRaw("model_rating.json", Rating.class);

        Assert.assertNotNull(rating);
        Assert.assertEquals(Rating.Type.B.name(), rating.rating().name());
    }

}
