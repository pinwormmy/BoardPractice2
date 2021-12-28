package com.board.practice2.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.practice2.DTO.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSession sqlSession;
	String namespace = "boardPractice2.mappers.boardMapper";
	
	@Override
	public List<BoardDTO> boardList() throws Exception{
		
		return sqlSession.selectList(namespace + ".boardList");
	}

	@Override
	public void submitPost(BoardDTO boardDTO) {
		
		sqlSession.insert(namespace + ".submitPost", boardDTO);		
	}

	@Override
	public BoardDTO readPost(int postNum) {
		
		return sqlSession.selectOne(namespace + ".readPost", postNum);
	}

	@Override
	public void plusViewCount(int postNum) {
		sqlSession.update(namespace + ".plusViewCount", postNum);		
	}

	@Override
	public void deletePost(int postNum) {
		sqlSession.delete(namespace + ".deletePost", postNum);	
	}

	@Override
	public void submitModifyPost(BoardDTO boardDTO) {
		sqlSession.update(namespace + ".submitModifyPost", boardDTO);
	}

	@Override
	public List<BoardDTO> readComment(int postNum) {
		return sqlSession.selectList(namespace + ".readComment", postNum);
	}

	@Override
	public void submitComment(BoardDTO boardDTO) {
		sqlSession.insert(namespace + ".submitComment", boardDTO);
	}

	@Override
	public void deleteComment(int commentNum) {
		sqlSession.delete(namespace + ".deleteComment", commentNum);	
	}

	@Override
	public void updateCommentCount(int postNum) {
		sqlSession.update(namespace + ".updateCommentCount", postNum);
	}

	@Override
	public List<BoardDTO> searchList(String searchOption, String searchKeyword) {
		
		HashMap<String, String> searchInfo = new HashMap<String, String>();
		searchInfo.put("searchOption", searchOption);
		searchInfo.put("searchKeyword", searchKeyword);
		
		return sqlSession.selectList(namespace + ".searchList", searchInfo);
	}

	@Override
	public void signUp(BoardDTO boardDTO) throws Exception {
		sqlSession.insert(namespace + ".signUp", boardDTO);		
	}

	@Override
	public BoardDTO login(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(namespace + ".login", boardDTO);
	}

}
