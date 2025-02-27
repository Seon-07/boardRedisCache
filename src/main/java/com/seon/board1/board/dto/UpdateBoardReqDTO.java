package com.seon.board1.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 게시글 수정할 때 사용하는 객체
 * @author SEON
 * @version 1.0
 * @Class UpdateBoardReqDTO
 * @since 25. 2. 5.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateBoardReqDTO {
    /** 게시글 기본키 */
    private String id;

    /** 게시글 제목 */
    private String title;

    /** 게시글 내용 */
    private String content;

    /** 게시글 작성자 */
    private String author;
}
