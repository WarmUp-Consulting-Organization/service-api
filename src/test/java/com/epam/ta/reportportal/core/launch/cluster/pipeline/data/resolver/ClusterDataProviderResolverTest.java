/*
 * Copyright 2021 EPAM Systems
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

package com.epam.ta.reportportal.core.launch.cluster.pipeline.data.resolver;

import com.epam.ta.reportportal.core.launch.cluster.config.GenerateClustersConfig;
import com.epam.ta.reportportal.core.launch.cluster.pipeline.data.ClusterDataProvider;
import com.epam.ta.reportportal.core.launch.cluster.pipeline.data.resolver.evaluator.ClusterDataProviderEvaluator;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
class ClusterDataProviderResolverTest {

	private final ClusterDataProvider dataProvider = mock(ClusterDataProvider.class);
	private final ClusterDataProviderEvaluator evaluator = mock(ClusterDataProviderEvaluator.class);
	private final ClusterDataProviderResolver resolver = new ClusterDataProviderResolver(List.of(evaluator));

	@Test
	void shouldReturnProviderWhenSupports() {
		when(evaluator.supports(any(GenerateClustersConfig.class))).thenReturn(true);
		when(evaluator.getProvider()).thenReturn(dataProvider);

		final Optional<ClusterDataProvider> provider = resolver.resolve(new GenerateClustersConfig());

		assertTrue(provider.isPresent());
		assertEquals(dataProvider, provider.get());
	}

	@Test
	void shouldNotReturnProviderWhenSupports() {
		when(evaluator.supports(any(GenerateClustersConfig.class))).thenReturn(false);
		final Optional<ClusterDataProvider> provider = resolver.resolve(new GenerateClustersConfig());
		assertTrue(provider.isEmpty());
	}

}