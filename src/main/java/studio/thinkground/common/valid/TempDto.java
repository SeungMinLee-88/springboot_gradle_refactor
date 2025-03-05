package studio.thinkground.common.valid;

import studio.thinkground.common.annotation.ValidationAnnotation;

public class TempDto {
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @ValidationAnnotation private String value;
}
