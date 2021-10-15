/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.instrumentation.awssdk.v1_11;

import com.amazonaws.Request;
import com.amazonaws.Response;
import io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesExtractor;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import org.checkerframework.checker.nullness.qual.Nullable;

class AwsSdkNetAttributesExtractor extends NetClientAttributesExtractor<Request<?>, Response<?>> {
  @Override
  public String transport(Request<?> request, @Nullable Response<?> response) {
    return SemanticAttributes.NetTransportValues.IP_TCP;
  }

  @Override
  public @Nullable String peerName(Request<?> request, @Nullable Response<?> response) {
    return request.getEndpoint().getHost();
  }

  @Override
  public Integer peerPort(Request<?> request, @Nullable Response<?> response) {
    return request.getEndpoint().getPort();
  }

  @Override
  public @Nullable String peerIp(Request<?> request, @Nullable Response<?> response) {
    return null;
  }
}