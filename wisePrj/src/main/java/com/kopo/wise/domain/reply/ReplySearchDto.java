package com.kopo.wise.domain.reply;


import com.kopo.wise.common.dto.SearchDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplySearchDto extends SearchDto {

    private Long postId;  
    private Long fatherId;

}