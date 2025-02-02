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

package com.epam.ta.reportportal.core.item.validator.parent;

import com.epam.ta.reportportal.entity.item.TestItem;
import com.epam.ta.reportportal.ws.model.StartTestItemRQ;

public interface ParentItemValidator {

	/**
	 * Verifies if the start of a child item is allowed.
	 *
	 * @param rq     Start child item request
	 * @param parent Parent item
	 */
	void validate(StartTestItemRQ rq, TestItem parent);
}
