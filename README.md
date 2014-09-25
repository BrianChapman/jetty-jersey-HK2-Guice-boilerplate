jetty-jersey-HK2-Guice-boilerplate with GuiceBridgeJitInjector
==================================

This is fairly minimal code for a Jersey 2/Embedded Jetty/Guice application using the [GuiceBridgeJitInjector](https://github.com/t-tang/guice-bridge-jit-injector "guice-bridge-jit-injector").

To run

mvn exec:java -Dexec.mainClass="org.ttang.Main"

Then visit:

http://0.0.0.0:8080/services/hello