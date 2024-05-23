package com.prj2spring20240521.mapper.board;

import com.prj2spring20240521.domain.board.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Insert("""
            INSERT INTO board (title, content, member_id)
            VALUES (#{title}, #{content}, #{memberId})
            """)
    public int insert(Board board);

    @Select("""
            SELECT b.id, 
                   b.title,
                   m.nick_name writer
            FROM board b JOIN member m ON b.member_id = m.id
            ORDER BY b.id DESC
            """)
    List<Board> selectAll();

    @Select("""
            SELECT *
            FROM board
            WHERE id = #{id}
            """)
    Board selectById(Integer id);

    @Delete("""
            DELETE FROM board
            WHERE id = #{id}
            """)
    int deleteById(Integer id);

    @Update("""
            UPDATE board
            SET title=#{title},
                content=#{content},
                writer=#{writer}
            WHERE id=#{id}
            """)
    int update(Board board);
}
