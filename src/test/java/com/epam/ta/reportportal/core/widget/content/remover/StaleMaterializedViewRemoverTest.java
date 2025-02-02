/*
 * Copyright 2022 EPAM Systems
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.epam.ta.reportportal.core.widget.content.remover;

import com.epam.ta.reportportal.core.widget.content.materialized.generator.MaterializedViewNameGenerator;
import com.epam.ta.reportportal.dao.StaleMaterializedViewRepository;
import com.epam.ta.reportportal.entity.materialized.StaleMaterializedView;
import com.epam.ta.reportportal.entity.widget.Widget;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
class StaleMaterializedViewRemoverTest {

	private final MaterializedViewNameGenerator nameGenerator = mock(MaterializedViewNameGenerator.class);
	private final StaleMaterializedViewRepository staleMaterializedViewRepository = mock(StaleMaterializedViewRepository.class);
	private final StaleMaterializedViewRemover staleMaterializedViewRemover = new StaleMaterializedViewRemover(nameGenerator,
			staleMaterializedViewRepository
	);

	@Test
	void shouldSaveStaleView() {
		final Widget widget = new Widget();

		final String viewName = "widget_1_1";
		when(nameGenerator.generate(widget)).thenReturn(viewName);

		staleMaterializedViewRemover.removeContent(widget);

		final ArgumentCaptor<StaleMaterializedView> viewArgumentCaptor = ArgumentCaptor.forClass(StaleMaterializedView.class);
		verify(staleMaterializedViewRepository, times(1)).insert(viewArgumentCaptor.capture());

		final StaleMaterializedView view = viewArgumentCaptor.getValue();

		Assertions.assertEquals(viewName, view.getName());
		Assertions.assertNotNull(view.getCreationDate());
	}

}