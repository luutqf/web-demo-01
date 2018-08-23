package cn.luutqf.webdemo01.web;

import cn.luutqf.webdemo01.config.MyStringUtil;
import cn.luutqf.webdemo01.config.UnicodeUtil;
import cn.luutqf.webdemo01.utils.RestKingClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * @Author : ZhenYang
 * @Despriction :
 * @Date: Created in 2018/7/24 17:22
 * @Modify By:
 */
@RestController
//@RequestMapping()
public class WeiboController {

//    @Autowired
//    private RestKingClient restKingClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public Object get(){
//        Object o = restKingClient.get("http://s.weibo.com/ajax/jsonp/gettopsug", Object.class, new HashMap<>());
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://s.weibo.com/top/summary", String.class);
        String html = UnicodeUtil.unicode2String(forEntity.toString());
//        System.out.println(html);
        Document doc = Jsoup.parse(html);
////        Elements rows = doc.select("div[class=hot_ranklist]").get(0).select("td[class=td_02]");
        Element row = doc.select("script").last();

//        System.out.println(row.outerHtml());
        String table = MyStringUtil.getTable(row.outerHtml());
        Document doc2 = Jsoup.parse(table);
        String s2 = doc2.outerHtml();
        String replace = s2.replace("\\&quot;", "");
        replace = replace.replace("\\n","");
        replace = replace.replace("\\","");
        replace = replace.replace("&lt;","");
        replace = replace.replace("/span&gt;","");
        replace = replace.replace("/p&gt;","");
        replace = replace.replace("/td&gt;","");
        replace = replace.replace("/a&gt;","");
        replace = replace.replace("/div&gt;","");
        replace = replace.replace("/em&gt;","");
        replace = replace.replace("/tr&gt;","");
        replace = replace.replace("/thead&gt;","");
        replace = replace.replace("/th&gt;","");
        replace = replace.replace("/i&gt;","");
        replace = replace.replace("/weibo","http://s.weibo.com/weibo");
        System.out.println(replace);
        return replace;
    }
}
