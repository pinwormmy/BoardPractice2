package com.board.practice2.DAO;

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

}
