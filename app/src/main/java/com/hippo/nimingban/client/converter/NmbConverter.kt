/*
 * Copyright 2017 Hippo Seven
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

package com.hippo.nimingban.client.converter

import okhttp3.ResponseBody
import retrofit2.Converter

/*
 * Created by Hippo on 6/21/2017.
 */

abstract class NmbConverter<T> : Converter<ResponseBody, T> {

  override final fun convert(value: ResponseBody): T {
    val body = value.string()
    try {
      return doConvert(body)
    } catch (e: Throwable) {
      throw parseError(body) ?: e
    }
  }

  /**
   * Converts the body to value.
   */
  abstract fun doConvert(body: String): T
}
