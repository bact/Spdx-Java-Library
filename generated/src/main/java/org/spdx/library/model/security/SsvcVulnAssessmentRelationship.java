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
 
package org.spdx.library.model.security;

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

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import org.spdx.library.SpdxConstants;
import org.spdx.library.model.core.ProfileIdentifierType;

/**
 * DO NOT EDIT - this file is generated by the Owl to Java Utility 
 * See: https://github.com/spdx/tools-java 
 * 
 * An SsvcVulnAssessmentRelationship describes the decision made using the Stakeholder-Specific 
 * Vulnerability Categorization (SSVC) decision tree as defined on [https://www.cisa.gov/stakeholder-specific-vulnerability-categorization-ssvc](https://www.cisa.gov/stakeholder-specific-vulnerability-categorization-ssvc). 
 * It is intended to communicate the results of using the CISA SSVC Calculator. **Constraints** 
 * - The relationship type must be set to hasAssessmentFor. **Syntax** ```json { "@type": 
 * "SsvcVulnAssessmentRelationship", "@id": "urn:spdx.dev:ssvc-1", "relationshipType": 
 * "hasAssessmentFor", "decisionType": "act", "from": "urn:spdx.dev:vuln-cve-2020-28498", 
 * "to": ["urn:product-acme-application-1.3"], "assessedElement": "urn:npm-elliptic-6.5.2", 
 * "suppliedBy": ["urn:spdx.dev:agent-jane-doe"], "publishedTime": "2021-03-09T11:04:53Z" 
 * } ``` 
 */
public class SsvcVulnAssessmentRelationship extends VulnAssessmentRelationship  {

	
	/**
	 * Create the SsvcVulnAssessmentRelationship with default model store and generated anonymous ID
	 * @throws InvalidSPDXAnalysisException when unable to create the SsvcVulnAssessmentRelationship
	 */
	public SsvcVulnAssessmentRelationship() throws InvalidSPDXAnalysisException {
		this(DefaultModelStore.getDefaultModelStore().getNextId(IdType.Anonymous, null));
	}

	/**
	 * @param objectUri URI or anonymous ID for the SsvcVulnAssessmentRelationship
	 * @throws InvalidSPDXAnalysisException when unable to create the SsvcVulnAssessmentRelationship
	 */
	public SsvcVulnAssessmentRelationship(String objectUri) throws InvalidSPDXAnalysisException {
		this(DefaultModelStore.getDefaultModelStore(), objectUri, DefaultModelStore.getDefaultCopyManager(), true);
	}

	/**
	 * @param modelStore Model store where the SsvcVulnAssessmentRelationship is to be stored
	 * @param objectUri URI or anonymous ID for the SsvcVulnAssessmentRelationship
	 * @param copyManager Copy manager for the SsvcVulnAssessmentRelationship - can be null if copying is not required
	 * @param create true if SsvcVulnAssessmentRelationship is to be created
	 * @throws InvalidSPDXAnalysisException when unable to create the SsvcVulnAssessmentRelationship
	 */
	public SsvcVulnAssessmentRelationship(IModelStore modelStore, String objectUri, @Nullable ModelCopyManager copyManager,
			boolean create)	throws InvalidSPDXAnalysisException {
		super(modelStore, objectUri, copyManager, create);
	}

	/**
	 * Create the SsvcVulnAssessmentRelationship from the builder - used in the builder class
	 * @param builder Builder to create the SsvcVulnAssessmentRelationship from
	 * @throws InvalidSPDXAnalysisException when unable to create the SsvcVulnAssessmentRelationship
	 */
	protected SsvcVulnAssessmentRelationship(SsvcVulnAssessmentRelationshipBuilder builder) throws InvalidSPDXAnalysisException {
		super(builder);
		setDecisionType(builder.decisionType);
	}

	/* (non-Javadoc)
	 * @see org.spdx.library.model.ModelObject#getType()
	 */
	@Override
	public String getType() {
		return "Security.SsvcVulnAssessmentRelationship";
	}
	
