package com.u.teach.model.entity;

import com.u.teach.BuildConfig;
import com.u.teach.model.Expertise;
import com.u.teach.model.Gender;
import com.u.teach.model.Rating;
import com.u.teach.test_utils.ResourceUtils;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by saguilera on 1/19/17.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class ProfessorTest {

    @Test
    public void testResponseFromHttpCreatesModel() throws Exception {
        Professor professor = ResourceUtils.fromRaw("model_professor.json", Professor.class);

        Assert.assertNotNull(professor);

        Assert.assertEquals(1, professor.id());

        Assert.assertEquals("Santiago", professor.name());
        Assert.assertEquals(Gender.MALE, professor.gender());
        Assert.assertEquals("mail@mailto.com", professor.email());
        Assert.assertEquals("santiago-picture-large", professor.picture().large());
        Assert.assertTrue(professor.birthday().toString().contains("Mon Apr 23"));

        Assert.assertEquals(-34.56, professor.location().latitude(), 0);
        Assert.assertEquals(Expertise.Type.BLACK, professor.expertise().value());
        Assert.assertEquals(Rating.Type.A_PLUS, professor.rating().value());
        Assert.assertEquals(4000.0, professor.fee());
        Assert.assertEquals(1, professor.tags().size());
        Assert.assertEquals(2, professor.pendingRequests().size());
    }

    @Test
    public void testBuilderWithoutAllParamsFails() {
        try {
            new Professor.Builder()
                .build();

            Assert.fail();
        } catch (IllegalStateException ex) {
        }
    }

    @Test
    public void testBuilderToInstanceBackAndForth() throws Exception {
        Professor professor = ResourceUtils.fromRaw("model_professor.json", Professor.class);

        Assert.assertEquals(1, professor.id());

        professor = professor.newBuilder()
            .id(2)
            .build();

        Assert.assertEquals(2, professor.id());
    }

}
