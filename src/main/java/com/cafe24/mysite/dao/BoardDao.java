package com.cafe24.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.mysite.vo.BoardVo;



public class BoardDao {
	public List<BoardVo> getList() {
		List<BoardVo> result = new ArrayList<BoardVo>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "select a.no, a.subject, a.hit, date_format(a.write_date, \'%Y-%m-%d\'), b.name" + 
					" from board a, user b"
					+ " where a.user_no=b.no" + 
					" order by no desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVo vo = new BoardVo();
				vo.setNo(rs.getLong(1));
				vo.setSubject(rs.getString(2));
				vo.setHit(rs.getLong(3));
				vo.setWriteDate(rs.getString(4));
				vo.setUserName(rs.getString(5));
				
				result.add(vo);
			}
			
			
		} catch(SQLException e) {
			System.out.println("error" + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	public boolean insert(BoardVo vo) {
		boolean result = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql = "insert into board values(null, ?, ?, ?, now(), ?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getContents());
			pstmt.setLong(3, vo.getHit());
			pstmt.setLong(4, vo.getUserNo());
			
			int count = pstmt.executeUpdate();
			
			if(count == 1) result = true;
			
		} catch(SQLException e) {
			System.out.println("error" + e);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public boolean delete(BoardVo vo) {
		boolean result = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql = "delete from board where no=? and user_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, vo.getNo());
			pstmt.setLong(2, vo.getUserNo());
			
			int count = pstmt.executeUpdate();
			
			if(count == 1) result = true;
			
		} catch(SQLException e) {
			System.out.println("error" + e);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	//커넥션 받는 함수
	private Connection getConnection() throws SQLException {
		Connection con = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url = "jdbc:mariadb://192.168.0.10:3307/webdb";
			con = DriverManager.getConnection(url, "webdb", "webdb");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		}
		
		
		return con;
	}
}
