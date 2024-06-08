/**
 * Copyright (c) 2016 Source Auditor Inc.
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
 *
*/
package org.spdx.utility.compare;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.spdx.library.DefaultModelStore;
import org.spdx.library.InvalidSPDXAnalysisException;
import org.spdx.library.SpdxConstants.SpdxMajorVersion;
import org.spdx.library.model.compat.v2.Checksum;
import org.spdx.library.model.compat.v2.GenericModelObject;
import org.spdx.library.model.compat.v2.Relationship;
import org.spdx.library.model.compat.v2.SpdxDocument;
import org.spdx.library.model.compat.v2.SpdxFile;
import org.spdx.library.model.compat.v2.SpdxSnippet;
import org.spdx.library.model.compat.v2.enumerations.ChecksumAlgorithm;
import org.spdx.library.model.compat.v2.enumerations.FileType;
import org.spdx.library.model.compat.v2.enumerations.RelationshipType;
import org.spdx.library.model.compat.v2.license.AnyLicenseInfo;
import org.spdx.library.model.compat.v2.license.LicenseInfoFactory;
import org.spdx.library.model.compat.v2.pointer.ByteOffsetPointer;
import org.spdx.library.model.compat.v2.pointer.LineCharPointer;
import org.spdx.library.model.compat.v2.pointer.StartEndPointer;

import junit.framework.TestCase;


/**
 * @author Gary O'Neall
 *
 */
public class SpdxSnippetComparerTest extends TestCase {
	
	static final String SNIPPET_NAME1 = "snippet1";
	static final String SNIPPET_NAME2 = "snippet2";
	static final String COMMENT1 = "comment1";
	static final String COMMENT2 = "comment2";
	static final String CONCLUDED_LICENSE_STRING = "ADSL";
	static final String SEEN_LICENSE_STRING = "APSL-2.0";
	static final String COPYRIGHT_TEXT = "copyrightText";
	static final String LICENSE_COMMENT = "License comment";
	
	AnyLicenseInfo CONCLUDED_LICENSE;
	Collection<AnyLicenseInfo> SEEN_LICENSES;
	SpdxFile FROM_FILE;
	SpdxSnippet SNIPPET1;
	
	Integer OFFSET1_1 = Integer.valueOf(2342);
	ByteOffsetPointer BOP_POINTER1_1;
	Integer LINE1_1 = Integer.valueOf(113);
	LineCharPointer LCP_POINTER1_1; 
	Integer OFFSET2_1 = Integer.valueOf(444);
	ByteOffsetPointer BOP_POINTER2_1;
	Integer LINE2_1 = Integer.valueOf(23422);
	LineCharPointer LCP_POINTER2_1; 
	Integer OFFSET1_2 = Integer.valueOf(3542);
	ByteOffsetPointer BOP_POINTER1_2;
	Integer LINE1_2 = Integer.valueOf(555);
	LineCharPointer LCP_POINTER1_2; 
	Integer OFFSET2_2 = Integer.valueOf(2444);
	ByteOffsetPointer BOP_POINTER2_2;
	Integer LINE2_2 = Integer.valueOf(23428);
	LineCharPointer LCP_POINTER2_2; 
	StartEndPointer BYTE_RANGE1;
	StartEndPointer BYTE_RANGE2;
	StartEndPointer LINE_RANGE1;
	StartEndPointer LINE_RANGE2;
	private static final Map<String, String> LICENSE_XLATION_MAPAB = new HashMap<>();
	static {
		LICENSE_XLATION_MAPAB.put("LicenseRef-1", "LicenseRef-4");
		LICENSE_XLATION_MAPAB.put("LicenseRef-2", "LicenseRef-5");
		LICENSE_XLATION_MAPAB.put("LicenseRef-3", "LicenseRef-6");
	}
	
	private static final Map<String, String> LICENSE_XLATION_MAPBA = new HashMap<>();
	private static final String FILE_NAME = "FileName";
	private static final String FILE_COMMENT = "File Comment";
	private static final String FILE_COPYRIGHT = "File Copyright";
	private static final String FILE_LICENSE_COMMENT = "File License Comment";
	private static final Collection<FileType> FILE_TYPES = new HashSet<>(Arrays.asList(new FileType[] {FileType.SOURCE}));
	private static final String FILE_NOTICE = "File Notice";
	
