/**
 * Copyright (c) 2023 Source Auditor Inc.
 *
 * SPDX-License-Identifier: Apache-2.0
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.spdx.library;

import org.spdx.storage.PropertyDescriptor;

/**
 * Constants which map to the SPDX specifications
 * @author Gary O'Neall
 *
 */
public class SpdxConstants {
	
	public enum SpdxMajorVersion {
		VERSION_1,
		VERSION_2,
		VERSION_3;

		public static SpdxMajorVersion latestVersion() {
			return VERSION_3;
		}
	}

	/**
	 * Core namespace
	 */
	public static final String CORE_NAMESPACE = "https://rdf.spdx.org/v3/Core";
	public static final PropertyDescriptor CORE_PROP_RELATED_SPDX_ELEMENT = new PropertyDescriptor("to", CORE_NAMESPACE);

}
