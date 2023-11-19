package com.kopo.wise.domain.post;

import org.apache.ibatis.annotations.Mapper;

import com.kopo.wise.common.dto.SearchDto;

import java.util.List;

@Mapper
public interface PostMapper {

    
    void save(PostRequest params);

   
    PostResponse findById(Long id);

     
    void update(PostRequest params);

     
    void deleteById(Long id);

    
    List<PostResponse> findAll(SearchDto params);

    int postCount(SearchDto params);
    

}
