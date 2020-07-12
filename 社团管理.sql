/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : 社团管理

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 12/07/2020 15:57:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `activityId` int(11) NOT NULL AUTO_INCREMENT,
  `activityRange` varchar(255) NOT NULL,
  `activityName` varchar(255) NOT NULL,
  `activityIntroduction` varchar(255) NOT NULL,
  `activityStartTime` datetime NOT NULL,
  `activityEndTime` datetime NOT NULL,
  `activityReleaseTime` datetime NOT NULL,
  `activityDeadLine` datetime NOT NULL,
  `activityPalce` int(11) NOT NULL,
  `associationsId` int(11) NOT NULL,
  `departmentId` int(11) NOT NULL,
  `activitiesApplicationTime` datetime NOT NULL,
  `activitiesApplicationState` varchar(255) NOT NULL,
  PRIMARY KEY (`activityId`),
  KEY `departmentId` (`departmentId`),
  KEY `associationsId` (`associationsId`),
  KEY `activityPalce` (`activityPalce`),
  CONSTRAINT `activity_ibfk_1` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`),
  CONSTRAINT `activity_ibfk_2` FOREIGN KEY (`associationsId`) REFERENCES `associations` (`associationsId`),
  CONSTRAINT `activity_ibfk_3` FOREIGN KEY (`activityPalce`) REFERENCES `palce` (`palceId`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
BEGIN;
INSERT INTO `activity` VALUES (27, '全校', '下周打篮球比赛', '来来来', '2020-06-04 00:00:00', '2020-06-08 00:00:00', '2020-06-01 20:25:17', '2020-06-02 00:00:00', 2, 25, 999999, '2020-06-01 20:16:31', '审核通过');
INSERT INTO `activity` VALUES (28, '社团', '篮球社开会', '来', '2020-06-04 00:00:00', '2020-06-08 00:00:00', '2020-06-01 20:17:18', '2020-06-02 00:00:00', 5, 25, 999999, '2020-06-01 20:17:18', '审核通过');
INSERT INTO `activity` VALUES (29, '社团', '操场跑步', '来', '2020-06-04 00:00:00', '2020-06-08 00:00:00', '2020-06-01 20:19:52', '2020-06-02 00:00:00', 3, 25, 999999, '2020-06-01 20:19:52', '审核通过');
INSERT INTO `activity` VALUES (30, '社团', '聚餐', '聚餐,是最容易促进社团成员彼此之间的感情的一个契机,通过聚餐来拉近彼此的距离,加强沟通。下周一的聚餐，请大家积极参加。', '2020-06-10 00:00:00', '2020-06-11 00:00:00', '2020-06-01 23:18:24', '2020-06-08 00:00:00', 1, 27, 999999, '2020-06-01 23:18:24', '审核通过');
INSERT INTO `activity` VALUES (31, '全校', '演讲', '目的：推广电竞活动。\n时间：2020.6.29 \n地点：风雨操场', '2020-06-28 00:00:00', '2020-06-29 00:00:00', '2020-06-01 23:20:12', '2020-06-25 00:00:00', 4, 27, 999999, '2020-06-01 23:20:12', '审核拒绝');
INSERT INTO `activity` VALUES (32, '全校', '爱心募捐', '为山区留守儿童献爱心。', '2020-06-04 00:00:00', '2020-06-13 00:00:00', '2020-06-03 15:09:39', '2020-06-03 00:00:00', 4, 30, 999999, '2020-06-03 15:04:28', '审核通过');
INSERT INTO `activity` VALUES (33, '全校', '花式篮球', '花式篮球大赛开始啦，奖励多多！', '2020-06-06 00:00:00', '2020-06-10 00:00:00', '2020-06-03 15:24:19', '2020-06-06 00:00:00', 6, 25, 999999, '2020-06-03 15:24:19', '等待审核');
INSERT INTO `activity` VALUES (35, '全校', '植树', '绿化校园', '2020-06-03 23:40:15', '2020-06-10 15:40:23', '2020-06-03 15:45:07', '2020-06-03 22:40:06', 7, 30, 999999, '2020-06-03 15:45:07', '等待审核');
INSERT INTO `activity` VALUES (36, '全校', '第一次心理讲座', '三天后教3心理讲座， 欢迎大家报名', '2020-06-07 22:48:17', '2020-06-11 22:48:20', '2020-06-04 22:48:50', '2020-06-05 22:48:22', 8, 34, 999999, '2020-06-04 22:48:50', '等待审核');
INSERT INTO `activity` VALUES (37, '全校', '篮球比赛', '篮球比赛', '2020-06-08 09:15:23', '2020-06-12 09:15:06', '2020-06-05 09:15:55', '2020-06-06 09:15:25', 6, 25, 999999, '2020-06-05 09:15:34', '审核通过');
COMMIT;

-- ----------------------------
-- Table structure for activitysign
-- ----------------------------
DROP TABLE IF EXISTS `activitysign`;
CREATE TABLE `activitysign` (
  `activitySignId` int(11) NOT NULL AUTO_INCREMENT,
  `studentSignTime` datetime NOT NULL,
  `activitySignState` varchar(255) NOT NULL,
  `userId` varchar(255) NOT NULL,
  `activityId` int(11) NOT NULL,
  PRIMARY KEY (`activitySignId`),
  KEY `userId` (`userId`),
  KEY `activityId` (`activityId`),
  CONSTRAINT `activitysign_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  CONSTRAINT `activitysign_ibfk_2` FOREIGN KEY (`activityId`) REFERENCES `activity` (`activityId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activitysign
-- ----------------------------
BEGIN;
INSERT INTO `activitysign` VALUES (6, '2020-06-01 20:20:51', '审核通过', '31701055', 28);
INSERT INTO `activitysign` VALUES (7, '2020-06-01 23:55:32', '审核通过', '31701053', 27);
INSERT INTO `activitysign` VALUES (8, '2020-06-01 23:59:44', '审核通过', '31701268', 27);
INSERT INTO `activitysign` VALUES (9, '2020-06-05 09:16:33', '审核通过', '31701099', 37);
COMMIT;

-- ----------------------------
-- Table structure for associations
-- ----------------------------
DROP TABLE IF EXISTS `associations`;
CREATE TABLE `associations` (
  `associationsId` int(11) NOT NULL AUTO_INCREMENT,
  `associationsName` varchar(255) NOT NULL,
  `associationsTime` datetime NOT NULL,
  `associationsType` varchar(255) NOT NULL,
  `associationsIntroduction` varchar(255) NOT NULL,
  `associationsNumber` int(11) NOT NULL,
  `associationsLeader` varchar(255) NOT NULL,
  `associationsApplicationTime` datetime NOT NULL,
  `associationsApplicationState` varchar(255) NOT NULL,
  PRIMARY KEY (`associationsId`),
  KEY `associationsLeader` (`associationsLeader`),
  CONSTRAINT `associations_ibfk_1` FOREIGN KEY (`associationsLeader`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of associations
-- ----------------------------
BEGIN;
INSERT INTO `associations` VALUES (0, '管理员', '2019-12-16 19:32:16', '0', '0', 0, '0', '2019-12-16 19:32:27', '0');
INSERT INTO `associations` VALUES (25, '篮球社', '2020-06-01 17:41:47', '体育类', '篮球（basketball），是奥运会核心比赛项目，是以手为中心的身体对抗性体育运动。篮球运动是1891年由美国人詹姆斯·奈史密斯发明的。当时，他在马萨诸塞州斯普林菲尔德基督教青年会国际训练学校任教。由于当地盛产桃子，这里的儿童又非常喜欢玩将球投入桃子筐的游戏。这使他从中得到启发，并博采足球、曲棍球等其他球类项目的特点，创编了篮球游戏。', 2, '31701055', '2020-06-01 17:40:14', '审核通过');
INSERT INTO `associations` VALUES (26, '学习会', '2020-06-01 17:41:50', '学术类', '学习，是指通过阅读、听讲、思考、研究、实践等途径获得知识和技能的过程。学习分为狭义与广义两种：\n狭义：通过阅读、听讲、研究、观察、理解、探索、实验、实践等手段获得知识或技能的过程，是一种使个体可以得到持续变化（知识和技能，方法与过程，情感与价值的改善和升华）的行为方式。例如通过学校教育获得知识的过程。\n广义：是人在生活过程中，通过获得经验而产生的行为或行为潜能的相对持久的行为方式。', 1, '31701055', '2020-06-01 17:41:29', '审核通过');
INSERT INTO `associations` VALUES (27, '电竞社', '2020-06-01 23:08:43', '体育类', '电子竞技（Electronic Sports）是电子游戏比赛达到“竞技”层面的体育项目。电子竞技运动就是利用电子设备作为运动器械进行的、人与人之间的智力对抗运动。通过运动，可以锻炼和提高参与者的思维能力、反应能力、四肢协调能力和意志力，培养团队精神。电子竞技也是一种职业，和棋艺等非电子游戏比赛类似。', 1, '31701058', '2020-06-01 23:04:57', '审核通过');
INSERT INTO `associations` VALUES (28, '轮滑团', '2020-06-03 13:50:22', '体育类', '轮滑（Roller skating），有很多汉化版本叫法，如旱冰、溜冰、滑冰、滚轴溜冰，但是到现在，统一叫轮滑，但并不否定之前的叫法，因为这些都是正确的。\n轮滑是很棒的代步工具，如果选对了类型，双排轮滑（quad roller skating）和单排轮滑（inline roller skating）都是可以刷街的，但是双排轮滑轮子直径较小，而且硬度高，对路面的容忍度较差，想要舒服的刷街需要换专门的', 1, '31701058', '2020-06-01 23:05:35', '审核通过');
INSERT INTO `associations` VALUES (29, 'Google', '2020-06-03 13:50:23', '科技类', 'Google实验室', 1, '31701268', '2020-06-01 23:59:14', '审核通过');
INSERT INTO `associations` VALUES (30, '公益爱心', '2020-06-03 13:50:26', '公益类', '爱心社团是表现爱心的一种介质,尤其是在大学里能够培养大学生的良好的素质,培养个人的良好习惯,尤其是培养责任心的一个组织。', 1, '31701053', '2020-06-03 13:47:57', '审核通过');
INSERT INTO `associations` VALUES (31, '高数协会', '2020-06-03 13:50:25', '学术类', '作为一门基础科学，高等数学有其固有的特点，这就是高度的抽象性、严密的逻辑性和广泛的应用性。', 1, '31701057', '2020-06-03 13:50:06', '审核通过');
INSERT INTO `associations` VALUES (32, '吉他社', '2020-06-03 15:35:05', '艺术类', '吉他（意大利语：Chitarra），又译为结他或六弦琴。是一种弹拨乐器，通常有六条弦，形状与提琴相似。\n吉他在流行音乐、摇滚音乐、蓝调、民歌、佛朗明哥中，常被视为主要乐器。而在古典音乐的领域里，吉他常以独奏或二重奏的型式演出；当然，在室内乐和管弦乐中，吉他亦扮演着相当程度的陪衬角色。\n古典吉他与小提琴、钢琴并列为世界著名三大乐器。', 1, '31701051', '2020-06-03 15:14:51', '审核通过');
INSERT INTO `associations` VALUES (33, '网球社', '2020-06-03 15:45:34', '体育类', '网球运动是一种球类运动，通常在两个单打球员或两对组合之间进行。球员在网球场上隔着球网用网球拍击打网球。网球运动的由来和发展可以用四句话来概括：孕育在法国，诞生在英国，开始普及和形成高潮在美国，盛行全世界，被称为世界第二大球。', 1, '31701053', '2020-06-03 15:37:31', '审核通过');
INSERT INTO `associations` VALUES (34, '心理协会', '2020-06-04 22:45:57', '公益类', '关注心理问题， 培养良好心态', 1, '31701099', '2020-06-04 22:45:06', '审核通过');
COMMIT;

-- ----------------------------
-- Table structure for collectpost
-- ----------------------------
DROP TABLE IF EXISTS `collectpost`;
CREATE TABLE `collectpost` (
  `collectPostId` int(11) NOT NULL AUTO_INCREMENT,
  `collectPostTime` datetime NOT NULL,
  `subjectPostId` int(11) NOT NULL,
  `userId` varchar(255) NOT NULL,
  PRIMARY KEY (`collectPostId`),
  KEY `subjectPostId` (`subjectPostId`),
  KEY `userId` (`userId`),
  CONSTRAINT `collectpost_ibfk_1` FOREIGN KEY (`subjectPostId`) REFERENCES `subjectpost` (`subjectPostId`),
  CONSTRAINT `collectpost_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `departmentId` int(11) NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(255) NOT NULL,
  `departmentLeader` varchar(255) NOT NULL,
  `associationsId` int(11) NOT NULL,
  PRIMARY KEY (`departmentId`),
  KEY `departmentLeader` (`departmentLeader`),
  KEY `associationsId` (`associationsId`),
  CONSTRAINT `department_ibfk_1` FOREIGN KEY (`departmentLeader`) REFERENCES `user` (`userId`),
  CONSTRAINT `department_ibfk_2` FOREIGN KEY (`associationsId`) REFERENCES `associations` (`associationsId`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
BEGIN;
INSERT INTO `department` VALUES (1, '0', '0', 0);
INSERT INTO `department` VALUES (999999, '管理员', '0', 0);
COMMIT;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `logId` int(11) NOT NULL AUTO_INCREMENT,
  `logName` varchar(255) NOT NULL,
  `userId` varchar(255) NOT NULL,
  PRIMARY KEY (`logId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `managerId` varchar(255) NOT NULL,
  `managerPwd` varchar(255) NOT NULL,
  `managerName` varchar(255) NOT NULL,
  `managerPalce` varchar(255) NOT NULL,
  `managerTel` varchar(255) NOT NULL,
  PRIMARY KEY (`managerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
BEGIN;
INSERT INTO `manager` VALUES ('0', '1962aadacbef2272bcfbcc42edc662c8', '0', '0', '0');
COMMIT;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `memberId` int(11) NOT NULL AUTO_INCREMENT,
  `memberPost` varchar(255) NOT NULL,
  `memberTime` datetime NOT NULL,
  `memberIntroduction` varchar(255) NOT NULL,
  `userId` varchar(255) NOT NULL,
  `associationsId` int(11) NOT NULL,
  `departmentId` int(11) NOT NULL,
  PRIMARY KEY (`memberId`),
  KEY `userId` (`userId`),
  KEY `associationsId` (`associationsId`),
  KEY `departmentId` (`departmentId`),
  CONSTRAINT `member_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  CONSTRAINT `member_ibfk_2` FOREIGN KEY (`associationsId`) REFERENCES `associations` (`associationsId`),
  CONSTRAINT `member_ibfk_3` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
BEGIN;
INSERT INTO `member` VALUES (14, '社长', '2020-06-01 17:41:47', 'Leader', '31701055', 25, 999999);
INSERT INTO `member` VALUES (15, '社长', '2020-06-01 17:41:50', 'Leader', '31701055', 26, 999999);
INSERT INTO `member` VALUES (16, '社员', '2020-06-01 20:26:30', '这是个人介绍', '31701056', 25, 999999);
INSERT INTO `member` VALUES (17, '社长', '2020-06-01 23:08:43', 'Leader', '31701058', 27, 999999);
INSERT INTO `member` VALUES (18, '社长', '2020-06-03 13:50:22', 'Leader', '31701058', 28, 999999);
INSERT INTO `member` VALUES (19, '社长', '2020-06-03 13:50:23', 'Leader', '31701268', 29, 999999);
INSERT INTO `member` VALUES (20, '社长', '2020-06-03 13:50:25', 'Leader', '31701057', 31, 999999);
INSERT INTO `member` VALUES (21, '社长', '2020-06-03 13:50:26', 'Leader', '31701053', 30, 999999);
INSERT INTO `member` VALUES (22, '社长', '2020-06-03 15:26:12', 'Leader', '31701051', 32, 999999);
INSERT INTO `member` VALUES (27, '社长', '2020-06-03 15:45:34', 'Leader', '31701053', 33, 999999);
INSERT INTO `member` VALUES (28, '社长', '2020-06-04 22:45:57', 'Leader', '31701099', 34, 999999);
COMMIT;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `noticeId` int(11) NOT NULL AUTO_INCREMENT,
  `noticeRange` varchar(255) NOT NULL,
  `noticeName` varchar(255) NOT NULL,
  `noticeContent` varchar(255) NOT NULL,
  `noticeTime` datetime NOT NULL,
  `associationsId` int(11) NOT NULL,
  `departmentId` int(11) NOT NULL,
  `noticeState` varchar(255) NOT NULL,
  PRIMARY KEY (`noticeId`),
  KEY `departmentId` (`departmentId`),
  KEY `associationsId` (`associationsId`),
  CONSTRAINT `notice_ibfk_1` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`),
  CONSTRAINT `notice_ibfk_2` FOREIGN KEY (`associationsId`) REFERENCES `associations` (`associationsId`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
BEGIN;
INSERT INTO `notice` VALUES (49, '全校', '篮球社明天招新', '篮球社明天招新， 来来来', '2020-06-01 17:51:05', 25, 999999, '审核通过');
INSERT INTO `notice` VALUES (50, '全社', '篮球社内部聚餐', '来来来', '2020-06-01 20:04:43', 25, 999999, '审核通过');
INSERT INTO `notice` VALUES (51, '全校', '系统维护', '今晚系统维护， 9-10点', '2020-06-01 20:25:43', 0, 999999, '审核通过');
INSERT INTO `notice` VALUES (52, '全社', '即将举行社长选举', '我们社团即将举行社长选举，时间预计为半个月后，具体时间另行通知，请有意向的社员做好充足准备。', '2020-06-01 23:16:10', 27, 999999, '审核通过');
INSERT INTO `notice` VALUES (53, '全校', '失物招领', '有一同学在教三，捡到一个棕色钱包。请速来认领。', '2020-06-01 23:24:36', 27, 999999, '审核通过');
INSERT INTO `notice` VALUES (54, '全校', '疫情防控', '请同学们自觉佩戴控制，勤洗手，勤通风，做好疫情防控措施。', '2020-06-03 13:52:03', 0, 999999, '审核通过');
INSERT INTO `notice` VALUES (55, '全社', 'Google融资', 'Google融资成功', '2020-06-03 15:10:23', 29, 999999, '审核通过');
INSERT INTO `notice` VALUES (56, '全校', '学习会开始招新', '学习会开始招新', '2020-06-03 15:25:49', 26, 999999, '等待审核');
INSERT INTO `notice` VALUES (57, '全校', '下周数学讲座', '下周数学讲座， 有二课分', '2020-06-04 22:46:42', 0, 999999, '审核通过');
INSERT INTO `notice` VALUES (58, '全校', '心理社创建', '心理社正式成立，欢迎大家踊跃报名', '2020-06-04 22:47:54', 34, 999999, '审核拒绝');
INSERT INTO `notice` VALUES (59, '全校', '心理社创建', '心理社创建， 欢迎大叫报名', '2020-06-04 22:49:56', 34, 999999, '审核通过');
COMMIT;

-- ----------------------------
-- Table structure for palce
-- ----------------------------
DROP TABLE IF EXISTS `palce`;
CREATE TABLE `palce` (
  `palceId` int(11) NOT NULL AUTO_INCREMENT,
  `palceName` varchar(255) NOT NULL,
  `palceState` varchar(255) NOT NULL,
  PRIMARY KEY (`palceId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of palce
-- ----------------------------
BEGIN;
INSERT INTO `palce` VALUES (1, '理四1楼大教室', '室内');
INSERT INTO `palce` VALUES (2, '南校操场', '室外');
INSERT INTO `palce` VALUES (3, '北校操场', '室外');
INSERT INTO `palce` VALUES (4, '风雨操场', '室内');
INSERT INTO `palce` VALUES (5, '科技楼', '室内');
INSERT INTO `palce` VALUES (6, '篮球场', '室外');
INSERT INTO `palce` VALUES (7, '网球场', '室外');
INSERT INTO `palce` VALUES (8, '教3', '室内');
INSERT INTO `palce` VALUES (9, '教5', '室内');
COMMIT;

-- ----------------------------
-- Table structure for recruitnotice
-- ----------------------------
DROP TABLE IF EXISTS `recruitnotice`;
CREATE TABLE `recruitnotice` (
  `recruitNoticeId` int(11) NOT NULL AUTO_INCREMENT,
  `recruitNoticeContent` varchar(255) NOT NULL,
  `recruitNoticeStartTime` datetime NOT NULL,
  `recruitNoticeEndTime` datetime NOT NULL,
  `recruitNoticeReleaseTime` datetime NOT NULL,
  `associationsId` int(11) NOT NULL,
  PRIMARY KEY (`recruitNoticeId`),
  KEY `associationsId` (`associationsId`),
  CONSTRAINT `recruitnotice_ibfk_1` FOREIGN KEY (`associationsId`) REFERENCES `associations` (`associationsId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recruitnotice
-- ----------------------------
BEGIN;
INSERT INTO `recruitnotice` VALUES (5, '篮球社招新', '2020-06-02 00:00:00', '2020-06-04 00:00:00', '2020-06-01 17:50:32', 25);
INSERT INTO `recruitnotice` VALUES (6, '电竞社，气氛活跃，活动丰富，期待大家加入！', '2020-06-01 00:00:00', '2020-06-04 00:00:00', '2020-06-01 23:22:27', 27);
INSERT INTO `recruitnotice` VALUES (7, 'google实验室期待你的加入。', '2020-06-04 00:00:00', '2020-06-10 00:00:00', '2020-06-03 15:11:27', 29);
INSERT INTO `recruitnotice` VALUES (8, '这里是高数协会，新的一学期开学啦，高数社团欢迎大家成为湖北三峡职业技术学院的大一新生，这里是你的始点，更是你的出发点，坚持心中的微光，梦想将在这里起航。你们拥有学姐学长们的耐心教导，不仅是学习，为人处事。高数协会拥有分丰富多彩的社团活动，让你享受学习以外的快乐。', '2020-06-04 00:00:00', '2020-06-06 00:00:00', '2020-06-03 15:12:56', 31);
INSERT INTO `recruitnotice` VALUES (9, '在这里，你可以畅所欲言，结交新友，取长补短。期待你的加入。', '2020-06-04 00:00:00', '2020-06-10 00:00:00', '2020-06-03 15:25:12', 26);
INSERT INTO `recruitnotice` VALUES (10, '寻找你的音乐梦', '2020-06-03 00:00:00', '2020-06-10 00:00:00', '2020-06-03 15:49:03', 32);
INSERT INTO `recruitnotice` VALUES (11, '心理社招生， 欢迎大家报名', '2020-06-07 00:00:00', '2020-06-11 00:00:00', '2020-06-04 22:51:11', 34);
COMMIT;

-- ----------------------------
-- Table structure for recruitsign
-- ----------------------------
DROP TABLE IF EXISTS `recruitsign`;
CREATE TABLE `recruitsign` (
  `recruitSignId` int(11) NOT NULL AUTO_INCREMENT,
  `recruitSignTime` datetime NOT NULL,
  `userId` varchar(255) NOT NULL,
  `associationsId` int(11) NOT NULL,
  `recruitSignContent` varchar(255) NOT NULL,
  `recruitSignApplicationState` varchar(255) NOT NULL,
  PRIMARY KEY (`recruitSignId`),
  KEY `userId` (`userId`),
  KEY `associationsId` (`associationsId`),
  CONSTRAINT `recruitsign_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  CONSTRAINT `recruitsign_ibfk_2` FOREIGN KEY (`associationsId`) REFERENCES `associations` (`associationsId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recruitsign
-- ----------------------------
BEGIN;
INSERT INTO `recruitsign` VALUES (3, '2020-06-01 20:24:23', '31701056', 25, '这是个人介绍', '审核通过');
INSERT INTO `recruitsign` VALUES (4, '2020-06-01 23:03:23', '31701058', 25, '这是个人介绍', '等待审核');
INSERT INTO `recruitsign` VALUES (6, '2020-06-01 23:31:28', '31701053', 27, '这是个人介绍', '等待审核');
INSERT INTO `recruitsign` VALUES (7, '2020-06-03 13:45:16', '31701055', 27, '我想入社', '等待审核');
INSERT INTO `recruitsign` VALUES (8, '2020-06-03 15:49:23', '31701051', 25, '这是个人介绍', '等待审核');
INSERT INTO `recruitsign` VALUES (10, '2020-06-04 22:44:00', '31701099', 31, '这是个人介绍', '等待审核');
INSERT INTO `recruitsign` VALUES (11, '2020-06-05 09:12:53', '31701055', 29, '我想入社', '等待审核');
INSERT INTO `recruitsign` VALUES (12, '2020-06-05 09:13:00', '31701055', 31, '我想入社', '等待审核');
COMMIT;

-- ----------------------------
-- Table structure for replaytpost
-- ----------------------------
DROP TABLE IF EXISTS `replaytpost`;
CREATE TABLE `replaytpost` (
  `replayPostId` int(11) NOT NULL AUTO_INCREMENT,
  `replayPostContent` varchar(255) NOT NULL,
  `replayPostTime` datetime NOT NULL,
  `likeNum` int(11) NOT NULL,
  `subjectPostId` int(11) NOT NULL,
  `userId` varchar(255) NOT NULL,
  PRIMARY KEY (`replayPostId`),
  KEY `subjectPostId` (`subjectPostId`),
  KEY `userId` (`userId`),
  CONSTRAINT `replaytpost_ibfk_1` FOREIGN KEY (`subjectPostId`) REFERENCES `subjectpost` (`subjectPostId`),
  CONSTRAINT `replaytpost_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for subjectpost
-- ----------------------------
DROP TABLE IF EXISTS `subjectpost`;
CREATE TABLE `subjectpost` (
  `subjectPostId` int(11) NOT NULL AUTO_INCREMENT,
  `subjectPostTitle` varchar(255) NOT NULL,
  `subjectPostContent` varchar(255) NOT NULL,
  `subjectPostTime` datetime NOT NULL,
  `collectNum` int(11) NOT NULL,
  `lookNum` int(11) NOT NULL,
  `userId` varchar(255) NOT NULL,
  PRIMARY KEY (`subjectPostId`),
  KEY `userId` (`userId`),
  CONSTRAINT `subjectpost_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` varchar(255) NOT NULL,
  `userName` varchar(255) NOT NULL,
  `userPwd` varchar(255) NOT NULL,
  `userSex` varchar(255) NOT NULL,
  `userMajor` varchar(255) NOT NULL,
  `userClass` varchar(255) NOT NULL,
  `userTel` varchar(255) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('0', '0', 'cfcd208495d565ef66e7dff9f98764da', '0', '0', '0', '0');
INSERT INTO `user` VALUES ('31701051', '吴雨翰', 'bb7deb21a898d6660698a98f950e47d1', '男', '计算', '1702', '13429490334');
INSERT INTO `user` VALUES ('31701053', '谢林专', '482feb79c654d63ee6a762e1be9403ee', '男', '计算', '1702', '13967525787');
INSERT INTO `user` VALUES ('31701055', '杨煜升', '1962aadacbef2272bcfbcc42edc662c8', '男', '计算', '计算机1702', '18857533745');
INSERT INTO `user` VALUES ('31701056', '杨峥', '683cd2e5bcb95ea3903b06ff8fe5b5f8', '男', '计算', '计算机1702', '18857533745');
INSERT INTO `user` VALUES ('31701057', '俞凌健', 'a2f25cf9607f6a8b313e74407f0da3b9', '男', '计算', '计算机1702', '18857533745');
INSERT INTO `user` VALUES ('31701058', '赵晟', '94a4f1bc197df92948f74e44e7cba974', '男', '计算', '1702', '13429590334');
INSERT INTO `user` VALUES ('31701099', '小王', '6538918db4ba32f5b3bb6efb146741c2', '女', '软工', '软工1701', '18857533745');
INSERT INTO `user` VALUES ('31701268', '陈昱熹', '37b24e9d64a623ecc1fac4f5ff2a1022', '女', '软工', '1702', '15363554787');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
