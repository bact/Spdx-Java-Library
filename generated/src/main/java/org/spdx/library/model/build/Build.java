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
 
package org.spdx.library.model.build;

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
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import org.spdx.library.SpdxConstants;
import org.spdx.library.model.core.DictionaryEntry;
import org.spdx.library.model.core.Element;
import org.spdx.library.model.core.Hash;
import org.spdx.library.model.core.ProfileIdentifierType;

/**
 * DO NOT EDIT - this file is generated by the Owl to Java Utility 
 * See: https://github.com/spdx/tools-java 
 * 
 * A build is a representation of the process in which a piece of software or artifact 
 * is built. It encapsulates information related to a build process and provides an 
 * element from which relationships can be created to describe the build's inputs, 
 * outputs, and related entities (e.g. builders, identities, etc.). Definitions 
 * of "BuildType", "ConfigSource", "Parameters" and "Environment" follow those 
 * defined in [SLSA provenance](https://slsa.dev/provenance/v0.2). ExternalIdentifier 
 * of type "urlScheme" may be used to identify build logs. In this case, the comment of 
 * the ExternalIdentifier should be "LogReference". Note that buildStart and buildEnd 
 * are optional, and may be omitted to simplify creating reproducible builds. 
 */
public class Build extends Element  {

	Collection<DictionaryEntry> parameterss;
	Collection<Hash> configSourceDigests;
	Collection<DictionaryEntry> environments;
	Collection<String> configSourceEntrypoints;
	Collection<String> configSourceUris;
	
	/**
	 * Create the Build with default model store and generated anonymous ID
	 * @throws InvalidSPDXAnalysisException when unable to create the Build
	 */
	public Build() throws InvalidSPDXAnalysisException {
		this(DefaultModelStore.getDefaultModelStore().getNextId(IdType.Anonymous, null));
	}

	/**
	 * @param objectUri URI or anonymous ID for the Build
	 * @throws InvalidSPDXAnalysisException when unable to create the Build
	 */
	public Build(String objectUri) throws InvalidSPDXAnalysisException {
		this(DefaultModelStore.getDefaultModelStore(), objectUri, DefaultModelStore.getDefaultCopyManager(), true);
	}

	/**
	 * @param modelStore Model store where the Build is to be stored
	 * @param objectUri URI or anonymous ID for the Build
	 * @param copyManager Copy manager for the Build - can be null if copying is not required
	 * @param create true if Build is to be created
	 * @throws InvalidSPDXAnalysisException when unable to create the Build
	 */
	 @SuppressWarnings("unchecked")
	public Build(IModelStore modelStore, String objectUri, @Nullable ModelCopyManager copyManager,
			boolean create)	throws InvalidSPDXAnalysisException {
		super(modelStore, objectUri, copyManager, create);
		parameterss = (Collection<DictionaryEntry>)(Collection<?>)this.getObjectPropertyValueCollection(SpdxConstants.BUILD_PROP_PARAMETERS, DictionaryEntry.class);
		configSourceDigests = (Collection<Hash>)(Collection<?>)this.getObjectPropertyValueCollection(SpdxConstants.BUILD_PROP_CONFIG_SOURCE_DIGEST, Hash.class);
		environments = (Collection<DictionaryEntry>)(Collection<?>)this.getObjectPropertyValueCollection(SpdxConstants.BUILD_PROP_ENVIRONMENT, DictionaryEntry.class);
		configSourceEntrypoints = (Collection<String>)(Collection<?>)this.getObjectPropertyValueCollection(SpdxConstants.BUILD_PROP_CONFIG_SOURCE_ENTRYPOINT, String.class);
		configSourceUris = (Collection<String>)(Collection<?>)this.getObjectPropertyValueCollection(SpdxConstants.BUILD_PROP_CONFIG_SOURCE_URI, String.class);
	}