	static {
		LICENSE_XLATION_MAPBA.put("LicenseRef-4", "LicenseRef-1");
		LICENSE_XLATION_MAPBA.put("LicenseRef-5", "LicenseRef-2");
		LICENSE_XLATION_MAPBA.put("LicenseRef-6", "LicenseRef-3");
	}
	
	Checksum CHECKSUM1;
	
	private final Map<SpdxDocument, Map<SpdxDocument, Map<String, String>>> LICENSE_XLATION_MAP = new HashMap<>();
	private SpdxDocument DOCA;
	private SpdxDocument DOCB;


	/**
	 * @throws java.lang.Exception
	 */
	public void setUp() throws Exception {
		DefaultModelStore.reset(SpdxMajorVersion.VERSION_2);
		GenericModelObject gmo = new GenericModelObject();
		CHECKSUM1 = gmo.createChecksum(ChecksumAlgorithm.SHA1, 
				"111bf72bf99b7e471f1a27989667a903658652bb");
		CONCLUDED_LICENSE = LicenseInfoFactory.parseSPDXLicenseStringCompatV2(CONCLUDED_LICENSE_STRING);
		SEEN_LICENSES = new HashSet<>(Arrays.asList(new AnyLicenseInfo[] {LicenseInfoFactory.parseSPDXLicenseStringCompatV2(SEEN_LICENSE_STRING)}));
		FROM_FILE = gmo.createSpdxFile("SPDXRef-"+FILE_NAME, FILE_NAME, CONCLUDED_LICENSE, 
				SEEN_LICENSES, FILE_COPYRIGHT, CHECKSUM1)
				.setComment(FILE_COMMENT)
				.setLicenseComments(FILE_LICENSE_COMMENT)
				.setFileTypes(FILE_TYPES)
				.setNoticeText(FILE_NOTICE)
				.build();
		BOP_POINTER1_1 = gmo.createByteOffsetPointer(FROM_FILE, OFFSET1_1);
		BOP_POINTER1_2 = gmo.createByteOffsetPointer(FROM_FILE, OFFSET1_2);
		BYTE_RANGE1 = gmo.createStartEndPointer(BOP_POINTER1_1, BOP_POINTER1_2);
		LCP_POINTER1_1 = gmo.createLineCharPointer(FROM_FILE, LINE1_1);
		LCP_POINTER1_2 = gmo.createLineCharPointer(FROM_FILE, LINE1_2);
		LINE_RANGE1 = gmo.createStartEndPointer(LCP_POINTER1_1, LCP_POINTER1_2);
		BOP_POINTER2_1 = gmo.createByteOffsetPointer(FROM_FILE, OFFSET2_1);
		BOP_POINTER2_2 = gmo.createByteOffsetPointer(FROM_FILE, OFFSET2_2);
		BYTE_RANGE2 = gmo.createStartEndPointer(BOP_POINTER2_1, BOP_POINTER2_2);
		LCP_POINTER2_1 = gmo.createLineCharPointer(FROM_FILE, LINE2_1);
		LCP_POINTER2_2 = gmo.createLineCharPointer(FROM_FILE, LINE2_2);
		LINE_RANGE2 = gmo.createStartEndPointer(LCP_POINTER2_1, LCP_POINTER2_2);
		SNIPPET1 = gmo.createSpdxSnippet("SPDXRef-"+SNIPPET_NAME1, SNIPPET_NAME1, CONCLUDED_LICENSE, 
				SEEN_LICENSES, COPYRIGHT_TEXT, FROM_FILE, OFFSET1_1, OFFSET1_2)
				.setComment(COMMENT1)
				.setLicenseComments(LICENSE_COMMENT)
				.setLineRange(LCP_POINTER1_1.getLineNumber(), LCP_POINTER1_2.getLineNumber())
				.build();
		
		String uri1 = "http://doc/uri1";
		DOCA = new SpdxDocument(uri1);
		String uri2 = "http://doc/uri2";
		DOCB = new SpdxDocument(uri2);
		Map<SpdxDocument, Map<String, String>> bmap = new HashMap<>();
		bmap.put(DOCB, LICENSE_XLATION_MAPAB);
		LICENSE_XLATION_MAP.put(DOCA, bmap);
		Map<SpdxDocument, Map<String, String>> amap = new HashMap<>();
		amap.put(DOCA, LICENSE_XLATION_MAPBA);
		LICENSE_XLATION_MAP.put(DOCB, amap);
	}

