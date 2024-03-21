package com.board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board.domain.BoardVo;
import com.board.mapper.BoardMapper;

@SpringBootTest
class Board2ApplicationTests {
	
	//DataSource ds = new DataSource(); sprinjg 자동 실행
	// @Autowired :  Spring 이 자동으로 생성한 ds를 연결 해준다 
	@Autowired
	private DataSource ds;
	@Autowired
	private BoardMapper boardmapper;
	
	// junit  단위(unit) 테스트  - 함수 한개만 테스트한다
	@Test
	void contextLoads() {
	}
	
	
	@Test
	public void test1() {
		double n1 = 10;
		double n2 = 3;
		double n = n1/n2;
		System.out.println(n);
		//assertEquals(n, 3.5);
		assertEquals(n, 3.5,0.5);
	}
	
	// db 연결 확인
	@Test
	public void testConnection() throws SQLException {
		System.out.println(ds);  // HikariDataSource (null)
		Connection conn = ds.getConnection();
		System.out.println(conn);// HikariProxyConnection@1383942363 wrapping oracle.jdbc.driver.T4CConnection@45c90a05
		System.out.println(ds); //  HikariDataSource (HikariPool-1)
		conn.close();
	}
	
	// db 저장 확인 - sql 문 테스트 : Insert
	@Test 
	public void testInsert() {
		BoardVo vo = new BoardVo();
		vo.setTitle("Stringboot 글쓰기");
		vo.setContent("글 내용입니다");
		vo.setWriter("관리자");
		boardmapper.boardInsert(vo);
		
		
	}
	
}