	/**
	 * Create the Build from the builder - used in the builder class
	 * @param builder Builder to create the Build from
	 * @throws InvalidSPDXAnalysisException when unable to create the Build
	 */
	 @SuppressWarnings("unchecked")
	protected Build(BuildBuilder builder) throws InvalidSPDXAnalysisException {
		super(builder);
		parameterss = (Collection<DictionaryEntry>)(Collection<?>)this.getObjectPropertyValueCollection(SpdxConstants.BUILD_PROP_PARAMETERS, DictionaryEntry.class);
		configSourceDigests = (Collection<Hash>)(Collection<?>)this.getObjectPropertyValueCollection(SpdxConstants.BUILD_PROP_CONFIG_SOURCE_DIGEST, Hash.class);
		environments = (Collection<DictionaryEntry>)(Collection<?>)this.getObjectPropertyValueCollection(SpdxConstants.BUILD_PROP_ENVIRONMENT, DictionaryEntry.class);
		configSourceEntrypoints = (Collection<String>)(Collection<?>)this.getObjectPropertyValueCollection(SpdxConstants.BUILD_PROP_CONFIG_SOURCE_ENTRYPOINT, String.class);
		configSourceUris = (Collection<String>)(Collection<?>)this.getObjectPropertyValueCollection(SpdxConstants.BUILD_PROP_CONFIG_SOURCE_URI, String.class);
		getParameterss().addAll(builder.parameterss);
		getConfigSourceDigests().addAll(builder.configSourceDigests);
		getEnvironments().addAll(builder.environments);
		getConfigSourceEntrypoints().addAll(builder.configSourceEntrypoints);
		getConfigSourceUris().addAll(builder.configSourceUris);
		setBuildEndTime(builder.buildEndTime);
		setBuildType(builder.buildType);
		setBuildStartTime(builder.buildStartTime);
		setBuildId(builder.buildId);
	}

	/* (non-Javadoc)
	 * @see org.spdx.library.model.ModelObject#getType()
	 */
	@Override
	public String getType() {
		return "Build.Build";
	}
	
	// Getters and Setters
	public Collection<DictionaryEntry> getParameterss() {
		return parameterss;
	}
	public Collection<Hash> getConfigSourceDigests() {
		return configSourceDigests;
	}
	public Collection<DictionaryEntry> getEnvironments() {
		return environments;
	}
	public Collection<String> getConfigSourceEntrypoints() {
		return configSourceEntrypoints;
	}
	public Collection<String> getConfigSourceUris() {
		return configSourceUris;
	}
	

		/**
	 * @return the buildEndTime
	 */
	public Optional<String> getBuildEndTime() throws InvalidSPDXAnalysisException {
		return getStringPropertyValue(SpdxConstants.BUILD_PROP_BUILD_END_TIME);
	}
	/**
	 * @param buildEndTime the buildEndTime to set
	 * @return this to chain setters
	 * @throws InvalidSPDXAnalysisException 
	 */
	public Build setBuildEndTime(@Nullable String buildEndTime) throws InvalidSPDXAnalysisException {
		setPropertyValue(SpdxConstants.BUILD_PROP_BUILD_END_TIME, buildEndTime);
		return this;
	}

	/**
	 * @return the buildType
	 */
	public @Nullable String getBuildType() throws InvalidSPDXAnalysisException {
		Optional<String> retval = getStringPropertyValue(SpdxConstants.BUILD_PROP_BUILD_TYPE);
		return retval.isPresent() ? retval.get() : null;
	}
		/**
	 * @param buildType the buildType to set
	 * @return this to chain setters
	 * @throws InvalidSPDXAnalysisException 
	 */
	public Build setBuildType(@Nullable String buildType) throws InvalidSPDXAnalysisException {
		if (isStrict() && Objects.isNull(buildType)) {
			throw new InvalidSPDXAnalysisException("buildType is a required property");
		}
		setPropertyValue(SpdxConstants.BUILD_PROP_BUILD_TYPE, buildType);
		return this;
	}

		/**
	 * @return the buildStartTime
	 */
	public Optional<String> getBuildStartTime() throws InvalidSPDXAnalysisException {
		return getStringPropertyValue(SpdxConstants.BUILD_PROP_BUILD_START_TIME);
	}
	/**
	 * @param buildStartTime the buildStartTime to set
	 * @return this to chain setters
	 * @throws InvalidSPDXAnalysisException 
	 */
	public Build setBuildStartTime(@Nullable String buildStartTime) throws InvalidSPDXAnalysisException {
		setPropertyValue(SpdxConstants.BUILD_PROP_BUILD_START_TIME, buildStartTime);
		return this;
	}

		/**
	 * @return the buildId
	 */
	public Optional<String> getBuildId() throws InvalidSPDXAnalysisException {
		return getStringPropertyValue(SpdxConstants.BUILD_PROP_BUILD_ID);
	}
	/**
	 * @param buildId the buildId to set
	 * @return this to chain setters
	 * @throws InvalidSPDXAnalysisException 
	 */
	public Build setBuildId(@Nullable String buildId) throws InvalidSPDXAnalysisException {
		setPropertyValue(SpdxConstants.BUILD_PROP_BUILD_ID, buildId);
		return this;
	}
	
	
	@Override
	public String toString() {
		return "Build: "+getObjectUri();
	}
	
