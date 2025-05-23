/**
 * SPDX-FileCopyrightText: Copyright (c) 2019 Source Auditor Inc.
 * SPDX-FileType: SOURCE
 * SPDX-License-Identifier: Apache-2.0
 * <p>
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * <p>
 *       http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.spdx.storage.listedlicense;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.spdx.core.InvalidSPDXAnalysisException;
import org.spdx.library.model.v2.license.ListedLicenseException;


/**
 * Table of Contents for the listed license list as represented as a JSON index file
 * at spdx.org/licenses/licenses.json
 * 
 * @author Gary O'Neall
 */
public class ExceptionJsonTOC {
	public static class ExceptionJson {
		private String reference;
		private boolean isDeprecatedLicenseId;
		private String detailsUrl;
		private int referenceNumber;
		private String name;
		private String licenseExceptionId;
		private List<String> seeAlso;

		/**
		 * Retrieve the license exception ID
		 *
		 * @return the licenseExceptionId
		 */
		public String getLicenseExceptionId() {
			return licenseExceptionId;
		}

		/**
		 * Retrieve the reference
		 *
		 * @return the reference
		 */
		public String getReference() {
			return reference;
		}

		/**
		 * Check whether this is a deprecated license ID
		 *
		 * @return the isDeprecatedLicenseId
		 */
		public boolean isDeprecatedLicenseId() {
			return isDeprecatedLicenseId;
		}

		/**
		 * Retrieve the details URL
		 *
		 * @return the detailsUrl
		 */
		public String getDetailsUrl() {
			return detailsUrl;
		}

		/**
		 * Retrieve the reference number
		 *
		 * @return the referenceNumber
		 */
		public int getReferenceNumber() {
			return referenceNumber;
		}

		/**
		 * Retrieve the name
		 *
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * Retrieve the see-also list
		 *
		 * @return the seeAlso
		 */
		public List<String> getSeeAlso() {
			return seeAlso;
		}

		/**
		 * Set the reference
		 *
		 * @param reference the reference to set
		 */
		public void setReference(String reference) {
			this.reference = reference;
		}

		/**
		 * Set whether this is a deprecated license ID
		 *
		 * @param isDeprecatedLicenseId the isDeprecatedLicenseId to set
		 */
		public void setDeprecatedLicenseId(boolean isDeprecatedLicenseId) {
			this.isDeprecatedLicenseId = isDeprecatedLicenseId;
		}

		/**
		 * Set the details URL
		 *
		 * @param detailsUrl the detailsUrl to set
		 */
		public void setDetailsUrl(String detailsUrl) {
			this.detailsUrl = detailsUrl;
		}

		/**
		 * Set the reference number
		 *
		 * @param referenceNumber the referenceNumber to set
		 */
		public void setReferenceNumber(int referenceNumber) {
			this.referenceNumber = referenceNumber;
		}

		/**
		 * Set the name
		 *
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * Set the license exception ID
		 *
		 * @param licenseExceptionId the licenseExceptionId to set
		 */
		public void setLicenseExceptionId(String licenseExceptionId) {
			this.licenseExceptionId = licenseExceptionId;
		}

		/**
		 * Set the see-also list
		 *
		 * @param seeAlso the seeAlso to set
		 */
		public void setSeeAlso(List<String> seeAlso) {
			this.seeAlso = seeAlso;
		}
	}

	private String licenseListVersion;
	private final List<ExceptionJson> exceptions;
	private String releaseDate;

	/**
	 * Create an ExceptionJsonTOC
	 *
	 * @param version license list version
	 * @param releaseDate release date of the license list
	 */
	public ExceptionJsonTOC(String version, String releaseDate) {
		this.licenseListVersion = version;
		this.releaseDate = releaseDate;
		exceptions = new ArrayList<>();
	}

	/**
	 * Create an ExceptionJsonTOC
	 */
	public ExceptionJsonTOC() {
		licenseListVersion = null;
		exceptions = new ArrayList<>();
		releaseDate = null;
	}

	/**
	 * Retrieve the license list version
	 *
	 * @return the licenseListVersion
	 */
	public @Nullable String getLicenseListVersion() {
		return licenseListVersion;
	}

	/**
	 * Retrieve the list of exceptions
	 *
	 * @return the exceptions
	 */
	public List<ExceptionJson> getExceptions() {
		return exceptions;
	}
	
	/**
	 * Retrieve a map of lower case to correct case exception IDs
	 *
	 * @return A map of lower case to correct case exception IDs
	 */
	public Map<String, String> getExceptionIds() {
		Map<String, String> retval = new HashMap<>();
		for (ExceptionJson licenseException:exceptions) {
			retval.put(licenseException.licenseExceptionId.toLowerCase(), licenseException.licenseExceptionId);
		}
		return retval;
	}

	/**
	 * Retrieve the release date
	 *
	 * @return the releaseDate
	 */
	public @Nullable String getReleaseDate() {
		return releaseDate;
	}

	/**
	 * Add a new exception to the list of exceptions
	 *
	 * @param exception exception to be added
	 * @param exceptionHTMLReference URL of the exception HTML
	 * @param exceptionJSONReference URL of the JSON
	 * @param deprecated true if deprecated
	 * @throws InvalidSPDXAnalysisException on error accessing Exception properties 
	 */
	public void addException(ListedLicenseException exception, String exceptionHTMLReference,
			String exceptionJSONReference, boolean deprecated) throws InvalidSPDXAnalysisException {
		ExceptionJson ej = new ExceptionJson();
		ej.setLicenseExceptionId(exception.getId());
		ej.setDeprecatedLicenseId(deprecated);
		ej.setDetailsUrl(LicenseJsonTOC.toAbsoluteURL(exceptionJSONReference));
		ej.setName(exception.getName());
		ej.setReference(LicenseJsonTOC.toAbsoluteURL(exceptionHTMLReference));
		int referenceNumber = 0;
		for (ExceptionJson existing:this.exceptions) {
			if (existing.getReferenceNumber() > referenceNumber) {
				referenceNumber = existing.getReferenceNumber();
			}
		}
		referenceNumber++;
		ej.setReferenceNumber(referenceNumber);
		ej.setSeeAlso(new ArrayList<>(exception.getSeeAlso()));
		this.exceptions.add(ej);
	}

	/**
	 * Set the license list version
	 *
	 * @param licenseListVersion the licenseListVersion to set
	 */
	public void setLicenseListVersion(String licenseListVersion) {
		this.licenseListVersion = licenseListVersion;
	}

	/**
	 * Set the release date
	 *
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

}
