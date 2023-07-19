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
 
package org.spdx.library.model.core;

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

/**
 * DO NOT EDIT - this file is generated by the Owl to Java Utility 
 * See: https://github.com/spdx/tools-java 
 * 
 * A Bill Of Materials (BOM) is a container for a grouping of SPDX-3.0 content characterizing 
 * details about a product. This could include details of the content and composition 
 * of the product, provenence details of the product and/or its composition, licensing 
 * information, known quality or security issues, etc. 
 */
public class Bom extends Bundle  {

	
	/**
	 * Create the Bom with default model store and generated anonymous ID
	 * @throws InvalidSPDXAnalysisException when unable to create the Bom
	 */
	public Bom() throws InvalidSPDXAnalysisException {
		this(DefaultModelStore.getDefaultModelStore().getNextId(IdType.Anonymous, null));
	}

	/**
	 * @param objectUri URI or anonymous ID for the Bom
	 * @throws InvalidSPDXAnalysisException when unable to create the Bom
	 */
	public Bom(String objectUri) throws InvalidSPDXAnalysisException {
		this(DefaultModelStore.getDefaultModelStore(), objectUri, DefaultModelStore.getDefaultCopyManager(), true);
	}

	/**
	 * @param modelStore Model store where the Bom is to be stored
	 * @param objectUri URI or anonymous ID for the Bom
	 * @param copyManager Copy manager for the Bom - can be null if copying is not required
	 * @param create true if Bom is to be created
	 * @throws InvalidSPDXAnalysisException when unable to create the Bom
	 */
	public Bom(IModelStore modelStore, String objectUri, @Nullable ModelCopyManager copyManager,
			boolean create)	throws InvalidSPDXAnalysisException {
		super(modelStore, objectUri, copyManager, create);
	}

	/**
	 * Create the Bom from the builder - used in the builder class
	 * @param builder Builder to create the Bom from
	 * @throws InvalidSPDXAnalysisException when unable to create the Bom
	 */
	protected Bom(BomBuilder builder) throws InvalidSPDXAnalysisException {
		super(builder);
	}

	/* (non-Javadoc)
	 * @see org.spdx.library.model.ModelObject#getType()
	 */
	@Override
	public String getType() {
		return "Core.Bom";
	}
	
	// Getters and Setters
	
	
	
	@Override
	public String toString() {
		return "Bom: "+getObjectUri();
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
	
	public static class BomBuilder extends BundleBuilder {
	
		/**
		 * Create an BomBuilder from another model object copying the modelStore and copyManager and using an anonymous ID
		 * @param from model object to copy the model store and copyManager from
		 * @throws InvalidSPDXAnalysisException
		 */
		public BomBuilder(ModelObject from) throws InvalidSPDXAnalysisException {
			this(from, from.getModelStore().getNextId(IdType.Anonymous, null));
		}
	
		/**
		 * Create an BomBuilder from another model object copying the modelStore and copyManager
		 * @param from model object to copy the model store and copyManager from
		 * @param objectUri URI for the object
		 * @param objectUri
		 */
		public BomBuilder(ModelObject from, String objectUri) {
			this(from.getModelStore(), objectUri, from.getCopyManager());
			setStrict(from.isStrict());
		}
		
		/**
		 * Creates a BomBuilder
		 * @param modelStore model store for the built Bom
		 * @param objectUri objectUri for the built Bom
		 * @param copyManager optional copyManager for the built Bom
		 */
		public BomBuilder(IModelStore modelStore, String objectUri, @Nullable ModelCopyManager copyManager) {
			super(modelStore, objectUri, copyManager);
		}
		
		
	
		
		/**
		 * @return the Bom
		 * @throws InvalidSPDXAnalysisException on any errors during build
		 */
		public Bom build() throws InvalidSPDXAnalysisException {
			IModelStoreLock lock = modelStore.enterCriticalSection(false);
			try {
				return new Bom(this);
			} finally {
				modelStore.leaveCriticalSection(lock);
			}
		}
	}
}
