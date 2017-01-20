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
public class AccessTokenTest {

    @Test
    public void testResponseFromHttpCreatesModel() throws Exception {
        AccessToken accessToken = ResourceUtils.fromRaw("model_access_token.json", AccessToken.class);

        Assert.assertNotNull(accessToken);
        Assert.assertEquals("f148ed1ece66589c3f637745cdae345c94a66c0be31b19abeb098edc155b298a", accessToken.accessToken());
        Assert.assertEquals("7bb93e22de7ebb410dac83572e07a71e490a4deea8acedd3bab5154f2533ea5d", accessToken.refreshToken());
        Assert.assertEquals(AccessToken.UserType.PROFESSOR.name(), accessToken.userType().name());
        Assert.assertEquals("bearer", accessToken.tokenType());
    }

}
