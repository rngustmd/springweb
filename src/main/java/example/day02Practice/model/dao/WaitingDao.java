package example.day02Practice.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import example.day02Practice.model.dto.WaitingDto;

public class WaitingDao extends BaseDao {

    private WaitingDao( ){ };
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance( ){ return instance; }

    // [1] 대기명단 등록 
    public boolean save( WaitingDto waitingDto ){
        try {
            String sql = "insert into waiting( phone, count ) values( ? , ? )";
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setString( 1 , waitingDto.getPhone() );
            ps.setInt( 2 , waitingDto.getCount() );
            int result = ps.executeUpdate();
            if( result == 1 ){ return true; } 
        } catch( Exception e ){ 
            System.out.println( e ); 
        }
        return false;
    }

    // [2] 대기명단 전체조회
    public ArrayList<WaitingDto> findAll( ){
        ArrayList<WaitingDto> list = new ArrayList<>();
        try{
        String sql = "select * from waiting";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            WaitingDto waitingDto = new WaitingDto();
            waitingDto.setNo(rs.getInt("no"));
            waitingDto.setPhone(rs.getString("phone"));
            waitingDto.setCount(rs.getInt("count"));
            list.add(waitingDto);
        }
        } catch( SQLException e ){ System.out.println( e );}
        return list;
    } // findAll end

    
        // [3] 개별수정 (번호 no 기준 인원수 count 수정)
        public boolean update( WaitingDto waitingDto ){
            try {
                String sql = "update waiting set count = ? where no = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, waitingDto.getCount());
                ps.setInt(2, waitingDto.getNo()); // no 기준으로 변경
                int result = ps.executeUpdate();
                if( result >= 1 ) return true;
            } catch( SQLException e ){ 
                System.out.println( e );
            }
            return false;
        } // update end

        // [4] 개별삭제
        public boolean delete( int no ){
            try {
                String sql = "delete from waiting where no = ?";
                PreparedStatement ps = conn.prepareStatement( sql );
                ps.setInt( 1 , no );
                int result = ps.executeUpdate();
                if( result >= 1 ){ return true; }
            } catch( SQLException e ){
                System.out.println(e);
            }
            return false;
    }
}