	/* (non-Javadoc)
	 * @see org.spdx.library.model.ModelObject#_verify(java.util.List)
	 */
	@Override
	protected List<String> _verify(Set<String> verifiedIds, String specVersion, List<ProfileIdentifierType> profiles) {
		List<String> retval = new ArrayList<>();
		retval.addAll(super._verify(verifiedIds, specVersion, profiles));
		try {
			@SuppressWarnings("unused")
			Optional<String> buildEndTime = getBuildEndTime();
		} catch (InvalidSPDXAnalysisException e) {
			retval.add("Error getting buildEndTime for Build: "+e.getMessage());
		}
		try {
			String buildType = getBuildType();
			if (Objects.isNull(buildType)) {
				retval.add("Missing buildType in Build");
			}
		} catch (InvalidSPDXAnalysisException e) {
			retval.add("Error getting buildType for Build: "+e.getMessage());
		}
		try {
			@SuppressWarnings("unused")
			Optional<String> buildStartTime = getBuildStartTime();
		} catch (InvalidSPDXAnalysisException e) {
			retval.add("Error getting buildStartTime for Build: "+e.getMessage());
		}
		try {
			@SuppressWarnings("unused")
			Optional<String> buildId = getBuildId();
		} catch (InvalidSPDXAnalysisException e) {
			retval.add("Error getting buildId for Build: "+e.getMessage());
		}
		for (DictionaryEntry parameters:parameterss) {
			retval.addAll(parameters.verify(verifiedIds, specVersion, profiles));
		}
		for (Hash configSourceDigest:configSourceDigests) {
			retval.addAll(configSourceDigest.verify(verifiedIds, specVersion, profiles));
		}
		for (DictionaryEntry environment:environments) {
			retval.addAll(environment.verify(verifiedIds, specVersion, profiles));
		}
		return retval;
	}
	
	public static class BuildBuilder extends ElementBuilder {
	
		/**
		 * Create an BuildBuilder from another model object copying the modelStore and copyManager and using an anonymous ID
		 * @param from model object to copy the model store and copyManager from
		 * @throws InvalidSPDXAnalysisException
		 */
		public BuildBuilder(ModelObject from) throws InvalidSPDXAnalysisException {
			this(from, from.getModelStore().getNextId(IdType.Anonymous, null));
		}
	
		/**
		 * Create an BuildBuilder from another model object copying the modelStore and copyManager
		 * @param from model object to copy the model store and copyManager from
		 * @param objectUri URI for the object
		 * @param objectUri
		 */
		public BuildBuilder(ModelObject from, String objectUri) {
			this(from.getModelStore(), objectUri, from.getCopyManager());
			setStrict(from.isStrict());
		}
		
		/**
		 * Creates a BuildBuilder
		 * @param modelStore model store for the built Build
		 * @param objectUri objectUri for the built Build
		 * @param copyManager optional copyManager for the built Build
		 */
		public BuildBuilder(IModelStore modelStore, String objectUri, @Nullable ModelCopyManager copyManager) {
			super(modelStore, objectUri, copyManager);
		}
		
		Collection<DictionaryEntry> parameterss = new ArrayList<>();
		Collection<Hash> configSourceDigests = new ArrayList<>();
		Collection<DictionaryEntry> environments = new ArrayList<>();
		Collection<String> configSourceEntrypoints = new ArrayList<>();
		Collection<String> configSourceUris = new ArrayList<>();
		String buildEndTime = null;
		String buildType = null;
		String buildStartTime = null;
		String buildId = null;
		
		
		/**
		 * Adds a parameters to the initial collection
		 * @parameter parameters parameters to add
		 * @return this for chaining
		**/
		BuildBuilder addParameters(DictionaryEntry parameters) {
			if (Objects.nonNull(parameters)) {
				parameterss.add(parameters);
			}
			return this;
		}
		
		/**
		 * Adds all elements from a collection to the initial parameters collection
		 * @parameter parametersCollection collection to initialize the parameters
		 * @return this for chaining
		**/
		BuildBuilder addAllParameters(Collection<DictionaryEntry> parametersCollection) {
			if (Objects.nonNull(parametersCollection)) {
				parameterss.addAll(parametersCollection);
			}
			return this;
		}
		
