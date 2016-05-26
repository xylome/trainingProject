package com.orange.devoxx.com.backend.beans;


import org.junit.Test;

import static org.hamcrest.core.Is.isA;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by xylome on 26/05/2016.
 */
public class GroupModelTest {
    @Test
    public void testGroup() {
        GroupModel gm = new GroupModel();
        gm.setId(45).setCreatorId(45).setName("TestGroup").setFraction(4).setCreatorNick("TestCreator");
        assertThat(gm.getName(), is("TestGroup"));
        assertThat(gm.getFraction(), is(4));
        assertThat(gm.getCreatorId(), is(45));
        assertThat(gm.getCreatorNick(), is("TestCreator"));
        assertThat(gm instanceof GroupModel, is(true));
        assertThat(gm.getId(), isA(long.class));
    }
}
