package mysql.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class TestDao {
	MysqlConnect db=new MysqlConnect();
	
	public List<TestDto> getList(){
		List<TestDto>list=new Vector<TestDto>();
		
		Connection conn=db.getConnction();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from test01 order by num";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				TestDto dto=new TestDto();
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setHeight(rs.getDouble("height"));
				dto.setBirth(rs.getString("birth"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return list;
	}
	
	public void insertTest(TestDto dto) {
		Connection conn=db.getConnction();
		PreparedStatement pstmt=null;
		String sql="insert into test01 (name,age,height,birth,writeday) values (?,?,?,?,now())";
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAge());
			pstmt.setDouble(3, dto.getHeight());
			pstmt.setString(4, dto.getBirth());
			
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
}
