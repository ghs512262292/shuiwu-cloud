package com.shuiyou.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
public class MarkUtilsTest {


    @Test
    void splitText() {
        String text = "财政部 国家税务总局关于增值税几个税收政策问题的通知\n" +
                "\n" +
                " 注释：条款失效，本办法第四条第（一）项、第六条第（二）项、第八条、第十一条失效。参见：《财政部 国家税务总局关于公布若干废止和失效的增值税规范性文件目录的通知》，财税〔2009〕17号。\n" +
                "    根据国务院批示精神，经研究，现对几个增值税政策问题明确如下：\n" +
                "    一、增值税一般纳税人1994年5月1日以后销售应税货物而支付的运输费用，除《中华人民共和国增值税暂行条例实施细则》第十二条所规定的不并入销售额的代垫运费以外，可按（94）财税字第12号《财政部、国家税务总局关于运输费用和废旧物资准予抵扣进项税额问题的通知》中有关规定，依10%的扣除率计算进项税额予以抵扣。\n" +
                "    纳税人购买或销售免税货物所发生的运输费用，不得计算进项税额抵扣。\n" +
                "    二、供残疾人专用的假肢、轮椅、矫型器（包括上肢矫型器、下肢矫型器、脊椎侧弯矫型器），免征增值税。\n" +
                "    三、对国家定点企业（名单见附件）生产和经销单位经销的专供少数民族饮用的边销茶，免征增值税。\n" +
                "    边销茶，是指以黑茶、红茶末、老青茶、绿茶经蒸制、加压、发酵、压制成不同形状，专门销往边疆少数民族地区的紧压茶。\n" +
                "    四、对农业产品收购单位在收购价格之外按规定缴纳的农业特产税，准予并入农业产品的买价，计算进项税额扣除。\n" +
                "    五、铁路工附业单位，凡是向其所在铁路局内部其他单位提供的货物或应税劳务，1995年底前暂免征收增值税；向其所在铁路局以外销售的货物或应税劳务，应照章征收增值税。\n" +
                "    上款所称铁路工附业，是指直接为铁路运输生产服务的工业性和非工业性生产经营单位，主要包括工业性生产和加工修理修配、材料供应、生活供应等。\n" +
                "    六、农用水泵、农用柴油机按农机产品依13%的税率征收增值税。\n" +
                "    农用水泵是指主要用于农业生产的水泵，包括农村水井用泵、农田作业面潜水泵、农用轻便离心泵、与喷灌机配套的喷灌自吸泵。其他水泵不属于农机产品征税范围。\n";
        String pattern = "[一二三四五六七八九十]{1,3}、(?=[^ 一二三四五六七八九十]{1,})";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        List<int[]> indexList = new ArrayList<>();
        //取出所有匹配到的目标
        while (m.find()) {

//            System.out.print(m.group());
            // 左闭右开
            indexList.add(new int[] {m.start(), m.end()});
        }
        System.out.println();
    }
}
