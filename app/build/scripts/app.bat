@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem
@rem SPDX-License-Identifier: Apache-2.0
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  app startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables, and ensure extensions are enabled
setlocal EnableExtensions

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
@rem This is normally unused
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and APP_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo. 1>&2
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH. 1>&2
echo. 1>&2
echo Please set the JAVA_HOME variable in your environment to match the 1>&2
echo location of your Java installation. 1>&2

"%COMSPEC%" /c exit 1

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo. 1>&2
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME% 1>&2
echo. 1>&2
echo Please set the JAVA_HOME variable in your environment to match the 1>&2
echo location of your Java installation. 1>&2

"%COMSPEC%" /c exit 1

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\app-plain.jar;%APP_HOME%\lib\guava-33.5.0-jre.jar;%APP_HOME%\lib\spring-boot-starter-web-3.5.6.jar;%APP_HOME%\lib\aspectjrt-1.9.24.jar;%APP_HOME%\lib\aspectjweaver-1.9.24.jar;%APP_HOME%\lib\lombok-1.18.40.jar;%APP_HOME%\lib\groovy-cli-picocli-4.0.28.jar;%APP_HOME%\lib\groovy-groovysh-4.0.28.jar;%APP_HOME%\lib\groovy-console-4.0.28.jar;%APP_HOME%\lib\groovy-datetime-4.0.28.jar;%APP_HOME%\lib\groovy-groovydoc-4.0.28.jar;%APP_HOME%\lib\groovy-docgenerator-4.0.28.jar;%APP_HOME%\lib\groovy-jmx-4.0.28.jar;%APP_HOME%\lib\groovy-yaml-4.0.28.jar;%APP_HOME%\lib\groovy-json-4.0.28.jar;%APP_HOME%\lib\groovy-jsr223-4.0.28.jar;%APP_HOME%\lib\groovy-macro-4.0.28.jar;%APP_HOME%\lib\groovy-nio-4.0.28.jar;%APP_HOME%\lib\groovy-servlet-4.0.28.jar;%APP_HOME%\lib\groovy-sql-4.0.28.jar;%APP_HOME%\lib\groovy-swing-4.0.28.jar;%APP_HOME%\lib\groovy-templates-4.0.28.jar;%APP_HOME%\lib\groovy-test-4.0.28.jar;%APP_HOME%\lib\groovy-test-junit5-4.0.28.jar;%APP_HOME%\lib\groovy-xml-4.0.28.jar;%APP_HOME%\lib\groovy-ant-4.0.28.jar;%APP_HOME%\lib\groovy-4.0.28.jar;%APP_HOME%\lib\failureaccess-1.0.3.jar;%APP_HOME%\lib\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;%APP_HOME%\lib\jspecify-1.0.0.jar;%APP_HOME%\lib\error_prone_annotations-2.41.0.jar;%APP_HOME%\lib\j2objc-annotations-3.1.jar;%APP_HOME%\lib\spring-boot-starter-json-3.5.6.jar;%APP_HOME%\lib\spring-boot-starter-3.5.6.jar;%APP_HOME%\lib\spring-boot-starter-tomcat-3.5.6.jar;%APP_HOME%\lib\spring-webmvc-6.2.11.jar;%APP_HOME%\lib\spring-web-6.2.11.jar;%APP_HOME%\lib\ant-junit-1.10.15.jar;%APP_HOME%\lib\ant-1.10.15.jar;%APP_HOME%\lib\ant-launcher-1.10.15.jar;%APP_HOME%\lib\ant-antlr-1.10.15.jar;%APP_HOME%\lib\picocli-4.7.7.jar;%APP_HOME%\lib\javaparser-core-3.27.0.jar;%APP_HOME%\lib\asm-util-9.8.jar;%APP_HOME%\lib\ivy-2.5.3.jar;%APP_HOME%\lib\org.abego.treelayout.core-1.0.3.jar;%APP_HOME%\lib\qdox-1.12.1.jar;%APP_HOME%\lib\jline-2.14.6.jar;%APP_HOME%\lib\junit-4.13.2.jar;%APP_HOME%\lib\junit-jupiter-engine-5.12.2.jar;%APP_HOME%\lib\junit-jupiter-api-5.12.2.jar;%APP_HOME%\lib\junit-platform-engine-1.12.2.jar;%APP_HOME%\lib\junit-platform-commons-1.12.2.jar;%APP_HOME%\lib\junit-platform-launcher-1.12.2.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.19.2.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.19.2.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.19.2.jar;%APP_HOME%\lib\jackson-databind-2.19.2.jar;%APP_HOME%\lib\jackson-core-2.19.2.jar;%APP_HOME%\lib\jackson-annotations-2.19.2.jar;%APP_HOME%\lib\jackson-dataformat-yaml-2.19.2.jar;%APP_HOME%\lib\spring-boot-autoconfigure-3.5.6.jar;%APP_HOME%\lib\spring-boot-3.5.6.jar;%APP_HOME%\lib\spring-boot-starter-logging-3.5.6.jar;%APP_HOME%\lib\jakarta.annotation-api-2.1.1.jar;%APP_HOME%\lib\spring-context-6.2.11.jar;%APP_HOME%\lib\spring-aop-6.2.11.jar;%APP_HOME%\lib\spring-beans-6.2.11.jar;%APP_HOME%\lib\spring-expression-6.2.11.jar;%APP_HOME%\lib\spring-core-6.2.11.jar;%APP_HOME%\lib\snakeyaml-2.4.jar;%APP_HOME%\lib\tomcat-embed-websocket-10.1.46.jar;%APP_HOME%\lib\tomcat-embed-core-10.1.46.jar;%APP_HOME%\lib\tomcat-embed-el-10.1.46.jar;%APP_HOME%\lib\micrometer-observation-1.15.4.jar;%APP_HOME%\lib\asm-analysis-9.8.jar;%APP_HOME%\lib\asm-tree-9.8.jar;%APP_HOME%\lib\asm-9.8.jar;%APP_HOME%\lib\hamcrest-core-3.0.jar;%APP_HOME%\lib\opentest4j-1.3.0.jar;%APP_HOME%\lib\logback-classic-1.5.18.jar;%APP_HOME%\lib\log4j-to-slf4j-2.24.3.jar;%APP_HOME%\lib\jul-to-slf4j-2.0.17.jar;%APP_HOME%\lib\spring-jcl-6.2.11.jar;%APP_HOME%\lib\micrometer-commons-1.15.4.jar;%APP_HOME%\lib\hamcrest-3.0.jar;%APP_HOME%\lib\logback-core-1.5.18.jar;%APP_HOME%\lib\slf4j-api-2.0.17.jar;%APP_HOME%\lib\log4j-api-2.24.3.jar


@rem Execute app
@rem endlocal doesn't take effect until after the line is parsed and variables are expanded
@rem which allows us to clear the local environment before executing the java command
endlocal & "%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %APP_OPTS%  -classpath "%CLASSPATH%" org.example.App %* & call :exitWithErrorLevel

:exitWithErrorLevel
@rem Use "%COMSPEC%" /c exit to allow operators to work properly in scripts
"%COMSPEC%" /c exit %ERRORLEVEL%
