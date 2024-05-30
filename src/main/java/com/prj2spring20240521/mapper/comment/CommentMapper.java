package com.prj2spring20240521.mapper.comment;

import com.prj2spring20240521.domain.comment.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {


    @Insert("""
            INSERT INTO comment
            (board_id, member_id, comment)
            VALUES (#{boardId}, #{memberId}, #{comment})
            """)
    int insert(Comment comment);

    @Select("""
            SELECT c.id,
                   c.comment,
                   c.inserted,
                   m.nick_name
            FROM comment c JOIN member m ON c.member_id = m.id
            WHERE board_id = #{boardId}
            ORDER BY id 
            """)
    List<Comment> selectAllByBoardId(Integer boardId);


    @Delete("""
            DELETE FROM comment 
            WHERE id = #{id}
            """)
    int deleteById(Integer id);
}
