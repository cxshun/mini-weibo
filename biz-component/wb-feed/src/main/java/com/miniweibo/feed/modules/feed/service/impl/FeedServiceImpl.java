package com.miniweibo.feed.modules.feed.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miniweibo.common.service.AbstractServiceImpl;
import com.miniweibo.feed.modules.feed.dao.FeedMapper;
import com.miniweibo.feed.modules.feed.entity.Feed;
import com.miniweibo.feed.modules.feed.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nicolas.chan
 * 2020/9/6
 */
@Service
public class FeedServiceImpl extends AbstractServiceImpl<Feed, Long> implements FeedService {
    @Autowired
    private FeedMapper feedMapper;

    @Override
    protected BaseMapper<Feed> getMapper() {
        return feedMapper;
    }
}
