package com.example.windows.chatwith.utils;

import com.example.windows.chatwith.beans.ForumInfoBean;

import java.util.ArrayList;

/**
 * Created by Windows on 2018/6/29.
 */

public class Data {

    private static ArrayList<Object> mList;

    public static ArrayList<Object> getForumList() {
        mList = new ArrayList<>();
        ForumInfoBean infoBean;
        ArrayList<String> imageList;

//        imageList = new ArrayList<>();
//        infoBean = new ForumInfoBean();
//        infoBean.setArticleTitle("中国大陆记者被指“假新闻”遭拒入境台湾");
//        infoBean.setArticleContent("华盛顿 — \n" +
//                "台湾负责两岸关系的陆委会星期三在回应中国大陆一位记者被拒绝赴台驻点采访事件时表示，台湾政府向来尊重新闻自由，致力于维护两岸新闻正常交流，但不容许大陆媒体记者制造“假新闻”，散布不实言论。\n" +
//                "\n" +
//                "据台湾媒体报道，中国大陆福建东南卫视的记者叶青林透露，再度申请今年6月赴台驻点采访，但被拒绝。\n" +
//                "\n" +
//                "报道表示，叶青林被拒很可能是因为他今年2月报道花莲大地震时，称日本救难队“动口不动手”，是一场“救灾政治秀”，而台湾方面认为与实际情况不符。\n" +
//                "\n" +
//                "法新社报道说，陆委会还指叶青林曾未经允许到军事基地采访，违反台湾允许大陆媒体记者在台驻点采访的规定。\n" +
//                "\n" +
//                "中国国台办27日举行记者会，称大陆记者赴台驻点申请遭到台湾当局的“无理拒绝”，创下了两岸互派驻点记者采访以来的恶例。而台湾一些亲中媒体和专家也质疑台湾当局的做法能否彰显台湾对中国大陆的制度优势。\n" +
//                "\n" +
//                "这是2000年台湾当局开放中国大陆媒体记者赴台驻点采访以来，首次有记者被拒绝入境。");
//        infoBean.setPublisherHp("https://img2.woyaogexing.com/2018/06/29/a266b81205d82755!480x480.jpg");
//        infoBean.setPublisherName("海彦");
//        imageList.add("http://p2.ifengimg.com/a/2018_26/d2eea2ca4f10c73_size79_w727_h487.jpg");
//        imageList.add("http://p0.ifengimg.com/a/2018_26/b755f42d6318fe0_size179_w1328_h912.jpg");
//        infoBean.setPublishImage(imageList);
//        infoBean.setPublishTime(System.currentTimeMillis());
//        mList.add(infoBean);

        imageList = new ArrayList<>();
        infoBean = new ForumInfoBean();
        infoBean.setArticleContent("原标题：“台湾省”和“福建省”被废掉之后\n" +
                "\n" +
                "台湾当局28日宣布，自2019年起将“省级机关”预算归零。预算归零，意味着有关机构名存实亡。自1997年7月李登辉搞“冻省”至今21年，“台湾省”终于被废掉了，“福建省”也被废掉了，两个“省政府”将同时走入历史。\n" +
                "\n" +
                "中评社对此发表评论说，台湾当局做出此项决定，给出的理由是为使“国家资源”做最有效的运用，以及提高行政效能。网上有留言说这是“变相台独”，机关算尽；大陆媒体的报道则直指“台独”死心不改。\n" +
                "\n" +
                "台当局“福建省政府”\n" +
                "\n" +
                "台湾目前共有三个“省级机关”，分别是“台湾省政府”“福建省政府”和“台湾省谘议会”。“福建省政府”“台湾省政府”分别于1956年、1997年起虚级化；“台湾省谘议会”由“台湾省议会”改设而来，业务与人员也于1997年逐渐移转。\n" +
                "\n" +
                "依据台湾现行“宪法”规定，“省级机关”不能废除，明年起“省级业务”全部归零后，台湾当局仍须设“省主席”和“省谘议会长”，但已无薪水可发，也无一兵一卒。台湾当局要将“台湾省”和“福建省”彻底铲除，还须过“修宪”这一关。\n" +
                "\n" +
                "评论指出，废掉“台湾省”和“福建省”之后，没有了“省级机关”，民进党执政的“中央政府”直接统管全台湾县级政府，岂非成了“省政府”？不管“台湾省政府”是否被实质废掉，民进党当局无力改变台湾是一个省的事实，如有踩到大陆底线的行动，眼下的“台湾省”甚至会加速成为实实在在的中国台湾省。");
        infoBean.setArticleTitle("台当局将废除“台湾省和福建省” 港媒：或踩大陆底线");
        infoBean.setPublisherHp("http://imgsrc.baidu.com/imgad/pic/item/ac345982b2b7d0a2c5bdacb9c1ef76094b369a9a.jpg");
        infoBean.setPublisherName("中国台湾网");
        imageList.add("http://p2.ifengimg.com/a/2018_26/d2eea2ca4f10c73_size79_w727_h487.jpg");
        imageList.add("http://p0.ifengimg.com/a/2018_26/b755f42d6318fe0_size179_w1328_h912.jpg");
        infoBean.setPublishImage(imageList);
        infoBean.setPublishTime(System.currentTimeMillis());
        mList.add(infoBean);
        return mList;
    }

    public static ArrayList<Object> getReplyList() {
        mList = new ArrayList<>();

        return mList;
    }

}
