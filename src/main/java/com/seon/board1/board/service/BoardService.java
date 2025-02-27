package com.seon.board1.board.service;

import com.seon.board1.board.domain.Board;
import com.seon.board1.board.dto.BoardReqDTO;
import com.seon.board1.board.dto.BoardResDTO;
import com.seon.board1.board.dto.DeleteBoardReqDTO;
import com.seon.board1.board.dto.UpdateBoardReqDTO;
import com.seon.board1.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 게시글 서비스 클래스
 * @author SEON
 * @version 1.0
 * @Class BoardService
 * @since 25. 2. 5.
 */
@Service
public class BoardService {

    private final BoardRepository boardRepository;
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    /**
     * 게시글 등록 서비스
     * @param boardReqDTO 등록할 게시글 객체
     * @return boolean
     * @author SEON
     * @since 25. 2. 5.
     */
    @Transactional
    public boolean insertBoard(BoardReqDTO boardReqDTO) {
        Board board = new Board();
        board.setTitle(boardReqDTO.getTitle());
        board.setContent(boardReqDTO.getContent());
        board.setAuthor(boardReqDTO.getAuthor());
        boardRepository.save(board);
        return true;
    }

    /**
     * 게시글 소프트 삭제
     * @param deleteBoardReqDTO 삭제할 게시글 객체
     * @return boolean
     * @author SEON
     * @since 25. 2. 6.
     */
    @CacheEvict(value = "board", key = "#deleteBoardReqDTO.id")
    @Transactional
    public boolean deleteBoard(DeleteBoardReqDTO deleteBoardReqDTO) {
        String id = deleteBoardReqDTO.getId();
        return boardRepository.deleteBoardById(id) == 1;
    }

    /**
     * 게시글 수정 서비스
     * @param boardReqDTO 수정할 게시글 객체
     * @return boolean
     * @author SEON
     * @since 25. 2. 5.
     */
    @CachePut(value = "board", key = "#boardReqDTO.id")
    @Transactional
    public boolean updateBoard(UpdateBoardReqDTO boardReqDTO) {
        Board board = new Board();
        board.setId(boardReqDTO.getId());
        board.setTitle(boardReqDTO.getTitle());
        board.setContent(boardReqDTO.getContent());
        board.setAuthor(boardReqDTO.getAuthor());
        boardRepository.save(board);
        return true;
    }

    /**
     * 게시글 조회 서비스
     * @param id 조회할 게시글 기본키
     * @return BoardResDTO
     * @author SEON
     * @since 25. 2. 5.
     */
    @Cacheable(value = "board", key = "#id")
    public BoardResDTO getBoard(String id){
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("Board not found"));
        BoardResDTO boardResDTO = new BoardResDTO();
        boardResDTO.setId(board.getId());
        boardResDTO.setTitle(board.getTitle());
        boardResDTO.setContent(board.getContent());
        boardResDTO.setAuthor(board.getAuthor());
        return boardResDTO;
    }

    /**
     * 게시글 리스트 조회 서비스
     * @return List<BoardResDTO>
     * @author SEON
     * @since 25. 2. 5.
     */
    public List<BoardResDTO> getBoardList(){
        List<Board> boardList = boardRepository.findBoardList();
        List<BoardResDTO> boardResDTOList = new ArrayList<>();
        for(Board board : boardList){
            BoardResDTO boardResDTO = new BoardResDTO();
            boardResDTO.setId(board.getId());
            boardResDTO.setTitle(board.getTitle());
            boardResDTO.setContent(board.getContent());
            boardResDTO.setAuthor(board.getAuthor());
            boardResDTOList.add(boardResDTO);
        }
        return boardResDTOList;
    }
}
