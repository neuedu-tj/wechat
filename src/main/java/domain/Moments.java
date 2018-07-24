package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class Moments {

    private Integer mid;
    private String nickname;
    private String content;
    private String img;
}
