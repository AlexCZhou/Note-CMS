-- 创建NoteCMS管理员
CREATE USER 'NoteCMS_Admin'@'localhost' IDENTIFIED BY 'Admin_NoteCMS';

-- 建库
CREATE database NoteCMS;
use NoteCMS;

-- 授权给管理员
GRANT ALL PRIVILEGES on NoteCMS.* to NoteCMS_Admin@localhost identified by 'Admin_NoteCMS';


CREATE TABLE cms_users(
    user_id VARCHAR(64) PRIMARY KEY NOT NULL,
    user_password VARCHAR(256) NOT NULL, -- 记得加密，等等又忘了
    user_cookie VARCHAR(256), -- cookie的加密方式是 SHA256（用户名+密码+创建cookie时间）
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
    -- 3:只有最高管理员可见,
    -- 2:管理员可见,
    -- 1:登录可见,
    -- 0:所有人可见
    note_status int NOT NULL
    -- 0:正常状态遵照restrict
    -- 1:在作者的草稿箱
    -- 2:在作者的回收站中
    -- 3:被作者删除
    -- CONSTRAINT fk_owner FOREIGN KEY (note_owner) REFERENCES cms_users(user_id)
)AUTO_INCREMENT=1;
-- 这个表用来存储网站的设置数据
CREATE TABLE cms_setting(
    sys_version VARCHAR(64) NOT NULL
);


-- 测试数据
-- 密码是1234566AA
INSERT INTO cms_users values('super_admin','bec21fb9d6fc82e72ef92c20defc727444df389d',null,'zbc','随便',3);

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

INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题13',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题14',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题15',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题16',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题17',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题18',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题19',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题20',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题21',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题22',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题23',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题24',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题25',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题26',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题27',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题28',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题29',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题30',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题31',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题32',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题33',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题34',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题35',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题36',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题37',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题38',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题39',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题40',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题41',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题42',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题43',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题44',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题45',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题46',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题47',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题48',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题49',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题50',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题51',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题52',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题53',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题54',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题55',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题56',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题57',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题58',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题59',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题60',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题61',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题62',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题63',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题64',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题65',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题66',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题67',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题68',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题69',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题71',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题72',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题73',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题74',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题75',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题76',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题77',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题78',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题79',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题80',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题81',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题82',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题83',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题84',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题85',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题86',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题87',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题88',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题89',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题90',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题91',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题92',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题93',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题94',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题95',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题96',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题97',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题98',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题99',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('标题100',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);

INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('测试用001',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);
INSERT INTO cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) values('Markdown 模板',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'super_admin',3,0);






