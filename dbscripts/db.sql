CREATE TABLE `comment` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `topic_id` bigint(20) NOT NULL COMMENT '话题ID',
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `content` text NOT NULL COMMENT '内容',
  `reply_count` int(11) NOT NULL COMMENT '回复数量',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除 ，1-是，0-否',
  PRIMARY KEY (`id`),
  KEY `idx_topic_id` (`topic_id`),
  KEY `idx_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='回复表';

CREATE TABLE `feed` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `topic_id` bigint(20) NOT NULL COMMENT '话题ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除，1-是，0-否',
  PRIMARY KEY (`id`),
  KEY `idx_uid_topic` (`user_id`,`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息流表';

CREATE TABLE `reply` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `topic_id` bigint(20) NOT NULL COMMENT '主题ID',
  `comment_id` bigint(20) NOT NULL COMMENT '回复ID',
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `content` text NOT NULL COMMENT '内容',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除，1是，0-否',
  PRIMARY KEY (`id`),
  KEY `idx_topic_comment` (`topic_id`,`comment_id`),
  KEY `idx_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='针对回复的评论表';

CREATE TABLE `topic` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `title` varchar(64) NOT NULL DEFAULT '' COMMENT '标题',
  `content` text NOT NULL COMMENT '内容',
  `comment_count` int(11) NOT NULL COMMENT '评论数量',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(4) NOT NULL COMMENT '是否删除，1-是，0-否',
  PRIMARY KEY (`id`),
  KEY `idx_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='话题表';

CREATE TABLE `user` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `login_id` varchar(32) NOT NULL DEFAULT '' COMMENT '登录名',
  `name` varchar(32) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(128) NOT NULL DEFAULT '' COMMENT '密码',
  `logo_url` varchar(512) NOT NULL DEFAULT '' COMMENT '用户头像',
  `email` varchar(64) NOT NULL DEFAULT '' COMMENT '邮箱',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_deleted` tinyint(4) NOT NULL COMMENT '是否删除 ，1-是，0-否',
  PRIMARY KEY (`id`),
  KEY `idx_loginid` (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

CREATE TABLE `user_ext` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `latest_topic_id` bigint(20) NOT NULL COMMENT '最近拉到的话题ID',
  `follow_count` int(11) NOT NULL DEFAULT '0' COMMENT '关注的用户数',
  `fans_count` int(11) NOT NULL DEFAULT '0' COMMENT '粉丝用户数',
  `comment_count` int(11) NOT NULL DEFAULT '0' COMMENT '回复数',
  `reply_count` int(11) NOT NULL DEFAULT '0' COMMENT '回复数',
  `topic_count` int(11) NOT NULL DEFAULT '0' COMMENT '已发的话题数',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间 ',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除 ，1-是，0-否',
  PRIMARY KEY (`id`),
  KEY `idx_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户扩展信息表';

CREATE TABLE `user_follow` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `target_user_id` bigint(20) NOT NULL COMMENT '关注的用户ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间 ',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除，1-是，0-否',
  PRIMARY KEY (`id`),
  KEY `idx_user_follow` (`user_id`,`target_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户关注表';
