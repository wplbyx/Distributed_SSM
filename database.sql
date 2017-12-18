-- ==================================================
--
--              数据库表定义：
--
--  tb_admin           管理员表（相当于老板，管理员工）
--
--  tb_user            客户表（客户基本信息）
--  tb_user_address    客户收货地址表（可以有多个收货地址）
--  tb_user_coupon     优惠券表（系统发放优惠券，数量有限 由客户主动去抢得，可以抵消面额的消费）
--
--  tb_goods           商品表
--  tb_goods_img       商品图片表
--  tb_goods_type      商品分类表
--  tb_goods_provider  商品供货商表（同一种商品 可能有不同的生产商）
--
--  tb_car             购物车表（由用户浏览商品选择后 添加到的地方，这个时候商品的库存减少）
--  tb_car_item        购物车明细表
--
--  tb_order           订单表(销售/采购)（两种订单）
--  tb_order_item      订单明细表
--
--  tb_comment         综合评价表（信用评价，服务评价，物流评价）
--  tb_logistics       物流信息表（一站一站的物流节点的信息）
--
-- ==================================================

--  1. 创建管理员表： tb_admin
-- -----------------------------------------------------------------
DROP TABLE IF EXISTS tb_admin;
CREATE TABLE tb_admin (
    admin_id  INT(11) PRIMARY KEY AUTO_INCREMENT, -- 用户类型的主键
    adminName VARCHAR(24) NOT NULL, -- 管理员的名字
    adminNick VARCHAR(24) NOT NULL, -- 管理员的昵称
    adminPwd  VARCHAR(24) NOT NULL, -- 管理员的密码
    phone     VARCHAR(11) NOT NULL, -- 管理员的电话
    qq        VARCHAR(14) NOT NULL, -- 管理员的QQ
    email     VARCHAR(32) NOT NULL  -- 管理员的邮箱
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

--  2. 用户表： tb_user
-- -----------------------------------------------------------------
DROP TABLE IF EXISTS tb_user;
CREATE TABLE tb_user (
    user_id      INT(11) PRIMARY KEY  AUTO_INCREMENT, -- 用户表 (主键)
    userName     VARCHAR(24) NOT NULL,                -- 用户名字
    userPwd      VARCHAR(24) NOT NULL,                -- 用户密码
    sex          VARCHAR(4)  NOT NULL DEFAULT '男',
    birthday     DATETIME    NOT NULL,                -- 用户生日
    phone        VARCHAR(11) NOT NULL,                -- 用户电话，用来手机验证找回密码的
    qq           VARCHAR(14),                         -- 用户QQ
    email        VARCHAR(24) NOT NULL,                -- 用户邮箱
    points       INT(11)              DEFAULT 1  -- 获得积分，每一次通过购买商品获得不同的积分
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

--  3. 用户收货地址表： tb_user_address
-- -----------------------------------------------------------------
DROP TABLE IF EXISTS tb_user_address;
CREATE TABLE tb_user_address (
    address_id INT(11) PRIMARY KEY AUTO_INCREMENT, -- (主)
    user_id    INT(11)      NOT NULL, -- (外)
    address    VARCHAR(128) NOT NULL,
    status     BOOLEAN             DEFAULT FALSE, -- 默认不是第一收货地址

    -- 配置外键: user_id :
    CONSTRAINT tb_user_address_tb_user_fk
    FOREIGN KEY (user_id)
    REFERENCES tb_user (user_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE

) ENGINE = InnoDB DEFAULT CHARSET = utf8;

--  4. 优惠券表： tb_user_coupon
-- -----------------------------------------------------------------
DROP TABLE IF EXISTS tb_user_coupon;
CREATE TABLE tb_user_coupon (
    coupon_id   INT(11) PRIMARY KEY AUTO_INCREMENT, -- (主)
    user_id     INT(11)     NULL, -- (外)  该优惠券的持有者，外键允许为空
    couponName  VARCHAR(32) NOT NULL, -- 优惠券 名字
    couponValue FLOAT(6, 2) NOT NULL, -- 面值
    createTime  DATETIME            DEFAULT now(), -- 创建时间
    startTime   DATETIME    NOT NULL, -- 可用时间
    endTime     DATETIME    NOT NULL, -- 失效时间
    status      TINYINT(4), -- 优惠券的状态：0:不能抢(默认)，1:可以抢，不能使用，2:已经被抢，可以使用， 3:已经使用，不能再使用
    print       INT(11),    -- 价值多少积分

    -- 配置外键: user_id :
    CONSTRAINT tb_user_coupon_tb_user_fk
    FOREIGN KEY (user_id)
    REFERENCES tb_user (user_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE

) ENGINE = InnoDB DEFAULT CHARSET = utf8;

--  5. 商品类别表    tb_goods_type   这是一个递归表
-- -----------------------------------------------------------------
DROP TABLE IF EXISTS tb_goods_type;
CREATE TABLE tb_goods_type (
    goods_type_id   INT(11) PRIMARY KEY AUTO_INCREMENT, -- 商品类别的主键
    father_type_id  int(11) not null DEFAULT 0,         -- 父分类的 id； 0:表示一级类目
    typeName        VARCHAR(128) NOT NULL, -- 商品描述 关键字
    sortOrder       INT(11)             DEFAULT 1       -- 排序标准

#     -- 配置外键: father_type_id :
#     CONSTRAINT tb_goods_type_tb_goods_type_fk
#     FOREIGN KEY (father_type_id)
#     REFERENCES tb_goods_type(goods_type_id)

) ENGINE = InnoDB DEFAULT CHARSET = utf8;

--  6. 创建 商品表：
-- -----------------------------------------------------------------
DROP TABLE IF EXISTS tb_goods;
CREATE TABLE tb_goods (
    goods_id      INT(11) PRIMARY KEY AUTO_INCREMENT, -- 商品表 主键
    goods_type_id INT(11)      NOT NULL, -- (外) 商品的分类

    goodsName     VARCHAR(200) NOT NULL, -- 商品名称 (标题)
    goodsDesc     VARCHAR(500) NOT NULL, -- 商品描述 (卖点)
    goodsPrice    FLOAT(8, 2)  NOT NULL, -- 原价
    goodsNumber   INT(11)             DEFAULT 100,   -- 商品库存
    provider      VARCHAR(200) not null, -- 商品供货商
    onTime        DATETIME            DEFAULT now(), -- 上架时间
    offTime       DATETIME            DEFAULT NULL,  -- 下架时间
    status        TINYINT(4)          DEFAULT 0, -- 商品状态：0=在售，1=下架，2=删除
    givePoints    INT(11)             DEFAULT 5, -- 这件商品值多少积分

    -- 配置外键: goods_type_id :
    CONSTRAINT tb_goods_tb_goods_type_fk
    FOREIGN KEY (goods_type_id)
    REFERENCES tb_goods_type (goods_type_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE

) ENGINE = InnoDB DEFAULT CHARSET = utf8;

--  7. 创建 商品图片表：
-- -----------------------------------------------------------------
DROP TABLE IF EXISTS tb_goods_img;
CREATE TABLE tb_goods_img (
    goods_img_id INT(11) PRIMARY KEY   AUTO_INCREMENT,
    goods_id     INT(11)      NOT NULL, -- (外)  相关联的商品的 ID
    imgPath      VARCHAR(255) NOT NULL, -- 图片路径
    uploadTime   DATETIME     NOT NULL DEFAULT now(),
    uploader     VARCHAR(128)          DEFAULT '未知上传者',

    -- 配置外键: goods_id
    CONSTRAINT tb_goods_img_tb_goods_fk
    FOREIGN KEY (goods_id)
    REFERENCES tb_goods (goods_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE

) ENGINE = InnoDB DEFAULT CHARSET = utf8;

--  8. 创建 商品描述表：(大文本 更加细节性的描述)
-- -----------------------------------------------------------------
DROP TABLE IF EXISTS tb_goods_desc;
CREATE TABLE tb_goods_desc (
    goods_desc_id INT(11) PRIMARY KEY   AUTO_INCREMENT,
    goods_id     INT(11)      NOT NULL, -- (外)  相关联的商品的 ID
    goodsDesc    TEXT , -- 图片路径
    uploadTime   DATETIME     NOT NULL DEFAULT now(),

    -- 配置外键: goods_id
    CONSTRAINT tb_goods_desc_tb_goods_fk
    FOREIGN KEY (goods_id)
    REFERENCES tb_goods (goods_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE

) ENGINE = InnoDB DEFAULT CHARSET = utf8;


--  9. 创建 购物车表：
-- -----------------------------------------------------------------
DROP TABLE IF EXISTS tb_car;
CREATE TABLE tb_car (
    car_id  INT(11) PRIMARY KEY AUTO_INCREMENT, -- (主)
    user_id INT(11) NULL, -- (外)  订单持有者

    -- 配置外键: user_id
    CONSTRAINT tb_car_tb_user_fk
    FOREIGN KEY (user_id)
    REFERENCES tb_user (user_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE

) ENGINE = InnoDB DEFAULT CHARSET = utf8;

--  10. 购物车明细表：
-- -----------------------------------------------------------------
DROP TABLE IF EXISTS tb_car_item;
CREATE TABLE tb_car_item (
    car_item_id INT(11) PRIMARY KEY AUTO_INCREMENT, -- (主)
    car_id      INT(11) NOT NULL, -- (外)
    goods_id    INT(11) NOT NULL, -- (外)
    goodsNumber INT(6)              DEFAULT 1, -- 货物的数量
    addTime     DATETIME            DEFAULT now(), -- 添加时间

    -- 配置外键: car_id :
    CONSTRAINT tb_car_item_tb_car_fk
    FOREIGN KEY (car_id)
    REFERENCES tb_car (car_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    -- 配置外键: goods_id :
    CONSTRAINT tb_car_item_tb_goods_fk
    FOREIGN KEY (goods_id)
    REFERENCES tb_goods (goods_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE

) ENGINE = InnoDB DEFAULT CHARSET = utf8;

--  11. 订单表(表头)：
-- -----------------------------------------------------------------
DROP TABLE IF EXISTS tb_order;
CREATE TABLE tb_order (
    order_id    INT(11) PRIMARY KEY AUTO_INCREMENT, -- (主)
    admin_id    INT(11)    NULL, -- (外)  审核人ID
    ownerId     INT(11)    NULL, -- 订单拥有者 ID, 拥有者类型通过订单类型来判断：采购是员工拥有，其他是用户拥有
    orderType   TINYINT(4) NULL, -- 订单类型：0=采购， 1=销售， 2=退货
    orderValue  FLOAT(8, 2)         DEFAULT 0.00, -- 订单原价(总价)
    useCoupon   FLOAT(6, 2)         DEFAULT 0.00, -- 使用优惠券抵消金额(只针对于客户来讲)
    creatTiem   DATETIME            DEFAULT now(), -- 创建时间（定货日期）
    deliverTime DATETIME   NULL, -- 发货时间
    finishTime  DATETIME   NULL, -- 成功完成时间 这个需要客户来确认的 客户点击确认收货

    -- 配置外键: admin_id :
    CONSTRAINT tb_order_tb_admin_fk
    FOREIGN KEY (admin_id)
    REFERENCES tb_admin (admin_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE

) ENGINE = InnoDB DEFAULT CHARSET = utf8;

--  12. 订单明细表（有状态）： tb_order_item
-- -----------------------------------------------------------------
DROP TABLE IF EXISTS tb_order_item;
CREATE TABLE tb_order_item (
    order_goods_id INT(11) PRIMARY KEY AUTO_INCREMENT, -- (主)
    order_id       INT(11) NOT NULL, -- (外) 订单的编号
    goods_id       INT(11) NOT NULL, -- (外) 订单里的商品的编号
    numbers        INT(11)             DEFAULT 1, -- 商品的数量
    status         TINYINT(4)          DEFAULT 0, -- 状态：0=已下单， 1=在路上， 2=已购买， 3=在退货， 4=已退货

    -- 配置外键: order_id
    CONSTRAINT tb_order_item_tb_order_fk
    FOREIGN KEY (order_id)
    REFERENCES tb_order (order_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    -- 配置外键: goods_id
    CONSTRAINT tb_order_item_tb_goods_fk
    FOREIGN KEY (goods_id)
    REFERENCES tb_goods (goods_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE

) ENGINE = InnoDB DEFAULT CHARSET = utf8;

--  13. 评论表： tb_comment
-- -----------------------------------------------------------------
DROP TABLE IF EXISTS tb_comment;
CREATE TABLE tb_comment (
    comment_id INT(11) PRIMARY KEY AUTO_INCREMENT, -- (主) 评论表
    user_id    INT(11)  NOT NULL, -- (外) 评论的用户
    goods_id   INT(11)  NOT NULL, -- (外) 被评论的商品
    content    VARCHAR(255)        DEFAULT '暂未评论',
    times      DATETIME NULL, -- 评论时间

    -- 配置外键: user_id :
    CONSTRAINT tb_comment_tb_user_fk
    FOREIGN KEY (user_id)
    REFERENCES tb_user (user_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    -- 配置外键: goods_id :
    CONSTRAINT tb_comment_tb_goods_fk
    FOREIGN KEY (goods_id)
    REFERENCES tb_goods (goods_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE

) ENGINE = InnoDB DEFAULT CHARSET = utf8;




--  tb_admin           管理员表（相当于老板，管理员工）
INSERT INTO tb_admin (adminName, adminNick, adminPwd, phone, qq, email) VALUES
    ('admin', '路伴友行', '111111', 01234567890, 123456, '123456@qq.com');


--  tb_user            客户表（客户基本信息）
INSERT INTO tb_user (userName, userPwd, sex, birthday, phone, qq, email, points) VALUES
    ('赵先生', '111111', '男', now(), '13912345678', '123456789', '123456789@qq.com', 0),
    ('钱先生', '111111', '男', now(), '13912345678', '123456789', '123456789@qq.com', 0),
    ('孙先生', '111111', '男', now(), '13912345678', '123456789', '123456789@qq.com', 0),
    ('李先生', '111111', '男', now(), '13912345678', '123456789', '123456789@qq.com', 0),
    ('周女士', '111111', '女', now(), '13912345678', '123456789', '123456789@qq.com', 0),
    ('武女士', '111111', '女', now(), '13912345678', '123456789', '123456789@qq.com', 0),
    ('郑女士', '111111', '女', now(), '13912345678', '123456789', '123456789@qq.com', 0),
    ('王女士', '111111', '女', now(), '13912345678', '123456789', '123456789@qq.com', 0),
    ('冯先生', '111111', '男', now(), '13912345678', '123456789', '123456789@qq.com', 0),
    ('陈先生', '111111', '男', now(), '13912345678', '123456789', '123456789@qq.com', 0),
    ('褚先生', '111111', '男', now(), '13912345678', '123456789', '123456789@qq.com', 0),
    ('卫先生', '111111', '男', now(), '13912345678', '123456789', '123456789@qq.com', 0),
    ('冯女士', '111111', '女', now(), '13912345678', '123456789', '123456789@qq.com', 0),
    ('陈女士', '111111', '女', now(), '13912345678', '123456789', '123456789@qq.com', 0),
    ('褚女士', '111111', '女', now(), '13912345678', '123456789', '123456789@qq.com', 0),
    ('卫女士', '111111', '女', now(), '13912345678', '123456789', '123456789@qq.com', 0);


--  tb_goods_type      商品分类表  (一级类目)
INSERT INTO tb_goods_type (goods_type_id, father_type_id, typeName, sortOrder) VALUES
    (1, 0, '家用电器', 4),
    (2, 0, '手机 数码', 6),
    (3, 0, '电脑 办公', 5),
    (4, 0, '家具 家居 厨卫', 4),
    (5, 0, '男装 女装 童装 内衣', 7),
    (6, 0, '女鞋 箱包 珠宝', 5),
    (7, 0, '男鞋 运动 户外', 6),
    (8, 0, '汽车 汽车用品', 2),
    (9, 0, '母婴 玩具 乐器', 2),
    (10, 0, '食品 酒类 生鲜 特产', 1),
    (11, 0, '美妆 化妆 宠物', 3),
    (12, 0, '礼品鲜花 农资绿植', 2),
    (13, 0, '医药保健 计生情趣', 1),
    (14, 0, '图书 影像 电子书', 3),
    (15, 0, '机票 酒店 旅游 生化', 1),
    (16, 0, '理财 众筹 白条 保险', 1);

--  tb_goods_type      商品分类表  (二级类目)
INSERT INTO tb_goods_type (goods_type_id, father_type_id, typeName, sortOrder) VALUES
    (17, 1, '电视', 1),
    (18, 1, '冰箱', 1),
    (19, 1, '空调', 1),
    (20, 1, '洗衣机', 1),
    (21, 1, '饮水机', 1),
    (22, 1, '生活电器', 1),
    (23, 1, '进口电器', 1),-- -------------------------

    (24, 2, '手机', 1),
    (25, 2, '手机配件', 1),
    (26, 2, '摄影摄像', 1),
    (27, 2, '数码配件', 1),
    (28, 2, '影音娱乐', 1),
    (29, 2, '智能设备', 1),
    (30, 2, '电子教育', 1),-- -------------------------

    (31, 3, '电脑整机', 1),
    (32, 3, '电脑配件', 1),
    (33, 3, '外设产品', 1),
    (34, 3, '游戏设备', 1),
    (35, 3, '网络产品', 1),
    (36, 3, '办公设备', 1),
    (37, 3, '文具耗材', 1),
    (38, 3, '服务产品', 1),-- -------------------------

    (39, 4, '厨具', 1),
    (40, 4, '家纺', 1),
    (41, 4, '生活日用', 1),
    (42, 4, '家装软饰', 1),
    (43, 4, '灯具', 1),
    (44, 4, '家具', 1),
    (45, 4, '家装主材', 1),
    (46, 4, '厨房卫浴', 1),
    (47, 4, '五金电工', 1),
    (48, 4, '装修定制', 1),-- -------------------------

    (49, 5, '女装', 1),
    (50, 5, '男装', 1),
    (51, 5, '内衣', 1),
    (52, 5, '配饰', 1),
    (53, 5, '童装', 1),
    (54, 5, '童鞋', 1),-- -------------------------

    (55, 6, '时尚女鞋', 1),
    (56, 6, '潮流女包', 1),
    (57, 6, '精品男包', 1),
    (58, 6, '功能箱包', 1),
    (59, 6, '奢侈品', 1),
    (60, 6, '精选大牌', 1),
    (61, 6, '珠宝首饰', 1),
    (62, 6, '金银投资', 1),-- -------------------------

    (63, 7, '流行男鞋', 1),
    (64, 7, '运动鞋包', 1),
    (65, 7, '运动服饰', 1),
    (66, 7, '健身训练', 1),
    (67, 7, '骑行运动', 1),
    (68, 7, '体育用品', 1),
    (69, 7, '户外鞋服', 1),
    (70, 7, '户外装备', 1),
    (71, 7, '垂钓用品', 1),
    (72, 7, '游泳用品', 1),-- -------------------------

    (73, 8, '汽车车型', 1),
    (74, 8, '汽车价格', 1),
    (75, 8, '汽车品牌', 1),
    (76, 8, '维修保养', 1),
    (77, 8, '汽车装饰', 1),
    (78, 8, '车载电器', 1),
    (79, 8, '载电器配件', 1),
    (80, 8, '美容清洗', 1),
    (81, 8, '安全自驾', 1),
    (82, 8, '汽车服务', 1),-- -------------------------

    (83, 9, '奶粉', 1),
    (84, 9, '营养辅食', 1),
    (85, 9, '尿裤湿巾', 1),
    (86, 9, '喂养用品', 1),
    (87, 9, '洗护用品', 1),
    (88, 9, '寝居服饰', 1),
    (89, 9, '妈妈专区', 1),
    (90, 9, '童车童床', 1),
    (91, 9, '玩具', 1),
    (92, 9, '乐器', 1),-- -------------------------

    (93, 10, '新鲜水果', 1),
    (94, 10, '蔬菜蛋品', 1),
    (95, 10, '精选肉类', 1),
    (96, 10, '冷饮冻食', 1),
    (97, 10, '中外名酒', 1),
    (98, 10, '进口食品', 1),
    (99, 10, '休闲食品', 1),
    (100, 10, '地方特产', 1),
    (101, 10, '茗茶', 1),
    (102, 10, '饮料冲调', 1),
    (103, 10, '粮油调味', 1),-- -------------------------

    (104, 11, '面部护肤', 1),
    (105, 11, '洗发护发', 1),
    (106, 11, '身体护理', 1),
    (107, 11, '口腔护理', 1),
    (108, 11, '女性护理', 1),
    (109, 11, '香水彩妆', 1),
    (110, 11, '清洁用品', 1),
    (111, 11, '宠物生活', 1),-- -------------------------

    (112, 12, '礼品', 1),
    (113, 12, '鲜花速递', 1),
    (114, 12, '绿植园艺', 1),
    (115, 12, '种子', 1),
    (116, 12, '农药', 1),
    (117, 12, '肥料', 1),
    (118, 12, '畜牧养殖', 1),
    (119, 12, '农机农具', 1),-- -------------------------

    (120, 13, '中西药品', 1),
    (121, 13, '营养健康', 1),
    (122, 13, '营养成分', 1),
    (123, 13, '滋补养生', 1),
    (124, 13, '计生情趣', 1),
    (125, 13, '保健器械', 1),
    (126, 13, '护理护具', 1),
    (127, 13, '隐形眼镜', 1),
    (128, 13, '健康服务', 1),-- -------------------------

    (129, 14, '邮币', 1),
    (130, 14, '少儿', 1),
    (131, 14, '教育', 1),
    (132, 14, '文艺', 1),
    (133, 14, '经管励志', 1),
    (134, 14, '人文社科', 1),
    (135, 14, '生活', 1),
    (136, 14, '科技', 1),
    (137, 14, '刊/原版', 1),
    (138, 14, '电子书', 1),
    (139, 14, '音像', 1),-- -------------------------

    (140, 15, '交通出行', 1),
    (141, 15, '酒店预订', 1),
    (142, 15, '旅游度假', 1),
    (143, 15, '商旅服务', 1),
    (144, 15, '演出票务', 1),
    (145, 15, '生活缴费', 1),
    (146, 15, '生活服务', 1),
    (147, 15, '教育培训', 1),
    (148, 15, '彩票', 1),
    (149, 15, '游戏', 1),
    (150, 15, '海外生活', 1),-- -------------------------

    (151, 16, '理财', 1),
    (152, 16, '众筹', 1),
    (153, 16, '东家', 1),
    (154, 16, '白条', 1),
    (155, 16, '支付', 1),
    (156, 16, '保险', 1),
    (157, 16, '股票', 1);-- -------------------------


--  tb_goods_type      商品分类表  (三级类目)
INSERT INTO tb_goods_type (father_type_id, typeName, sortOrder) VALUES
    (17, '4K电视', 1),
    (17, 'OLED电视', 1),
    (17, '超级大电视', 1),
    (17, '曲面电视', 1),

    (18, '中央空调', 1),
    (18, '挂式空调', 1),
    (18, '空调配件', 1),

    (24, '华为手机', 1),
    (24, '三星手机', 1),
    (24, '苹果手机', 1),
    (25, '手机屏幕配件', 1),
    (26, '单反相机', 1),



    (151, '基金理财', 1),
    (151, '定期理财', 1);



