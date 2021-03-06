/*
 * Copyright (C) 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ro.pippo.demo.template;

import ro.pippo.core.Languages;
import ro.pippo.core.Request;
import ro.pippo.core.Response;
import ro.pippo.core.route.RequestLanguageFilter;
import ro.pippo.core.route.RouteHandlerChain;

/**
 * Binds the available languages to the response.
 *
 * @author James Moger
 *
 */
public class LanguageFilter extends RequestLanguageFilter {

	public LanguageFilter(Languages languages, boolean enableQueryParameter) {
		super(languages, enableQueryParameter);
	}

	@Override
	public void handle(Request request, Response response, RouteHandlerChain chain) {
		response.bind("languageChoices", languages.getRegisteredLanguages());
		super.handle(request, response, chain);
	}

}
