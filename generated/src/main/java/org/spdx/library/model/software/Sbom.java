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
 
package org.spdx.library.model.software;

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

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import org.spdx.library.SpdxConstants;
import org.spdx.library.model.core.Bom;
import org.spdx.library.model.core.ProfileIdentifierType;

/**
 * DO NOT EDIT - this file is generated by the Owl to Java Utility 
 * See: https://github.com/spdx/tools-java 
 * 
 * A Software Bill of Materials (SBOM) is a collection of SPDX Elements describing a 
 * single package. This could include details of the content and composition of the 
 * product, provenance details of the product and/or its composition, licensing information, 
 * known quality or security issues, etc. 
 */
public class Sbom extends Bom  {

	Collection<SBOMType> sbomTypes;
	
	/**
	 * Create the Sbom with default model store and generated anonymous ID
	 * @throws InvalidSPDXAnalysisException when unable to create the Sbom
	 */
	public Sbom() throws InvalidSPDXAnalysisException {
		this(DefaultModelStore.getDefaultModelStore().getNextId(IdType.Anonymous, null));
	}

	/**
	 * @param objectUri URI or anonymous ID for the Sbom
	 * @throws InvalidSPDXAnalysisException when unable to create the Sbom
	 */
	public Sbom(String objectUri) throws InvalidSPDXAnalysisException {
		this(DefaultModelStore.getDefaultModelStore(), objectUri, DefaultModelStore.getDefaultCopyManager(), true);
	}

	/**
	 * @param modelStore Model store where the Sbom is to be stored
	 * @param objectUri URI or anonymous ID for the Sbom
	 * @param copyManager Copy manager for the Sbom - can be null if copying is not required
	 * @param create true if Sbom is to be created
	 * @throws InvalidSPDXAnalysisException when unable to create the Sbom
	 */
	public Sbom(IModelStore modelStore, String objectUri, @Nullable ModelCopyManager copyManager,
			boolean create)	throws InvalidSPDXAnalysisException {
		super(modelStore, objectUri, copyManager, create);
		sbomTypes = (Collection<SBOMType>)(Collection<?>)this.getObjectPropertyValueCollection(SpdxConstants.SOFTWARE_PROP_SBOM_TYPE, SBOMType.class);
	}

	/**
	 * Create the Sbom from the builder - used in the builder class
	 * @param builder Builder to create the Sbom from
	 * @throws InvalidSPDXAnalysisException when unable to create the Sbom
	 */
	protected Sbom(SbomBuilder builder) throws InvalidSPDXAnalysisException {
		super(builder);
		sbomTypes = (Collection<SBOMType>)(Collection<?>)this.getObjectPropertyValueCollection(SpdxConstants.SOFTWARE_PROP_SBOM_TYPE, SBOMType.class);
		getSbomTypes().addAll(builder.sbomTypes);
	}

	/* (non-Javadoc)
	 * @see org.spdx.library.model.ModelObject#getType()
	 */
	@Override
	public String getType() {
		return "Software.Sbom";
	}
	
	// Getters and Setters
	public Collection<SBOMType> getSbomTypes() {
		return sbomTypes;
	}
	
	
	
	@Override
	public String toString() {
		return "Sbom: "+getObjectUri();
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
	
	public static class SbomBuilder extends BomBuilder {
	
		/**
		 * Create an SbomBuilder from another model object copying the modelStore and copyManager and using an anonymous ID
		 * @param from model object to copy the model store and copyManager from
		 * @throws InvalidSPDXAnalysisException
		 */
		public SbomBuilder(ModelObject from) throws InvalidSPDXAnalysisException {
			this(from, from.getModelStore().getNextId(IdType.Anonymous, null));
		}
	
		/**
		 * Create an SbomBuilder from another model object copying the modelStore and copyManager
		 * @param from model object to copy the model store and copyManager from
		 * @param objectUri URI for the object
		 * @param objectUri
		 */
		public SbomBuilder(ModelObject from, String objectUri) {
			this(from.getModelStore(), objectUri, from.getCopyManager());
			setStrict(from.isStrict());
		}
		
		/**
		 * Creates a SbomBuilder
		 * @param modelStore model store for the built Sbom
		 * @param objectUri objectUri for the built Sbom
		 * @param copyManager optional copyManager for the built Sbom
		 */
		public SbomBuilder(IModelStore modelStore, String objectUri, @Nullable ModelCopyManager copyManager) {
			super(modelStore, objectUri, copyManager);
		}
		
		Collection<SBOMType> sbomTypes = new ArrayList<>();
		
		
		/**
		 * Adds a sbomType to the initial collection
		 * @parameter sbomType sbomType to add
		 * @return this for chaining
		**/
		SbomBuilder addSbomType(SBOMType sbomType) {
			if (Objects.nonNull(sbomType)) {
				sbomTypes.add(sbomType);
			}
			return this;
		}
		
		/**
		 * Adds all elements from a collection to the initial sbomType collection
		 * @parameter sbomTypeCollection collection to initialize the sbomType
		 * @return this for chaining
		**/
		SbomBuilder addAllSbomType(Collection<SBOMType> sbomTypeCollection) {
			if (Objects.nonNull(sbomTypeCollection)) {
				sbomTypes.addAll(sbomTypeCollection);
			}
			return this;
		}
	
		
		/**
		 * @return the Sbom
		 * @throws InvalidSPDXAnalysisException on any errors during build
		 */
		public Sbom build() throws InvalidSPDXAnalysisException {
			IModelStoreLock lock = modelStore.enterCriticalSection(false);
			try {
				return new Sbom(this);
			} finally {
				modelStore.leaveCriticalSection(lock);
			}
		}
	}
}
