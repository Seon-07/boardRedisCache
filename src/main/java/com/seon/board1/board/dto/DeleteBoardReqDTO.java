package com.seon.board1.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 게시글 삭제할 때 사용하는 객체
 * @author SEON
 * @version 1.0
 * @Class DeleteBoardReqDTO
 * @since 25. 2. 15.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DeleteBoardReqDTO {
    /** 게시글 기본키 */
    private String id;
}
