package com.seon.board1.board.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 게시글 조회할때 반환하는 객체
 * @author SEON
 * @version 1.0
 * @Class BoardResDTO
 * @since 25. 2. 5.
 */
@Getter
@Setter
public class BoardResDTO implements Serializable {
    /** 게시글 기본키 */
    private String id;

    /** 게시글 제목 */
    private String title;

    /** 게시글 내용 */
    private String content;

    /** 게시글 작성자 */
    private String author;
}
