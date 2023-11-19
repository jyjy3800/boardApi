package com.kopo.wise.domain.file;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {

   
    void saveAll(List<FileRequest> files);

  
    List<FileResponse> findAllByPostId(Long postId);

   
    List<FileResponse> findAllByIds(List<Long> ids);

  
    void deleteAllByIds(List<Long> ids);

    
    FileResponse findById(Long id);

}