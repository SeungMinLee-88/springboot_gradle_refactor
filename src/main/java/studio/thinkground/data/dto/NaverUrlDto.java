package studio.thinkground.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class NaverUrlDto {
  private String message;

  private String code;

  private Result result;

  @Getter
  @Setter
  public static class Result {
    private String hash;
    private String url;
    private String orgUrl;
  }
}
