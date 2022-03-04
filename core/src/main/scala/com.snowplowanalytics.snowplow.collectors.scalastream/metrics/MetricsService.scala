/*
 * Copyright (c) 2013-2022 Snowplow Analytics Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0, and
 * you may not use this file except in compliance with the Apache License
 * Version 2.0.  You may obtain a copy of the Apache License Version 2.0 at
 * http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Apache License Version 2.0 is distributed on an "AS
 * IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the Apache License Version 2.0 for the specific language
 * governing permissions and limitations there under.
 */
package com.snowplowanalytics.snowplow.collectors.scalastream
package metrics


import java.time.Duration

import akka.http.scaladsl.model.{HttpMethod, StatusCode, Uri}

/**
  * Service which is used to keep track of processed http requests
  * and report generation based on collected statistics
  */
trait MetricsService {
  def observeRequest(method: HttpMethod, uri: Uri, status: StatusCode, duration: Duration): Unit
  def report(): String
}
