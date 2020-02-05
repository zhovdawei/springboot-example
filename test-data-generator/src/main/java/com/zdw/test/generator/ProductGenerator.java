package com.zdw.test.generator;

public class ProductGenerator {

    public static String[] COLOR = {"红", "灰", "黑", "银", "紫", "蓝", "黄", "绿", "橙", "白", "粉", "褐", "靛", "青"};

    public static String[] ELECTRONIC_TYPE = {"iPhone6","iPhone6s","iPhone7","iPhone7 Plus",
            "iPhone8","iPhone8 Plus","iPhonex","iPhonex plus","iPhone11","iPhone11 Pro",
            "iPhone11 Pro Max","iPad1","iPad2","iPad3","iPad4","iPad2019","iPad mini1",
            "iPad mini2","iPad mini3","iPad mini4","iPad mini5","小米1","小米2","小米3",
            "小米5","小米6","小米7","小米8","小米9","小米9s","小米10","小米10s","红米 note1",
            "红米 note2","红米 note3","红米 note4","红米 note5","huawei mate","huawei mate10",
            "huawei mate10 pro","huawei mate20","huawei mate20 pro","huawei 青春版","荣耀1",
            "荣耀2","荣耀10","荣耀10 pro","荣耀20","荣耀20 pro","荣耀30","荣耀30 pro",
            "荣耀40","荣耀40 pro","vivo青春版","vivo pro","oppo1","oppo2","oppo3","oppo4",
            "oppo5","三星S1","三星S2","三星S3","三星S4","三星S5","三星S6"};

    public static String[] CUN_CHU = {"16g","32g","64g","128g","256g"};

    public static String[] CHI_MA = {"S","M","L","XL","2XL","3XL","4XL"};

    public static String[] SEX = {"男","女"};

    public static String[] CLOTHES_TYPE = {"羽绒服", "棉衣棉服", "毛呢大衣", "卫衣绒衫",
            "皮草皮衣", "裤裙", "衬衫", "牛仔衣", "西装", "T恤", "汉服", "半身裙", "风衣", "马夹",
            "牛仔裤", "POLO衫", "卫衣", "开衫", "工装裤", "运动裤", "文胸", "内裤", "睡衣", "袜子",
            "长袖衬衫", "条纹衬衫", "毛衣", "针织衫", "套头", "羊毛衫", "休闲裤", "短裤", "九分裤",
            "七分裤", "收脚裤", "阔腿裤", "短裙", "直筒裤", "背带裤", "小脚裤", "破洞牛仔裤"};

    public static String[] FRUIT_TYPE = {"荔枝", "百香果", "芒果", "樱桃", "榴莲", "杨梅",
            "柠檬", "水蜜桃", "苹果", "黄桃", "火龙果", "菠萝", "蓝莓", "山竹", "猕猴桃",
            "车厘子", "枣", "哈密瓜", "西瓜", "枇杷", "草莓", "葡萄", "鸭梨", "香梨", "桑葚",
            "山楂", "石榴", "木瓜", "金橘", "蜜桔", "香蕉", "甜瓜", "油桃", "乌梅", "龙眼",
            "柿子", "海棠果", "黑布林", "圣女果"};

    public static String[] WEIGHT = {"1斤","2斤","3斤","4斤","5斤","6斤","7斤","8斤","9斤","10斤"};

    public static String[] FISHERY_TYPE = {"鲤鱼", "草鱼", "鲢鱼", "鳙鱼", "青鱼", "鲫鱼",
            "团头鲂", "南美白对虾", "生虾仁", "白虾", "虎虾", "小龙虾", "带鱼", "黄鱼", "鲳鱼",
            "鳕鱼", "三文鱼", "海参", "八爪鱼", "鱿鱼", "墨鱼", "干贝", "鱼干", "花胶", "海带紫菜",
            "甲鱼", "牛蛙", "娃娃鱼", "大闸蟹", "鲍鱼", "扇贝", "青口贝", "生蚝", "北极贝",
            "帝王蟹", "波士顿龙虾", "北海蛏子", "英国面包蟹", "大连海螺", "海鲈鱼", "比目鱼",
            "龙斑鱼", "河豚", "丁香鱼", "石斑鱼", "青花鱼", "白话鲈", "秋刀鱼"};

    public static String[] WEIGHT_FISH = {"200g","500g","1000g","1500g","2000g","2500g","3000g","3500g","4000g","4500g",
            "5000g","5500g","6000g","6500g","7000g","7500g","8000g","8500g","9000g","9500g","10000g"};


    public static String[] DAILY_USE_TYPE = {"保温杯", "饭盒", "抽纸", "卷纸", "玻璃杯",
            "马克杯", "纸杯", "洗发水", "沐浴露", "牙膏", "洗洁精", "抹布", "毛刷", "牙签", "筷子",
            "雨伞", "遮阳伞", "太阳眼镜", "遮阳帽", "毛巾", "浴巾", "相框", "墙纸", "气球", "收纳盒",
            "垃圾袋", "挂钩", "餐巾纸", "垃圾桶", "牙刷", "电动牙刷", "马桶盖", "指甲钳", "瓷碗",
            "拖把", "扫帚", "吹干机", "菜刀", "水果刀", "铁锅", "平底锅"};

