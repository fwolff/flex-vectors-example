flex-vectors-example
====================

Flex Vectors Bidirectional Serialization Example with GraniteDS

What is this?
-------------

This sample application shows how to use Java annotations to get AS3 Vectors
instances in your Flex application from a GraniteDS back-end.

How to build the project?
-------------------------

1. Clone the project (or download it):

````bash
$ git clone https://github.com/fwolff/flex-vectors-example.git
````

2. Under Eclipse, import it as an existing application.

3. Edit flex-vectors-example/build.xml and fix the following section,
according to your environment:

```xml
<!-- EDIT THIS PART -->
<property name="FLEX_HOME" value="/path/to/flex_sdk_4.10.0"/>
<property name="deploy.dir" value="/path/to/tomcat/webapps"/>
<!-- /EDIT THIS PART -->
```
4. Open an Ant view, drag the build.xml file and run the "deploy" target.

5. Start Tomcat.

6. Point your browser to (http://localhost:8080/flex-vectors/).

What to do next?
----------------

Have a look at the source code, in the java and flex directory, you should
understand pretty quickly how it works.

 

