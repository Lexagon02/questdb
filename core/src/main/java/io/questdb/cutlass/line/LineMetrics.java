/*******************************************************************************
 *     ___                  _   ____  ____
 *    / _ \ _   _  ___  ___| |_|  _ \| __ )
 *   | | | | | | |/ _ \/ __| __| | | |  _ \
 *   | |_| | |_| |  __/\__ \ |_| |_| | |_) |
 *    \__\_\\__,_|\___||___/\__|____/|____/
 *
 *  Copyright (c) 2014-2019 Appsicle
 *  Copyright (c) 2019-2024 QuestDB
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 ******************************************************************************/

 package io.questdb.cutlass.line;

 import io.questdb.metrics.Counter;
 import io.questdb.metrics.MetricsRegistry;
 
 public class LineMetrics {
 
     private final LongGauge connectionCountGauge;
     private final Counter lineTcpRecvBytes;
     private final Counter lineHttpRecvBytes;
 
     public LineMetrics(MetricsRegistry metricsRegistry) {
         this.connectionCountGauge = metricsRegistry.newLongGauge("line_tcp_connections");
         this.lineTcpRecvBytes = metricsRegistry.newCounter("line_tcp_recv_bytes");
         this.lineHttpRecvBytes = metricsRegistry.newCounter("line_http_recv_bytes");
     }
 
     public LongGauge connectionCountGauge() {
         return connectionCountGauge;
     }
 
     public Counter lineTcpRecvBytes() {
         return lineTcpRecvBytes;
     }
 
     public Counter lineHttpRecvBytes() {
         return lineHttpRecvBytes;
     }
 }
