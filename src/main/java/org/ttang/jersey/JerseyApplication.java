package org.ttang.jersey;

import javax.inject.Inject;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;
import org.ttang.hk2.GuiceBridgeJitInjector;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class JerseyApplication
		extends ResourceConfig {
	@Inject
	public JerseyApplication(ServiceLocator serviceLocator) {

		packages(JerseyApplication.class.getPackage().getName());

		GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
		GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
		Injector injector = Guice.createInjector(new GuiceModule());
		guiceBridge.bridgeGuiceInjector(GuiceBridgeJitInjector.create(injector, "org.ttang"));
	}
}