[1mdiff --git a/.idea/codeStyles/Project.xml b/.idea/codeStyles/Project.xml[m
[1mindex b557e85..681f41a 100644[m
[1m--- a/.idea/codeStyles/Project.xml[m
[1m+++ b/.idea/codeStyles/Project.xml[m
[36m@@ -1,29 +1,5 @@[m
 <component name="ProjectCodeStyleConfiguration">[m
   <code_scheme name="Project" version="173">[m
[31m-    <DBN-PSQL>[m
[31m-      <case-options enabled="true">[m
[31m-        <option name="KEYWORD_CASE" value="lower" />[m
[31m-        <option name="FUNCTION_CASE" value="lower" />[m
[31m-        <option name="PARAMETER_CASE" value="lower" />[m
[31m-        <option name="DATATYPE_CASE" value="lower" />[m
[31m-        <option name="OBJECT_CASE" value="preserve" />[m
[31m-      </case-options>[m
[31m-      <formatting-settings enabled="false" />[m
[31m-    </DBN-PSQL>[m
[31m-    <DBN-SQL>[m
[31m-      <case-options enabled="true">[m
[31m-        <option name="KEYWORD_CASE" value="lower" />[m
[31m-        <option name="FUNCTION_CASE" value="lower" />[m
[31m-        <option name="PARAMETER_CASE" value="lower" />[m
[31m-        <option name="DATATYPE_CASE" value="lower" />[m
[31m-        <option name="OBJECT_CASE" value="preserve" />[m
[31m-      </case-options>[m
[31m-      <formatting-settings enabled="false">[m
[31m-        <option name="STATEMENT_SPACING" value="one_line" />[m
[31m-        <option name="CLAUSE_CHOP_DOWN" value="chop_down_if_statement_long" />[m
[31m-        <option name="ITERATION_ELEMENTS_WRAPPING" value="chop_down_if_not_single" />[m
[31m-      </formatting-settings>[m
[31m-    </DBN-SQL>[m
     <codeStyleSettings language="XML">[m
       <indentOptions>[m
         <option name="CONTINUATION_INDENT_SIZE" value="4" />[m
[1mdiff --git a/.idea/codeStyles/codeStyleConfig.xml b/.idea/codeStyles/codeStyleConfig.xml[m
[1mdeleted file mode 100644[m
[1mindex a55e7a1..0000000[m
[1m--- a/.idea/codeStyles/codeStyleConfig.xml[m
[1m+++ /dev/null[m
[36m@@ -1,5 +0,0 @@[m
[31m-<component name="ProjectCodeStyleConfiguration">[m
[31m-  <state>[m
[31m-    <option name="PREFERRED_PROJECT_CODE_STYLE" value="Default" />[m
[31m-  </state>[m
[31m-</component>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/dbnavigator.xml b/.idea/dbnavigator.xml[m
[1mdeleted file mode 100644[m
[1mindex c3ebd37..0000000[m
[1m--- a/.idea/dbnavigator.xml[m
[1m+++ /dev/null[m
[36m@@ -1,454 +0,0 @@[m
[31m-<?xml version="1.0" encoding="UTF-8"?>[m
[31m-<project version="4">[m
[31m-  <component name="DBNavigator.Project.DataEditorManager">[m
[31m-    <record-view-column-sorting-type value="BY_INDEX" />[m
[31m-    <value-preview-text-wrapping value="false" />[m
[31m-    <value-preview-pinned value="false" />[m
[31m-  </component>[m
[31m-  <component name="DBNavigator.Project.DataExportManager">[m
[31m-    <export-instructions>[m
[31m-      <create-header value="true" />[m
[31m-      <quote-values-containing-separator value="true" />[m
[31m-      <quote-all-values value="false" />[m
[31m-      <value-separator value="" />[m
[31m-      <file-name value="" />[m
[31m-      <file-location value="" />[m
[31m-      <scope value="GLOBAL" />[m
[31m-      <destination value="FILE" />[m
[31m-      <format value="EXCEL" />[m
[31m-      <charset value="GBK" />[m
[31m-    </export-instructions>[m
[31m-  </component>[m
[31m-  <component name="DBNavigator.Project.DatabaseBrowserManager">[m
[31m-    <autoscroll-to-editor value="false" />[m
[31m-    <autoscroll-from-editor value="true" />[m
[31m-    <show-object-properties value="true" />[m
[31m-    <loaded-nodes />[m
[31m-  </component>[m
[31m-  <component name="DBNavigator.Project.DatabaseFileManager">[m
[31m-    <open-files />[m
[31m-  </component>[m
[31m-  <component name="DBNavigator.Project.EditorStateManager">[m
[31m-    <last-used-providers />[m
[31m-  </component>[m
[31m-  <component name="DBNavigator.Project.MethodExecutionManager">[m
[31m-    <method-browser />[m
[31m-    <execution-history>[m
[31m-      <group-entries value="true" />[m
[31m-      <execution-inputs />[m
[31m-    </execution-history>[m
[31m-    <argument-values-cache />[m
[31m-  </component>[m
[31m-  <component name="DBNavigator.Project.ObjectDependencyManager">[m
[31m-    <last-used-dependency-type value="INCOMING" />[m
[31m-  </component>[m
[31m-  <component name="DBNavigator.Project.ObjectQuickFilterManager">[m
[31m-    <last-used-operator value="EQUAL" />[m
[31m-    <filters />[m
[31m-  </component>[m
[31m-  <component name="DBNavigator.Project.ScriptExecutionManager" clear-outputs="true">[m
[31m-    <recently-used-interfaces />[m
[31m-  </component>[m
[31m-  <component name="DBNavigator.Project.Settings">[m
[31m-    <connections />[m
[31m-    <browser-settings>[m
[31m-      <general>[m
[31m-        <display-mode value="TABBED" />[m
[31m-        <navigation-history-size value="100" />[m
[31m-        <show-object-details value="false" />[m
[31m-      </general>[m
[31m-      <filters>[m
[31m-        <object-type-filter>[m
[31m-          <object-type name="SCHEMA" enabled="true" />[m
[31m-          <object-type name="USER" enabled="true" />[m
[31m-          <object-type name="ROLE" enabled="true" />[m
[31m-          <object-type name="PRIVILEGE" enabled="true" />[m
[31m-          <object-type name="CHARSET" enabled="true" />[m
[31m-          <object-type name="TABLE" enabled="true" />[m
[31m-          <object-type name="VIEW" enabled="true" />[m
[31m-          <object-type name="MATERIALIZED_VIEW" enabled="true" />[m
[31m-          <object-type name="NESTED_TABLE" enabled="true" />[m
[31m-          <object-type name="COLUMN" enabled="true" />[m
[31m-          <object-type name="INDEX" enabled="true" />[m
[31m-          <object-type name="CONSTRAINT" enabled="true" />[m
[31m-          <object-type name="DATASET_TRIGGER" enabled="true" />[m
[31m-          <object-type name="DATABASE_TRIGGER" enabled="true" />[m
[31m-          <object-type name="SYNONYM" enabled="true" />[m
[31m-          <object-type name="SEQUENCE" enabled="true" />[m
[31m-          <object-type name="PROCEDURE" enabled="true" />[m
[31m-          <object-type name="FUNCTION" enabled="true" />[m
[31m-          <object-type name="PACKAGE" enabled="true" />[m
[31m-          <object-type name="TYPE" enabled="true" />[m
[31m-          <object-type name="TYPE_ATTRIBUTE" enabled="true" />[m
[31m-          <object-type name="ARGUMENT" enabled="true" />[m
[31m-          <object-type name="DIMENSION" enabled="true" />[m
[31m-          <object-type name="CLUSTER" enabled="true" />[m
[31m-          <object-type name="DBLINK" enabled="true" />[m
[31m-        </object-type-filter>[m
[31m-      </filters>[m
[31m-      <sorting>[m
[31m-        <object-type name="COLUMN" sorting-type="NAME" />[m
[31m-        <object-type name="FUNCTION" sorting-type="NAME" />[m
[31m-        <object-type name="PROCEDURE" sorting-type="NAME" />[m
[31m-        <object-type name="ARGUMENT" sorting-type="POSITION" />[m
[31m-      </sorting>[m
[31m-      <default-editors>[m
[31m-        <object-type name="VIEW" editor-type="SELECTION" />[m
[31m-        <object-type name="PACKAGE" editor-type="SELECTION" />[m
[31m-        <object-type name="TYPE" editor-type="SELECTION" />[m
[31m-      </default-editors>[m
[31m-    </browser-settings>[m
[31m-    <navigation-settings>[m
[31m-      <lookup-filters>[m
[31m-        <lookup-objects>[m
[31m-          <object-type name="SCHEMA" enabled="true" />[m
[31m-          <object-type name="USER" enabled="false" />[m
[31m-          <object-type name="ROLE" enabled="false" />[m
[31m-          <object-type name="PRIVILEGE" enabled="false" />[m
[31m-          <object-type name="CHARSET" enabled="false" />[m
[31m-          <object-type name="TABLE" enabled="true" />[m
[31m-          <object-type name="VIEW" enabled="true" />[m
[31m-          <object-type name="MATERIALIZED VIEW" enabled="true" />[m
[31m-          <object-type name="NESTED TABLE" enabled="false" />[m
[31m-          <object-type name="COLUMN" enabled="false" />[m
[31m-          <object-type name="INDEX" enabled="true" />[m
[31m-          <object-type name="CONSTRAINT" enabled="true" />[m
[31m-          <object-type name="DATASET TRIGGER" enabled="true" />[m
[31m-          <object-type name="DATABASE TRIGGER" enabled="true" />[m
[31m-          <object-type name="SYNONYM" enabled="false" />[m
[31m-          <object-type name="SEQUENCE" enabled="true" />[m
[31m-          <object-type name="PROCEDURE" enabled="true" />[m
[31m-          <object-type name="FUNCTION" enabled="true" />[m
[31m-          <object-type name="PACKAGE" enabled="true" />[m
[31m-          <object-type name="TYPE" enabled="true" />[m
[31m-          <object-type name="TYPE ATTRIBUTE" enabled="false" />[m
[31m-          <object-type name="ARGUMENT" enabled="false" />[m
[31m-          <object-type name="DIMENSION" enabled="false" />[m
[31m-          <object-type name="CLUSTER" enabled="false" />[m
[31m-          <object-type name="DBLINK" enabled="true" />[m
[31m-        </lookup-objects>[m
[31m-        <force-database-load value="false" />[m
[31m-        <prompt-connection-selection value="true" />[m
[31m-        <prompt-schema-selection value="true" />[m
[31m-      </lookup-filters>[m
[31m-    </navigation-settings>[m
[31m-    <dataset-grid-settings>[m
[31m-      <general>[m
[31m-        <enable-zooming value="true" />[m
[31m-        <enable-column-tooltip value="true" />[m
[31m-      </general>[m
[31m-      <sorting>[m
[31m-        <nulls-first value="true" />[m
[31m-        <max-sorting-columns value="4" />[m
[31m-      </sorting>[m
[31m-      <tracking-columns>[m
[31m-        <columnNames value="" />[m
[31m-        <visible value="true" />[m
[31m-        <editable value="false" />[m
[31m-      </tracking-columns>[m
[31m-    </dataset-grid-settings>[m
[31m-    <dataset-editor-settings>[m
[31m-      <text-editor-popup>[m
[31m-        <active value="false" />[m
[31m-        <active-if-empty value="false" />[m
[31m-        <data-length-threshold value="100" />[m
[31m-        <popup-delay value="1000" />[m
[31m-      </text-editor-popup>[m
[31m-      <values-actions-popup>[m
[31m-        <show-popup-button value="true" />[m
[31m-        <element-count-threshold value="1000" />[m
[31m-        <data-length-threshold value="250" />[m
[31m-      </values-actions-popup>[m
[31m-      <general>[m
[31m-        <fetch-block-size value="100" />[m
[31m-        <fetch-timeout value="30" />[m
[31m-        <trim-whitespaces value="true" />[m
[31m-        <convert-empty-strings-to-null value="true" />[m
[31m-        <select-content-on-cell-edit value="true" />[m
[31m-        <large-value-preview-active value="true" />[m
[31m-      </general>[m
[31m-      <filters>[m
[31m-        <prompt-filter-dialog value="true" />[m
[31m-        <default-filter-type value="BASIC" />[m
[31m-      </filters>[m
[31m-      <qualified-text-editor text-length-threshold="300">[m
[31m-        <content-types>[m
[31m-          <content-type name="Text" enabled="true" />[m
[31m-          <content-type name="Properties" enabled="true" />[m
[31m-          <content-type name="XML" enabled="true" />[m
[31m-          <content-type name="DTD" enabled="true" />[m
[31m-          <content-type name="HTML" enabled="true" />[m
[31m-          <content-type name="XHTML" enabled="true" />[m
[31m-          <content-type name="Java" enabled="true" />[m
[31m-          <content-type name="Groovy" enabled="true" />[m
[31m-          <content-type name="AIDL" enabled="true" />[m
[31m-          <content-type name="YAML" enabled="true" />[m
[31m-          <content-type name="Manifest" enabled="true" />[m
[31m-        </content-types>[m
[31m-      </qualified-text-editor>[m
[31m-      <record-navigation>[m
[31m-        <navigation-target value="VIEWER" />[m
[31m-      </record-navigation>[m
[31m-    </dataset-editor-settings>[m
[31m-    <code-editor-settings>[m
[31m-      <general>[m
[31m-        <show-object-navigation-gutter value="false" />[m
[31m-        <show-spec-declaration-navigation-gutter value="true" />[m
[31m-        <enable-spellchecking value="true" />[m
[31m-        <enable-reference-spellchecking value="false" />[m
[31m-      </general>[m
[31m-      <confirmations>[m
[31m-        <save-changes value="false" />[m
[31m-        <revert-changes value="true" />[m
[31m-      </confirmations>[m
[31m-    </code-editor-settings>[m
[31m-    <code-completion-settings>[m
[31m-      <filters>[m
[31m-        <basic-filter>[m
[31m-          <filter-element type="RESERVED_WORD" id="keyword" selected="true" />[m
[31m-          <filter-element type="RESERVED_WORD" id="function" selected="true" />[m
[31m-          <filter-element type="RESERVED_WORD" id="parameter" selected="true" />[m
[31m-          <filter-element type="RESERVED_WORD" id="datatype" selected="true" />[m
[31m-          <filter-element type="RESERVED_WORD" id="exception" selected="true" />[m
[31m-          <filter-element type="OBJECT" id="schema" selected="true" />[m
[31m-          <filter-element type="OBJECT" id="role" selected="true" />[m
[31m-          <filter-element type="OBJECT" id="user" selected="true" />[m
[31m-          <filter-element type="OBJECT" id="privilege" selected="true" />[m
[31m-          <user-schema>[m
[31m-            <filter-element type="OBJECT" id="table" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="view" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="materialized view" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="index" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="constraint" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="trigger" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="synonym" selected="false" />[m
[31m-            <filter-element type="OBJECT" id="sequence" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="procedure" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="function" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="package" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="type" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="dimension" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="cluster" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="dblink" selected="true" />[m
[31m-          </user-schema>[m
[31m-          <public-schema>[m
[31m-            <filter-element type="OBJECT" id="table" selected="false" />[m
[31m-            <filter-element type="OBJECT" id="view" selected="false" />[m
[31m-            <filter-element type="OBJECT" id="materialized view" selected="false" />[m
[31m-            <filter-element type="OBJECT" id="index" selected="false" />[m
[31m-            <filter-element type="OBJECT" id="constraint" selected="false" />[m
[31m-            <filter-element type="OBJECT" id="trigger" selected="false" />[m
[31m-            <filter-element type="OBJECT" id="synonym" selected="false" />[m
[31m-            <filter-element type="OBJECT" id="sequence" selected="false" />[m
[31m-            <filter-element type="OBJECT" id="procedure" selected="false" />[m
[31m-            <filter-element type="OBJECT" id="function" selected="false" />[m
[31m-            <filter-element type="OBJECT" id="package" selected="false" />[m
[31m-            <filter-element type="OBJECT" id="type" selected="false" />[m
[31m-            <filter-element type="OBJECT" id="dimension" selected="false" />[m
[31m-            <filter-element type="OBJECT" id="cluster" selected="false" />[m
[31m-            <filter-element type="OBJECT" id="dblink" selected="false" />[m
[31m-          </public-schema>[m
[31m-          <any-schema>[m
[31m-            <filter-element type="OBJECT" id="table" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="view" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="materialized view" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="index" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="constraint" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="trigger" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="synonym" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="sequence" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="procedure" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="function" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="package" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="type" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="dimension" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="cluster" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="dblink" selected="true" />[m
[31m-          </any-schema>[m
[31m-        </basic-filter>[m
[31m-        <extended-filter>[m
[31m-          <filter-element type="RESERVED_WORD" id="keyword" selected="true" />[m
[31m-          <filter-element type="RESERVED_WORD" id="function" selected="true" />[m
[31m-          <filter-element type="RESERVED_WORD" id="parameter" selected="true" />[m
[31m-          <filter-element type="RESERVED_WORD" id="datatype" selected="true" />[m
[31m-          <filter-element type="RESERVED_WORD" id="exception" selected="true" />[m
[31m-          <filter-element type="OBJECT" id="schema" selected="true" />[m
[31m-          <filter-element type="OBJECT" id="user" selected="true" />[m
[31m-          <filter-element type="OBJECT" id="role" selected="true" />[m
[31m-          <filter-element type="OBJECT" id="privilege" selected="true" />[m
[31m-          <user-schema>[m
[31m-            <filter-element type="OBJECT" id="table" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="view" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="materialized view" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="index" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="constraint" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="trigger" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="synonym" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="sequence" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="procedure" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="function" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="package" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="type" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="dimension" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="cluster" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="dblink" selected="true" />[m
[31m-          </user-schema>[m
[31m-          <public-schema>[m
[31m-            <filter-element type="OBJECT" id="table" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="view" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="materialized view" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="index" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="constraint" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="trigger" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="synonym" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="sequence" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="procedure" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="function" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="package" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="type" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="dimension" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="cluster" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="dblink" selected="true" />[m
[31m-          </public-schema>[m
[31m-          <any-schema>[m
[31m-            <filter-element type="OBJECT" id="table" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="view" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="materialized view" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="index" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="constraint" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="trigger" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="synonym" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="sequence" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="procedure" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="function" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="package" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="type" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="dimension" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="cluster" selected="true" />[m
[31m-            <filter-element type="OBJECT" id="dblink" selected="true" />[m
[31m-          </any-schema>[m
[31m-        </extended-filter>[m
[31m-      </filters>[m
[31m-      <sorting enabled="true">[m
[31m-        <sorting-element type="RESERVED_WORD" id="keyword" />[m
[31m-        <sorting-element type="RESERVED_WORD" id="datatype" />[m
[31m-        <sorting-element type="OBJECT" id="column" />[m
[31m-        <sorting-element type="OBJECT" id="table" />[m
[31m-        <sorting-element type="OBJECT" id="view" />[m
[31m-        <sorting-element type="OBJECT" id="materialized view" />[m
[31m-        <sorting-element type="OBJECT" id="index" />[m
[31m-        <sorting-element type="OBJECT" id="constraint" />[m
[31m-        <sorting-element type="OBJECT" id="trigger" />[m
[31m-        <sorting-element type="OBJECT" id="synonym" />[m
[31m-        <sorting-element type="OBJECT" id="sequence" />[m
[31m-        <sorting-element type="OBJECT" id="procedure" />[m
[31m-        <sorting-element type="OBJECT" id="function" />[m
[31m-        <sorting-element type="OBJECT" id="package" />[m
[31m-        <sorting-element type="OBJECT" id="type" />[m
[31m-        <sorting-element type="OBJECT" id="dimension" />[m
[31m-        <sorting-element type="OBJECT" id="cluster" />[m
[31m-        <sorting-element type="OBJECT" id="dblink" />[m
[31m-        <sorting-element type="OBJECT" id="schema" />[m
[31m-        <sorting-element type="OBJECT" id="role" />[m
[31m-        <sorting-element type="OBJECT" id="user" />[m
[31m-        <sorting-element type="RESERVED_WORD" id="function" />[m
[31m-        <sorting-element type="RESERVED_WORD" id="parameter" />[m
[31m-      </sorting>[m
[31m-      <format>[m
[31m-        <enforce-code-style-case value="true" />[m
[31m-      </format>[m
[31m-    </code-completion-settings>[m
[31m-    <execution-engine-settings>[m
[31m-      <statement-execution>[m
[31m-        <fetch-block-size value="100" />[m
[31m-        <execution-timeout value="20" />[m
[31m-        <debug-execution-timeout value="600" />[m
[31m-        <focus-result value="false" />[m
[31m-        <prompt-execution value="false" />[m
[31m-      </statement-execution>[m
[31m-      <script-execution>[m
[31m-        <command-line-interfaces />[m
[31m-        <execution-timeout value="300" />[m
[31m-      </script-execution>[m
[31m-      <method-execution>[m
[31m-        <execution-timeout value="30" />[m
[31m-        <debug-execution-timeout value="600" />[m
[31m-        <parameter-history-size value="10" />[m
[31m-      </method-execution>[m
[31m-    </execution-engine-settings>[m
[31m-    <operation-settings>[m
[31m-      <transactions>[m
[31m-        <uncommitted-changes>[m
[31m-          <on-project-close value="ASK" />[m
[31m-          <on-disconnect value="ASK" />[m
[31m-          <on-autocommit-toggle value="ASK" />[m
[31m-        </uncommitted-changes>[m
[31m-        <multiple-uncommitted-changes>[m
[31m-          <on-commit value="ASK" />[m
[31m-          <on-rollback value="ASK" />[m
[31m-        </multiple-uncommitted-changes>[m
[31m-      </transactions>[m
[31m-      <session-browser>[m
[31m-        <disconnect-session value="ASK" />[m
[31m-        <kill-session value="ASK" />[m
[31m-        <reload-on-filter-change value="false" />[m
[31m-      </session-browser>[m
[31m-      <compiler>[m
[31m-        <compile-type value="KEEP" />[m
[31m-        <compile-dependencies value="ASK" />[m
[31m-        <always-show-controls value="false" />[m
[31m-      </compiler>[m
[31m-      <debugger>[m
[31m-        <debugger-type value="ASK" />[m
[31m-        <use-generic-runners value="true" />[m
[31m-      </debugger>[m
[31m-    </operation-settings>[m
[31m-    <ddl-file-settings>[m
[31m-      <extensions>[m
[31m-        <mapping file-type-id="VIEW" extensions="vw" />[m
[31m-        <mapping file-type-id="TRIGGER" extensions="trg" />[m
[31m-        <mapping file-type-id="PROCEDURE" extensions="prc" />[m
[31m-        <mapping file-type-id="FUNCTION" extensions="fnc" />[m
[31m-        <mapping file-type-id="PACKAGE" extensions="pkg" />[m
[31m-        <mapping file-type-id="PACKAGE_SPEC" extensions="pks" />[m
[31m-        <mapping file-type-id="PACKAGE_BODY" extensions="pkb" />[m
[31m-        <mapping file-type-id="TYPE" extensions="tpe" />[m
[31m-        <mapping file-type-id="TYPE_SPEC" extensions="tps" />[m
[31m-        <mapping file-type-id="TYPE_BODY" extensions="tpb" />[m
[31m-      </extensions>[m
[31m-      <general>[m
[31m-        <lookup-ddl-files value="true" />[m
[31m-        <create-ddl-files value="false" />[m
[31m-        <synchronize-ddl-files value="true" />[m
[31m-        <use-qualified-names value="false" />[m
[31m-        <make-scripts-rerunnable value="true" />[m
[31m-      </general>[m
[31m-    </ddl-file-settings>[m
[31m-    <general-settings>[m
[31m-      <regional-settings>[m
[31m-        <date-format value="MEDIUM" />[m
[31m-        <number-format value="UNGROUPED" />[m
[31m-        <locale value="SYSTEM_DEFAULT" />[m
[31m-        <use-custom-formats value="false" />[m
[31m-      </regional-settings>[m
[31m-      <environment>[m
[31m-        <environment-types>[m
[31m-          <environment-type id="development" name="Development" description="Development environment" color="-2430209/-12296320" readonly-code="false" readonly-data="false" />[m
[31m-          <environment-type id="integration" name="Integration" description="Integration environment" color="-2621494/-12163514" readonly-code="true" readonly-data="false" />[m
[31m-          <environment-type id="production" name="Production" description="Productive environment" color="-11574/-10271420" readonly-code="true" readonly-data="true" />[m
[31m-          <environment-type id="other" name="Other" description="" color="-1576/-10724543" readonly-code="false" readonly-data="false" />[m
[31m-        </environment-types>[m
[31m-        <visibility-settings>[m
[31m-          <connection-tabs value="true" />[m
[31m-          <dialog-headers value="true" />[m
[31m-          <object-editor-tabs value="true" />[m
[31m-          <script-editor-tabs value="false" />[m
[31m-          <execution-result-tabs value="true" />[m
[31m-        </visibility-settings>[m
[31m-      </environment>[m
[31m-    </general-settings>[m
[31m-  </component>[m
[31m-  <component name="DBNavigator.Project.StatementExecutionManager">[m
[31m-    <execution-variables />[m
[31m-  </component>[m
[31m-</project>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/gradle.xml b/.idea/gradle.xml[m
[1mindex 169fd0d..d291b3d 100644[m
[1m--- a/.idea/gradle.xml[m
[1m+++ b/.idea/gradle.xml[m
[36m@@ -3,14 +3,11 @@[m
   <component name="GradleSettings">[m
     <option name="linkedExternalProjectsSettings">[m
       <GradleProjectSettings>[m
[32m+[m[32m        <compositeConfiguration>[m
[32m+[m[32m          <compositeBuild compositeDefinitionSource="SCRIPT" />[m
[32m+[m[32m        </compositeConfiguration>[m
         <option name="distributionType" value="DEFAULT_WRAPPED" />[m
         <option name="externalProjectPath" value="$PROJECT_DIR$" />[m
[31m-        <option name="modules">[m
[31m-          <set>[m
[31m-            <option value="$PROJECT_DIR$" />[m
[31m-            <option value="$PROJECT_DIR$/app" />[m
[31m-          </set>[m
[31m-        </option>[m
         <option name="resolveModulePerSourceSet" value="false" />[m
         <option name="testRunner" value="PLATFORM" />[m
       </GradleProjectSettings>[m
[1mdiff --git a/.idea/misc.xml b/.idea/misc.xml[m
[1mindex 7bfef59..b6ea2b1 100644[m
[1m--- a/.idea/misc.xml[m
[1m+++ b/.idea/misc.xml[m
[36m@@ -1,6 +1,6 @@[m
 <?xml version="1.0" encoding="UTF-8"?>[m
 <project version="4">[m
[31m-  <component name="ProjectRootManager" version="2" languageLevel="JDK_1_8" project-jdk-name="1.8" project-jdk-type="JavaSDK">[m
[32m+[m[32m  <component name="ProjectRootManager" version="2" languageLevel="JDK_1_8" project-jdk-name="JDK" project-jdk-type="JavaSDK">[m
     <output url="file://$PROJECT_DIR$/build/classes" />[m
   </component>[m
   <component name="ProjectType">[m
[1mdiff --git a/app/build.gradle b/app/build.gradle[m
[1mindex b53baf2..768d6a4 100644[m
[1m--- a/app/build.gradle[m
[1m+++ b/app/build.gradle[m
[36m@@ -38,6 +38,7 @@[m [mdependencies {[m
     implementation fileTree(dir: 'libs', include: ['*.jar'])[m
     implementation 'androidx.appcompat:appcompat:1.0.2'[m
     implementation 'androidx.constraintlayout:constraintlayout:1.1.3'[m
[32m+[m[32m    implementation 'com.android.support:recyclerview-v7:28.0.0'[m
     testImplementation 'junit:junit:4.12'[m
 [m
 // SDK在解析请求返回的JSON数据时用到[m
[36m@@ -59,4 +60,5 @@[m [mdependencies {[m
     implementation 'com.jakewharton:butterknife:10.2.1'[m
     annotationProcessor 'com.jakewharton:butterknife-compiler:10.2.1'[m
 [m
[32m+[m[32m    implementation 'com.github.bumptech.glide:glide:4.3.1'[m
 }[m
[1mdiff --git a/app/src/main/java/com/android/himalaya/MainActivity.java b/app/src/main/java/com/android/himalaya/MainActivity.java[m
[1mindex 9be4198..40158ad 100644[m
[1m--- a/app/src/main/java/com/android/himalaya/MainActivity.java[m
[1m+++ b/app/src/main/java/com/android/himalaya/MainActivity.java[m
[36m@@ -8,16 +8,18 @@[m [mimport androidx.viewpager.widget.ViewPager;[m
 [m
 import com.android.himalaya.adapters.IndicatorAdapter;[m
 import com.android.himalaya.adapters.MainContentAdapter;[m
[32m+[m[32mimport com.android.himalaya.utils.LogUtil;[m
 [m
 import net.lucode.hackware.magicindicator.MagicIndicator;[m
 import net.lucode.hackware.magicindicator.ViewPagerHelper;[m
 import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;[m
 [m
 public class MainActivity extends FragmentActivity {[m
[32m+[m[32m    private static final String TAG = "MainActivity";[m
     private MagicIndicator mMagicIndicator;[m
     private ViewPager mContentPager;[m
[31m-    private static final String TAG = "MainActivity";[m
     private FragmentManager mSupportFragmentManager;[m
[32m+[m[32m    private IndicatorAdapter mIndicatorAdapter;[m
 [m
     @Override[m
     protected void onCreate(Bundle savedInstanceState) {[m
[36m@@ -25,15 +27,29 @@[m [mpublic class MainActivity extends FragmentActivity {[m
         setContentView(R.layout.activity_main);[m
 [m
         initView();[m
[32m+[m[32m        initEvent();[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    private void initEvent() {[m
[32m+[m[32m        mIndicatorAdapter.setOnIndicatorTabClickListener(new IndicatorAdapter.OnIndicatorTabClickListener() {[m
[32m+[m[32m            @Override[m
[32m+[m[32m            public void onTabClick(int index) {[m
[32m+[m[32m                LogUtil.d(TAG,"click index is ----->" + index);[m
[32m+[m[32m                if (mContentPager != null){[m
[32m+[m[32m                    mContentPager.setCurrentItem(index);[m
[32m+[m[32m                }[m
[32m+[m[32m            }[m
[32m+[m[32m        });[m
     }[m
 [m
     private void initView() {[m
         mMagicIndicator = findViewById(R.id.magic_indicator3);[m
         mMagicIndicator.setBackgroundColor(this.getColor(R.color.main_color));[m
         //创建Indicator的适配器[m
[31m-        IndicatorAdapter indicatorAdapter = new IndicatorAdapter(this);[m
[32m+[m[32m        mIndicatorAdapter = new IndicatorAdapter(this);[m
         CommonNavigator commonNavigator = new CommonNavigator(this);[m
[31m-        commonNavigator.setAdapter(indicatorAdapter);[m
[32m+[m[32m        commonNavigator.setAdjustMode(true);[m
[32m+[m[32m        commonNavigator.setAdapter(mIndicatorAdapter);[m
 [m
         //ViewPage[m
         mContentPager = findViewById(R.id.content_pager);[m
[1mdiff --git a/app/src/main/java/com/android/himalaya/adapters/IndicatorAdapter.java b/app/src/main/java/com/android/himalaya/adapters/IndicatorAdapter.java[m
[1mindex c3751cf..a26330b 100644[m
[1m--- a/app/src/main/java/com/android/himalaya/adapters/IndicatorAdapter.java[m
[1m+++ b/app/src/main/java/com/android/himalaya/adapters/IndicatorAdapter.java[m
[36m@@ -22,6 +22,7 @@[m [mpublic class IndicatorAdapter extends CommonNavigatorAdapter {[m
 [m
 [m
     private final String[] mTitles;[m
[32m+[m[32m    private OnIndicatorTabClickListener mOnTabClickListener;[m
 [m
     public IndicatorAdapter(Context context) {[m
         mTitles = context.getResources().getStringArray(R.array.indicator_title);[m
[36m@@ -52,10 +53,9 @@[m [mpublic class IndicatorAdapter extends CommonNavigatorAdapter {[m
             @Override[m
             public void onClick(View v) {[m
                 //切换viewpage的内容，如果index不同[m
[31m-                //TODO：[m
[31m-//                if (mListener != null){[m
[31m-//                    mListener.onTitleSelected(index);[m
[31m-//                }[m
[32m+[m[32m                if (mOnTabClickListener != null){[m
[32m+[m[32m                    mOnTabClickListener.onTabClick(index);[m
[32m+[m[32m                }[m
             }[m
         });[m
         return colorTransitionPagerTitleView;[m
[36m@@ -69,4 +69,12 @@[m [mpublic class IndicatorAdapter extends CommonNavigatorAdapter {[m
         linePagerIndicator.setColors(Color.WHITE);[m
         return linePagerIndicator;[m
     }[m
[32m+[m
[32m+[m[32m    public void setOnIndicatorTabClickListener(OnIndicatorTabClickListener listener){[m
[32m+[m[32m        this.mOnTabClickListener = listener;[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    public interface OnIndicatorTabClickListener{[m
[32m+[m[32m        void onTabClick(int index);[m
[32m+[m[32m    }[m
 }[m
[1mdiff --git a/app/src/main/java/com/android/himalaya/adapters/MainContentAdapter.java b/app/src/main/java/com/android/himalaya/adapters/MainContentAdapter.java[m
[1mindex 80f5761..4386253 100644[m
[1m--- a/app/src/main/java/com/android/himalaya/adapters/MainContentAdapter.java[m
[1m+++ b/app/src/main/java/com/android/himalaya/adapters/MainContentAdapter.java[m
[36m@@ -10,6 +10,8 @@[m [mimport com.android.himalaya.utils.FragmentCreator;[m
 /**[m
  * create by shadowman[m
  * on 2019/12/28[m
[32m+[m[32m *[m
[32m+[m[32m * 将fragment和indicator一一对应[m
  */[m
 public class MainContentAdapter extends FragmentPagerAdapter {[m
     public MainContentAdapter(FragmentManager fm) {[m
[1mdiff --git a/app/src/main/java/com/android/himalaya/fragments/RecommendFragment.java b/app/src/main/java/com/android/himalaya/fragments/RecommendFragment.java[m
[1mindex 9819fa3..1751468 100644[m
[1m--- a/app/src/main/java/com/android/himalaya/fragments/RecommendFragment.java[m
[1m+++ b/app/src/main/java/com/android/himalaya/fragments/RecommendFragment.java[m
[36m@@ -1,20 +1,100 @@[m
 package com.android.himalaya.fragments;[m
 [m
[32m+[m[32mimport android.graphics.Rect;[m
[32m+[m[32mimport android.nfc.Tag;[m
 import android.view.LayoutInflater;[m
 import android.view.View;[m
 import android.view.ViewGroup;[m
 [m
[32m+[m[32mimport androidx.annotation.NonNull;[m
[32m+[m[32mimport androidx.recyclerview.widget.LinearLayoutManager;[m
[32m+[m[32mimport androidx.recyclerview.widget.RecyclerView;[m
[32m+[m
 import com.android.himalaya.R;[m
[32m+[m[32mimport com.android.himalaya.adapters.RecommendListAdapter;[m
 import com.android.himalaya.base.BaseFragment;[m
[32m+[m[32mimport com.android.himalaya.interfaces.IRecommendCallback;[m
[32m+[m[32mimport com.android.himalaya.presenters.RecommendPresenter;[m
[32m+[m[32mimport com.android.himalaya.utils.Constants;[m
[32m+[m[32mimport com.android.himalaya.utils.LogUtil;[m
[32m+[m[32mimport com.ximalaya.ting.android.opensdk.constants.DTransferConstants;[m
[32m+[m[32mimport com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;[m
[32m+[m[32mimport com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;[m
[32m+[m[32mimport com.ximalaya.ting.android.opensdk.model.album.Album;[m
[32m+[m[32mimport com.ximalaya.ting.android.opensdk.model.album.GussLikeAlbumList;[m
[32m+[m
[32m+[m[32mimport net.lucode.hackware.magicindicator.buildins.UIUtil;[m
[32m+[m
[32m+[m[32mimport java.util.HashMap;[m
[32m+[m[32mimport java.util.List;[m
[32m+[m[32mimport java.util.Map;[m
 [m
 /**[m
  * create by shadowman[m
  * on 2019/12/28[m
  */[m
[31m-public class RecommendFragment extends BaseFragment {[m
[32m+[m[32mpublic class RecommendFragment extends BaseFragment implements IRecommendCallback {[m
[32m+[m[32m    private static final String TAG = "RecommendFragment";[m
[32m+[m[32m    private View mRootView;[m
[32m+[m[32m    private RecyclerView mRecommendRv;[m
[32m+[m[32m    private RecommendListAdapter mRecommendListAdapter;[m
[32m+[m[32m    private RecommendPresenter mRecommendPresenter;[m
[32m+[m
     @Override[m
     protected View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container) {[m
[31m-        View rootView = layoutInflater.inflate(R.layout.fragment_recommend, container, false);[m
[31m-        return rootView;[m
[32m+[m[32m        mRootView = layoutInflater.inflate(R.layout.fragment_recommend, container, false);[m
[32m+[m
[32m+[m[32m        mRecommendRv = mRootView.findViewById(R.id.recommend_list);[m
[32m+[m[32m        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());[m
[32m+[m[32m        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);[m
[32m+[m[32m        mRecommendRv.setLayoutManager(linearLayoutManager);[m
[32m+[m[32m        mRecommendRv.addItemDecoration(new RecyclerView.ItemDecoration() {[m
[32m+[m[32m            @Override[m
[32m+[m[32m            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {[m
[32m+[m[32m                //UIUtiil工具类可以将px转为pd，pd转为px[m
[32m+[m[32m                outRect.bottom = UIUtil.dip2px(view.getContext(),5);[m
[32m+[m[32m                outRect.top = UIUtil.dip2px(view.getContext(),5);[m
[32m+[m[32m                outRect.left = UIUtil.dip2px(view.getContext(),5);[m
[32m+[m[32m                outRect.right = UIUtil.dip2px(view.getContext(),5);[m
[32m+[m[32m            }[m
[32m+[m[32m        });[m
[32m+[m[32m        mRecommendListAdapter = new RecommendListAdapter();[m
[32m+[m[32m        mRecommendRv.setAdapter(mRecommendListAdapter);[m
[32m+[m
[32m+[m[32m        //获取到逻辑层对象[m
[32m+[m[32m        mRecommendPresenter = RecommendPresenter.getInstance();[m
[32m+[m[32m        //设置通知接口的注册[m
[32m+[m[32m        mRecommendPresenter.registerViewCallback(this);[m
[32m+[m[32m        //获取推荐列表[m
[32m+[m[32m        mRecommendPresenter.getRecommendList();[m
[32m+[m
[32m+[m
[32m+[m[32m        return mRootView;[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    @Override[m
[32m+[m[32m    public void onRecommendListLoaded(List<Album> result) {[m
[32m+[m[32m        //当获取到推荐内容的时候，此方法就会被调用（成功）[m
[32m+[m[32m        //数据回来就更新UI[m
[32m+[m[32m        //把数据设置给适配器，并且更新UI[m
[32m+[m[32m        mRecommendListAdapter.setData(result);[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    @Override[m
[32m+[m[32m    public void onLoadMore(List<Album> result) {[m
[32m+[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    @Override[m
[32m+[m[32m    public void onReflashMore(List<Album> result) {[m
[32m+[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    @Override[m
[32m+[m[32m    public void onDestroy() {[m
[32m+[m[32m        super.onDestroy();[m
[32m+[m[32m        if (mRecommendPresenter != null){[m
[32m+[m[32m            mRecommendPresenter.unRegisterViewCallback(this);[m
[32m+[m[32m        }[m
     }[m
 }[m
[1mdiff --git a/app/src/main/java/com/android/himalaya/utils/FragmentCreator.java b/app/src/main/java/com/android/himalaya/utils/FragmentCreator.java[m
[1mindex 6a4919f..26c6e2a 100644[m
[1m--- a/app/src/main/java/com/android/himalaya/utils/FragmentCreator.java[m
[1m+++ b/app/src/main/java/com/android/himalaya/utils/FragmentCreator.java[m
[36m@@ -9,6 +9,10 @@[m [mimport java.util.Map;[m
 /**[m
  * create by shadowman[m
  * on 2019/12/28[m
[32m+[m[32m *[m
[32m+[m[32m * 添加fragment工具类，减少重复创建fragment，节省资源，[m
[32m+[m[32m * 如果后续要添加fragment，可以直接添加静态常量[m
[32m+[m[32m *[m
  */[m
 public class FragmentCreator {[m
     public final static int INDEX_RECOMMEND = 0;[m
[1mdiff --git a/app/src/main/res/layout/activity_main.xml b/app/src/main/res/layout/activity_main.xml[m
[1mindex 32bc4b3..50450ef 100644[m
[1m--- a/app/src/main/res/layout/activity_main.xml[m
[1m+++ b/app/src/main/res/layout/activity_main.xml[m
[36m@@ -1,20 +1,47 @@[m
 <?xml version="1.0" encoding="utf-8"?>[m
[31m-<RelativeLayout[m
[32m+[m[32m<LinearLayout[m
     xmlns:android="http://schemas.android.com/apk/res/android"[m
     xmlns:app="http://schemas.android.com/apk/res-auto"[m
     xmlns:tools="http://schemas.android.com/tools"[m
     android:layout_width="match_parent"[m
     android:layout_height="match_parent"[m
[32m+[m[32m    android:orientation="vertical"[m
     tools:context=".MainActivity">[m
 [m
[31m-    <net.lucode.hackware.magicindicator.MagicIndicator[m
[31m-        android:id="@+id/magic_indicator3"[m
[31m-        android:layout_width="match_parent"[m
[31m-        android:layout_height="40dp" />[m
[32m+[m[32m    <LinearLayout[m
[32m+[m[32m        android:layout_width="wrap_content"[m
[32m+[m[32m        android:layout_height="40dp"[m
[32m+[m[32m        android:orientation="horizontal">[m
[32m+[m
[32m+[m[32m        <net.lucode.hackware.magicindicator.MagicIndicator[m
[32m+[m[32m            android:id="@+id/magic_indicator3"[m
[32m+[m[32m            android:layout_width="0dp"[m
[32m+[m[32m            android:layout_weight="3"[m
[32m+[m[32m            android:layout_height="match_parent" />[m
[32m+[m
[32m+[m[32m        <LinearLayout[m
[32m+[m[32m            android:layout_width="0dp"[m
[32m+[m[32m            android:layout_height="match_parent"[m
[32m+[m[32m            android:layout_weight="1">[m
[32m+[m
[32m+[m[32m            <ImageView[m
[32m+[m[32m                android:layout_width="0dp"[m
[32m+[m[32m                android:layout_height="match_parent"[m
[32m+[m[32m                android:padding="7dp"[m
[32m+[m[32m                android:layout_weight="1"[m
[32m+[m[32m                android:src="@drawable/ic_search"[m
[32m+[m[32m                android:background="@color/main_color"/>[m
[32m+[m
[32m+[m[32m        </LinearLayout>[m
[32m+[m
[32m+[m[32m    </LinearLayout>[m
[32m+[m
[32m+[m
 [m
     <androidx.viewpager.widget.ViewPager[m
[32m+[m[32m        android:overScrollMode="never"[m
         android:id="@+id/content_pager"[m
         android:layout_width="match_parent"[m
         android:layout_height="match_parent"/>[m
[31m-[m
[31m-</RelativeLayout>[m
\ No newline at end of file[m
[32m+[m[32m<!--        overScrollMode="never" 是将viewpage左右滑动时尽头阴影动画取消-->[m
[32m+[m[32m</LinearLayout>[m
\ No newline at end of file[m
[1mdiff --git a/app/src/main/res/layout/fragment_recommend.xml b/app/src/main/res/layout/fragment_recommend.xml[m
[1mindex 3509b84..70a34b9 100644[m
[1m--- a/app/src/main/res/layout/fragment_recommend.xml[m
[1m+++ b/app/src/main/res/layout/fragment_recommend.xml[m
[36m@@ -3,4 +3,11 @@[m
     android:orientation="vertical" android:layout_width="match_parent"[m
     android:layout_height="match_parent">[m
 [m
[32m+[m[32m    <androidx.recyclerview.widget.RecyclerView[m
[32m+[m[32m        android:id="@+id/recommend_list"[m
[32m+[m[32m        android:layout_width="match_parent"[m
[32m+[m[32m        android:layout_height="match_parent"[m
[32m+[m[32m        android:overScrollMode="never"[m
[32m+[m[32m        android:background="#fff4f4f4"/>[m
[32m+[m
 </LinearLayout>[m
\ No newline at end of file[m
[1mdiff --git a/app/src/main/res/values/styles.xml b/app/src/main/res/values/styles.xml[m
[1mindex 2f244ad..b57bbcb 100644[m
[1m--- a/app/src/main/res/values/styles.xml[m
[1m+++ b/app/src/main/res/values/styles.xml[m
[36m@@ -6,6 +6,7 @@[m
         <item name="colorPrimary">@color/main_color</item>[m
         <item name="colorPrimaryDark">@color/main_color</item>[m
         <item name="colorAccent">@color/main_color</item>[m
[32m+[m
     </style>[m
 [m
 </resources>[m
