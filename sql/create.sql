-- 创建NoteCMS管理员
CREATE USER 'NoteCMS_Admin'@'localhost' IDENTIFIED BY 'Admin_NoteCMS';

-- 建库
CREATE database NoteCMS;
use NoteCMS;

-- 授权给管理员
GRANT ALL PRIVILEGES on NoteCMS.* to NoteCMS_Admin@localhost identified by 'Admin_NoteCMS';


CREATE TABLE cms_users(
    user_id VARCHAR(64) PRIMARY KEY NOT NULL,
    user_password VARCHAR(32) NOT NULL, -- 记得加密，等等又忘了
    user_nickname VARCHAR(32),
    user_bio VARCHAR(256),
    user_authority int NOT NULL
    -- 0:游客
    -- 1:普通用户
    -- 2:管理员
    -- 3:超级管理员
);

CREATE TABLE cms_notes(
    note_id int PRIMARY KEY AUTO_INCREMENT,
    note_heading VARCHAR(256) NOT NULL,
    note_publish_time DATETIME NOT NULL,
    note_latest_update DATETIME NOT NULL,
    note_owner VARCHAR(64) NOT NULL, -- 作者id
    note_restrict int NOT NULL,
    -- 0:只有最高管理员可见,
    -- 1:管理员可见,
    -- 2:登录可见,
    -- 3:所有人可见
    note_status int NOT NULL
    -- 0:正常状态遵照restrict
    -- 1:在作者的草稿箱
    -- 2:在作者的回收站中
    -- 3:被作者删除
    -- CONSTRAINT fk_owner FOREIGN KEY (note_owner) REFERENCES cms_users(user_id)
)AUTO_INCREMENT=1;

-- 测试数据
INSERT INTO cms_users values('super_admin','123456','zbc','随便',3);

INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题1',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题2',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('管理员可见',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',1,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题3',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题4',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('被删除',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,3);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题5',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('最高管理员可见',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',0,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题6',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题7',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题8',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('登录可见',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',2,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题9',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题10',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题11',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题12',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('不存在',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'Bob',3,0);
