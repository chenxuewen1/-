package a.bw.com.week_oneday_test.bean;

import java.util.List;

import a.bw.com.week_oneday_test.geen.NewsGreenDao;

/*Time:2019/3/16
 *Author:chenxuewen
 *Description:
 */
public class JsonBean {

    /**
     * data : [{"advTypeShare":"","countid":20009,"id":"298543","img":"","otime":"2019-03-16 10:17:20","resType":"置顶","source":"","stock":[],"summary":"","title":"周一最具爆发力六大牛股(名单)","url":"http://mnews.gw.com.cn/wap/data/news/txs/2019/03/298543.json","views":"2821"},{"advTypeShare":"","countid":20009,"id":"298542","img":"","otime":"2019-03-16 10:15:26","resType":"置顶","source":"","stock":[],"summary":"","title":"权威股民大数据来了！8成账户资产低于50万 盈利者更会止损","url":"http://mnews.gw.com.cn/wap/data/news/txs/2019/03/298542.json","views":"1325"},{"advTypeShare":"","countid":20009,"id":"298541","img":"","otime":"2019-03-16 10:00:51","resType":"置顶","source":"","stock":[],"summary":"","title":"重磅！3·15晚会曝光案例来了 数家上市公司紧急回应","url":"http://mnews.gw.com.cn/wap/data/news/txs/2019/03/298541.json","views":"3676"},{"advTypeShare":"","countid":20009,"id":"298544","img":"","otime":"2019-03-16 10:34:05","resType":"","source":"","stock":[],"summary":"","title":"特斯拉冲击波真的来了！上海超级工厂年底前投产，明年量产","url":"http://mnews.gw.com.cn/wap/data/news/txs/2019/03/298544.json","views":"17"},{"advTypeShare":"","countid":20009,"id":"298540","img":"","otime":"2019-03-16 09:30:52","resType":"","source":"","stock":[],"summary":"","title":"财务部发布关于粤港澳大湾区个人所得税优惠政策的通知","url":"http://mnews.gw.com.cn/wap/data/news/txs/2019/03/298540.json","views":"4020"},{"advTypeShare":"","countid":20009,"id":"298539","img":"","otime":"2019-03-16 09:02:36","resType":"","source":"","stock":[{"code":"SZ002110","name":"三钢闽光"},{"code":"SH600507","name":"方大特钢"},{"code":"SZ002756","name":"永兴特钢"}],"summary":"","title":"钢铁行业上市公司2018年盈利有望再创新高 8家公司营业收入与净利润实现双增长","url":"http://mnews.gw.com.cn/wap/data/news/txs/2019/03/298539.json","views":"6957"},{"advTypeShare":"","countid":20009,"id":"298537","img":"","otime":"2019-03-16 08:54:59","resType":"","source":"","stock":[],"summary":"挂牌公司在筹备或申报科创板上市期间，无需在新三板摘牌。","title":"新三板企业扎堆申报科创板 股转称申报期间无需摘牌","url":"http://mnews.gw.com.cn/wap/data/news/txs/2019/03/298537.json","views":"4814"},{"advTypeShare":"","countid":20009,"id":"298535","img":"","otime":"2019-03-15 22:32:31","resType":"","source":"","stock":[],"summary":"有友食品股份有限公司，中创物流股份有限公司","title":"证监会核发2家企业IPO批文，未披露筹资金额","url":"http://mnews.gw.com.cn/wap/data/news/txs/2019/03/298535.json","views":"18623"},{"advTypeShare":"","countid":20009,"id":"298534","img":"","otime":"2019-03-15 22:08:53","resType":"","source":"","stock":[],"summary":"央视3·15晚会曝光\u201c714高炮\u201d，融360被点名","title":"融360子公司简普科技跌幅扩大至15%；央视3·15晚会曝光\u201c714高炮\u201d，融360被点名","url":"http://mnews.gw.com.cn/wap/data/news/txs/2019/03/298534.json","views":"27638"},{"advTypeShare":"","countid":20009,"id":"298533","img":"","otime":"2019-03-15 21:24:26","resType":"","source":"","stock":[],"summary":"自发布之日起施行","title":"上交所发布《保荐人通过上海证券交易所科创板股票发行上市审核系统办理业务指南》","url":"http://mnews.gw.com.cn/wap/data/news/txs/2019/03/298533.json","views":"10337"},{"advTypeShare":"","countid":20009,"id":"298532","img":"","otime":"2019-03-15 21:22:55","resType":"","source":"","stock":[],"summary":"","title":"基金调研：海通证券访老板电器 中信证券关注伟星股份","url":"http://mnews.gw.com.cn/wap/data/news/txs/2019/03/298532.json","views":"18079"},{"advTypeShare":"","countid":20009,"id":"298531","img":"","otime":"2019-03-15 21:21:39","resType":"","source":"","stock":[],"summary":"","title":"商业贸易28家公司披露2018年年报 7只绩优股月内吸金近1亿元","url":"http://mnews.gw.com.cn/wap/data/news/txs/2019/03/298531.json","views":"19038"},{"advTypeShare":"","countid":20009,"id":"298530","img":"","otime":"2019-03-15 21:10:58","resType":"","source":"","stock":[],"summary":"","title":"最新版股民画像来了！8成账户资产低于50万、盈利者更能止损，最关注金融去杠杆\u2026","url":"http://mnews.gw.com.cn/wap/data/news/txs/2019/03/298530.json","views":"35191"},{"advTypeShare":"","countid":20009,"id":"298529","img":"","otime":"2019-03-15 21:09:38","resType":"","source":"","stock":[],"summary":"","title":"年初至今才涨了3%，这只生物制药股被低估了吗？","url":"http://mnews.gw.com.cn/wap/data/news/txs/2019/03/298529.json","views":"41731"},{"advTypeShare":"","countid":20009,"id":"298528","img":"","otime":"2019-03-15 21:07:53","resType":"","source":"","stock":[],"summary":"","title":"融资找钱 正成券业头等大事！今年来上市券商有望融资500亿 超去年全年","url":"http://mnews.gw.com.cn/wap/data/news/txs/2019/03/298528.json","views":"7822"},{"advTypeShare":"","countid":20009,"id":"298527","img":"","otime":"2019-03-15 20:24:43","resType":"","source":"","stock":[],"summary":"","title":"什么信号？主力资金持续三周千亿大撤退，这个板块成唯一避风港","url":"http://mnews.gw.com.cn/wap/data/news/txs/2019/03/298527.json","views":"39049"},{"advTypeShare":"","countid":20009,"id":"298526","img":"","otime":"2019-03-15 20:23:02","resType":"","source":"","stock":[],"summary":"","title":"15日公告精选：长江电力举牌两家公司，复旦复华5涨停后发异动公告","url":"http://mnews.gw.com.cn/wap/data/news/txs/2019/03/298526.json","views":"29926"},{"advTypeShare":"","countid":20009,"id":"298525","img":"","otime":"2019-03-15 20:21:42","resType":"","source":"","stock":[],"summary":"","title":"股市315：小心这些\u201c雷区\u201d！","url":"http://mnews.gw.com.cn/wap/data/news/txs/2019/03/298525.json","views":"29546"},{"advTypeShare":"","countid":20009,"id":"298524","img":"","otime":"2019-03-15 20:20:10","resType":"","source":"","stock":[{"code":"SH601319","name":"中国人保"}],"summary":"","title":"无惧看空？聪明资金\u201c抄底\u201d中国人保！股价暴跌25%，持股却大增70%！","url":"http://mnews.gw.com.cn/wap/data/news/txs/2019/03/298524.json","views":"31750"},{"advTypeShare":"","countid":20009,"id":"298523","img":"","otime":"2019-03-15 19:39:29","resType":"","source":"","stock":[],"summary":"证监会对《章程指引》做了三方面修改：","title":"证监会就修改《上市公司章程指引》公开征求意见","url":"http://mnews.gw.com.cn/wap/data/news/txs/2019/03/298523.json","views":"5214"}]
     * header : {"first":"page_1.json","last":"page_10.json","next":"page_2.json","pagesize":20,"pre":"page_1.json","totalpage":10,"totalsize":185}
     */

