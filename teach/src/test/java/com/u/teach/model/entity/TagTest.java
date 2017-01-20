package com.u.teach.model.entity;

import com.u.teach.BuildConfig;
import com.u.teach.test_utils.ResourceUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
public class TagTest {

    @Test
    public void testResponseFromHttpCreatesModel() throws Exception {
        Tag tag = ResourceUtils.fromRaw("model_tag.json", Tag.class);

        Assert.assertNotNull(tag);

        Assert.assertEquals(2, tag.id());
        Assert.assertEquals("math", tag.name());
        Assert.assertEquals(2, tag.levels().size());

        Assert.assertEquals(Tag.Level.HIGH_SCHOOL, tag.levels().get(0));
        Assert.assertEquals(Tag.Level.UNIVERSITY, tag.levels().get(1));
    }

    @Test
    public void testBuilderFailsIfIncomplete() {
        try {
            new Tag.Builder()
                .name("test")
                .levels(new ArrayList<Tag.Level>())
                .id(1)
                .build();

            Assert.fail();
        } catch (Exception ex) {
        }
    }

    @Test
    public void testBuilderBackAndForth() {
        Tag tag = new Tag.Builder()
            .name("test")
            .levels(Arrays.asList(Tag.Level.OTHER, Tag.Level.HIGH_SCHOOL))
            .id(1)
            .build();

        Assert.assertEquals("test", tag.name());
        Assert.assertEquals(2, tag.levels().size());
        Assert.assertEquals(1, tag.id());

        tag = tag.newBuilder().levels(Collections.singletonList(Tag.Level.ELEMENTARY)).build();

        Assert.assertEquals("test", tag.name());
        Assert.assertEquals(1, tag.id());
        Assert.assertEquals(1, tag.levels().size());
        Assert.assertEquals(Tag.Level.ELEMENTARY, tag.levels().get(0));
    }

}
