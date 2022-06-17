package site.metacoding.entitytest.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardDetailRespDto { // Entity를 리턴하지 않고 통신을 위해서 Dto를 만든다.
    // private BoardDto board;
    private Integer id;
    private String title;
    private String content;
    private boolean isLove;

    // class BoardDto {
    // private Integer id;
    // private String title;
    // private String content;
    // }
}
