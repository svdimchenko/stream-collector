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
import sbt._

object Dependencies {

  val resolutionRepos = Seq(
    "Snowplow Analytics Maven repo".at("http://maven.snplow.com/releases/").withAllowInsecureProtocol(true),
    // For uaParser utils
    "user-agent-parser repo".at("https://clojars.org/repo/")
  )

  object V {
    // Java
    val awsSdk       = "1.12.238"
    val pubsub       = "1.119.1"
    val kafka        = "2.2.1"
    val mskAuth      = "1.1.1"
    val nsqClient    = "1.3.0"
    val jodaTime     = "2.10.13"
    val slf4j        = "1.7.32"
    val log4j        = "2.17.2" // CVE-2021-44228
    val config       = "1.4.1"
    val rabbitMQ     = "5.15.0"
    val cbor         = "2.11.4" // See snowplow/snowplow/issues/4266
    val jackson      = "2.12.7" // force this version to mitigate security vulnerabilities
    val thrift       = "0.15.0" // force this version to mitigate security vulnerabilities
    val jnrUnixsock  = "0.38.17" // force this version to mitigate security vulnerabilities
    // Scala
    val collectorPayload = "0.0.0"
    val tracker          = "1.0.0"
    val akkaHttp         = "10.2.7"
    val akka             = "2.6.16"
    val scopt            = "4.0.1"
    val pureconfig       = "0.15.0"
    val json4s           = "3.6.11"
    val akkaHttpMetrics  = "1.7.1"
    val badRows          = "2.1.1"
    // Scala (test only)
    val specs2 = "4.11.0"
  }

  object Libraries {
    // Java
    val jackson        = "com.fasterxml.jackson.core"       % "jackson-databind"        % V.jackson // nsq only
    val thrift         = "org.apache.thrift"                % "libthrift"               % V.thrift
    val kinesis        = "com.amazonaws"                    % "aws-java-sdk-kinesis"    % V.awsSdk
    val sqs            = "com.amazonaws"                    % "aws-java-sdk-sqs"        % V.awsSdk
    val sts            = "com.amazonaws"                    % "aws-java-sdk-sts"        % V.awsSdk % Runtime // Enables web token authentication https://github.com/snowplow/stream-collector/issues/169
    val pubsub         = "com.google.cloud"                 % "google-cloud-pubsub"     % V.pubsub
    val kafkaClients   = "org.apache.kafka"                 % "kafka-clients"           % V.kafka
    val mskAuth        = "software.amazon.msk"              % "aws-msk-iam-auth"        % V.mskAuth % Runtime // Enables AWS MSK IAM authentication https://github.com/snowplow/stream-collector/pull/214
    val nsqClient      = "com.snowplowanalytics"            % "nsq-java-client"         % V.nsqClient
    val jodaTime       = "joda-time"                        % "joda-time"               % V.jodaTime
    val slf4j          = "org.slf4j"                        % "slf4j-simple"            % V.slf4j
    val log4jOverSlf4j = "org.slf4j"                        % "log4j-over-slf4j"        % V.slf4j
    val log4j          = "org.apache.logging.log4j"         % "log4j-core"              % V.log4j
    val config         = "com.typesafe"                     % "config"                  % V.config
    val cbor           = "com.fasterxml.jackson.dataformat" % "jackson-dataformat-cbor" % V.cbor
    val jnrUnixsocket  = "com.github.jnr"                   % "jnr-unixsocket"          % V.jnrUnixsock
    val rabbitMQ       = "com.rabbitmq"                     % "amqp-client"             % V.rabbitMQ

    // Scala
    val collectorPayload = "com.snowplowanalytics" % "collector-payload-1"                % V.collectorPayload
    val badRows          = "com.snowplowanalytics" %% "snowplow-badrows"                  % V.badRows
    val trackerCore      = "com.snowplowanalytics" %% "snowplow-scala-tracker-core"       % V.tracker
    val trackerEmitterId = "com.snowplowanalytics" %% "snowplow-scala-tracker-emitter-id" % V.tracker
    val scopt            = "com.github.scopt"      %% "scopt"                             % V.scopt
    val akkaHttp         = "com.typesafe.akka"     %% "akka-http"                         % V.akkaHttp
    val akkaStream       = "com.typesafe.akka"     %% "akka-stream"                       % V.akka
    val akkaSlf4j        = "com.typesafe.akka"     %% "akka-slf4j"                        % V.akka
    val json4sJackson    = "org.json4s"            %% "json4s-jackson"                    % V.json4s
    val pureconfig       = "com.github.pureconfig" %% "pureconfig"                        % V.pureconfig
    val akkaHttpMetrics  = "fr.davit"              %% "akka-http-metrics-datadog"         % V.akkaHttpMetrics

    // Scala (test only)
    val specs2            = "org.specs2"        %% "specs2-core"         % V.specs2   % Test
    val akkaTestkit       = "com.typesafe.akka" %% "akka-testkit"        % V.akka     % Test
    val akkaHttpTestkit   = "com.typesafe.akka" %% "akka-http-testkit"   % V.akkaHttp % Test
    val akkaStreamTestkit = "com.typesafe.akka" %% "akka-stream-testkit" % V.akka     % Test
  }
}
