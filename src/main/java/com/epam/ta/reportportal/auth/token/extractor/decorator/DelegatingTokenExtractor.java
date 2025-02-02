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

package com.epam.ta.reportportal.auth.token.extractor.decorator;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.TokenExtractor;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class DelegatingTokenExtractor implements TokenExtractor {

	private final List<TokenExtractor> extractors;

	public DelegatingTokenExtractor(List<TokenExtractor> extractors) {
		this.extractors = extractors;
	}

	@Override
	public Authentication extract(HttpServletRequest request) {
		return extractors.stream().map(ex -> ex.extract(request)).filter(Objects::nonNull).findFirst().orElse(null);
	}
}
