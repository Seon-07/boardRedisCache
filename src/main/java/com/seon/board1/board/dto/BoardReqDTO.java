package com.seon.board1.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 게시글 등록할 때 요청하는 객체
 * @author SEON
 * @version 1.0
 * @Class BoardReqDTO
 * @since 25. 2. 5.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BoardReqDTO {
    /** 게시글 제목 */
    private String title;

    /** 게시글 내용 */
    private String content;

    /** 게시글 작성자 */
    private String author;
}