	/**
	 * @throws java.lang.Exception
	 */
	public void tearDown() throws Exception {
		super.tearDown();
		DefaultModelStore.reset(SpdxMajorVersion.VERSION_3);
	}
	
	public void testNoDifference() throws InvalidSPDXAnalysisException, SpdxCompareException {

		SpdxSnippetComparer comparer = new SpdxSnippetComparer(LICENSE_XLATION_MAP);
		// Force a copy of the snippet1
		Relationship describesA = DOCA.createRelationship(SNIPPET1, RelationshipType.DESCRIBES, "DOCA Describes");
		Relationship describesB = DOCB.createRelationship(SNIPPET1, RelationshipType.DESCRIBES, "DOCB Describes");
		comparer.addDocumentSnippet(DOCA, (SpdxSnippet)describesA.getRelatedSpdxElement().get());
		comparer.addDocumentSnippet(DOCB, (SpdxSnippet)describesB.getRelatedSpdxElement().get());
		assertFalse(comparer.isDifferenceFound());
	}

	/**
	 * Test method for {@link org.spdx.compare.SpdxSnippetComparer#getSnippetFromFileDifference(org.spdx.rdfparser.model.SpdxDocument, org.spdx.rdfparser.model.SpdxDocument)}.
	 * @throws InvalidSPDXAnalysisException 
	 * @throws SpdxCompareException 
	 */
	public void testGetSnippetFromFileDifference() throws InvalidSPDXAnalysisException, SpdxCompareException {

		SpdxSnippetComparer comparer = new SpdxSnippetComparer(LICENSE_XLATION_MAP);
		// Force a copy of the snippet1
		Relationship describesA = DOCA.createRelationship(SNIPPET1, RelationshipType.DESCRIBES, "DOCA Describes");
		Relationship describesB = DOCB.createRelationship(SNIPPET1, RelationshipType.DESCRIBES, "DOCB Describes");

		SpdxFile snippetFromFile = ((SpdxSnippet)(describesB.getRelatedSpdxElement().get())).getSnippetFromFile();
		String newCopyright = "New copyright";
		snippetFromFile.setCopyrightText(newCopyright);
		// Note: we need to set the from file so that the start/end pointers get updated to the correct file
		//snippetClone.setSnippetFromFile(snippetFromFile);
		comparer.addDocumentSnippet(DOCA, (SpdxSnippet)describesA.getRelatedSpdxElement().get());
		comparer.addDocumentSnippet(DOCB, (SpdxSnippet)describesB.getRelatedSpdxElement().get());
		assertTrue(comparer.isDifferenceFound());
		assertFalse(comparer.isSnippetFromFilesEquals());
		SpdxFileDifference fileDiff = comparer.getSnippetFromFileDifference(DOCA, DOCB);
		assertFalse(fileDiff.isCopyrightsEqual());
		assertEquals(FILE_COPYRIGHT, fileDiff.getCopyrightA());
		assertEquals(newCopyright, fileDiff.getCopyrightB());
	}
	
	public void testGetSnippetFromFileDifferentFileName() throws InvalidSPDXAnalysisException, SpdxCompareException {

		SpdxSnippetComparer comparer = new SpdxSnippetComparer(LICENSE_XLATION_MAP);
		// Force a copy of the snippet1
		Relationship describesA = DOCA.createRelationship(SNIPPET1, RelationshipType.DESCRIBES, "DOCA Describes");
		Relationship describesB = DOCB.createRelationship(SNIPPET1, RelationshipType.DESCRIBES, "DOCB Describes");

		SpdxFile snippetFromFile = ((SpdxSnippet)(describesB.getRelatedSpdxElement().get())).getSnippetFromFile();
		String newFileName = "NewFIleName.c";
		snippetFromFile.setName(newFileName);
		//snippetClone.setSnippetFromFile(snippetFromFile);
		comparer.addDocumentSnippet(DOCA, (SpdxSnippet)describesA.getRelatedSpdxElement().get());
		comparer.addDocumentSnippet(DOCB, (SpdxSnippet)describesB.getRelatedSpdxElement().get());
		assertTrue(comparer.isDifferenceFound());
		assertFalse(comparer.isSnippetFromFilesEquals());
		assertTrue(comparer.getSnippetFromFileDifference(DOCA, DOCB) == null);
		assertEquals(FILE_NAME, comparer.getUniqueSnippetFromFile(DOCA, DOCB).getName().get());
		assertEquals(newFileName, comparer.getUniqueSnippetFromFile(DOCB, DOCA).getName().get());
		
	}

