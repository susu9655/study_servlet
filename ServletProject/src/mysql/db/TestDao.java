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
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return list;
	}
}
