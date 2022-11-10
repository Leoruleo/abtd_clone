<?xml version="1.1" encoding="UTF-8" standalone="no"?><flow-definition plugin="workflow-job@2.42">
    <actions>
      <org.jenkinsci.plugins.workflow.multibranch.JobPropertyTrackerAction plugin="workflow-multibranch@2.26">
        <jobPropertyDescriptors>
          <string>org.jenkinsci.plugins.workflow.job.properties.DisableConcurrentBuildsJobProperty</string>
          <string>jenkins.model.BuildDiscarderProperty</string>
        </jobPropertyDescriptors>
      </org.jenkinsci.plugins.workflow.multibranch.JobPropertyTrackerAction>
    </actions>
    <description/>
    <keepDependencies>false</keepDependencies>
    <properties>
      <hudson.plugins.jira.JiraProjectProperty plugin="jira@3.6">
        <siteName>https://jira.devops.dev.local/</siteName>
      </hudson.plugins.jira.JiraProjectProperty>
      <org.jenkinsci.plugins.workflow.job.properties.DisableConcurrentBuildsJobProperty>
        <abortPrevious>false</abortPrevious>
      </org.jenkinsci.plugins.workflow.job.properties.DisableConcurrentBuildsJobProperty>
      <com.dabsquared.gitlabjenkins.connection.GitLabConnectionProperty plugin="gitlab-plugin@1.5.24">
        <gitLabConnection>gitlab</gitLabConnection>
        <jobCredentialId/>
        <useAlternativeCredential>false</useAlternativeCredential>
      </com.dabsquared.gitlabjenkins.connection.GitLabConnectionProperty>
      <org.jenkinsci.plugins.gitlablogo.GitlabLogoProperty plugin="gitlab-logo@1.0.5">
        <repositoryName/>
      </org.jenkinsci.plugins.gitlablogo.GitlabLogoProperty>
      <com.synopsys.arc.jenkinsci.plugins.jobrestrictions.jobs.JobRestrictionProperty plugin="job-restrictions@0.8"/>
      <hudson.plugins.throttleconcurrents.ThrottleJobProperty plugin="throttle-concurrents@2.5">
        <maxConcurrentPerNode>0</maxConcurrentPerNode>
        <maxConcurrentTotal>0</maxConcurrentTotal>
        <categories class="java.util.concurrent.CopyOnWriteArrayList"/>
        <throttleEnabled>false</throttleEnabled>
        <throttleOption>project</throttleOption>
        <limitOneJobWithMatchingParams>false</limitOneJobWithMatchingParams>
        <paramsToUseForLimit/>
      </hudson.plugins.throttleconcurrents.ThrottleJobProperty>
      <EnvInjectJobProperty plugin="envinject@2.4.0">
        <info>
          <propertiesContent>VCS_ADDRESS=gitlab.devops.dev.local:10022
  ARTIFACTORY_URL=https://artifactory.devops.dev.local:443/artifactory/python-remote
  TRUSTED_HOST=artifactory.devops.dev.local
  REVISION=develop
  EMAIL_RECIPIENTS=Popkov.AA@gazprom-neft.ru</propertiesContent>
          <secureGroovyScript plugin="script-security@1.78">
            <script/>
            <sandbox>true</sandbox>
          </secureGroovyScript>
          <loadFilesFromMaster>false</loadFilesFromMaster>
        </info>
        <on>true</on>
        <keepJenkinsSystemVariables>true</keepJenkinsSystemVariables>
        <keepBuildVariables>true</keepBuildVariables>
        <overrideBuildParameters>false</overrideBuildParameters>
      </EnvInjectJobProperty>
      
      <jenkins.model.BuildDiscarderProperty>
        <strategy class="hudson.tasks.LogRotator">
          <daysToKeep>-1</daysToKeep>
          <numToKeep>30</numToKeep>
          <artifactDaysToKeep>-1</artifactDaysToKeep>
          <artifactNumToKeep>-1</artifactNumToKeep>
        </strategy>
      </jenkins.model.BuildDiscarderProperty>
      <hudson.model.ParametersDefinitionProperty>
        <parameterDefinitions>
          <hudson.model.StringParameterDefinition>
            <name>componentVersion</name>
            <defaultValue>0.0.1-rc10</defaultValue>
            <trim>false</trim>
          </hudson.model.StringParameterDefinition>
        </parameterDefinitions>
      </hudson.model.ParametersDefinitionProperty>
      <org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty>
        <triggers>
          <com.dabsquared.gitlabjenkins.GitLabPushTrigger plugin="gitlab-plugin@1.5.24">
            <spec/>
            <triggerOnPush>true</triggerOnPush>
            <triggerToBranchDeleteRequest>false</triggerToBranchDeleteRequest>
            <triggerOnMergeRequest>true</triggerOnMergeRequest>
            <triggerOnlyIfNewCommitsPushed>false</triggerOnlyIfNewCommitsPushed>
            <triggerOnPipelineEvent>false</triggerOnPipelineEvent>
            <triggerOnAcceptedMergeRequest>false</triggerOnAcceptedMergeRequest>
            <triggerOnClosedMergeRequest>false</triggerOnClosedMergeRequest>
            <triggerOnApprovedMergeRequest>false</triggerOnApprovedMergeRequest>
            <triggerOpenMergeRequestOnPush>never</triggerOpenMergeRequestOnPush>
            <triggerOnNoteRequest>false</triggerOnNoteRequest>
            <noteRegex>Jenkins please retry a build</noteRegex>
            <ciSkip>true</ciSkip>
            <skipWorkInProgressMergeRequest>true</skipWorkInProgressMergeRequest>
            <labelsThatForcesBuildIfAdded/>
            <setBuildDescription>true</setBuildDescription>
            <branchFilterType>RegexBasedFilter</branchFilterType>
            <includeBranchesSpec/>
            <excludeBranchesSpec/>
            <sourceBranchRegex>.*/tags/.*</sourceBranchRegex>
            <targetBranchRegex/>
            <secretToken>{AQAAABAAAAAwLTXny67eCtaJGXCR0sCWIG8mDRPKPzQz4+vomI2GDQ8folS8isXvQzMDfAka3TK0/FHGHGirVNaT08SgtRELtg==}</secretToken>
            <pendingBuildName/>
            <cancelPendingBuildsOnUpdate>false</cancelPendingBuildsOnUpdate>
          </com.dabsquared.gitlabjenkins.GitLabPushTrigger>
        </triggers>
      </org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty>
    </properties>
    <definition class="org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition" plugin="workflow-cps@2644.v29a793dac95a">
      <scm class="hudson.plugins.git.GitSCM" plugin="git@4.10.1">
        <configVersion>2</configVersion>
        <userRemoteConfigs>
          <hudson.plugins.git.UserRemoteConfig>
            <url>ssh://git@gitlab.devops.dev.local:10022/dzdscs/abtd/product/cicd.git</url>
            <credentialsId>82317fa7-f2c4-412c-bebf-1f7159086020</credentialsId>
          </hudson.plugins.git.UserRemoteConfig>
        </userRemoteConfigs>
        <branches>
          <hudson.plugins.git.BranchSpec>
            <name>*/unit-test-impl</name>
          </hudson.plugins.git.BranchSpec>
        </branches>
        <doGenerateSubmoduleConfigurations>false</doGenerateSubmoduleConfigurations>
        <submoduleCfg class="empty-list"/>
        <extensions/>
      </scm>
      <scriptPath>devzone.Jenkinsfile</scriptPath>
      <lightweight>true</lightweight>
    </definition>
    <triggers/>
    <disabled>false</disabled>
  </flow-definition>