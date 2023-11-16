package com.kopo.wise.domain.reply;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReplyMapper {

    
    

    
    List<ReplyResponse> findAll(Long postId);


}
