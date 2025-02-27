package com.seon.board1.board.controller;

import com.seon.board1.board.dto.BoardReqDTO;
import com.seon.board1.board.dto.BoardResDTO;
import com.seon.board1.board.dto.DeleteBoardReqDTO;
import com.seon.board1.board.dto.UpdateBoardReqDTO;
import com.seon.board1.board.service.BoardService;
import com.seon.board1.common.response.ContentResult;
import com.seon.board1.common.response.OperationResponse;
import com.seon.board1.common.response.OperationResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 게시글 컨트롤러
 * @author SEON
 * @version 1.0
 * @Class BoardRestController
 * @since 25. 2. 5.
 */
@RestController
@RequestMapping("/board")
public class BoardRestController {

    /**
     * 서비스 주입
     */
    private final BoardService boardService;
    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }

    /**
     * 게시글 리스트 조회 컨트롤러
     * @return ResponseEntity<ContentResult<List<BoardResDTO>>>
     * @author SEON
     * @since 25. 2. 5.
     */
    @GetMapping("/list")
    public ResponseEntity<ContentResult<List<BoardResDTO>>> getBoardList() {
        ContentResult<List<BoardResDTO>> response = OperationResponse.contentResult(boardService.getBoardList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * 게시글 조회 컨트롤러
     * @param id 게시글의 기본키
     * @return ResponseEntity<ContentResult<BoardResDTO>>
     * @author SEON
     * @since 25. 2. 5.
     */
    @GetMapping
    public ResponseEntity<ContentResult<BoardResDTO>> getBoard(@RequestParam String id) {
        ContentResult<BoardResDTO> response = OperationResponse.contentResult(boardService.getBoard(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * 게시글 등록 컨트롤러
     * @param  board 입력할 게시글 객체
     * @return ResponseEntity<OperationResult>
     * @author SEON
     * @since 25. 2. 5.
     */
    @PostMapping
    public ResponseEntity<OperationResult> insertBoard(@RequestBody BoardReqDTO board) {
        OperationResult response = OperationResponse.operationResult(boardService.insertBoard(board));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * 게시글 삭제 컨트롤러
     * @param deleteBoardReqDTO 삭제할 게시글의 객체
     * @return ResponseEntity<OperationResult>
     * @author SEON
     * @since 25. 2. 6.
     */
    @PostMapping("/delete")
    public ResponseEntity<OperationResult> deleteBoard(@RequestBody DeleteBoardReqDTO deleteBoardReqDTO) {
        OperationResult response = OperationResponse.operationResult(boardService.deleteBoard(deleteBoardReqDTO));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    /**
     * 게시글 수정 컨트롤러
     * @param updateBoard 수정할 게시글 객체
     * @return ResponseEntity<OperationResult>
     * @author SEON
     * @since 25. 2. 5.
     */
    @PostMapping("/update")
    public ResponseEntity<OperationResult> updateBoard(@RequestBody UpdateBoardReqDTO updateBoard) {
        OperationResult response = OperationResponse.operationResult(boardService.updateBoard(updateBoard));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
