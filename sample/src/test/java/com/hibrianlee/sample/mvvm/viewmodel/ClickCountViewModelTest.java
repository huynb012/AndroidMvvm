/*
 * Copyright (C) 2015 Brian Lee (@hiBrianLee)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hibrianlee.sample.mvvm.viewmodel;

import com.hibrianlee.sample.mvvm.BaseTest;
import com.hibrianlee.sample.mvvm.R;

import org.junit.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ClickCountViewModelTest extends BaseTest {

    private static final String TWITTER_URL = "twitterUrl";

    private ClickCountViewModel viewModel;

    @Override
    public void setup() {
        super.setup();
        when(appContext.getString(R.string.click_count)).thenReturn("%d");
        when(appContext.getString(R.string.twitter_url)).thenReturn(TWITTER_URL);
        viewModel = new ClickCountViewModel(testComponent, null);
    }

    @Test
    public void testViewModel() {
        assertEquals("0", viewModel.getClickCountText());
    }

    @Test
    public void testClickButton() {
        viewModel.onClickButton();
        assertEquals("1", viewModel.getClickCountText());

        viewModel.onClickButton();
        assertEquals("2", viewModel.getClickCountText());

        // TODO: property changed?
    }

    @Test
    public void testOnClickHiBrianLee() throws Exception {
        viewModel.onClickHiBrianLee();
        verify(attachedActivity).openUrl(TWITTER_URL);
    }

    // TODO: test rotation?
}