    private HeaderBean header;
    private List<NewsGreenDao> data;

    public HeaderBean getHeader() {
        return header;
    }

    public void setHeader(HeaderBean header) {
        this.header = header;
    }

    public List<NewsGreenDao> getData() {
        return data;
    }

    public void setData(List<NewsGreenDao> data) {
        this.data = data;
    }

    public static class HeaderBean {
        /**
         * first : page_1.json
         * last : page_10.json
         * next : page_2.json
         * pagesize : 20
         * pre : page_1.json
         * totalpage : 10
         * totalsize : 185
         */

        private String first;
        private String last;
        private String next;
        private int pagesize;
        private String pre;
        private int totalpage;
        private int totalsize;

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }

        public int getPagesize() {
            return pagesize;
        }

        public void setPagesize(int pagesize) {
            this.pagesize = pagesize;
        }

        public String getPre() {
            return pre;
        }

        public void setPre(String pre) {
            this.pre = pre;
        }

        public int getTotalpage() {
            return totalpage;
        }

        public void setTotalpage(int totalpage) {
            this.totalpage = totalpage;
        }

        public int getTotalsize() {
            return totalsize;
        }

        public void setTotalsize(int totalsize) {
            this.totalsize = totalsize;
        }
    }

    public static class DataBean {
        /**
         * advTypeShare :
         * countid : 20009
         * id : 298543
         * img :
         * otime : 2019-03-16 10:17:20
         * resType : 置顶
         * source :
         * stock : []
         * summary :
         * title : 周一最具爆发力六大牛股(名单)
         * url : http://mnews.gw.com.cn/wap/data/news/txs/2019/03/298543.json
         * views : 2821
         */

        private String advTypeShare;
        private int countid;
        private String id;
        private String img;
        private String otime;
        private String resType;
        private String source;
        private String summary;
        private String title;
        private String url;
        private String views;
        private List<?> stock;

        public String getAdvTypeShare() {
            return advTypeShare;
        }

        public void setAdvTypeShare(String advTypeShare) {
            this.advTypeShare = advTypeShare;
        }

        public int getCountid() {
            return countid;
        }

        public void setCountid(int countid) {
            this.countid = countid;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getOtime() {
            return otime;
        }

        public void setOtime(String otime) {
            this.otime = otime;
        }

        public String getResType() {
            return resType;
        }

        public void setResType(String resType) {
            this.resType = resType;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getViews() {
            return views;
        }

        public void setViews(String views) {
            this.views = views;
        }

        public List<?> getStock() {
            return stock;
        }

        public void setStock(List<?> stock) {
            this.stock = stock;
        }
    }
}