    public static String[] FEN_SHU = {"x1","x3","x5","x10","x20","x30","x50","x100"};

    public static String[] PIN_PAI = {"稳固牌","靠谱牌","得力牌","日本","美国","德国","英国","印度","越南",
            "日照牌","武汉牌","锋利牌","广源牌","杂牌","红星牌","国强牌","振华牌","兴国牌"};

    public static String[] SNACKS_TYPE = {"话梅", "凉果", "蜜饯", "芒果干", "香蕉片", "橄榄干",
            "黄桃罐头", "瓜子", "花生", "酸角糕", "虾条", "薯片", "鱿鱼丝", "爆米花", "牛头干",
            "牛肉粒", "泡椒鸡爪", "香辣鸡爪", "猪肉脯", "肉松饼", "香辣鱼干", "辣条", "香辣豆腐干",
            "绿箭口香糖", "益达", "水果果冻", "开心果", "核桃仁", "杏仁", "豌豆", "蚕豆", "海苔",
            "小鸡腿", "巧克力", "葱香饼干", "压缩饼干", "威化饼干", "臭豆腐干", "腰果", "松子",
            "徐福记沙琪玛", "大白兔奶糖", "花生牛轧糖", "玉米软糖", "阿尔卑斯棒棒糖", "麦丽素", "真知棒",
            "果丹皮", "无花果", "小浣熊干脆面", "锅巴", "浪味仙", "旺旺雪饼", "旺旺仙贝", "奥利奥",
            "老坛酸菜牛肉面", "红烧牛肉面"};

    public static String[] WEIGHT_KE = {"10g","50g","100g","150g","200g","250g","300g","350g","400g",
            "450g","500g"};


    public static String[] DRINK_TYPE = {"茅台", "洋河", "汾酒", "习酒", "剑南春",
            "五粮液", "泸州老窖", "郎酒", "牛栏山", "古井", "拉菲", "奔富", "黄尾袋鼠", "杰卡斯",
            "王朝", "长城", "张裕", "千露", "智象", "桃乐丝", "百威", "哈尔冰", "燕京啤酒", "福佳",
            "瓦伦丁", "青岛啤酒", "雪花啤酒", "科罗娜", "喜力", "爱士堡", "马爹利", "轩尼诗",
            "杰克丹尼", "芝华士", "百加得", "人头马", "尊尼获加", "锐澳", "格兰菲尼", "野格",
            "古越龙山", "塔牌", "会稽山", "海南椰岛", "即墨", "和酒", "鉴湖", "黄酒馆", "劲牌",
            "女儿红", "绿茶", "红茶", "冰红茶", "可口可乐", "百事可乐", "健怡可乐", "零度可乐",
            "雪碧", "美年达", "芬达", "红牛", "维他奶", "王老吉", "汇源果汁", "加多宝", "杏仁露",
            "乌龙茶", "格瓦斯", "六个核桃", "气泡水", "阿斯姆奶茶", "苹果除", "北冰洋", "椰汁汁",
            "青梅绿茶", "鲜橙多", "苏打水", "农夫三泉", "美汁源", "花生牛奶"};

    public static String[] WEIGHT_ML = {"100ml","200ml","300ml","400ml","500ml","600ml","700ml","800ml","900ml",
            "1000ml","2000ml"};


    public static String[] COSMETIC_TYPE = {"洗面奶", "眼霜", "面霜", "面膜", "爽肤水",
            "BB霜", "粉底液", "护手霜", "脱毛膏", "润肤乳", "紧肤水", "肌底液", "乳液", "晚霜",
            "柔肤水", "精华液", "日霜", "防晒霜", "隔离霜", "遮瑕霜", "腮红", "口红", "唇膏",
            "唇釉", "唇彩", "睫毛膏", "眼影", "眼线", "眉笔", "眉粉"};


    public static String[] WEIGHT_ML_HUA = {"10ml","20ml","30ml","40ml","50ml","60ml","70ml","80ml","90ml",
            "100ml","200ml","300ml","400ml","500ml","600ml","700ml","800ml","900ml","1000ml"};

    public static String[] SHOE_TYPE = {"跑步鞋","休闲鞋","雨鞋","拖鞋","登山鞋",
            "溯溪鞋","胶鞋","凉鞋","篮球鞋","足球鞋","帆布鞋","皮鞋","小白鞋",
            "老爹鞋","复古鞋","马丁靴","雪地靴","布鞋","草鞋","高跟鞋","滑板鞋"};


    public static String[] XIE_CHI_MA = {"35.5","36","36.5","37.5","38","38.5","39","40","41","42","42.5","43","44","44.5","45"};

}














