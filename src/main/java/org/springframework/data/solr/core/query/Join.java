/*
 * Copyright 2012 - 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.solr.core.query;

import org.springframework.util.Assert;

/**
 * @author Christoph Strobl
 */
public class Join {

	private Field from;
	private Field to;

	private Join() {
		// hide default constructor
	}

	public Join(Field from, Field to) {
		this.from = from;
		this.to = to;
	}

	public static Builder from(Field from) {
		return new Builder(from);
	}

	public static Builder from(String fieldname) {
		return from(new SimpleField(fieldname));
	}

	public Field getFrom() {
		return from;
	}

	public Field getTo() {
		return to;
	}

	public static class Builder {

		private Join join;

		public Builder(Field from) {
			Assert.notNull(from);

			join = new Join();
			join.from = from;
		}

		public Builder(String fieldname) {
			this(new SimpleField(fieldname));
		}

		public Join to(Field to) {
			Assert.notNull(to);

			join.to = to;
			return this.join;
		}

		public Join to(String fieldname) {
			return to(new SimpleField(fieldname));
		}

	}

}
