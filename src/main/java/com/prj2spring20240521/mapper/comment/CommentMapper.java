package com.prj2spring20240521.mapper.comment;

import com.prj2spring20240521.domain.comment.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {


    @Insert("""
            INSERT INTO comment
            (board_id, member_id, comment)
            VALUES (#{boardId}, #{memberId}, #{comment})
            """)
    int insert(Comment comment);
}
