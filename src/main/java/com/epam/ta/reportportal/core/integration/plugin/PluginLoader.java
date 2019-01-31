/*
 * Copyright 2018 EPAM Systems
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

package com.epam.ta.reportportal.core.integration.plugin;

import com.epam.ta.reportportal.entity.plugin.PluginFileExtension;
import org.pf4j.PluginState;
import org.pf4j.PluginWrapper;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.Optional;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public interface PluginLoader {

	PluginInfo extractPluginInfo(Path pluginPath);

	PluginState reloadPlugin(PluginWrapper plugin);

	boolean validatePluginExtensionClasses(String pluginId);

	Optional<PluginWrapper> retrieveOldPlugin(String newPluginId, String newPluginFileName);

	void deleteOldPlugin(PluginWrapper oldPluginWrapper, String newPluginFileName);

	void createTempPluginsFolderIfNotExists(String path);

	/**
	 * Resolve file type and upload it to the temporary plugins directory.
	 * If successful returns file extension
	 *
	 * @param pluginFile Plugin file to upload
	 * @return {@link PluginFileExtension#extension}
	 */
	String resolveFileExtensionAndUploadTempPlugin(MultipartFile pluginFile, String pluginsTempPath);

	void deleteTempPlugin(String pluginFileDirectory, String pluginFileName);
}
