/*
 * Copyright 2017 the original author or authors.
 *
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
 */

package org.springframework.cloud.stream.metrics;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.boot.actuate.metrics.Metric;

/**
 * @author Vinicius Carvalho
 */
public class ApplicationMetrics {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
	private final Date createdTime;

	private String name;

	private int instanceIndex;

	private Collection<Metric<?>> metrics;

	private Map<String, Object> properties;

	@JsonCreator
	public ApplicationMetrics(@JsonProperty("name") String name,
			@JsonProperty("instanceIndex") int instanceIndex,
			@JsonProperty("metrics") Collection<Metric<?>> metrics) {
		this.name = name;
		this.instanceIndex = instanceIndex;
		this.metrics = metrics;
		this.createdTime = new Date();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInstanceIndex() {
		return instanceIndex;
	}

	public void setInstanceIndex(int instanceIndex) {
		this.instanceIndex = instanceIndex;
	}

	public Collection<Metric<?>> getMetrics() {
		return metrics;
	}

	public void setMetrics(Collection<Metric<?>> metrics) {
		this.metrics = metrics;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}
}
