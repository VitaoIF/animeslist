package com.animeslist.animeslist.mapper;

import com.animeslist.animeslist.dto.request.StreamingRequest;
import com.animeslist.animeslist.dto.response.StreamingResponse;
import com.animeslist.animeslist.entity.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest request){
        return Streaming.builder().name(request.name()).build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming){
        return StreamingResponse.builder().id(streaming.getId()).name(streaming.getName()).build();
    }
}
