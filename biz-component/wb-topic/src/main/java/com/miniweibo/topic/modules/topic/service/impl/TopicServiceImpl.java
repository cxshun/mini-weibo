package com.miniweibo.topic.modules.topic.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miniweibo.common.service.AbstractServiceImpl;
import com.miniweibo.topic.modules.topic.dao.TopicMapper;
import com.miniweibo.topic.modules.topic.entity.Topic;
import com.miniweibo.topic.modules.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nicolas.chan
 * 2020/9/6
 */
@Service
public class TopicServiceImpl extends AbstractServiceImpl<Topic, Long> implements TopicService {

    @Autowired
    private TopicMapper topicMapper;

    @Override
    protected BaseMapper<Topic> getMapper() {
        return topicMapper;
    }
}
