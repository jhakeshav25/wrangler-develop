package io.cdap.wrangler.api.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class ByteSize implements Token {
  private final String originalValue;
  private final long bytes;

  public ByteSize(String value) {
    this.originalValue = value;
    this.bytes = parseBytes(value);
  }

  private long parseBytes(String value) {
    value = value.trim().toUpperCase();
    double number;
    if (value.endsWith("KB")) {
      number = Double.parseDouble(value.replace("KB", ""));
      return (long) (number * 1024);
    } else if (value.endsWith("MB")) {
      number = Double.parseDouble(value.replace("MB", ""));
      return (long) (number * 1024 * 1024);
    } else if (value.endsWith("GB")) {
      number = Double.parseDouble(value.replace("GB", ""));
      return (long) (number * 1024 * 1024 * 1024);
    } else if (value.endsWith("B")) {
      number = Double.parseDouble(value.replace("B", ""));
      return (long) number;
    } else {
      throw new IllegalArgumentException("Invalid ByteSize unit: " + value);
    }
  }

  public long getBytes() {
    return bytes;
  }

  @Override
  public Object value() {
    return bytes;
  }

  @Override
  public TokenType type() {
    return TokenType.BYTE_SIZE;
  }

  @Override
  public JsonElement toJson() {
    return new JsonPrimitive(bytes);
  }
}
