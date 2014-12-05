/*******************************************************************************
 * Copyright (c) 2010 University of Illinois at Urbana-Champaign and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    UIUC - Initial API and implementation
 *******************************************************************************/
package org.eclipse.photran.internal.ui.search;

import org.eclipse.osgi.util.NLS;

/**
 * Externalized strings.
 */
public class Messages extends NLS
{
    private static final String BUNDLE_NAME = "org.eclipse.photran.internal.ui.search.messages"; //$NON-NLS-1$

    public static String SearchLabelProvider_nMatches;

    public static String SearchLabelProvider_OneMatch;

    public static String SearchPage_11;

    public static String SearchPage_AnyStringAnyCharLabel;

    public static String SearchPage_IllegalCharacterInPatternString;

    public static String SearchPage_InvalidSearchPatternTitle;

    public static String SearchPage_LimitToLabel;

    public static String SearchPage_RegularExpressionLabel;

    public static String SearchPage_ScopeDescription_EnclosingProjects;

    public static String SearchPage_ScopeDescription_SelectedResources;

    public static String SearchPage_ScopeDescription_WorkingSet;

    public static String SearchPage_ScopeDescription_Workspace;

    public static String SearchPage_SearchForLabel;

    public static String SearchPage_SearchPatternIsInvalid;

    public static String SearchPage_SearchPatternLabel;

    public static String SearchQuery_nMatches;

    public static String SearchQuery_OneMatch;

    public static String SearchQuery_Searching;

    public static String SearchQuery_SearchingFor;

    public static String SearchResult_SearchResultTooltip;

    public static String FortranFindReferencesActionDelegate_DefinitionCouldNotBeFound;

    public static String FortranFindReferencesActionDelegate_ErrorTitle;

    public static String FortranFindReferencesActionDelegate_PleaseEnableAnalysisAndRefactoring;

    public static String FortranFindReferencesActionDelegate_PleaseSelectAnIdentifier;

    public static String FortranFindReferencesSearchQuery_FileScope;

    public static String FortranFindReferencesSearchQuery_nMatches;

    public static String FortranFindReferencesSearchQuery_OneMatch;

    public static String FortranFindReferencesSearchQuery_ProjectScope;

    public static String FortranFindReferencesSearchQuery_SearchSuccessful;

    public static String FortranFindReferencesSearchQuery_WorkspaceScope;

    public static String FortranSearchPage_AllOccurrences;

    public static String FortranSearchPage_CommonBlock;

    public static String FortranSearchPage_Declarations;

    public static String FortranSearchPage_Function;

    public static String FortranSearchPage_Module;

    public static String FortranSearchPage_Program;

    public static String FortranSearchPage_References;

    public static String FortranSearchPage_Subroutine;

    public static String FortranSearchPage_Variable;

    public static String FortranSearchQuery_AddingReferences;

    public static String FortranSearchQuery_AddingReferencesIn;

    public static String FortranSearchQuery_AnalysisRefactoringDisabled;

    public static String FortranSearchQuery_WarningTitle;
    static
    {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages()
    {
    }
}