		/**
		 * Adds a configSourceDigest to the initial collection
		 * @parameter configSourceDigest configSourceDigest to add
		 * @return this for chaining
		**/
		BuildBuilder addConfigSourceDigest(Hash configSourceDigest) {
			if (Objects.nonNull(configSourceDigest)) {
				configSourceDigests.add(configSourceDigest);
			}
			return this;
		}
		
		/**
		 * Adds all elements from a collection to the initial configSourceDigest collection
		 * @parameter configSourceDigestCollection collection to initialize the configSourceDigest
		 * @return this for chaining
		**/
		BuildBuilder addAllConfigSourceDigest(Collection<Hash> configSourceDigestCollection) {
			if (Objects.nonNull(configSourceDigestCollection)) {
				configSourceDigests.addAll(configSourceDigestCollection);
			}
			return this;
		}
		
		/**
		 * Adds a environment to the initial collection
		 * @parameter environment environment to add
		 * @return this for chaining
		**/
		BuildBuilder addEnvironment(DictionaryEntry environment) {
			if (Objects.nonNull(environment)) {
				environments.add(environment);
			}
			return this;
		}
		
		/**
		 * Adds all elements from a collection to the initial environment collection
		 * @parameter environmentCollection collection to initialize the environment
		 * @return this for chaining
		**/
		BuildBuilder addAllEnvironment(Collection<DictionaryEntry> environmentCollection) {
			if (Objects.nonNull(environmentCollection)) {
				environments.addAll(environmentCollection);
			}
			return this;
		}
		
		/**
		 * Adds a configSourceEntrypoint to the initial collection
		 * @parameter configSourceEntrypoint configSourceEntrypoint to add
		 * @return this for chaining
		**/
		BuildBuilder addConfigSourceEntrypoint(String configSourceEntrypoint) {
			if (Objects.nonNull(configSourceEntrypoint)) {
				configSourceEntrypoints.add(configSourceEntrypoint);
			}
			return this;
		}
		
		/**
		 * Adds all elements from a collection to the initial configSourceEntrypoint collection
		 * @parameter configSourceEntrypointCollection collection to initialize the configSourceEntrypoint
		 * @return this for chaining
		**/
		BuildBuilder addAllConfigSourceEntrypoint(Collection<String> configSourceEntrypointCollection) {
			if (Objects.nonNull(configSourceEntrypointCollection)) {
				configSourceEntrypoints.addAll(configSourceEntrypointCollection);
			}
			return this;
		}
		
		/**
		 * Adds a configSourceUri to the initial collection
		 * @parameter configSourceUri configSourceUri to add
		 * @return this for chaining
		**/
		BuildBuilder addConfigSourceUri(String configSourceUri) {
			if (Objects.nonNull(configSourceUri)) {
				configSourceUris.add(configSourceUri);
			}
			return this;
		}
		
		/**
		 * Adds all elements from a collection to the initial configSourceUri collection
		 * @parameter configSourceUriCollection collection to initialize the configSourceUri
		 * @return this for chaining
		**/
		BuildBuilder addAllConfigSourceUri(Collection<String> configSourceUriCollection) {
			if (Objects.nonNull(configSourceUriCollection)) {
				configSourceUris.addAll(configSourceUriCollection);
			}
			return this;
		}
		
		/**
		 * Sets the initial value of buildEndTime
		 * @parameter buildEndTime value to set
		 * @return this for chaining
		**/
		BuildBuilder setBuildEndTime(String buildEndTime) {
			this.buildEndTime = buildEndTime;
			return this;
		}
		
		/**
		 * Sets the initial value of buildType
		 * @parameter buildType value to set
		 * @return this for chaining
		**/
		BuildBuilder setBuildType(String buildType) {
			this.buildType = buildType;
			return this;
		}
		
		/**
		 * Sets the initial value of buildStartTime
		 * @parameter buildStartTime value to set
		 * @return this for chaining
		**/
		BuildBuilder setBuildStartTime(String buildStartTime) {
			this.buildStartTime = buildStartTime;
			return this;
		}
		
		/**
		 * Sets the initial value of buildId
		 * @parameter buildId value to set
		 * @return this for chaining
		**/
		BuildBuilder setBuildId(String buildId) {
			this.buildId = buildId;
			return this;
		}
	
		
		/**
		 * @return the Build
		 * @throws InvalidSPDXAnalysisException on any errors during build
		 */
		public Build build() throws InvalidSPDXAnalysisException {
			IModelStoreLock lock = modelStore.enterCriticalSection(false);
			try {
				return new Build(this);
			} finally {
				modelStore.leaveCriticalSection(lock);
			}
		}
	}
}
