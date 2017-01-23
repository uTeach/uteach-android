package com.u.teach.model.entity;

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
public class PictureTest {

    @Test
    public void testResponseFromHttpCreatesModel() throws Exception {
        Picture picture = ResourceUtils.fromRaw("model_picture.json", Picture.class);

        Assert.assertNotNull(picture);
        Assert.assertEquals("large", picture.large());
        Assert.assertEquals("medium", picture.medium());
        Assert.assertEquals("thumb", picture.thumb());
    }

}