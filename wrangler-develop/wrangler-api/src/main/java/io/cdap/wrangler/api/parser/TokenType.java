/*
 * Copyright © 2017-2019 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package io.cdap.wrangler.api.parser;

import io.cdap.wrangler.api.annotations.PublicEvolving;

import java.io.Serializable;

/**
 * The TokenType class provides the enumerated types for different types of
 * tokens that are supported by the grammar.
 *
 * Each of the enumerated types specified in this class also has associated
 * object representing it. e.g. {@code DIRECTIVE_NAME} is represented by the
 * object {@code DirectiveName}.
 */
@PublicEvolving
public enum TokenType implements Serializable {
  DIRECTIVE_NAME,
  COLUMN_NAME,
  TEXT,
  NUMERIC,
  BOOLEAN,
  COLUMN_NAME_LIST,
  TEXT_LIST,
  NUMERIC_LIST,
  BOOLEAN_LIST,
  EXPRESSION,
  PROPERTIES,
  RANGES,
  IDENTIFIER,

  /**
   * Represents the enumerated type for the object of type {@code ByteSize}.
   * This type is associated with values like '10KB', '1MB', '2.5GB', etc.
   */
  BYTE_SIZE,

  /**
   * Represents the enumerated type for the object of type {@code TimeDuration}.
   * This type is associated with values like '5ms', '2s', '3.5m', '1h', etc.
   */
  TIME_DURATION
}
