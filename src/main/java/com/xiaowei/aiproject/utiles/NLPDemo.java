package com.xiaowei.aiproject.utiles;

import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.nlp.ESimnetType;
import org.json.JSONObject;

import java.util.HashMap;

public class NLPDemo {

    //设置APPID/AK/SK
    public static final String APP_ID = "16396119";
    public static final String API_KEY = "kEkYG8blkggDcAv7MIqzpEbs";
    public static final String SECRET_KEY = "KVbD6nBlBPp4GFMdSS8LurRuLVGr3KgV";

    public static void main(String[] args) {
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 调用接口
        /**
         * 1、词法分析
         * 词法分析接口向用户提供分词、词性标注、专名识别三大功能；能够识别出文本串中的基本词汇（分词），对这些词汇进行重组、
         * 标注组合后词汇的词性，并进一步识别出命名实体。
         */
        System.out.println("-------------词法分析--------------");
        String text = "百度是一家高科技公司";
        JSONObject res = client.lexer(text, null);
        System.out.println(res.toString(2));

        /**
         * 2、词向量
         * 词向量表示接口提供中文词向量的查询功能。
         */
        System.out.println("-------------词向量--------------");
        String word = "张飞";
        // 传入可选参数调用接口
        HashMap<String, Object> options2 = new HashMap<String, Object>();

        // 词向量表示
        JSONObject res2 = client.wordEmbedding(word, options2);
        System.out.println(res2.toString(2));

        /**
         * 3、DNN语言模型
         * 中文DNN语言模型接口用于输出切词结果并给出每个词在句子中的概率值,判断一句话是否符合语言表达习惯。
         */
        System.out.println("-------------DNN语言模型-------------");
        String text2 = "床前明月光";

        // 传入可选参数调用接口
        HashMap<String, Object> options3 = new HashMap<String, Object>();

        // DNN语言模型
        JSONObject res3 = client.dnnlmCn(text2, options3);
        System.out.println(res3.toString(2));

        /**
         * 4、词义相似度
         * 输入两个词，得到两个词的相似度结果。
         */
        System.out.println("-------------词义相似度-------------");
        String word1 = "北京";
        String word2 = "上海";

        // 传入可选参数调用接口
        HashMap<String, Object> options4 = new HashMap<String, Object>();


        // 词义相似度
        JSONObject res4 = client.wordSimEmbedding(word1, word2, options4);
        System.out.println(res4.toString(2));

        /**
         * 5、短文本相似度
         * 短文本相似度接口用来判断两个文本的相似度得分。
         */
        System.out.println("-------------短文本相似度-------------");
        String text5_1 = "考研";
        String text5_2 = "高考";

        // 传入可选参数调用接口
        HashMap<String, Object> options5 = new HashMap<String, Object>();
        options5.put("model", "CNN");

        // 短文本相似度
        JSONObject res5 = client.simnet(text5_1, text5_2, options5);
        System.out.println(res5.toString(2));

        /**
         * 6、评论观点抽取
         * 评论观点抽取接口用来提取一条评论句子的关注点和评论观点，并输出评论观点标签及评论观点极性。
         */
        System.out.println("-------------评论观点抽取-------------");
        String text6 = "三星电脑电池不给力";
        HashMap<String, Object> options6 = new HashMap<String, Object>();

        // 获取美食评论情感属性
        JSONObject response6 = client.commentTag("这家餐馆味道不错", ESimnetType.FOOD, options6);
        System.out.println(response6.toString());

        // 获取酒店评论情感属性
        response6 = client.commentTag("喜来登酒店不错", ESimnetType.HOTEL, options6);
        System.out.println(response6.toString());

        /**
         * 7、情感倾向分析
         * 对包含主观观点信息的文本进行情感极性类别（积极、消极、中性）的判断，并给出相应的置信度。
         */
        System.out.println("-------------情感倾向分析-------------");
        String text7 = "苹果是一家伟大的公司";

        // 传入可选参数调用接口
        HashMap<String, Object> options7 = new HashMap<String, Object>();

        // 情感倾向分析
        JSONObject res7 = client.sentimentClassify(text, options7);
        System.out.println(res7.toString(2));

        /**
         * 8、文章标签
         * 文章标签服务能够针对网络各类媒体文章进行快速的内容理解，根据输入含有标题的文章，输出多个内容标签以及对应的置信度，
         * 用于个性化推荐、相似文章聚合、文本内容分析等场景。
         */
        System.out.println("-------------文章标签-------------");
        String title = "iphone手机出现“白苹果”原因及解决办法，用苹果手机的可以看下";
        String content = "如果下面的方法还是没有解决你的问题建议来我们门店看下成都市锦江区红星路三段99号银石广场24层01室。";

        // 传入可选参数调用接口
        HashMap<String, Object> options8 = new HashMap<String, Object>();

        // 文章标签
        JSONObject res8 = client.keyword(title, content, options8);
        System.out.println(res8.toString(2));

        /**
         * 9、文章分类
         * 对文章按照内容类型进行自动分类，首批支持娱乐、体育、科技等26个主流内容类型，为文章聚类、文本内容分析等应用提供基础技术支持。
         */
        System.out.println("-------------文章分类-------------");
        String title9 = "欧洲冠军杯足球赛";
        String content9 = "欧洲冠军联赛是欧洲足球协会联盟主办的年度足球比赛，代表欧洲俱乐部足球最高荣誉和水平，被认为是全世界最高素质、最具影响力以及最高水平的俱乐部赛事，亦是世界上奖金最高的足球赛事和体育赛事之一。";

        // 传入可选参数调用接口
        HashMap<String, Object> options9 = new HashMap<String, Object>();

        // 文章分类
        JSONObject res9 = client.topic(title9, content9, options9);
        System.out.println(res9.toString(2));

        /**
         * 10、文本纠错
         * 识别输入文本中有错误的片段，提示错误并给出正确的文本结果。支持短文本、长文本、语音等内容的错误识别，纠错是搜索引擎、语音识别、内容审查等功能更好运行的基础模块之一。
         */
        System.out.println("-------------文本纠错-------------");
        String text10 = "百度是一家人工只能公司";

        // 传入可选参数调用接口
        HashMap<String, Object> options10 = new HashMap<String, Object>();

        // 文本纠错
        JSONObject res10 = client.ecnet(text10, options10);
        System.out.println(res10.toString(2));

        /**
         * 11、对话情绪识别接口
         * 针对用户日常沟通文本背后所蕴含情绪的一种直观检测，可自动识别出当前会话者所表现出的情绪类别及其置信度，可以帮助企业更全面地把握产品服务质量、监控客户服务质量
         */
        System.out.println("-------------对话情绪识别接口-------------");
        String text11 = "本来今天高高兴兴";

        // 传入可选参数调用接口
        HashMap<String, Object> options11 = new HashMap<String, Object>();
        options11.put("scene", "talk");

        // 对话情绪识别接口
        JSONObject res11 = client.emotion(text11, options11);
        System.out.println(res11.toString(2));

        /**
         * 12、新闻摘要接口
         * 自动抽取新闻文本中的关键信息，进而生成指定长度的新闻摘要
         */
        System.out.println("-------------对话情绪识别接口-------------");
        String content12 = "麻省理工学院的研究团队为无人机在仓库中使用RFID技术进行库存查找等工作，创造了一种...";
        int maxSummaryLen = 300;

        // 传入可选参数调用接口
        HashMap<String, Object> options12 = new HashMap<String, Object>();
        options12.put("title", "标题");

        // 新闻摘要接口
        JSONObject res12 = client.newsSummary(content12, maxSummaryLen, options12);
        System.out.println(res12.toString(2));

        /**
         * 13、地址识别接口
         * 针对快递、电商行业中客户在线提交的大量非结构化地址单据，该接口可以帮助精准提取快递填单文本中的姓名、电话、地址信息，通过自然语言
         * 处理辅助地址识别做自动补充和纠正，生成标准规范的结构化信息，大幅提升企业处理单据的效率。
         */
        System.out.println("-------------地址识别接口-------------");
        String text13 = "上海市浦东新区纳贤路701号百度上海研发中心 F4A000 张三";

        // 传入可选参数调用接口
        HashMap<String, Object> options13 = new HashMap<String, Object>();

        // 地址识别接口
        JSONObject res13 = client.address(text13, options13);
        System.out.println(res.toString(2));

    }
}
