/*
 Navicat Premium Data Transfer

 Source Server         : hejin
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : localhost:3306
 Source Schema         : boon

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 19/03/2020 09:36:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for capacity
-- ----------------------------
DROP TABLE IF EXISTS `capacity`;
CREATE TABLE `capacity`  (
  `sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `basic` int(10) NOT NULL COMMENT '基本分',
  `rewards_sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '奖惩分',
  `proportion` double(10, 2) NOT NULL COMMENT '占比',
  `del` int(10) NOT NULL COMMENT '删除状态',
  PRIMARY KEY (`sno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of capacity
-- ----------------------------
INSERT INTO `capacity` VALUES ('2016901130', 60, '2016901130', 0.10, 0);
INSERT INTO `capacity` VALUES ('2016901133', 60, '2016901133', 0.10, 0);
INSERT INTO `capacity` VALUES ('2016901134', 60, '2016901134', 0.10, 0);
INSERT INTO `capacity` VALUES ('2016901135', 60, '2016901135', 0.10, 0);
INSERT INTO `capacity` VALUES ('2016901136', 60, '2016901136', 0.10, 0);
INSERT INTO `capacity` VALUES ('2016901138', 60, '2016901138', 0.10, 0);
INSERT INTO `capacity` VALUES ('2016901140', 60, '2016901140', 0.10, 0);
INSERT INTO `capacity` VALUES ('2016901141', 60, '2016901141', 0.10, 0);
INSERT INTO `capacity` VALUES ('2016901147', 60, '2016901147', 0.10, 0);

-- ----------------------------
-- Table structure for class_fee
-- ----------------------------
DROP TABLE IF EXISTS `class_fee`;
CREATE TABLE `class_fee`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `income` double(10, 2) NULL DEFAULT NULL COMMENT '收入的钱',
  `expend` double(10, 2) NULL DEFAULT NULL COMMENT '支出的钱',
  `money` double(10, 2) NULL DEFAULT NULL COMMENT '总的钱',
  `user_sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对班费进行管理的用户学号',
  `operation_time` timestamp NULL DEFAULT NULL COMMENT '对班费进行操作的时间',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of class_fee
-- ----------------------------
INSERT INTO `class_fee` VALUES (1, 2600.00, 0.00, 2600.00, '2016901147', '2020-02-29 14:04:43', '每个人交了50的班费');
INSERT INTO `class_fee` VALUES (2, 2000.00, 0.00, 4600.00, '2016901115', '2020-02-29 14:05:23', '学院拨款');
INSERT INTO `class_fee` VALUES (3, 3000.00, 0.00, 7600.00, '2016901147', '2020-02-29 14:06:06', '团建费用');

-- ----------------------------
-- Table structure for comprehensive
-- ----------------------------
DROP TABLE IF EXISTS `comprehensive`;
CREATE TABLE `comprehensive`  (
  `id` int(10) NOT NULL,
  `sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `score_sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '成绩的外键',
  `moral_sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '思想品德的外键',
  `health_sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '卫生体育的外键',
  `capacity_sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '个人能力的外键',
  `sum` double(10, 2) NOT NULL COMMENT '综测总分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `credit` int(10) NOT NULL,
  `del` int(10) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '二维动画制作', 3, 0);
INSERT INTO `course` VALUES (2, '概率论和数理统计', 3, 0);
INSERT INTO `course` VALUES (3, ' 大学英语三（读写）', 2, 0);
INSERT INTO `course` VALUES (4, '大学英语三（听说）', 2, 0);
INSERT INTO `course` VALUES (5, 'office高级应用', 3, 0);
INSERT INTO `course` VALUES (6, '离散数学', 5, 0);
INSERT INTO `course` VALUES (7, '高等数学Ⅰ', 4, 0);

-- ----------------------------
-- Table structure for health
-- ----------------------------
DROP TABLE IF EXISTS `health`;
CREATE TABLE `health`  (
  `sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `physique` int(10) NOT NULL COMMENT '身体健康状况',
  `hygiene` int(10) NOT NULL COMMENT '卫生情况',
  `exercise` int(10) NOT NULL COMMENT '锻炼情况',
  `labour` int(255) NOT NULL COMMENT '劳动情况',
  `rewards_sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '奖惩的学号',
  `proportion` double(10, 2) NOT NULL COMMENT '占比',
  `del` int(10) NOT NULL COMMENT '删除状态',
  PRIMARY KEY (`sno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of health
-- ----------------------------
INSERT INTO `health` VALUES ('2016901135', 15, 15, 15, 15, '2016901135', 0.10, 0);
INSERT INTO `health` VALUES ('2016901138', 15, 15, 15, 15, '2016901138', 0.10, 0);
INSERT INTO `health` VALUES ('2016901147', 15, 15, 15, 15, '2016901147', 0.10, 0);

-- ----------------------------
-- Table structure for inform
-- ----------------------------
DROP TABLE IF EXISTS `inform`;
CREATE TABLE `inform`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `user_sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of inform
-- ----------------------------
INSERT INTO `inform` VALUES (1, '关于寒假放假通知', '各位同学，第7个学期已经结束，寒假来临了。我们下个学期的重头戏是两门课程：毕业设计及论文答辩；自主实习。请大家提前准备。\n开学后毕业设计环节的步骤如下：论文修改-论文定稿-论文检测-论文答辩。\n自主实习：评定成绩需要提交的资料如下：附件1（实习单位接收证明）、附件2（安全协议书）、专业自主实习报告（第二阶段）。请已经完成或正在自主实习的同学积极收集资料，完成以上三个文档，开学就可以开始提交有关资料了。\n', '2020-01-24 15:29:38', '0', 0);
INSERT INTO `inform` VALUES (2, '3月收假通知', '各位同学，第7个学期已经结束，寒假来临了。我们下个学期的重头戏是两门课程：毕业设计及论文答辩；自主实习。请大家提前准备。\n开学后毕业设计环节的步骤如下：论文修改-论文定稿-论文检测-论文答辩。\n自主实习：评定成绩需要提交的资料如下：附件1（实习单位接收证明）、附件2（安全协议书）、专业自主实习报告（第二阶段）。请已经完成或正在自主实习的同学积极收集资料，完成以上三个文档，开学就可以开始提交有关资料了。\n', '2020-01-24 15:25:54', '2016901147', 0);
INSERT INTO `inform` VALUES (3, '运动会通知', '各位同学，第7个学期已经结束，寒假来临了。我们下个学期的重头戏是两门课程：毕业设计及论文答辩；自主实习。请大家提前准备。\n开学后毕业设计环节的步骤如下：论文修改-论文定稿-论文检测-论文答辩。\n自主实习：评定成绩需要提交的资料如下：附件1（实习单位接收证明）、附件2（安全协议书）、专业自主实习报告（第二阶段）。请已经完成或正在自主实习的同学积极收集资料，完成以上三个文档，开学就可以开始提交有关资料了。\n', '2020-01-24 15:25:54', '2016901147', 0);
INSERT INTO `inform` VALUES (4, '寒假放假通知', '各位同学，第7个学期已经结束，寒假来临了。我们下个学期的重头戏是两门课程：毕业设计及论文答辩；自主实习。请大家提前准备。\n开学后毕业设计环节的步骤如下：论文修改-论文定稿-论文检测-论文答辩。\n自主实习：评定成绩需要提交的资料如下：附件1（实习单位接收证明）、附件2（安全协议书）、专业自主实习报告（第二阶段）。请已经完成或正在自主实习的同学积极收集资料，完成以上三个文档，开学就可以开始提交有关资料了。\n', '2020-01-24 15:25:54', '2016901138', 0);
INSERT INTO `inform` VALUES (5, '毕业设计通知', '各位同学，第7个学期已经结束，寒假来临了。我们下个学期的重头戏是两门课程：毕业设计及论文答辩；自主实习。请大家提前准备。\n开学后毕业设计环节的步骤如下：论文修改-论文定稿-论文检测-论文答辩。\n自主实习：评定成绩需要提交的资料如下：附件1（实习单位接收证明）、附件2（安全协议书）、专业自主实习报告（第二阶段）。请已经完成或正在自主实习的同学积极收集资料，完成以上三个文档，开学就可以开始提交有关资料了。\n', '2020-01-24 15:25:54', '2016901138', 0);
INSERT INTO `inform` VALUES (6, '通知示例', '这是通知的示例', '2020-03-01 15:05:26', '2016901138', 0);
INSERT INTO `inform` VALUES (7, '补考通知', '请还有学科成绩没有通过的同学，这几天在家好好复习，4月份开学之后将开始补考。', '2020-03-16 21:48:16', '2016901138', 0);
INSERT INTO `inform` VALUES (8, '关于学分未够同学选课的通知', '请学分未够的同学在本周四之前联系对应的老师，选好自己的课。', '2020-03-16 21:53:07', '2016901148', 0);
INSERT INTO `inform` VALUES (9, '这个是示例', '我是示例，哈哈哈', '2020-03-16 21:55:00', '2016901148', 0);
INSERT INTO `inform` VALUES (10, '我还是通知的示例', '你好，我还是通知的示例', '2020-03-16 21:55:51', '2016901148', 0);
INSERT INTO `inform` VALUES (11, NULL, NULL, '2020-03-16 21:56:45', '2016901148', 1);
INSERT INTO `inform` VALUES (12, NULL, NULL, '2020-03-16 21:56:47', '2016901148', 1);
INSERT INTO `inform` VALUES (13, NULL, NULL, '2020-03-16 21:56:48', '2016901148', 1);
INSERT INTO `inform` VALUES (14, '我还来试一遍', '我就不信了，还是不行？', '2020-03-16 21:58:03', '2016901148', 0);
INSERT INTO `inform` VALUES (15, NULL, NULL, '2020-03-16 21:58:14', '2016901148', 1);
INSERT INTO `inform` VALUES (16, '还来试一遍', '再来试一遍', '2020-03-16 22:00:51', '2016901148', 0);
INSERT INTO `inform` VALUES (17, '老是不对', '再来一遍', '2020-03-16 22:02:43', '2016901148', 0);
INSERT INTO `inform` VALUES (18, NULL, NULL, '2020-03-16 22:12:16', 'admin', 1);
INSERT INTO `inform` VALUES (19, NULL, NULL, '2020-03-16 22:13:54', 'admin', 1);
INSERT INTO `inform` VALUES (20, NULL, NULL, '2020-03-16 22:14:46', 'admin', 1);
INSERT INTO `inform` VALUES (21, '我又来了', '别问我来干嘛！', '2020-03-16 22:26:11', 'admin', 0);

-- ----------------------------
-- Table structure for logs
-- ----------------------------
DROP TABLE IF EXISTS `logs`;
CREATE TABLE `logs`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userSno` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户学号',
  `module` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模块',
  `flag` tinyint(4) NOT NULL COMMENT '成功失败',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 156 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of logs
-- ----------------------------
INSERT INTO `logs` VALUES (1, '2016901147', '用户登录', 1, NULL, '2020-03-14 13:30:20');
INSERT INTO `logs` VALUES (2, '2016901147', '用户退出', 1, NULL, '2020-03-14 13:30:30');
INSERT INTO `logs` VALUES (3, 'admin', '用户登录', 1, NULL, '2020-03-14 13:30:51');
INSERT INTO `logs` VALUES (4, 'admin', '用户登录', 1, NULL, '2020-03-14 13:44:19');
INSERT INTO `logs` VALUES (5, 'admin', '修改用户删除状态', 1, NULL, '2020-03-14 13:44:38');
INSERT INTO `logs` VALUES (6, 'admin', '修改用户状态', 1, NULL, '2020-03-14 13:46:52');
INSERT INTO `logs` VALUES (7, 'admin', '用户登录', 1, NULL, '2020-03-14 13:59:18');
INSERT INTO `logs` VALUES (8, 'admin', '修改用户状态', 1, NULL, '2020-03-14 13:59:27');
INSERT INTO `logs` VALUES (9, '2016901115', '用户登录', 1, NULL, '2020-03-14 13:59:35');
INSERT INTO `logs` VALUES (10, '2016901115', '用户退出', 1, NULL, '2020-03-14 14:00:00');
INSERT INTO `logs` VALUES (11, 'admin', '用户登录', 1, NULL, '2020-03-14 14:00:26');
INSERT INTO `logs` VALUES (12, 'admin', '用户退出', 1, NULL, '2020-03-14 14:03:33');
INSERT INTO `logs` VALUES (13, '2016901147', '用户登录', 1, NULL, '2020-03-14 14:04:04');
INSERT INTO `logs` VALUES (14, '2016901147', '用户登录', 1, NULL, '2020-03-14 17:57:41');
INSERT INTO `logs` VALUES (15, '2016901147', '用户登录', 1, NULL, '2020-03-15 14:17:36');
INSERT INTO `logs` VALUES (16, '2016901147', '用户登录', 1, NULL, '2020-03-15 14:22:24');
INSERT INTO `logs` VALUES (17, '2016901147', '用户登录', 1, NULL, '2020-03-15 14:33:37');
INSERT INTO `logs` VALUES (18, '2016901147', '用户退出', 1, NULL, '2020-03-15 14:39:26');
INSERT INTO `logs` VALUES (19, '2016901115', '用户登录', 1, NULL, '2020-03-15 14:39:33');
INSERT INTO `logs` VALUES (20, '2016901115', '用户退出', 1, NULL, '2020-03-15 14:39:50');
INSERT INTO `logs` VALUES (21, '2016901135', '用户登录', 1, NULL, '2020-03-15 14:39:58');
INSERT INTO `logs` VALUES (22, '2016901135', '用户退出', 1, NULL, '2020-03-15 14:40:16');
INSERT INTO `logs` VALUES (23, '2016901147', '用户登录', 1, NULL, '2020-03-15 14:40:24');
INSERT INTO `logs` VALUES (24, '2016901147', '用户登录', 1, NULL, '2020-03-15 14:44:16');
INSERT INTO `logs` VALUES (25, '2016901147', '用户退出', 0, NULL, '2020-03-15 14:47:09');
INSERT INTO `logs` VALUES (26, '2016901147', '用户退出', 0, NULL, '2020-03-15 14:47:09');
INSERT INTO `logs` VALUES (27, '2016901147', '用户登录', 1, NULL, '2020-03-15 14:47:22');
INSERT INTO `logs` VALUES (28, '2016901147', '用户登录', 1, NULL, '2020-03-15 14:48:22');
INSERT INTO `logs` VALUES (29, '2016901147', '用户退出', 1, NULL, '2020-03-15 14:48:35');
INSERT INTO `logs` VALUES (30, '2016901147', '用户登录', 1, NULL, '2020-03-15 14:48:41');
INSERT INTO `logs` VALUES (31, '2016901147', '用户登录', 1, NULL, '2020-03-15 15:19:34');
INSERT INTO `logs` VALUES (32, '2016901147', '用户登录', 1, NULL, '2020-03-15 15:50:35');
INSERT INTO `logs` VALUES (33, '2016901147', '用户登录', 1, NULL, '2020-03-15 15:53:53');
INSERT INTO `logs` VALUES (34, '2016901147', '用户退出', 1, NULL, '2020-03-15 15:57:08');
INSERT INTO `logs` VALUES (35, '2016901138', '用户登录', 1, NULL, '2020-03-15 15:57:15');
INSERT INTO `logs` VALUES (36, '2016901138', '用户退出', 1, NULL, '2020-03-15 16:04:08');
INSERT INTO `logs` VALUES (37, '2016901138', '用户登录', 1, NULL, '2020-03-15 16:04:15');
INSERT INTO `logs` VALUES (38, '2016901138', '用户退出', 1, NULL, '2020-03-15 16:06:20');
INSERT INTO `logs` VALUES (39, 'admin', '用户登录', 1, NULL, '2020-03-15 16:06:26');
INSERT INTO `logs` VALUES (40, '2016901147', '用户登录', 1, NULL, '2020-03-15 16:15:42');
INSERT INTO `logs` VALUES (41, '2016901147', '用户退出', 1, NULL, '2020-03-15 16:16:58');
INSERT INTO `logs` VALUES (42, '2016901147', '用户登录', 1, NULL, '2020-03-15 16:17:05');
INSERT INTO `logs` VALUES (43, '2016901147', '用户退出', 1, NULL, '2020-03-15 16:17:20');
INSERT INTO `logs` VALUES (44, 'admin', '用户登录', 1, NULL, '2020-03-15 16:17:28');
INSERT INTO `logs` VALUES (45, 'admin', '用户退出', 1, NULL, '2020-03-15 16:21:08');
INSERT INTO `logs` VALUES (46, '2016901147', '用户登录', 1, NULL, '2020-03-15 16:21:17');
INSERT INTO `logs` VALUES (47, '2016901147', '用户退出', 1, NULL, '2020-03-15 16:22:22');
INSERT INTO `logs` VALUES (48, 'admin', '用户登录', 1, NULL, '2020-03-15 16:22:31');
INSERT INTO `logs` VALUES (49, 'admin', '用户退出', 1, NULL, '2020-03-15 16:24:37');
INSERT INTO `logs` VALUES (50, '2016901147', '用户登录', 1, NULL, '2020-03-15 16:24:44');
INSERT INTO `logs` VALUES (51, '2016901147', '用户登录', 1, NULL, '2020-03-15 16:25:26');
INSERT INTO `logs` VALUES (52, '2016901147', '用户退出', 1, NULL, '2020-03-15 16:25:37');
INSERT INTO `logs` VALUES (53, 'admin', '用户登录', 1, NULL, '2020-03-15 16:25:42');
INSERT INTO `logs` VALUES (54, '2016901147', '用户登录', 1, NULL, '2020-03-15 16:55:54');
INSERT INTO `logs` VALUES (55, '2016901147', '用户退出', 1, NULL, '2020-03-15 16:56:45');
INSERT INTO `logs` VALUES (56, 'admin', '用户登录', 1, NULL, '2020-03-15 16:56:52');
INSERT INTO `logs` VALUES (57, '2016901147', '用户登录', 1, NULL, '2020-03-15 17:39:38');
INSERT INTO `logs` VALUES (58, '2016901147', '用户登录', 1, NULL, '2020-03-15 17:42:34');
INSERT INTO `logs` VALUES (59, '2016901147', '用户登录', 1, NULL, '2020-03-15 18:03:35');
INSERT INTO `logs` VALUES (60, '2016901147', '用户登录', 1, NULL, '2020-03-15 18:06:36');
INSERT INTO `logs` VALUES (61, 'admin', '用户登录', 1, NULL, '2020-03-15 18:18:44');
INSERT INTO `logs` VALUES (62, '2016901147', '用户登录', 1, NULL, '2020-03-15 18:21:54');
INSERT INTO `logs` VALUES (63, '2016901147', '用户登录', 1, NULL, '2020-03-15 18:26:44');
INSERT INTO `logs` VALUES (64, '2016901147', '用户登录', 1, NULL, '2020-03-15 18:28:13');
INSERT INTO `logs` VALUES (65, 'admin', '用户登录', 1, NULL, '2020-03-16 12:59:46');
INSERT INTO `logs` VALUES (66, 'admin', '用户登录', 1, NULL, '2020-03-16 13:03:19');
INSERT INTO `logs` VALUES (67, '2016901147', '用户登录', 1, NULL, '2020-03-16 13:03:59');
INSERT INTO `logs` VALUES (68, 'admin', '用户登录', 1, NULL, '2020-03-16 13:06:37');
INSERT INTO `logs` VALUES (69, '2016901147', '用户登录', 1, NULL, '2020-03-16 13:30:31');
INSERT INTO `logs` VALUES (70, 'admin', '用户登录', 1, NULL, '2020-03-16 13:38:38');
INSERT INTO `logs` VALUES (71, 'admin', '用户退出', 1, NULL, '2020-03-16 13:45:51');
INSERT INTO `logs` VALUES (72, '2016901147', '用户登录', 1, NULL, '2020-03-16 13:45:58');
INSERT INTO `logs` VALUES (73, '2016901147', '用户登录', 1, NULL, '2020-03-16 14:40:39');
INSERT INTO `logs` VALUES (74, 'admin', '用户登录', 1, NULL, '2020-03-16 21:30:02');
INSERT INTO `logs` VALUES (75, 'admin', '用户登录', 1, NULL, '2020-03-16 21:42:19');
INSERT INTO `logs` VALUES (76, 'admin', '新增用户', 1, NULL, '2020-03-16 21:43:47');
INSERT INTO `logs` VALUES (77, 'admin', '用户退出', 1, NULL, '2020-03-16 21:44:21');
INSERT INTO `logs` VALUES (78, '2016901148', '用户登录', 1, NULL, '2020-03-16 21:44:28');
INSERT INTO `logs` VALUES (79, '2016901148', '新增通知', 1, NULL, '2020-03-16 21:48:16');
INSERT INTO `logs` VALUES (80, '2016901148', '新增通知', 1, NULL, '2020-03-16 21:53:07');
INSERT INTO `logs` VALUES (81, '2016901148', '新增通知', 1, NULL, '2020-03-16 21:55:00');
INSERT INTO `logs` VALUES (82, '2016901148', '新增通知', 1, NULL, '2020-03-16 21:55:51');
INSERT INTO `logs` VALUES (83, '2016901148', '新增通知', 1, NULL, '2020-03-16 21:56:45');
INSERT INTO `logs` VALUES (84, '2016901148', '新增通知', 1, NULL, '2020-03-16 21:56:47');
INSERT INTO `logs` VALUES (85, '2016901148', '新增通知', 1, NULL, '2020-03-16 21:56:49');
INSERT INTO `logs` VALUES (86, '2016901148', '删除通知', 1, NULL, '2020-03-16 21:57:07');
INSERT INTO `logs` VALUES (87, '2016901148', '删除通知', 1, NULL, '2020-03-16 21:57:10');
INSERT INTO `logs` VALUES (88, '2016901148', '删除通知', 1, NULL, '2020-03-16 21:57:15');
INSERT INTO `logs` VALUES (89, '2016901148', '新增通知', 1, NULL, '2020-03-16 21:58:03');
INSERT INTO `logs` VALUES (90, '2016901148', '新增通知', 1, NULL, '2020-03-16 21:58:14');
INSERT INTO `logs` VALUES (91, '2016901148', '新增通知', 1, NULL, '2020-03-16 22:00:51');
INSERT INTO `logs` VALUES (92, '2016901148', '新增通知', 1, NULL, '2020-03-16 22:02:43');
INSERT INTO `logs` VALUES (93, '2016901148', '删除通知', 1, NULL, '2020-03-16 22:03:06');
INSERT INTO `logs` VALUES (94, '2016901148', '用户退出', 1, NULL, '2020-03-16 22:04:41');
INSERT INTO `logs` VALUES (95, 'admin', '用户登录', 1, NULL, '2020-03-16 22:04:48');
INSERT INTO `logs` VALUES (96, 'admin', '新增通知', 1, NULL, '2020-03-16 22:12:16');
INSERT INTO `logs` VALUES (97, 'admin', '删除通知', 1, NULL, '2020-03-16 22:12:41');
INSERT INTO `logs` VALUES (98, 'admin', '新增通知', 1, NULL, '2020-03-16 22:13:54');
INSERT INTO `logs` VALUES (99, 'admin', '新增通知', 1, NULL, '2020-03-16 22:14:46');
INSERT INTO `logs` VALUES (100, 'admin', '删除通知', 1, NULL, '2020-03-16 22:15:08');
INSERT INTO `logs` VALUES (101, 'admin', '批量删除通知', 1, NULL, '2020-03-16 22:15:12');
INSERT INTO `logs` VALUES (102, 'admin', '新增通知', 1, NULL, '2020-03-16 22:26:11');
INSERT INTO `logs` VALUES (103, 'admin', '新增用户', 1, NULL, '2020-03-16 22:28:07');
INSERT INTO `logs` VALUES (104, '2016901147', '用户登录', 1, NULL, '2020-03-16 22:32:30');
INSERT INTO `logs` VALUES (105, '2016901147', '用户退出', 1, NULL, '2020-03-16 22:36:31');
INSERT INTO `logs` VALUES (106, 'admin', '用户登录', 1, NULL, '2020-03-16 22:36:40');
INSERT INTO `logs` VALUES (107, 'admin', '用户退出', 1, NULL, '2020-03-16 22:36:52');
INSERT INTO `logs` VALUES (108, '2016901138', '用户登录', 1, NULL, '2020-03-16 22:37:00');
INSERT INTO `logs` VALUES (109, '2016901147', '用户登录', 1, NULL, '2020-03-16 22:40:41');
INSERT INTO `logs` VALUES (110, 'admin', '用户登录', 1, NULL, '2020-03-16 22:51:21');
INSERT INTO `logs` VALUES (111, '2016901147', '用户登录', 1, NULL, '2020-03-16 23:11:36');
INSERT INTO `logs` VALUES (112, '2016901147', '用户退出', 1, NULL, '2020-03-16 23:11:52');
INSERT INTO `logs` VALUES (113, 'admin', '用户登录', 1, NULL, '2020-03-16 23:11:57');
INSERT INTO `logs` VALUES (114, 'admin', '用户登录', 1, NULL, '2020-03-16 23:15:46');
INSERT INTO `logs` VALUES (115, 'admin', '用户登录', 1, NULL, '2020-03-16 23:20:00');
INSERT INTO `logs` VALUES (116, 'admin', '用户登录', 1, NULL, '2020-03-16 23:22:28');
INSERT INTO `logs` VALUES (117, 'admin', '用户登录', 1, NULL, '2020-03-16 23:28:03');
INSERT INTO `logs` VALUES (118, 'admin', '用户登录', 1, NULL, '2020-03-16 23:35:07');
INSERT INTO `logs` VALUES (119, '2016901147', '用户登录', 1, NULL, '2020-03-17 09:44:54');
INSERT INTO `logs` VALUES (120, '2016901147', '用户退出', 1, NULL, '2020-03-17 09:45:18');
INSERT INTO `logs` VALUES (121, 'admin', '用户登录', 1, NULL, '2020-03-17 09:45:26');
INSERT INTO `logs` VALUES (122, 'admin', '用户登录', 1, NULL, '2020-03-17 09:51:26');
INSERT INTO `logs` VALUES (123, 'admin', '用户登录', 1, NULL, '2020-03-17 10:08:16');
INSERT INTO `logs` VALUES (124, 'admin', '用户登录', 1, NULL, '2020-03-17 10:12:17');
INSERT INTO `logs` VALUES (125, 'admin', '删除用户', 1, NULL, '2020-03-17 10:39:32');
INSERT INTO `logs` VALUES (126, 'admin', '修改用户删除状态', 1, NULL, '2020-03-17 10:39:41');
INSERT INTO `logs` VALUES (127, 'admin', '用户登录', 1, NULL, '2020-03-17 11:02:25');
INSERT INTO `logs` VALUES (128, 'admin', '用户登录', 1, NULL, '2020-03-17 12:53:19');
INSERT INTO `logs` VALUES (129, 'admin', '用户登录', 1, NULL, '2020-03-17 12:55:36');
INSERT INTO `logs` VALUES (130, 'admin', '用户登录', 1, NULL, '2020-03-17 14:12:15');
INSERT INTO `logs` VALUES (131, '2016901147', '用户登录', 1, NULL, '2020-03-17 14:47:58');
INSERT INTO `logs` VALUES (132, '2016901147', '用户退出', 1, NULL, '2020-03-17 14:57:36');
INSERT INTO `logs` VALUES (133, 'admin', '用户登录', 1, NULL, '2020-03-17 14:59:34');
INSERT INTO `logs` VALUES (134, 'admin', '用户退出', 1, NULL, '2020-03-17 15:01:05');
INSERT INTO `logs` VALUES (135, 'admin', '用户登录', 1, NULL, '2020-03-17 15:02:03');
INSERT INTO `logs` VALUES (136, 'admin', '用户退出', 1, NULL, '2020-03-17 15:03:55');
INSERT INTO `logs` VALUES (137, '2016901147', '用户登录', 1, NULL, '2020-03-17 15:04:52');
INSERT INTO `logs` VALUES (138, 'admin', '用户登录', 1, NULL, '2020-03-17 15:06:48');
INSERT INTO `logs` VALUES (139, 'admin', '用户登录', 1, NULL, '2020-03-17 15:07:02');
INSERT INTO `logs` VALUES (140, '2016901147', '用户登录', 1, NULL, '2020-03-17 15:15:17');
INSERT INTO `logs` VALUES (141, '2016901147', '用户退出', 1, NULL, '2020-03-17 15:15:56');
INSERT INTO `logs` VALUES (142, 'admin', '用户登录', 1, NULL, '2020-03-18 00:00:03');
INSERT INTO `logs` VALUES (143, 'admin', '用户登录', 1, NULL, '2020-03-18 16:21:21');
INSERT INTO `logs` VALUES (144, '2016901147', '用户登录', 1, NULL, '2020-03-18 17:00:50');
INSERT INTO `logs` VALUES (145, '2016901147', '用户登录', 1, NULL, '2020-03-18 17:17:55');
INSERT INTO `logs` VALUES (146, '2016901147', '用户登录', 1, NULL, '2020-03-18 17:24:50');
INSERT INTO `logs` VALUES (147, '2016901147', '用户退出', 1, NULL, '2020-03-18 17:25:03');
INSERT INTO `logs` VALUES (148, 'admin', '用户登录', 1, NULL, '2020-03-18 17:55:57');
INSERT INTO `logs` VALUES (149, 'admin', '用户退出', 1, NULL, '2020-03-18 17:56:43');
INSERT INTO `logs` VALUES (150, 'admin', '用户登录', 1, NULL, '2020-03-18 22:22:31');
INSERT INTO `logs` VALUES (151, 'admin', '用户登录', 1, NULL, '2020-03-18 22:57:51');
INSERT INTO `logs` VALUES (152, 'admin', '用户登录', 1, NULL, '2020-03-18 23:29:50');
INSERT INTO `logs` VALUES (153, 'admin', '用户登录', 1, NULL, '2020-03-18 23:38:05');
INSERT INTO `logs` VALUES (154, 'admin', '用户登录', 1, NULL, '2020-03-19 00:09:59');
INSERT INTO `logs` VALUES (155, 'admin', '用户登录', 1, NULL, '2020-03-19 09:15:15');

-- ----------------------------
-- Table structure for moral
-- ----------------------------
DROP TABLE IF EXISTS `moral`;
CREATE TABLE `moral`  (
  `sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `politics` int(10) NOT NULL COMMENT '政治思想',
  `learn` int(10) NOT NULL COMMENT '学习态度',
  `culture` int(10) NOT NULL COMMENT '文明礼貌',
  `discipline` int(10) NOT NULL COMMENT '纪律观念',
  `rewards_sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '奖惩中的学号',
  `proportion` double(10, 2) NOT NULL COMMENT '占比',
  `del` int(10) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`sno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of moral
-- ----------------------------
INSERT INTO `moral` VALUES ('2016901133', 15, 15, 15, 15, '2016901133', 0.20, 0);
INSERT INTO `moral` VALUES ('2016901135', 15, 15, 15, 15, '2016901135', 0.20, 0);
INSERT INTO `moral` VALUES ('2016901138', 15, 15, 15, 15, '2016901138', 0.20, 0);
INSERT INTO `moral` VALUES ('2016901147', 15, 15, 15, 15, '2016901147', 0.20, 0);

-- ----------------------------
-- Table structure for rewards
-- ----------------------------
DROP TABLE IF EXISTS `rewards`;
CREATE TABLE `rewards`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `type_id` int(10) NULL DEFAULT NULL COMMENT '奖惩类别（思想品德，卫生体育，个人能力）',
  `initial_value` int(10) NOT NULL COMMENT '初始值',
  `reward` int(10) NULL DEFAULT NULL COMMENT '奖励',
  `punish` int(10) NULL DEFAULT NULL COMMENT '惩罚',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建的时间',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `final_value` int(10) NOT NULL COMMENT '最终值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of rewards
-- ----------------------------
INSERT INTO `rewards` VALUES (1, '2016901147', 1, 0, 2, 0, '2020-01-28 21:42:42', '奖状一张', 2);
INSERT INTO `rewards` VALUES (2, '2016901147', 1, 2, 2, 0, '2020-01-28 21:43:36', '证书一本', 4);
INSERT INTO `rewards` VALUES (3, '2016901147', 7, 0, 2, 0, '2020-01-28 21:47:29', '参加活动一次', 2);
INSERT INTO `rewards` VALUES (4, '2016901147', 7, 2, 3, 0, '2020-01-28 21:48:04', '获得文明宿舍', 5);
INSERT INTO `rewards` VALUES (5, '2016901147', 1, 4, 2, 0, '2020-01-28 22:44:56', '奖状一张', 6);
INSERT INTO `rewards` VALUES (6, '2016901138', 1, 0, 2, 0, '2020-01-28 22:45:52', '荣誉证书一本', 2);
INSERT INTO `rewards` VALUES (7, '2016901138', 1, 2, 2, 0, '2020-01-28 22:48:41', '奖状一张', 4);
INSERT INTO `rewards` VALUES (8, '2016901138', 7, 0, 3, 0, '2020-01-29 23:05:25', '获得文明宿舍', 3);
INSERT INTO `rewards` VALUES (9, '2016901138', 7, 3, 3, 0, '2020-02-01 23:06:14', '5000米第一名', 6);
INSERT INTO `rewards` VALUES (10, '2016901147', 13, 0, 5, 0, '2020-01-30 14:48:31', '班委', 5);
INSERT INTO `rewards` VALUES (11, '2016901147', 13, 5, 2, 0, '2020-01-30 14:49:39', '歌唱比赛第一名', 7);
INSERT INTO `rewards` VALUES (12, '2016901138', 13, 0, 6, 0, '2020-01-30 14:50:39', '班长', 6);
INSERT INTO `rewards` VALUES (13, '2016901138', 13, 6, 2, 0, '2020-01-30 14:51:08', '组织志愿活动', 8);
INSERT INTO `rewards` VALUES (14, '2016901147', 1, 6, 3, 0, '2020-02-27 14:30:55', '奖状一张', 9);
INSERT INTO `rewards` VALUES (15, '2016901135', 1, 0, 3, 0, '2020-02-27 14:41:24', '奖状一张', 3);
INSERT INTO `rewards` VALUES (16, '2016901133', 7, 0, 3, 0, '2020-02-29 13:47:23', '奖状一张', 3);
INSERT INTO `rewards` VALUES (17, '2016901134', 7, 0, 3, 0, '2020-02-29 13:48:31', '奖状一张', 3);

-- ----------------------------
-- Table structure for right
-- ----------------------------
DROP TABLE IF EXISTS `right`;
CREATE TABLE `right`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parent_id` int(10) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of right
-- ----------------------------
INSERT INTO `right` VALUES (1, '系统设置', 0, '/**', '0');
INSERT INTO `right` VALUES (2, '用户管理', 1, '/user', '1');
INSERT INTO `right` VALUES (3, '成绩管理', 1, '/score', '1');
INSERT INTO `right` VALUES (4, '课程管理', 1, '/course', '1');
INSERT INTO `right` VALUES (5, '奖惩管理', 1, '/reward', '1');
INSERT INTO `right` VALUES (6, '班费管理', 1, '/fee', '1');
INSERT INTO `right` VALUES (7, '通知管理', 1, '/inform', '1');
INSERT INTO `right` VALUES (9, '增加用户', 2, '/user/addUser', '1');
INSERT INTO `right` VALUES (10, '删除用户', 2, '/user/deleteBySno', '1');
INSERT INTO `right` VALUES (11, '修改用户信息', 2, '/user/update', '1');
INSERT INTO `right` VALUES (12, '修改用户状态', 2, '/user/changeState', '1');
INSERT INTO `right` VALUES (13, '批量删除数据', 2, '/user/delBatch', '1');
INSERT INTO `right` VALUES (14, '修改删除状态', 2, '/user/changeDel', '1');
INSERT INTO `right` VALUES (15, '批量恢复删除', 2, '/user/restoreBatch', '1');
INSERT INTO `right` VALUES (16, '成绩的添加', 3, '/score/addScore', '1');
INSERT INTO `right` VALUES (17, '批量删除', 3, '/score/delBatch', '1');
INSERT INTO `right` VALUES (18, '删除成绩', 3, '/score/delete', '1');
INSERT INTO `right` VALUES (19, '课程的添加', 4, '/course/addCourse', '1');
INSERT INTO `right` VALUES (20, '更新课程', 4, '/course/update', '1');
INSERT INTO `right` VALUES (21, '删除课程', 4, '/course/delete', '1');
INSERT INTO `right` VALUES (22, '批量删除', 4, '/course/delBatch', '1');
INSERT INTO `right` VALUES (23, '新增奖惩', 5, '/reward/addReward', '1');
INSERT INTO `right` VALUES (24, '更新奖惩', 5, '/reward/uodate', '1');
INSERT INTO `right` VALUES (25, '新增班费', 6, '/fee/addFee', '1');
INSERT INTO `right` VALUES (26, '班费更新', 6, '/fee/updateFee', '1');
INSERT INTO `right` VALUES (27, '新增通知', 7, '/inform/addInform', '1');
INSERT INTO `right` VALUES (28, '更新通知', 7, '/inform/update', '1');
INSERT INTO `right` VALUES (29, '删除通知', 7, '/inform/delete', '1');
INSERT INTO `right` VALUES (30, '批量删除', 7, '/inform/delBatch', '1');
INSERT INTO `right` VALUES (31, '成绩更新', 3, '/score/update', '1');
INSERT INTO `right` VALUES (32, '个人能力', 1, '/capacity', '1');
INSERT INTO `right` VALUES (33, '新增个人能力', 32, '/capacity/addCapacity', '1');
INSERT INTO `right` VALUES (34, '更新个人能力', 32, '/capacity/update', '1');
INSERT INTO `right` VALUES (35, '删除个人能力', 32, '/capacity/delete', '1');
INSERT INTO `right` VALUES (36, '批量删除', 32, '/capacity/delBatch', '1');
INSERT INTO `right` VALUES (37, '卫生体育', 1, '/health', '1');
INSERT INTO `right` VALUES (38, '新增卫生体育', 37, '/health/addHealth', '1');
INSERT INTO `right` VALUES (39, '更新卫生体育', 37, '/health/update', '1');
INSERT INTO `right` VALUES (40, '删除卫生体育', 37, '/health/delete', '1');
INSERT INTO `right` VALUES (41, '批量删除', 37, '/health/delBatch', '1');
INSERT INTO `right` VALUES (42, '思想品德', 1, '/moral', '1');
INSERT INTO `right` VALUES (43, '新增思想品德', 42, '/moral/addMoral', '1');
INSERT INTO `right` VALUES (44, '更新思想品德', 42, '/moral/update', '1');
INSERT INTO `right` VALUES (45, '删除思想品德', 42, '/moral/delete', '1');
INSERT INTO `right` VALUES (46, '批量删除', 42, '/moral/delBatch', '1');
INSERT INTO `right` VALUES (47, '类别', 1, '/type', '1');
INSERT INTO `right` VALUES (48, '新增类别', 47, '/type/addType', '1');
INSERT INTO `right` VALUES (49, '更新类别', 47, '/type/update', '1');
INSERT INTO `right` VALUES (50, '删除类别', 47, '/type/delete', '1');
INSERT INTO `right` VALUES (51, '批量删除', 47, '/type/delBatch', '1');
INSERT INTO `right` VALUES (52, '管理员', 1, '/admin', '1');
INSERT INTO `right` VALUES (54, '权限管理', 52, '/admin/all', '1');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '超级管理员', '拥有至高无上的权限', 0);
INSERT INTO `role` VALUES (2, '班长', '拥有除权限管理，用户管理外的所有权限', 0);
INSERT INTO `role` VALUES (3, '副班长', '拥有除权限管理，用户管理外的所有权限', 0);
INSERT INTO `role` VALUES (4, '学习委员', '拥有除权限管理，用户管理外的所有权限', 0);
INSERT INTO `role` VALUES (5, '团支书', '拥有除权限管理，用户管理外的所有权限', 0);
INSERT INTO `role` VALUES (6, '生活委员', '拥有除权限管理，用户管理外的所有权限', 0);
INSERT INTO `role` VALUES (7, '体育委员', '拥有除权限管理，用户管理外的所有权限', 0);
INSERT INTO `role` VALUES (8, '纪律委员', '拥有除权限管理，用户管理外的所有权限', 0);
INSERT INTO `role` VALUES (9, '文艺委员', '拥有除权限管理，用户管理外的所有权限', 0);
INSERT INTO `role` VALUES (10, '宣传委员', '拥有除权限管理，用户管理外的所有权限', 0);
INSERT INTO `role` VALUES (11, '班主任', '拥有出权限管理外的所有权限', 0);
INSERT INTO `role` VALUES (12, '普通同学', '拥有所有查询功能，但是只能对自己信息进行管理', 0);

-- ----------------------------
-- Table structure for role_right
-- ----------------------------
DROP TABLE IF EXISTS `role_right`;
CREATE TABLE `role_right`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(10) NOT NULL,
  `right_id` int(10) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 509 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_right
-- ----------------------------
INSERT INTO `role_right` VALUES (1, 1, 1);
INSERT INTO `role_right` VALUES (3, 1, 2);
INSERT INTO `role_right` VALUES (4, 1, 3);
INSERT INTO `role_right` VALUES (5, 1, 4);
INSERT INTO `role_right` VALUES (6, 1, 5);
INSERT INTO `role_right` VALUES (7, 1, 6);
INSERT INTO `role_right` VALUES (8, 1, 7);
INSERT INTO `role_right` VALUES (9, 1, 8);
INSERT INTO `role_right` VALUES (10, 1, 9);
INSERT INTO `role_right` VALUES (11, 1, 10);
INSERT INTO `role_right` VALUES (12, 1, 11);
INSERT INTO `role_right` VALUES (13, 1, 12);
INSERT INTO `role_right` VALUES (14, 1, 13);
INSERT INTO `role_right` VALUES (15, 1, 14);
INSERT INTO `role_right` VALUES (16, 1, 15);
INSERT INTO `role_right` VALUES (17, 1, 16);
INSERT INTO `role_right` VALUES (18, 1, 17);
INSERT INTO `role_right` VALUES (19, 1, 18);
INSERT INTO `role_right` VALUES (20, 1, 19);
INSERT INTO `role_right` VALUES (21, 1, 20);
INSERT INTO `role_right` VALUES (22, 1, 21);
INSERT INTO `role_right` VALUES (23, 1, 22);
INSERT INTO `role_right` VALUES (24, 1, 23);
INSERT INTO `role_right` VALUES (25, 1, 24);
INSERT INTO `role_right` VALUES (26, 1, 25);
INSERT INTO `role_right` VALUES (27, 1, 26);
INSERT INTO `role_right` VALUES (28, 1, 27);
INSERT INTO `role_right` VALUES (29, 1, 28);
INSERT INTO `role_right` VALUES (30, 1, 29);
INSERT INTO `role_right` VALUES (31, 1, 30);
INSERT INTO `role_right` VALUES (32, 2, 1);
INSERT INTO `role_right` VALUES (33, 2, 2);
INSERT INTO `role_right` VALUES (34, 2, 3);
INSERT INTO `role_right` VALUES (35, 2, 4);
INSERT INTO `role_right` VALUES (36, 2, 5);
INSERT INTO `role_right` VALUES (37, 2, 6);
INSERT INTO `role_right` VALUES (38, 2, 7);
INSERT INTO `role_right` VALUES (39, 2, 8);
INSERT INTO `role_right` VALUES (40, 2, 16);
INSERT INTO `role_right` VALUES (41, 2, 17);
INSERT INTO `role_right` VALUES (42, 2, 18);
INSERT INTO `role_right` VALUES (43, 2, 19);
INSERT INTO `role_right` VALUES (44, 2, 20);
INSERT INTO `role_right` VALUES (45, 2, 21);
INSERT INTO `role_right` VALUES (46, 2, 22);
INSERT INTO `role_right` VALUES (47, 2, 23);
INSERT INTO `role_right` VALUES (48, 2, 24);
INSERT INTO `role_right` VALUES (49, 2, 25);
INSERT INTO `role_right` VALUES (50, 2, 26);
INSERT INTO `role_right` VALUES (51, 2, 27);
INSERT INTO `role_right` VALUES (52, 2, 28);
INSERT INTO `role_right` VALUES (53, 2, 29);
INSERT INTO `role_right` VALUES (54, 2, 30);
INSERT INTO `role_right` VALUES (55, 3, 1);
INSERT INTO `role_right` VALUES (56, 3, 2);
INSERT INTO `role_right` VALUES (57, 3, 3);
INSERT INTO `role_right` VALUES (58, 3, 4);
INSERT INTO `role_right` VALUES (59, 3, 5);
INSERT INTO `role_right` VALUES (60, 3, 6);
INSERT INTO `role_right` VALUES (61, 3, 7);
INSERT INTO `role_right` VALUES (62, 3, 8);
INSERT INTO `role_right` VALUES (63, 3, 16);
INSERT INTO `role_right` VALUES (64, 3, 17);
INSERT INTO `role_right` VALUES (65, 3, 18);
INSERT INTO `role_right` VALUES (66, 3, 19);
INSERT INTO `role_right` VALUES (67, 3, 20);
INSERT INTO `role_right` VALUES (68, 3, 21);
INSERT INTO `role_right` VALUES (69, 3, 22);
INSERT INTO `role_right` VALUES (70, 3, 23);
INSERT INTO `role_right` VALUES (71, 3, 24);
INSERT INTO `role_right` VALUES (72, 3, 25);
INSERT INTO `role_right` VALUES (73, 3, 26);
INSERT INTO `role_right` VALUES (74, 3, 27);
INSERT INTO `role_right` VALUES (75, 3, 28);
INSERT INTO `role_right` VALUES (76, 3, 29);
INSERT INTO `role_right` VALUES (77, 3, 30);
INSERT INTO `role_right` VALUES (78, 4, 1);
INSERT INTO `role_right` VALUES (79, 4, 2);
INSERT INTO `role_right` VALUES (80, 4, 3);
INSERT INTO `role_right` VALUES (81, 4, 4);
INSERT INTO `role_right` VALUES (82, 4, 5);
INSERT INTO `role_right` VALUES (83, 4, 6);
INSERT INTO `role_right` VALUES (84, 4, 7);
INSERT INTO `role_right` VALUES (85, 4, 8);
INSERT INTO `role_right` VALUES (86, 4, 16);
INSERT INTO `role_right` VALUES (87, 4, 17);
INSERT INTO `role_right` VALUES (88, 4, 18);
INSERT INTO `role_right` VALUES (89, 4, 19);
INSERT INTO `role_right` VALUES (90, 4, 20);
INSERT INTO `role_right` VALUES (91, 4, 21);
INSERT INTO `role_right` VALUES (92, 4, 22);
INSERT INTO `role_right` VALUES (93, 4, 23);
INSERT INTO `role_right` VALUES (94, 4, 24);
INSERT INTO `role_right` VALUES (95, 4, 25);
INSERT INTO `role_right` VALUES (96, 4, 26);
INSERT INTO `role_right` VALUES (97, 4, 27);
INSERT INTO `role_right` VALUES (98, 4, 28);
INSERT INTO `role_right` VALUES (99, 4, 29);
INSERT INTO `role_right` VALUES (100, 4, 30);
INSERT INTO `role_right` VALUES (101, 5, 1);
INSERT INTO `role_right` VALUES (102, 5, 2);
INSERT INTO `role_right` VALUES (103, 5, 3);
INSERT INTO `role_right` VALUES (104, 5, 4);
INSERT INTO `role_right` VALUES (105, 5, 5);
INSERT INTO `role_right` VALUES (106, 5, 6);
INSERT INTO `role_right` VALUES (107, 5, 7);
INSERT INTO `role_right` VALUES (108, 5, 8);
INSERT INTO `role_right` VALUES (109, 5, 16);
INSERT INTO `role_right` VALUES (110, 5, 17);
INSERT INTO `role_right` VALUES (111, 5, 18);
INSERT INTO `role_right` VALUES (112, 5, 19);
INSERT INTO `role_right` VALUES (113, 5, 20);
INSERT INTO `role_right` VALUES (114, 5, 21);
INSERT INTO `role_right` VALUES (115, 5, 22);
INSERT INTO `role_right` VALUES (116, 5, 23);
INSERT INTO `role_right` VALUES (117, 5, 24);
INSERT INTO `role_right` VALUES (118, 5, 25);
INSERT INTO `role_right` VALUES (119, 5, 26);
INSERT INTO `role_right` VALUES (120, 5, 27);
INSERT INTO `role_right` VALUES (121, 5, 28);
INSERT INTO `role_right` VALUES (122, 5, 29);
INSERT INTO `role_right` VALUES (123, 5, 30);
INSERT INTO `role_right` VALUES (124, 6, 1);
INSERT INTO `role_right` VALUES (125, 6, 2);
INSERT INTO `role_right` VALUES (126, 6, 3);
INSERT INTO `role_right` VALUES (127, 6, 4);
INSERT INTO `role_right` VALUES (128, 6, 5);
INSERT INTO `role_right` VALUES (129, 6, 6);
INSERT INTO `role_right` VALUES (130, 6, 7);
INSERT INTO `role_right` VALUES (131, 6, 8);
INSERT INTO `role_right` VALUES (132, 6, 16);
INSERT INTO `role_right` VALUES (133, 6, 17);
INSERT INTO `role_right` VALUES (134, 6, 18);
INSERT INTO `role_right` VALUES (135, 6, 19);
INSERT INTO `role_right` VALUES (136, 6, 20);
INSERT INTO `role_right` VALUES (137, 6, 21);
INSERT INTO `role_right` VALUES (138, 6, 22);
INSERT INTO `role_right` VALUES (139, 6, 23);
INSERT INTO `role_right` VALUES (140, 6, 24);
INSERT INTO `role_right` VALUES (141, 6, 25);
INSERT INTO `role_right` VALUES (142, 6, 26);
INSERT INTO `role_right` VALUES (143, 6, 27);
INSERT INTO `role_right` VALUES (144, 6, 28);
INSERT INTO `role_right` VALUES (145, 6, 29);
INSERT INTO `role_right` VALUES (146, 6, 30);
INSERT INTO `role_right` VALUES (147, 7, 1);
INSERT INTO `role_right` VALUES (148, 7, 2);
INSERT INTO `role_right` VALUES (149, 7, 3);
INSERT INTO `role_right` VALUES (150, 7, 4);
INSERT INTO `role_right` VALUES (151, 7, 5);
INSERT INTO `role_right` VALUES (152, 7, 6);
INSERT INTO `role_right` VALUES (153, 7, 7);
INSERT INTO `role_right` VALUES (154, 7, 8);
INSERT INTO `role_right` VALUES (155, 8, 1);
INSERT INTO `role_right` VALUES (156, 8, 2);
INSERT INTO `role_right` VALUES (157, 8, 3);
INSERT INTO `role_right` VALUES (158, 8, 4);
INSERT INTO `role_right` VALUES (159, 8, 5);
INSERT INTO `role_right` VALUES (160, 8, 6);
INSERT INTO `role_right` VALUES (161, 8, 7);
INSERT INTO `role_right` VALUES (162, 8, 8);
INSERT INTO `role_right` VALUES (163, 9, 1);
INSERT INTO `role_right` VALUES (164, 9, 2);
INSERT INTO `role_right` VALUES (165, 9, 3);
INSERT INTO `role_right` VALUES (166, 9, 4);
INSERT INTO `role_right` VALUES (167, 9, 5);
INSERT INTO `role_right` VALUES (168, 9, 6);
INSERT INTO `role_right` VALUES (169, 9, 7);
INSERT INTO `role_right` VALUES (170, 9, 8);
INSERT INTO `role_right` VALUES (171, 10, 1);
INSERT INTO `role_right` VALUES (172, 10, 2);
INSERT INTO `role_right` VALUES (173, 10, 3);
INSERT INTO `role_right` VALUES (174, 10, 4);
INSERT INTO `role_right` VALUES (175, 10, 5);
INSERT INTO `role_right` VALUES (176, 10, 6);
INSERT INTO `role_right` VALUES (177, 10, 7);
INSERT INTO `role_right` VALUES (178, 10, 8);
INSERT INTO `role_right` VALUES (179, 7, 16);
INSERT INTO `role_right` VALUES (180, 7, 17);
INSERT INTO `role_right` VALUES (181, 7, 18);
INSERT INTO `role_right` VALUES (182, 7, 19);
INSERT INTO `role_right` VALUES (183, 7, 20);
INSERT INTO `role_right` VALUES (184, 7, 21);
INSERT INTO `role_right` VALUES (185, 7, 22);
INSERT INTO `role_right` VALUES (186, 7, 23);
INSERT INTO `role_right` VALUES (187, 7, 24);
INSERT INTO `role_right` VALUES (188, 7, 25);
INSERT INTO `role_right` VALUES (189, 7, 26);
INSERT INTO `role_right` VALUES (190, 7, 27);
INSERT INTO `role_right` VALUES (191, 7, 28);
INSERT INTO `role_right` VALUES (192, 7, 29);
INSERT INTO `role_right` VALUES (193, 7, 30);
INSERT INTO `role_right` VALUES (194, 8, 16);
INSERT INTO `role_right` VALUES (195, 8, 17);
INSERT INTO `role_right` VALUES (196, 8, 18);
INSERT INTO `role_right` VALUES (197, 8, 19);
INSERT INTO `role_right` VALUES (198, 8, 20);
INSERT INTO `role_right` VALUES (199, 8, 21);
INSERT INTO `role_right` VALUES (200, 8, 22);
INSERT INTO `role_right` VALUES (201, 8, 23);
INSERT INTO `role_right` VALUES (202, 8, 24);
INSERT INTO `role_right` VALUES (203, 8, 25);
INSERT INTO `role_right` VALUES (204, 8, 26);
INSERT INTO `role_right` VALUES (205, 8, 27);
INSERT INTO `role_right` VALUES (206, 8, 28);
INSERT INTO `role_right` VALUES (207, 8, 29);
INSERT INTO `role_right` VALUES (208, 8, 30);
INSERT INTO `role_right` VALUES (209, 9, 16);
INSERT INTO `role_right` VALUES (210, 9, 17);
INSERT INTO `role_right` VALUES (211, 9, 18);
INSERT INTO `role_right` VALUES (212, 9, 19);
INSERT INTO `role_right` VALUES (213, 9, 20);
INSERT INTO `role_right` VALUES (214, 9, 21);
INSERT INTO `role_right` VALUES (215, 9, 22);
INSERT INTO `role_right` VALUES (216, 9, 23);
INSERT INTO `role_right` VALUES (217, 9, 24);
INSERT INTO `role_right` VALUES (218, 9, 25);
INSERT INTO `role_right` VALUES (219, 9, 26);
INSERT INTO `role_right` VALUES (220, 9, 27);
INSERT INTO `role_right` VALUES (221, 9, 28);
INSERT INTO `role_right` VALUES (222, 9, 29);
INSERT INTO `role_right` VALUES (223, 9, 30);
INSERT INTO `role_right` VALUES (224, 10, 16);
INSERT INTO `role_right` VALUES (225, 10, 17);
INSERT INTO `role_right` VALUES (226, 10, 18);
INSERT INTO `role_right` VALUES (227, 10, 19);
INSERT INTO `role_right` VALUES (228, 10, 20);
INSERT INTO `role_right` VALUES (229, 10, 21);
INSERT INTO `role_right` VALUES (230, 10, 22);
INSERT INTO `role_right` VALUES (231, 10, 23);
INSERT INTO `role_right` VALUES (232, 10, 24);
INSERT INTO `role_right` VALUES (233, 10, 25);
INSERT INTO `role_right` VALUES (234, 10, 26);
INSERT INTO `role_right` VALUES (235, 10, 27);
INSERT INTO `role_right` VALUES (236, 10, 28);
INSERT INTO `role_right` VALUES (237, 10, 29);
INSERT INTO `role_right` VALUES (238, 10, 30);
INSERT INTO `role_right` VALUES (239, 11, 1);
INSERT INTO `role_right` VALUES (240, 11, 2);
INSERT INTO `role_right` VALUES (241, 11, 3);
INSERT INTO `role_right` VALUES (242, 11, 4);
INSERT INTO `role_right` VALUES (243, 11, 5);
INSERT INTO `role_right` VALUES (244, 11, 6);
INSERT INTO `role_right` VALUES (245, 11, 7);
INSERT INTO `role_right` VALUES (246, 11, 8);
INSERT INTO `role_right` VALUES (247, 11, 9);
INSERT INTO `role_right` VALUES (248, 11, 10);
INSERT INTO `role_right` VALUES (249, 11, 11);
INSERT INTO `role_right` VALUES (250, 11, 12);
INSERT INTO `role_right` VALUES (251, 11, 13);
INSERT INTO `role_right` VALUES (252, 11, 14);
INSERT INTO `role_right` VALUES (253, 11, 15);
INSERT INTO `role_right` VALUES (254, 11, 16);
INSERT INTO `role_right` VALUES (255, 11, 17);
INSERT INTO `role_right` VALUES (256, 11, 18);
INSERT INTO `role_right` VALUES (257, 11, 19);
INSERT INTO `role_right` VALUES (258, 11, 20);
INSERT INTO `role_right` VALUES (259, 11, 21);
INSERT INTO `role_right` VALUES (260, 11, 22);
INSERT INTO `role_right` VALUES (261, 11, 23);
INSERT INTO `role_right` VALUES (262, 11, 24);
INSERT INTO `role_right` VALUES (263, 11, 25);
INSERT INTO `role_right` VALUES (264, 11, 26);
INSERT INTO `role_right` VALUES (265, 11, 27);
INSERT INTO `role_right` VALUES (266, 11, 28);
INSERT INTO `role_right` VALUES (267, 11, 29);
INSERT INTO `role_right` VALUES (268, 11, 30);
INSERT INTO `role_right` VALUES (269, 12, 1);
INSERT INTO `role_right` VALUES (270, 12, 2);
INSERT INTO `role_right` VALUES (271, 12, 3);
INSERT INTO `role_right` VALUES (272, 12, 4);
INSERT INTO `role_right` VALUES (273, 12, 5);
INSERT INTO `role_right` VALUES (274, 12, 6);
INSERT INTO `role_right` VALUES (275, 12, 7);
INSERT INTO `role_right` VALUES (276, 1, 31);
INSERT INTO `role_right` VALUES (277, 1, 32);
INSERT INTO `role_right` VALUES (278, 1, 33);
INSERT INTO `role_right` VALUES (279, 1, 34);
INSERT INTO `role_right` VALUES (280, 1, 35);
INSERT INTO `role_right` VALUES (281, 1, 36);
INSERT INTO `role_right` VALUES (282, 1, 37);
INSERT INTO `role_right` VALUES (283, 1, 38);
INSERT INTO `role_right` VALUES (284, 1, 39);
INSERT INTO `role_right` VALUES (285, 1, 40);
INSERT INTO `role_right` VALUES (286, 1, 41);
INSERT INTO `role_right` VALUES (287, 1, 42);
INSERT INTO `role_right` VALUES (288, 1, 43);
INSERT INTO `role_right` VALUES (289, 1, 44);
INSERT INTO `role_right` VALUES (290, 1, 45);
INSERT INTO `role_right` VALUES (291, 1, 46);
INSERT INTO `role_right` VALUES (292, 1, 47);
INSERT INTO `role_right` VALUES (293, 1, 48);
INSERT INTO `role_right` VALUES (294, 1, 49);
INSERT INTO `role_right` VALUES (295, 1, 50);
INSERT INTO `role_right` VALUES (296, 1, 51);
INSERT INTO `role_right` VALUES (297, 2, 31);
INSERT INTO `role_right` VALUES (298, 2, 32);
INSERT INTO `role_right` VALUES (299, 2, 33);
INSERT INTO `role_right` VALUES (300, 2, 34);
INSERT INTO `role_right` VALUES (301, 2, 35);
INSERT INTO `role_right` VALUES (302, 2, 36);
INSERT INTO `role_right` VALUES (303, 2, 37);
INSERT INTO `role_right` VALUES (304, 2, 38);
INSERT INTO `role_right` VALUES (305, 2, 39);
INSERT INTO `role_right` VALUES (306, 2, 40);
INSERT INTO `role_right` VALUES (307, 2, 41);
INSERT INTO `role_right` VALUES (308, 2, 42);
INSERT INTO `role_right` VALUES (309, 2, 43);
INSERT INTO `role_right` VALUES (310, 2, 44);
INSERT INTO `role_right` VALUES (311, 2, 45);
INSERT INTO `role_right` VALUES (312, 2, 46);
INSERT INTO `role_right` VALUES (313, 2, 47);
INSERT INTO `role_right` VALUES (314, 2, 48);
INSERT INTO `role_right` VALUES (315, 2, 49);
INSERT INTO `role_right` VALUES (316, 2, 50);
INSERT INTO `role_right` VALUES (317, 2, 51);
INSERT INTO `role_right` VALUES (318, 3, 31);
INSERT INTO `role_right` VALUES (319, 3, 32);
INSERT INTO `role_right` VALUES (320, 3, 33);
INSERT INTO `role_right` VALUES (321, 3, 34);
INSERT INTO `role_right` VALUES (322, 3, 35);
INSERT INTO `role_right` VALUES (323, 3, 36);
INSERT INTO `role_right` VALUES (324, 3, 37);
INSERT INTO `role_right` VALUES (325, 3, 38);
INSERT INTO `role_right` VALUES (326, 3, 39);
INSERT INTO `role_right` VALUES (327, 3, 40);
INSERT INTO `role_right` VALUES (328, 3, 41);
INSERT INTO `role_right` VALUES (329, 3, 42);
INSERT INTO `role_right` VALUES (330, 3, 43);
INSERT INTO `role_right` VALUES (331, 3, 44);
INSERT INTO `role_right` VALUES (332, 3, 45);
INSERT INTO `role_right` VALUES (333, 3, 46);
INSERT INTO `role_right` VALUES (334, 3, 47);
INSERT INTO `role_right` VALUES (335, 3, 48);
INSERT INTO `role_right` VALUES (336, 3, 49);
INSERT INTO `role_right` VALUES (337, 3, 50);
INSERT INTO `role_right` VALUES (338, 3, 51);
INSERT INTO `role_right` VALUES (339, 4, 31);
INSERT INTO `role_right` VALUES (340, 4, 32);
INSERT INTO `role_right` VALUES (341, 4, 33);
INSERT INTO `role_right` VALUES (342, 4, 34);
INSERT INTO `role_right` VALUES (343, 4, 35);
INSERT INTO `role_right` VALUES (344, 4, 36);
INSERT INTO `role_right` VALUES (345, 4, 37);
INSERT INTO `role_right` VALUES (346, 4, 38);
INSERT INTO `role_right` VALUES (347, 4, 39);
INSERT INTO `role_right` VALUES (348, 4, 40);
INSERT INTO `role_right` VALUES (349, 4, 41);
INSERT INTO `role_right` VALUES (350, 4, 42);
INSERT INTO `role_right` VALUES (351, 4, 43);
INSERT INTO `role_right` VALUES (352, 4, 44);
INSERT INTO `role_right` VALUES (353, 4, 45);
INSERT INTO `role_right` VALUES (354, 4, 46);
INSERT INTO `role_right` VALUES (355, 4, 47);
INSERT INTO `role_right` VALUES (356, 4, 48);
INSERT INTO `role_right` VALUES (357, 4, 49);
INSERT INTO `role_right` VALUES (358, 4, 50);
INSERT INTO `role_right` VALUES (359, 4, 51);
INSERT INTO `role_right` VALUES (360, 5, 31);
INSERT INTO `role_right` VALUES (361, 5, 32);
INSERT INTO `role_right` VALUES (362, 5, 33);
INSERT INTO `role_right` VALUES (363, 5, 34);
INSERT INTO `role_right` VALUES (364, 5, 35);
INSERT INTO `role_right` VALUES (365, 5, 36);
INSERT INTO `role_right` VALUES (366, 5, 37);
INSERT INTO `role_right` VALUES (367, 5, 38);
INSERT INTO `role_right` VALUES (368, 5, 39);
INSERT INTO `role_right` VALUES (369, 5, 40);
INSERT INTO `role_right` VALUES (370, 5, 41);
INSERT INTO `role_right` VALUES (371, 5, 42);
INSERT INTO `role_right` VALUES (372, 5, 43);
INSERT INTO `role_right` VALUES (373, 5, 44);
INSERT INTO `role_right` VALUES (374, 5, 45);
INSERT INTO `role_right` VALUES (375, 5, 46);
INSERT INTO `role_right` VALUES (376, 5, 47);
INSERT INTO `role_right` VALUES (377, 5, 48);
INSERT INTO `role_right` VALUES (378, 5, 49);
INSERT INTO `role_right` VALUES (379, 5, 50);
INSERT INTO `role_right` VALUES (380, 5, 51);
INSERT INTO `role_right` VALUES (381, 6, 31);
INSERT INTO `role_right` VALUES (382, 6, 32);
INSERT INTO `role_right` VALUES (383, 6, 33);
INSERT INTO `role_right` VALUES (384, 6, 34);
INSERT INTO `role_right` VALUES (385, 6, 35);
INSERT INTO `role_right` VALUES (386, 6, 36);
INSERT INTO `role_right` VALUES (387, 6, 37);
INSERT INTO `role_right` VALUES (388, 6, 38);
INSERT INTO `role_right` VALUES (389, 6, 39);
INSERT INTO `role_right` VALUES (390, 6, 40);
INSERT INTO `role_right` VALUES (391, 6, 41);
INSERT INTO `role_right` VALUES (392, 6, 42);
INSERT INTO `role_right` VALUES (393, 6, 43);
INSERT INTO `role_right` VALUES (394, 6, 44);
INSERT INTO `role_right` VALUES (395, 6, 45);
INSERT INTO `role_right` VALUES (396, 6, 46);
INSERT INTO `role_right` VALUES (397, 6, 47);
INSERT INTO `role_right` VALUES (398, 6, 48);
INSERT INTO `role_right` VALUES (399, 6, 49);
INSERT INTO `role_right` VALUES (400, 6, 50);
INSERT INTO `role_right` VALUES (401, 6, 51);
INSERT INTO `role_right` VALUES (402, 7, 31);
INSERT INTO `role_right` VALUES (403, 7, 32);
INSERT INTO `role_right` VALUES (404, 7, 33);
INSERT INTO `role_right` VALUES (405, 7, 34);
INSERT INTO `role_right` VALUES (406, 7, 35);
INSERT INTO `role_right` VALUES (407, 7, 36);
INSERT INTO `role_right` VALUES (408, 7, 37);
INSERT INTO `role_right` VALUES (409, 7, 38);
INSERT INTO `role_right` VALUES (410, 7, 39);
INSERT INTO `role_right` VALUES (411, 7, 40);
INSERT INTO `role_right` VALUES (412, 7, 41);
INSERT INTO `role_right` VALUES (413, 7, 42);
INSERT INTO `role_right` VALUES (414, 7, 43);
INSERT INTO `role_right` VALUES (415, 7, 44);
INSERT INTO `role_right` VALUES (416, 7, 45);
INSERT INTO `role_right` VALUES (417, 7, 46);
INSERT INTO `role_right` VALUES (418, 7, 47);
INSERT INTO `role_right` VALUES (419, 7, 48);
INSERT INTO `role_right` VALUES (420, 7, 49);
INSERT INTO `role_right` VALUES (421, 7, 50);
INSERT INTO `role_right` VALUES (422, 7, 51);
INSERT INTO `role_right` VALUES (423, 8, 31);
INSERT INTO `role_right` VALUES (424, 8, 32);
INSERT INTO `role_right` VALUES (425, 8, 33);
INSERT INTO `role_right` VALUES (426, 8, 34);
INSERT INTO `role_right` VALUES (427, 8, 35);
INSERT INTO `role_right` VALUES (428, 8, 36);
INSERT INTO `role_right` VALUES (429, 8, 37);
INSERT INTO `role_right` VALUES (430, 8, 38);
INSERT INTO `role_right` VALUES (431, 8, 39);
INSERT INTO `role_right` VALUES (432, 8, 40);
INSERT INTO `role_right` VALUES (433, 8, 41);
INSERT INTO `role_right` VALUES (434, 8, 42);
INSERT INTO `role_right` VALUES (435, 8, 43);
INSERT INTO `role_right` VALUES (436, 8, 44);
INSERT INTO `role_right` VALUES (437, 8, 45);
INSERT INTO `role_right` VALUES (438, 8, 46);
INSERT INTO `role_right` VALUES (439, 8, 47);
INSERT INTO `role_right` VALUES (440, 8, 48);
INSERT INTO `role_right` VALUES (441, 8, 49);
INSERT INTO `role_right` VALUES (442, 8, 50);
INSERT INTO `role_right` VALUES (443, 8, 51);
INSERT INTO `role_right` VALUES (444, 9, 31);
INSERT INTO `role_right` VALUES (445, 9, 32);
INSERT INTO `role_right` VALUES (446, 9, 33);
INSERT INTO `role_right` VALUES (447, 9, 34);
INSERT INTO `role_right` VALUES (448, 9, 35);
INSERT INTO `role_right` VALUES (449, 9, 36);
INSERT INTO `role_right` VALUES (450, 9, 37);
INSERT INTO `role_right` VALUES (451, 9, 38);
INSERT INTO `role_right` VALUES (452, 9, 39);
INSERT INTO `role_right` VALUES (453, 9, 40);
INSERT INTO `role_right` VALUES (454, 9, 41);
INSERT INTO `role_right` VALUES (455, 9, 42);
INSERT INTO `role_right` VALUES (456, 9, 43);
INSERT INTO `role_right` VALUES (457, 9, 44);
INSERT INTO `role_right` VALUES (458, 9, 45);
INSERT INTO `role_right` VALUES (459, 9, 46);
INSERT INTO `role_right` VALUES (460, 9, 47);
INSERT INTO `role_right` VALUES (461, 9, 48);
INSERT INTO `role_right` VALUES (462, 9, 49);
INSERT INTO `role_right` VALUES (463, 9, 50);
INSERT INTO `role_right` VALUES (464, 9, 51);
INSERT INTO `role_right` VALUES (465, 10, 31);
INSERT INTO `role_right` VALUES (466, 10, 32);
INSERT INTO `role_right` VALUES (467, 10, 33);
INSERT INTO `role_right` VALUES (468, 10, 34);
INSERT INTO `role_right` VALUES (469, 10, 35);
INSERT INTO `role_right` VALUES (470, 10, 36);
INSERT INTO `role_right` VALUES (471, 10, 37);
INSERT INTO `role_right` VALUES (472, 10, 38);
INSERT INTO `role_right` VALUES (473, 10, 39);
INSERT INTO `role_right` VALUES (474, 10, 40);
INSERT INTO `role_right` VALUES (475, 10, 41);
INSERT INTO `role_right` VALUES (476, 10, 42);
INSERT INTO `role_right` VALUES (477, 10, 43);
INSERT INTO `role_right` VALUES (478, 10, 44);
INSERT INTO `role_right` VALUES (479, 10, 45);
INSERT INTO `role_right` VALUES (480, 10, 46);
INSERT INTO `role_right` VALUES (481, 10, 47);
INSERT INTO `role_right` VALUES (482, 10, 48);
INSERT INTO `role_right` VALUES (483, 10, 49);
INSERT INTO `role_right` VALUES (484, 10, 50);
INSERT INTO `role_right` VALUES (485, 10, 51);
INSERT INTO `role_right` VALUES (486, 11, 31);
INSERT INTO `role_right` VALUES (487, 11, 32);
INSERT INTO `role_right` VALUES (488, 11, 33);
INSERT INTO `role_right` VALUES (489, 11, 34);
INSERT INTO `role_right` VALUES (490, 11, 35);
INSERT INTO `role_right` VALUES (491, 11, 36);
INSERT INTO `role_right` VALUES (492, 11, 37);
INSERT INTO `role_right` VALUES (493, 11, 38);
INSERT INTO `role_right` VALUES (494, 11, 39);
INSERT INTO `role_right` VALUES (495, 11, 40);
INSERT INTO `role_right` VALUES (496, 11, 41);
INSERT INTO `role_right` VALUES (497, 11, 42);
INSERT INTO `role_right` VALUES (498, 11, 43);
INSERT INTO `role_right` VALUES (499, 11, 44);
INSERT INTO `role_right` VALUES (500, 11, 45);
INSERT INTO `role_right` VALUES (501, 11, 46);
INSERT INTO `role_right` VALUES (502, 11, 47);
INSERT INTO `role_right` VALUES (503, 11, 48);
INSERT INTO `role_right` VALUES (504, 11, 49);
INSERT INTO `role_right` VALUES (505, 11, 50);
INSERT INTO `role_right` VALUES (506, 11, 51);
INSERT INTO `role_right` VALUES (507, 1, 52);
INSERT INTO `role_right` VALUES (508, 1, 54);

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_id` int(10) NOT NULL,
  `score` int(10) NOT NULL,
  `del` int(10) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (1, '2016901147', 1, 90, 0);
INSERT INTO `score` VALUES (2, '2016901147', 2, 90, 0);
INSERT INTO `score` VALUES (3, '2016901135', 1, 89, 0);
INSERT INTO `score` VALUES (4, '2016901135', 2, 90, 0);
INSERT INTO `score` VALUES (5, '2016901133', 1, 58, 0);
INSERT INTO `score` VALUES (6, '2016901133', 3, 89, 0);
INSERT INTO `score` VALUES (7, '2016901147', 3, 90, 0);
INSERT INTO `score` VALUES (8, '2016901147', 5, 96, 0);
INSERT INTO `score` VALUES (9, '2016901135', 5, 95, 0);
INSERT INTO `score` VALUES (10, '2016901133', 6, 94, 0);

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `alias` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` int(10) NULL DEFAULT NULL,
  `del` int(10) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (1, 'moral', '思想品德', 0, 0);
INSERT INTO `type` VALUES (2, 'express', '政治思想表现', 1, 0);
INSERT INTO `type` VALUES (3, 'attitude', '学习态度', 1, 0);
INSERT INTO `type` VALUES (4, 'politeness', '文明礼貌', 1, 0);
INSERT INTO `type` VALUES (5, 'discipline', '纪律观念', 1, 0);
INSERT INTO `type` VALUES (6, 'reward', '奖惩分', 1, 0);
INSERT INTO `type` VALUES (7, 'health', '卫生体育', 0, 0);
INSERT INTO `type` VALUES (8, 'physique', '身体健康状况', 7, 0);
INSERT INTO `type` VALUES (9, 'hygiene', '卫生情况', 7, 0);
INSERT INTO `type` VALUES (10, 'exercise', '锻炼情况', 7, 0);
INSERT INTO `type` VALUES (11, 'labour', '劳动情况', 7, 0);
INSERT INTO `type` VALUES (12, 'reward', '奖惩分', 7, 0);
INSERT INTO `type` VALUES (13, 'capacity', '个人能力', 0, 0);
INSERT INTO `type` VALUES (14, 'basic', '基本分', 13, 0);
INSERT INTO `type` VALUES (15, 'reward', '奖惩分', 13, 0);
INSERT INTO `type` VALUES (16, 'test', '测试分类', 0, 1);
INSERT INTO `type` VALUES (17, 'test', '测试数据', 0, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `qq` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `signature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(1) NULL DEFAULT NULL,
  `del` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`sno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2016901115', '曹德飞', '2fe91c4101826c332d299673bc207c6a', NULL, '女', '2020-02-13 12:39:00', NULL, NULL, NULL, 1, 0);
INSERT INTO `user` VALUES ('2016901127', '张秋凤', '35318cc37ea7c3e38593f3e05a028fb6', NULL, '女', '2020-02-21 17:23:03', NULL, NULL, NULL, 1, 0);
INSERT INTO `user` VALUES ('2016901128', '崔明文', 'd5fe0410b18226f5d11cc23dd62afae8', NULL, '男', '2020-02-18 23:15:35', NULL, NULL, NULL, 1, 0);
INSERT INTO `user` VALUES ('2016901130', '舒凌霄', '230a4ebb56f41f023c320612c5220fb5', NULL, '男', '2020-02-18 23:09:14', NULL, 'null', NULL, 1, 0);
INSERT INTO `user` VALUES ('2016901133', '高显欢', '1145fd197264a108cc1110c5eebc98b6', '18946842584', '男', '2020-02-13 13:56:53', '4561245', 'null', '', 1, 0);
INSERT INTO `user` VALUES ('2016901135', '易俊涛', '242fbf785ff0fe73861c54c085318a68', NULL, '男', '2020-02-13 13:56:48', NULL, 'null', '', 1, 0);
INSERT INTO `user` VALUES ('2016901136', '张乘瑞', '38535aaf61f37ecc0d04e46796d5d13b', NULL, '男', '2020-02-13 14:00:27', NULL, 'null', NULL, 1, 0);
INSERT INTO `user` VALUES ('2016901138', '张越', '66bace8aa1f3901d6db99e305fe09dfd', NULL, '男', '2020-02-13 13:57:24', NULL, 'null', NULL, 1, 0);
INSERT INTO `user` VALUES ('2016901141', '张海龙', 'de61431d9dd22127ce8dcb1ad0f3d5a2', NULL, '男', '2020-02-13 13:57:28', NULL, NULL, NULL, 1, 0);
INSERT INTO `user` VALUES ('2016901143', '罗银卫', '9391d0f0d3be894c9b62a3fac6ff193e', NULL, '男', '2020-02-18 23:06:45', NULL, 'null', NULL, 1, 0);
INSERT INTO `user` VALUES ('2016901147', '何劲', 'efb35e2e43d8f9806cb302403043534b', '18760765207', '男', '1998-02-09 17:00:33', '1614523908', '123.jpg', '我是何劲', 1, 0);
INSERT INTO `user` VALUES ('2016901148', '于昌国', 'e41386836a490eb7daa7024b8b240d6e', NULL, '男', '2020-03-16 21:43:47', NULL, NULL, NULL, 1, 0);
INSERT INTO `user` VALUES ('2016901150', '余海兴', '7748aabeaa93a74b0930ef9c7805ae5e', NULL, '男', '2020-03-16 22:28:07', NULL, NULL, NULL, 1, 0);
INSERT INTO `user` VALUES ('admin', '超级管理员', 'aa667daa9730e7609ef14f6d7dc55522', '18760765207', '男', '1998-02-09 17:00:33', '1614523908', '123.jpg', '我是超级管理员', 1, 0);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_sno` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_id` int(10) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `del` int(10) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 'admin', 1, '2020-02-05 09:49:28', 0);
INSERT INTO `user_role` VALUES (2, '2016901138', 2, '2020-03-04 09:49:43', 0);
INSERT INTO `user_role` VALUES (3, '2016901147', 9, '2020-03-17 11:12:17', 0);
INSERT INTO `user_role` VALUES (4, '2016901148', 4, '2020-02-25 09:49:54', 0);
INSERT INTO `user_role` VALUES (5, '2016901115', 6, '2020-03-05 09:49:59', 0);
INSERT INTO `user_role` VALUES (6, '2016901127', 12, '2020-03-13 09:50:03', 0);
INSERT INTO `user_role` VALUES (7, '2016901128', 12, '2020-03-01 09:50:08', 0);
INSERT INTO `user_role` VALUES (8, '2016901130', 12, '2020-03-17 12:58:42', 0);
INSERT INTO `user_role` VALUES (9, '2016901133', 12, '2020-02-29 09:50:18', 0);
INSERT INTO `user_role` VALUES (10, '2016901135', 12, '2020-03-11 09:50:21', 0);
INSERT INTO `user_role` VALUES (11, '2016901136', 12, '2020-03-04 09:50:26', 0);
INSERT INTO `user_role` VALUES (12, '2016901141', 12, '2020-03-04 09:50:35', 0);
INSERT INTO `user_role` VALUES (13, '2016901143', 12, '2020-03-05 09:50:30', 0);
INSERT INTO `user_role` VALUES (16, '2016901150', 8, '2020-03-17 10:13:03', 0);

SET FOREIGN_KEY_CHECKS = 1;
