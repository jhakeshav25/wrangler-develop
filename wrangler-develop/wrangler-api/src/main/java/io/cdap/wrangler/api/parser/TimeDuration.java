package io.cdap.wrangler.api.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class TimeDuration implements Token {
  private final String originalValue;
  private final long milliseconds;

  public TimeDuration(String value) {
    this.originalValue = value;
    this.milliseconds = parseMilliseconds(value);
  }

  private long parseMilliseconds(String value) {
    value = value.trim().toLowerCase();
    double number;
    if (value.endsWith("ms")) {
      number = Double.parseDouble(value.replace("ms", ""));
      return (long) number;
    } else if (value.endsWith("s")) {
      number = Double.parseDouble(value.replace("s", ""));
      return (long) (number * 1000);
    } else if (value.endsWith("m")) {
      number = Double.parseDouble(value.replace("m", ""));
      return (long) (number * 60 * 1000);
    } else if (value.endsWith("h")) {
      number = Double.parseDouble(value.replace("h", ""));
      return (long) (number * 60 * 60 * 1000);
    } else {
      throw new IllegalArgumentException("Invalid TimeDuration unit: " + value);
    }
  }

  public long getMilliseconds() {
    return milliseconds;
  }

  @Override
  public Object value() {
    return milliseconds;
  }

  @Override
  public TokenType type() {
    return TokenType.TIME_DURATION;
  }

  @Override
  public JsonElement toJson() {
    return new JsonPrimitive(milliseconds);
  }
}