	// Getters and Setters
	
	
	/**
	 * @return the decisionType
	 */
	public @Nullable SsvcDecisionType getDecisionType() throws InvalidSPDXAnalysisException {
		Optional<Enum<?>> retval = getEnumPropertyValue(SpdxConstants.SECURITY_PROP_DECISION_TYPE);
		if (retval.isPresent()) {
			if (!(retval.get() instanceof SsvcDecisionType)) {
				throw new InvalidSPDXAnalysisException("Incorrect type stored for ");
			}
			return (SsvcDecisionType)(retval.get());
		} else {
			return null;
		}
	}
	/**
	 * @param decisionType the decisionType to set
	 * @return this to chain setters
	 * @throws InvalidSPDXAnalysisException 
	 */
	public SsvcVulnAssessmentRelationship setDecisionType(@Nullable SsvcDecisionType decisionType) throws InvalidSPDXAnalysisException {
		if (isStrict() && Objects.isNull(decisionType)) {
			throw new InvalidSPDXAnalysisException("decisionType is a required property");
		}
		setPropertyValue(SpdxConstants.SECURITY_PROP_DECISION_TYPE, decisionType);
		return this;
	}
	
	
	@Override
	public String toString() {
		return "SsvcVulnAssessmentRelationship: "+getObjectUri();
	}
	
	/* (non-Javadoc)
	 * @see org.spdx.library.model.ModelObject#_verify(java.util.List)
	 */
	@Override
	protected List<String> _verify(Set<String> verifiedIds, String specVersion, List<ProfileIdentifierType> profiles) {
		List<String> retval = new ArrayList<>();
		retval.addAll(super._verify(verifiedIds, specVersion, profiles));
		try {
			SsvcDecisionType decisionType = getDecisionType();
			if (Objects.isNull(decisionType)) {
				retval.add("Missing decisionType in SsvcVulnAssessmentRelationship");
			}
		} catch (InvalidSPDXAnalysisException e) {
			retval.add("Error getting decisionType for SsvcVulnAssessmentRelationship: "+e.getMessage());
		}
		return retval;
	}
	
	public static class SsvcVulnAssessmentRelationshipBuilder extends VulnAssessmentRelationshipBuilder {
	
		/**
		 * Create an SsvcVulnAssessmentRelationshipBuilder from another model object copying the modelStore and copyManager and using an anonymous ID
		 * @param from model object to copy the model store and copyManager from
		 * @throws InvalidSPDXAnalysisException
		 */
		public SsvcVulnAssessmentRelationshipBuilder(ModelObject from) throws InvalidSPDXAnalysisException {
			this(from, from.getModelStore().getNextId(IdType.Anonymous, null));
		}
	
		/**
		 * Create an SsvcVulnAssessmentRelationshipBuilder from another model object copying the modelStore and copyManager
		 * @param from model object to copy the model store and copyManager from
		 * @param objectUri URI for the object
		 * @param objectUri
		 */
		public SsvcVulnAssessmentRelationshipBuilder(ModelObject from, String objectUri) {
			this(from.getModelStore(), objectUri, from.getCopyManager());
			setStrict(from.isStrict());
		}
		
		/**
		 * Creates a SsvcVulnAssessmentRelationshipBuilder
		 * @param modelStore model store for the built SsvcVulnAssessmentRelationship
		 * @param objectUri objectUri for the built SsvcVulnAssessmentRelationship
		 * @param copyManager optional copyManager for the built SsvcVulnAssessmentRelationship
		 */
		public SsvcVulnAssessmentRelationshipBuilder(IModelStore modelStore, String objectUri, @Nullable ModelCopyManager copyManager) {
			super(modelStore, objectUri, copyManager);
		}
		
		SsvcDecisionType decisionType = null;
		
		
		/**
		 * Sets the initial value of decisionType
		 * @parameter decisionType value to set
		 * @return this for chaining
		**/
		SsvcVulnAssessmentRelationshipBuilder setDecisionType(SsvcDecisionType decisionType) {
			this.decisionType = decisionType;
			return this;
		}
	
		
		/**
		 * @return the SsvcVulnAssessmentRelationship
		 * @throws InvalidSPDXAnalysisException on any errors during build
		 */
		public SsvcVulnAssessmentRelationship build() throws InvalidSPDXAnalysisException {
			IModelStoreLock lock = modelStore.enterCriticalSection(false);
			try {
				return new SsvcVulnAssessmentRelationship(this);
			} finally {
				modelStore.leaveCriticalSection(lock);
			}
		}
	}
}
