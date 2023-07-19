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
 
package org.spdx.library.model.licensing;

import javax.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.spdx.library.DefaultModelStore;
import org.spdx.library.InvalidSPDXAnalysisException;
import org.spdx.library.ModelCopyManager;
import org.spdx.library.model.ModelObject;
import org.spdx.storage.IModelStore;
import org.spdx.storage.IModelStore.IdType;
import org.spdx.storage.IModelStore.IModelStoreLock;

import java.util.Optional;
import org.spdx.library.SpdxConstants;
import org.spdx.library.model.core.ProfileIdentifierType;

/**
 * DO NOT EDIT - this file is generated by the Owl to Java Utility 
 * See: https://github.com/spdx/tools-java 
 * 
 * A CustomLicense represents a License that is not listed on the SPDX License List at 
 * https://spdx.org/licenses, and is therefore defined by an SPDX data creator. 
 */
public class CustomLicense extends License  {

	
	/**
	 * Create the CustomLicense with default model store and generated anonymous ID
	 * @throws InvalidSPDXAnalysisException when unable to create the CustomLicense
	 */
	public CustomLicense() throws InvalidSPDXAnalysisException {
		this(DefaultModelStore.getDefaultModelStore().getNextId(IdType.Anonymous, null));
	}

	/**
	 * @param objectUri URI or anonymous ID for the CustomLicense
	 * @throws InvalidSPDXAnalysisException when unable to create the CustomLicense
	 */
	public CustomLicense(String objectUri) throws InvalidSPDXAnalysisException {
		this(DefaultModelStore.getDefaultModelStore(), objectUri, DefaultModelStore.getDefaultCopyManager(), true);
	}

	/**
	 * @param modelStore Model store where the CustomLicense is to be stored
	 * @param objectUri URI or anonymous ID for the CustomLicense
	 * @param copyManager Copy manager for the CustomLicense - can be null if copying is not required
	 * @param create true if CustomLicense is to be created
	 * @throws InvalidSPDXAnalysisException when unable to create the CustomLicense
	 */
	public CustomLicense(IModelStore modelStore, String objectUri, @Nullable ModelCopyManager copyManager,
			boolean create)	throws InvalidSPDXAnalysisException {
		super(modelStore, objectUri, copyManager, create);
	}

	/**
	 * Create the CustomLicense from the builder - used in the builder class
	 * @param builder Builder to create the CustomLicense from
	 * @throws InvalidSPDXAnalysisException when unable to create the CustomLicense
	 */
	protected CustomLicense(CustomLicenseBuilder builder) throws InvalidSPDXAnalysisException {
		super(builder);
	}

	/* (non-Javadoc)
	 * @see org.spdx.library.model.ModelObject#getType()
	 */
	@Override
	public String getType() {
		return "Licensing.CustomLicense";
	}
	
	// Getters and Setters
	
	
	
	@Override
	public String toString() {
		return "CustomLicense: "+getObjectUri();
	}
	
	/* (non-Javadoc)
	 * @see org.spdx.library.model.ModelObject#_verify(java.util.List)
	 */
	@Override
	protected List<String> _verify(Set<String> verifiedIds, String specVersion, List<ProfileIdentifierType> profiles) {
		List<String> retval = new ArrayList<>();
		retval.addAll(super._verify(verifiedIds, specVersion, profiles));
		return retval;
	}
	
	public static class CustomLicenseBuilder extends LicenseBuilder {
	
		/**
		 * Create an CustomLicenseBuilder from another model object copying the modelStore and copyManager and using an anonymous ID
		 * @param from model object to copy the model store and copyManager from
		 * @throws InvalidSPDXAnalysisException
		 */
		public CustomLicenseBuilder(ModelObject from) throws InvalidSPDXAnalysisException {
			this(from, from.getModelStore().getNextId(IdType.Anonymous, null));
		}
	
		/**
		 * Create an CustomLicenseBuilder from another model object copying the modelStore and copyManager
		 * @param from model object to copy the model store and copyManager from
		 * @param objectUri URI for the object
		 * @param objectUri
		 */
		public CustomLicenseBuilder(ModelObject from, String objectUri) {
			this(from.getModelStore(), objectUri, from.getCopyManager());
			setStrict(from.isStrict());
		}
		
		/**
		 * Creates a CustomLicenseBuilder
		 * @param modelStore model store for the built CustomLicense
		 * @param objectUri objectUri for the built CustomLicense
		 * @param copyManager optional copyManager for the built CustomLicense
		 */
		public CustomLicenseBuilder(IModelStore modelStore, String objectUri, @Nullable ModelCopyManager copyManager) {
			super(modelStore, objectUri, copyManager);
		}
		
		
	
		
		/**
		 * @return the CustomLicense
		 * @throws InvalidSPDXAnalysisException on any errors during build
		 */
		public CustomLicense build() throws InvalidSPDXAnalysisException {
			IModelStoreLock lock = modelStore.enterCriticalSection(false);
			try {
				return new CustomLicense(this);
			} finally {
				modelStore.leaveCriticalSection(lock);
			}
		}
	}
}