	/**
	 * Test method for {@link org.spdx.compare.SpdxSnippetComparer#isByteRangeEquals()}.
	 */
	public void testIsByteRangeEquals() throws InvalidSPDXAnalysisException, SpdxCompareException {
		SpdxSnippetComparer comparer = new SpdxSnippetComparer(LICENSE_XLATION_MAP);
		// Force a copy of the snippet1
		Relationship describesA = DOCA.createRelationship(SNIPPET1, RelationshipType.DESCRIBES, "DOCA Describes");
		Relationship describesB = DOCB.createRelationship(SNIPPET1, RelationshipType.DESCRIBES, "DOCB Describes");

		((SpdxSnippet)(describesB.getRelatedSpdxElement().get())).setByteRange(OFFSET2_1, OFFSET2_2);
		comparer.addDocumentSnippet(DOCA, (SpdxSnippet)describesA.getRelatedSpdxElement().get());
		comparer.addDocumentSnippet(DOCB, (SpdxSnippet)describesB.getRelatedSpdxElement().get());
		assertTrue(comparer.isDifferenceFound());
		assertFalse(comparer.isByteRangeEquals());
	}

	/**
	 * Test method for {@link org.spdx.compare.SpdxSnippetComparer#isLineRangeEquals()}.
	 */
	public void testIsLineRangeEquals() throws InvalidSPDXAnalysisException, SpdxCompareException {
		SpdxSnippetComparer comparer = new SpdxSnippetComparer(LICENSE_XLATION_MAP);
		// Force a copy of the snippet1
		Relationship describesA = DOCA.createRelationship(SNIPPET1, RelationshipType.DESCRIBES, "DOCA Describes");
		Relationship describesB = DOCB.createRelationship(SNIPPET1, RelationshipType.DESCRIBES, "DOCB Describes");

		((SpdxSnippet)(describesB.getRelatedSpdxElement().get())).setLineRange(LINE2_1, LINE2_2);
		comparer.addDocumentSnippet(DOCA, (SpdxSnippet)describesA.getRelatedSpdxElement().get());
		comparer.addDocumentSnippet(DOCB, (SpdxSnippet)describesB.getRelatedSpdxElement().get());
		assertTrue(comparer.isDifferenceFound());
		assertFalse(comparer.isLineRangeEquals());
	}

	/**
	 * Test method for {@link org.spdx.compare.SpdxSnippetComparer#isNameEquals()}.
	 */
	public void testIsNameEquals() throws InvalidSPDXAnalysisException, SpdxCompareException {
		SpdxSnippetComparer comparer = new SpdxSnippetComparer(LICENSE_XLATION_MAP);
		// Force a copy of the snippet1
		Relationship describesA = DOCA.createRelationship(SNIPPET1, RelationshipType.DESCRIBES, "DOCA Describes");
		Relationship describesB = DOCB.createRelationship(SNIPPET1, RelationshipType.DESCRIBES, "DOCB Describes");
		String newSnippetName = "NewSnippetName";
		((SpdxSnippet)(describesB.getRelatedSpdxElement().get())).setName(newSnippetName);
		comparer.addDocumentSnippet(DOCA, (SpdxSnippet)describesA.getRelatedSpdxElement().get());
		comparer.addDocumentSnippet(DOCB, (SpdxSnippet)describesB.getRelatedSpdxElement().get());
		assertTrue(comparer.isDifferenceFound());
		assertFalse(comparer.isNameEquals());
	}

}
