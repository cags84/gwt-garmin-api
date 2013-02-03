package com.garmin.gwt.communicator.client.request;

/*
 * #%L
 * GWT Garmin API - Core API
 * %%
 * Copyright (C) 2012 - 2013 GWT Garmin API
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import com.garmin.gwt.communicator.client.base.Device;
import com.garmin.gwt.communicator.client.plugin.DevicePlugin;


/**
 * General handler for callbacks to the device.<br>
 * <b>NOTE:</b> Once created, the request will start.
 * 
 * @author Joseph Lust
 * 
 */
public final class DevicesPluginRequest extends AbstractPluginRequest<Device[]> {


	public DevicesPluginRequest(DevicePlugin plugin, RequestCallback<Device[]> callback) {
		super();
		setPlugin(plugin);
		setCallback(callback);
		startRequest(); // DON'T override...
	}

	@Override
	protected void startRequest() {
		setRunning(true);
		getPlugin().startFindDevices();
		getTimer().schedule(POLLING_INTERVAL_MS);
	}

	@Override
	protected boolean finishRequest() {
		return getPlugin().finishFindDevices();
	}

	@Override
	public void cancelRequest() {
		if(isRunning()) {
			getPlugin().cancelFindDevices();
			getTimer().cancel();
		}
	}

	@Override
	protected Device[] getRequestResult() {
		setRunning(false);
		return getPlugin().getDevices();
	}

}
