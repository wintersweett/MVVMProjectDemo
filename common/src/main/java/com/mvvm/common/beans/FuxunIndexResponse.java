package com.mvvm.common.beans;


import java.util.List;

import androidx.annotation.Keep;

import com.mvvm.net.beans.BaseResponse;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
@Keep
public class FuxunIndexResponse extends BaseResponse {

    /**
     * data : {"channelName":"AI智慧导览","tripStandard":"高管-一线城市800,其他城市600","hotCityList":[{"id":110100,"brief":"北京","pname":"北京市","hotFlag":1,"firstLetter":"B"},{"id":210100,"brief":"沈阳","pname":"辽宁省","hotFlag":1,"firstLetter":"S"},{"id":210200,"brief":"大连","pname":"辽宁省","hotFlag":1,"firstLetter":"D"},{"id":220100,"brief":"长春","pname":"吉林省","hotFlag":1,"firstLetter":"C"},{"id":310100,"brief":"上海","pname":"上海市","hotFlag":1,"firstLetter":"S"},{"id":320100,"brief":"南京","pname":"江苏省","hotFlag":1,"firstLetter":"N"},{"id":420100,"brief":"武汉","pname":"湖北省","hotFlag":1,"firstLetter":"W"},{"id":440300,"brief":"深圳","pname":"广东省","hotFlag":1,"firstLetter":"S"}],"firstLetterList":["A","B","C","D","E","F","G","H","J","K","L","M","N","P","Q","R","S","T","W","X","Y","Z"],"cityList":{"A":[{"id":152900,"brief":"阿拉善盟","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"A"},{"id":210300,"brief":"鞍山","pname":"辽宁省","hotFlag":0,"firstLetter":"A"},{"id":340800,"brief":"安庆","pname":"安徽省","hotFlag":0,"firstLetter":"A"},{"id":410500,"brief":"安阳","pname":"河南省","hotFlag":0,"firstLetter":"A"},{"id":513200,"brief":"阿坝","pname":"四川省","hotFlag":0,"firstLetter":"A"},{"id":520400,"brief":"安顺","pname":"贵州省","hotFlag":0,"firstLetter":"A"},{"id":542500,"brief":"阿里","pname":"西藏自治区","hotFlag":0,"firstLetter":"A"},{"id":610900,"brief":"安康","pname":"陕西省","hotFlag":0,"firstLetter":"A"},{"id":652900,"brief":"阿克苏","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"A"},{"id":654300,"brief":"阿勒泰","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"A"},{"id":659002,"brief":"阿拉尔","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"A"},{"id":820100,"brief":"澳门","pname":"澳门特别行政区","hotFlag":0,"firstLetter":"A"}],"B":[{"id":110100,"brief":"北京","pname":"北京市","hotFlag":1,"firstLetter":"B"},{"id":130600,"brief":"保定","pname":"河北省","hotFlag":0,"firstLetter":"B"},{"id":150200,"brief":"包头","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"B"},{"id":150800,"brief":"巴彦淖尔","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"B"},{"id":210500,"brief":"本溪","pname":"辽宁省","hotFlag":0,"firstLetter":"B"},{"id":220600,"brief":"白山","pname":"吉林省","hotFlag":0,"firstLetter":"B"},{"id":220800,"brief":"白城","pname":"吉林省","hotFlag":0,"firstLetter":"B"},{"id":340300,"brief":"蚌埠","pname":"安徽省","hotFlag":0,"firstLetter":"B"},{"id":341600,"brief":"亳州","pname":"安徽省","hotFlag":0,"firstLetter":"B"},{"id":371600,"brief":"滨州","pname":"山东省","hotFlag":0,"firstLetter":"B"},{"id":450500,"brief":"北海","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"B"},{"id":451000,"brief":"百色","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"B"},{"id":469025,"brief":"白沙","pname":"海南省","hotFlag":0,"firstLetter":"B"},{"id":469029,"brief":"保亭","pname":"海南省","hotFlag":0,"firstLetter":"B"},{"id":511900,"brief":"巴中","pname":"四川省","hotFlag":0,"firstLetter":"B"},{"id":520500,"brief":"毕节","pname":"贵州省","hotFlag":0,"firstLetter":"B"},{"id":530500,"brief":"保山","pname":"云南省","hotFlag":0,"firstLetter":"B"},{"id":610300,"brief":"宝鸡","pname":"陕西省","hotFlag":0,"firstLetter":"B"},{"id":620400,"brief":"白银","pname":"甘肃省","hotFlag":0,"firstLetter":"B"},{"id":652700,"brief":"博尔塔拉","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"B"},{"id":652800,"brief":"巴音郭楞","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"B"},{"id":659005,"brief":"北屯","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"B"}],"C":[{"id":130800,"brief":"承德","pname":"河北省","hotFlag":0,"firstLetter":"C"},{"id":130900,"brief":"沧州","pname":"河北省","hotFlag":0,"firstLetter":"C"},{"id":140400,"brief":"长治","pname":"山西省","hotFlag":0,"firstLetter":"C"},{"id":150400,"brief":"赤峰","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"C"},{"id":220100,"brief":"长春","pname":"吉林省","hotFlag":1,"firstLetter":"C"},{"id":320400,"brief":"常州","pname":"江苏省","hotFlag":0,"firstLetter":"C"},{"id":341100,"brief":"滁州","pname":"安徽省","hotFlag":0,"firstLetter":"C"},{"id":341700,"brief":"池州","pname":"安徽省","hotFlag":0,"firstLetter":"C"},{"id":430100,"brief":"长沙","pname":"湖南省","hotFlag":0,"firstLetter":"C"},{"id":430700,"brief":"常德","pname":"湖南省","hotFlag":0,"firstLetter":"C"},{"id":431000,"brief":"郴州","pname":"湖南省","hotFlag":0,"firstLetter":"C"},{"id":445100,"brief":"潮州","pname":"广东省","hotFlag":0,"firstLetter":"C"},{"id":451400,"brief":"崇左","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"C"},{"id":469023,"brief":"澄迈","pname":"海南省","hotFlag":0,"firstLetter":"C"},{"id":469026,"brief":"昌江","pname":"海南省","hotFlag":0,"firstLetter":"C"},{"id":500100,"brief":"重庆","pname":"重庆市","hotFlag":0,"firstLetter":"C"},{"id":500200,"brief":"重庆郊","pname":"重庆市","hotFlag":0,"firstLetter":"C"},{"id":510100,"brief":"成都","pname":"四川省","hotFlag":0,"firstLetter":"C"},{"id":532300,"brief":"楚雄","pname":"云南省","hotFlag":0,"firstLetter":"C"},{"id":540300,"brief":"昌都","pname":"西藏自治区","hotFlag":0,"firstLetter":"C"},{"id":652300,"brief":"昌吉","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"C"}],"D":[{"id":140200,"brief":"大同","pname":"山西省","hotFlag":0,"firstLetter":"D"},{"id":210200,"brief":"大连","pname":"辽宁省","hotFlag":1,"firstLetter":"D"},{"id":210600,"brief":"丹东","pname":"辽宁省","hotFlag":0,"firstLetter":"D"},{"id":230600,"brief":"大庆","pname":"黑龙江省","hotFlag":0,"firstLetter":"D"},{"id":232700,"brief":"大兴安岭","pname":"黑龙江省","hotFlag":0,"firstLetter":"D"},{"id":370500,"brief":"东营","pname":"山东省","hotFlag":0,"firstLetter":"D"},{"id":371400,"brief":"德州","pname":"山东省","hotFlag":0,"firstLetter":"D"},{"id":441900,"brief":"东莞","pname":"广东省","hotFlag":0,"firstLetter":"D"},{"id":460400,"brief":"儋州","pname":"海南省","hotFlag":0,"firstLetter":"D"},{"id":469007,"brief":"东方","pname":"海南省","hotFlag":0,"firstLetter":"D"},{"id":469021,"brief":"定安","pname":"海南省","hotFlag":0,"firstLetter":"D"},{"id":510600,"brief":"德阳","pname":"四川省","hotFlag":0,"firstLetter":"D"},{"id":511700,"brief":"达州","pname":"四川省","hotFlag":0,"firstLetter":"D"},{"id":532900,"brief":"大理","pname":"云南省","hotFlag":0,"firstLetter":"D"},{"id":533100,"brief":"德宏","pname":"云南省","hotFlag":0,"firstLetter":"D"},{"id":533400,"brief":"迪庆","pname":"云南省","hotFlag":0,"firstLetter":"D"},{"id":621100,"brief":"定西","pname":"甘肃省","hotFlag":0,"firstLetter":"D"}],"E":[{"id":150600,"brief":"鄂尔多斯","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"E"},{"id":420700,"brief":"鄂州","pname":"湖北省","hotFlag":0,"firstLetter":"E"},{"id":422800,"brief":"恩施","pname":"湖北省","hotFlag":0,"firstLetter":"E"}],"F":[{"id":210400,"brief":"抚顺","pname":"辽宁省","hotFlag":0,"firstLetter":"F"},{"id":210900,"brief":"阜新","pname":"辽宁省","hotFlag":0,"firstLetter":"F"},{"id":341200,"brief":"阜阳","pname":"安徽省","hotFlag":0,"firstLetter":"F"},{"id":350100,"brief":"福州","pname":"福建省","hotFlag":0,"firstLetter":"F"},{"id":361000,"brief":"抚州","pname":"江西省","hotFlag":0,"firstLetter":"F"},{"id":440600,"brief":"佛山","pname":"广东省","hotFlag":0,"firstLetter":"F"},{"id":450600,"brief":"防城港","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"F"}],"G":[{"id":360700,"brief":"赣州","pname":"江西省","hotFlag":0,"firstLetter":"G"},{"id":440100,"brief":"广州","pname":"广东省","hotFlag":0,"firstLetter":"G"},{"id":450300,"brief":"桂林","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"G"},{"id":450800,"brief":"贵港","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"G"},{"id":510800,"brief":"广元","pname":"四川省","hotFlag":0,"firstLetter":"G"},{"id":511600,"brief":"广安","pname":"四川省","hotFlag":0,"firstLetter":"G"},{"id":513300,"brief":"甘孜","pname":"四川省","hotFlag":0,"firstLetter":"G"},{"id":520100,"brief":"贵阳","pname":"贵州省","hotFlag":0,"firstLetter":"G"},{"id":623000,"brief":"甘南","pname":"甘肃省","hotFlag":0,"firstLetter":"G"},{"id":632600,"brief":"果洛","pname":"青海省","hotFlag":0,"firstLetter":"G"},{"id":640400,"brief":"固原","pname":"宁夏回族自治区","hotFlag":0,"firstLetter":"G"},{"id":710200,"brief":"高雄","pname":"台湾省","hotFlag":0,"firstLetter":"G"}],"H":[{"id":130400,"brief":"邯郸","pname":"河北省","hotFlag":0,"firstLetter":"H"},{"id":131100,"brief":"衡水","pname":"河北省","hotFlag":0,"firstLetter":"H"},{"id":150100,"brief":"呼和浩特","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"H"},{"id":150700,"brief":"呼伦贝尔","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"H"},{"id":211400,"brief":"葫芦岛","pname":"辽宁省","hotFlag":0,"firstLetter":"H"},{"id":230100,"brief":"哈尔滨","pname":"黑龙江省","hotFlag":0,"firstLetter":"H"},{"id":230400,"brief":"鹤岗","pname":"黑龙江省","hotFlag":0,"firstLetter":"H"},{"id":231100,"brief":"黑河","pname":"黑龙江省","hotFlag":0,"firstLetter":"H"},{"id":320800,"brief":"淮安","pname":"江苏省","hotFlag":0,"firstLetter":"H"},{"id":330100,"brief":"杭州","pname":"浙江省","hotFlag":0,"firstLetter":"H"},{"id":330500,"brief":"湖州","pname":"浙江省","hotFlag":0,"firstLetter":"H"},{"id":340100,"brief":"合肥","pname":"安徽省","hotFlag":0,"firstLetter":"H"},{"id":340400,"brief":"淮南","pname":"安徽省","hotFlag":0,"firstLetter":"H"},{"id":340600,"brief":"淮北","pname":"安徽省","hotFlag":0,"firstLetter":"H"},{"id":341000,"brief":"黄山","pname":"安徽省","hotFlag":0,"firstLetter":"H"},{"id":371700,"brief":"菏泽","pname":"山东省","hotFlag":0,"firstLetter":"H"},{"id":410600,"brief":"鹤壁","pname":"河南省","hotFlag":0,"firstLetter":"H"},{"id":420200,"brief":"黄石","pname":"湖北省","hotFlag":0,"firstLetter":"H"},{"id":421100,"brief":"黄冈","pname":"湖北省","hotFlag":0,"firstLetter":"H"},{"id":430400,"brief":"衡阳","pname":"湖南省","hotFlag":0,"firstLetter":"H"},{"id":431200,"brief":"怀化","pname":"湖南省","hotFlag":0,"firstLetter":"H"},{"id":441300,"brief":"惠州","pname":"广东省","hotFlag":0,"firstLetter":"H"},{"id":441600,"brief":"河源","pname":"广东省","hotFlag":0,"firstLetter":"H"},{"id":451100,"brief":"贺州","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"H"},{"id":451200,"brief":"河池","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"H"},{"id":460100,"brief":"海口","pname":"海南省","hotFlag":0,"firstLetter":"H"},{"id":532500,"brief":"红河","pname":"云南省","hotFlag":0,"firstLetter":"H"},{"id":610700,"brief":"汉中","pname":"陕西省","hotFlag":0,"firstLetter":"H"},{"id":630200,"brief":"海东","pname":"青海省","hotFlag":0,"firstLetter":"H"},{"id":632200,"brief":"海北","pname":"青海省","hotFlag":0,"firstLetter":"H"},{"id":632300,"brief":"黄南","pname":"青海省","hotFlag":0,"firstLetter":"H"},{"id":632500,"brief":"海南","pname":"青海省","hotFlag":0,"firstLetter":"H"},{"id":632800,"brief":"海西","pname":"青海省","hotFlag":0,"firstLetter":"H"},{"id":650500,"brief":"哈密","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"H"},{"id":653200,"brief":"和田","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"H"},{"id":659010,"brief":"胡杨河","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"H"},{"id":719013,"brief":"花莲","pname":"台湾省","hotFlag":0,"firstLetter":"H"}],"J":[{"id":140500,"brief":"晋城","pname":"山西省","hotFlag":0,"firstLetter":"J"},{"id":140700,"brief":"晋中","pname":"山西省","hotFlag":0,"firstLetter":"J"},{"id":210700,"brief":"锦州","pname":"辽宁省","hotFlag":0,"firstLetter":"J"},{"id":220200,"brief":"吉林","pname":"吉林省","hotFlag":0,"firstLetter":"J"},{"id":230300,"brief":"鸡西","pname":"黑龙江省","hotFlag":0,"firstLetter":"J"},{"id":230800,"brief":"佳木斯","pname":"黑龙江省","hotFlag":0,"firstLetter":"J"},{"id":330400,"brief":"嘉兴","pname":"浙江省","hotFlag":0,"firstLetter":"J"},{"id":330700,"brief":"金华","pname":"浙江省","hotFlag":0,"firstLetter":"J"},{"id":360200,"brief":"景德镇","pname":"江西省","hotFlag":0,"firstLetter":"J"},{"id":360400,"brief":"九江","pname":"江西省","hotFlag":0,"firstLetter":"J"},{"id":360800,"brief":"吉安","pname":"江西省","hotFlag":0,"firstLetter":"J"},{"id":370100,"brief":"济南","pname":"山东省","hotFlag":0,"firstLetter":"J"},{"id":370800,"brief":"济宁","pname":"山东省","hotFlag":0,"firstLetter":"J"},{"id":410800,"brief":"焦作","pname":"河南省","hotFlag":0,"firstLetter":"J"},{"id":419001,"brief":"济源","pname":"河南省","hotFlag":0,"firstLetter":"J"},{"id":420800,"brief":"荆门","pname":"湖北省","hotFlag":0,"firstLetter":"J"},{"id":421000,"brief":"荆州","pname":"湖北省","hotFlag":0,"firstLetter":"J"},{"id":440700,"brief":"江门","pname":"广东省","hotFlag":0,"firstLetter":"J"},{"id":445200,"brief":"揭阳","pname":"广东省","hotFlag":0,"firstLetter":"J"},{"id":620200,"brief":"嘉峪关","pname":"甘肃省","hotFlag":0,"firstLetter":"J"},{"id":620300,"brief":"金昌","pname":"甘肃省","hotFlag":0,"firstLetter":"J"},{"id":620900,"brief":"酒泉","pname":"甘肃省","hotFlag":0,"firstLetter":"J"},{"id":712000,"brief":"嘉义","pname":"台湾省","hotFlag":0,"firstLetter":"J"},{"id":719001,"brief":"基隆","pname":"台湾省","hotFlag":0,"firstLetter":"J"},{"id":719010,"brief":"嘉义","pname":"台湾省","hotFlag":0,"firstLetter":"J"}],"K":[{"id":410200,"brief":"开封","pname":"河南省","hotFlag":0,"firstLetter":"K"},{"id":530100,"brief":"昆明","pname":"云南省","hotFlag":0,"firstLetter":"K"},{"id":650200,"brief":"克拉玛依","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"K"},{"id":653000,"brief":"克孜勒苏","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"K"},{"id":653100,"brief":"喀什","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"K"},{"id":659008,"brief":"可克达拉","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"K"},{"id":659009,"brief":"昆玉","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"K"}],"L":[{"id":131000,"brief":"廊坊","pname":"河北省","hotFlag":0,"firstLetter":"L"},{"id":141000,"brief":"临汾","pname":"山西省","hotFlag":0,"firstLetter":"L"},{"id":141100,"brief":"吕梁","pname":"山西省","hotFlag":0,"firstLetter":"L"},{"id":211000,"brief":"辽阳","pname":"辽宁省","hotFlag":0,"firstLetter":"L"},{"id":220400,"brief":"辽源","pname":"吉林省","hotFlag":0,"firstLetter":"L"},{"id":320700,"brief":"连云港","pname":"江苏省","hotFlag":0,"firstLetter":"L"},{"id":331100,"brief":"丽水","pname":"浙江省","hotFlag":0,"firstLetter":"L"},{"id":341500,"brief":"六安","pname":"安徽省","hotFlag":0,"firstLetter":"L"},{"id":350800,"brief":"龙岩","pname":"福建省","hotFlag":0,"firstLetter":"L"},{"id":371300,"brief":"临沂","pname":"山东省","hotFlag":0,"firstLetter":"L"},{"id":371500,"brief":"聊城","pname":"山东省","hotFlag":0,"firstLetter":"L"},{"id":410300,"brief":"洛阳","pname":"河南省","hotFlag":0,"firstLetter":"L"},{"id":411100,"brief":"漯河","pname":"河南省","hotFlag":0,"firstLetter":"L"},{"id":431300,"brief":"娄底","pname":"湖南省","hotFlag":0,"firstLetter":"L"},{"id":450200,"brief":"柳州","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"L"},{"id":451300,"brief":"来宾","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"L"},{"id":469024,"brief":"临高","pname":"海南省","hotFlag":0,"firstLetter":"L"},{"id":469027,"brief":"乐东","pname":"海南省","hotFlag":0,"firstLetter":"L"},{"id":469028,"brief":"陵水","pname":"海南省","hotFlag":0,"firstLetter":"L"},{"id":510500,"brief":"泸州","pname":"四川省","hotFlag":0,"firstLetter":"L"},{"id":511100,"brief":"乐山","pname":"四川省","hotFlag":0,"firstLetter":"L"},{"id":513400,"brief":"凉山","pname":"四川省","hotFlag":0,"firstLetter":"L"},{"id":520200,"brief":"六盘水","pname":"贵州省","hotFlag":0,"firstLetter":"L"},{"id":530700,"brief":"丽江","pname":"云南省","hotFlag":0,"firstLetter":"L"},{"id":530900,"brief":"临沧","pname":"云南省","hotFlag":0,"firstLetter":"L"},{"id":540100,"brief":"拉萨","pname":"西藏自治区","hotFlag":0,"firstLetter":"L"},{"id":540400,"brief":"林芝","pname":"西藏自治区","hotFlag":0,"firstLetter":"L"},{"id":620100,"brief":"兰州","pname":"甘肃省","hotFlag":0,"firstLetter":"L"},{"id":621200,"brief":"陇南","pname":"甘肃省","hotFlag":0,"firstLetter":"L"},{"id":622900,"brief":"临夏","pname":"甘肃省","hotFlag":0,"firstLetter":"L"}],"M":[{"id":231000,"brief":"牡丹江","pname":"黑龙江省","hotFlag":0,"firstLetter":"M"},{"id":340500,"brief":"马鞍山","pname":"安徽省","hotFlag":0,"firstLetter":"M"},{"id":440900,"brief":"茂名","pname":"广东省","hotFlag":0,"firstLetter":"M"},{"id":441400,"brief":"梅州","pname":"广东省","hotFlag":0,"firstLetter":"M"},{"id":510700,"brief":"绵阳","pname":"四川省","hotFlag":0,"firstLetter":"M"},{"id":511400,"brief":"眉山","pname":"四川省","hotFlag":0,"firstLetter":"M"},{"id":719006,"brief":"苗栗","pname":"台湾省","hotFlag":0,"firstLetter":"M"}],"N":[{"id":320100,"brief":"南京","pname":"江苏省","hotFlag":1,"firstLetter":"N"},{"id":320600,"brief":"南通","pname":"江苏省","hotFlag":0,"firstLetter":"N"},{"id":330200,"brief":"宁波","pname":"浙江省","hotFlag":0,"firstLetter":"N"},{"id":350700,"brief":"南平","pname":"福建省","hotFlag":0,"firstLetter":"N"},{"id":350900,"brief":"宁德","pname":"福建省","hotFlag":0,"firstLetter":"N"},{"id":360100,"brief":"南昌","pname":"江西省","hotFlag":0,"firstLetter":"N"},{"id":411300,"brief":"南阳","pname":"河南省","hotFlag":0,"firstLetter":"N"},{"id":450100,"brief":"南宁","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"N"},{"id":511000,"brief":"内江","pname":"四川省","hotFlag":0,"firstLetter":"N"},{"id":511300,"brief":"南充","pname":"四川省","hotFlag":0,"firstLetter":"N"},{"id":533300,"brief":"怒江","pname":"云南省","hotFlag":0,"firstLetter":"N"},{"id":540600,"brief":"那曲","pname":"西藏自治区","hotFlag":0,"firstLetter":"N"},{"id":719009,"brief":"南投","pname":"台湾省","hotFlag":0,"firstLetter":"N"}],"P":[{"id":211100,"brief":"盘锦","pname":"辽宁省","hotFlag":0,"firstLetter":"P"},{"id":350300,"brief":"莆田","pname":"福建省","hotFlag":0,"firstLetter":"P"},{"id":360300,"brief":"萍乡","pname":"江西省","hotFlag":0,"firstLetter":"P"},{"id":410400,"brief":"平顶山","pname":"河南省","hotFlag":0,"firstLetter":"P"},{"id":410900,"brief":"濮阳","pname":"河南省","hotFlag":0,"firstLetter":"P"},{"id":510400,"brief":"攀枝花","pname":"四川省","hotFlag":0,"firstLetter":"P"},{"id":530800,"brief":"普洱","pname":"云南省","hotFlag":0,"firstLetter":"P"},{"id":620800,"brief":"平凉","pname":"甘肃省","hotFlag":0,"firstLetter":"P"},{"id":719011,"brief":"屏东","pname":"台湾省","hotFlag":0,"firstLetter":"P"},{"id":719014,"brief":"澎湖","pname":"台湾省","hotFlag":0,"firstLetter":"P"}],"Q":[{"id":130300,"brief":"秦皇岛","pname":"河北省","hotFlag":0,"firstLetter":"Q"},{"id":230200,"brief":"齐齐哈尔","pname":"黑龙江省","hotFlag":0,"firstLetter":"Q"},{"id":230900,"brief":"七台河","pname":"黑龙江省","hotFlag":0,"firstLetter":"Q"},{"id":330800,"brief":"衢州","pname":"浙江省","hotFlag":0,"firstLetter":"Q"},{"id":350500,"brief":"泉州","pname":"福建省","hotFlag":0,"firstLetter":"Q"},{"id":370200,"brief":"青岛","pname":"山东省","hotFlag":0,"firstLetter":"Q"},{"id":429005,"brief":"潜江","pname":"湖北省","hotFlag":0,"firstLetter":"Q"},{"id":441800,"brief":"清远","pname":"广东省","hotFlag":0,"firstLetter":"Q"},{"id":450700,"brief":"钦州","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"Q"},{"id":469002,"brief":"琼海","pname":"海南省","hotFlag":0,"firstLetter":"Q"},{"id":469030,"brief":"琼中","pname":"海南省","hotFlag":0,"firstLetter":"Q"},{"id":522300,"brief":"黔西","pname":"贵州省","hotFlag":0,"firstLetter":"Q"},{"id":522600,"brief":"黔东","pname":"贵州省","hotFlag":0,"firstLetter":"Q"},{"id":522700,"brief":"黔南","pname":"贵州省","hotFlag":0,"firstLetter":"Q"},{"id":530300,"brief":"曲靖","pname":"云南省","hotFlag":0,"firstLetter":"Q"},{"id":621000,"brief":"庆阳","pname":"甘肃省","hotFlag":0,"firstLetter":"Q"}],"R":[{"id":371100,"brief":"日照","pname":"山东省","hotFlag":0,"firstLetter":"R"},{"id":540200,"brief":"日喀则","pname":"西藏自治区","hotFlag":0,"firstLetter":"R"}],"S":[{"id":130100,"brief":"石家庄","pname":"河北省","hotFlag":0,"firstLetter":"S"},{"id":140600,"brief":"朔州","pname":"山西省","hotFlag":0,"firstLetter":"S"},{"id":210100,"brief":"沈阳","pname":"辽宁省","hotFlag":1,"firstLetter":"S"},{"id":220300,"brief":"四平","pname":"吉林省","hotFlag":0,"firstLetter":"S"},{"id":220700,"brief":"松原","pname":"吉林省","hotFlag":0,"firstLetter":"S"},{"id":230500,"brief":"双鸭山","pname":"黑龙江省","hotFlag":0,"firstLetter":"S"},{"id":231200,"brief":"绥化","pname":"黑龙江省","hotFlag":0,"firstLetter":"S"},{"id":310100,"brief":"上海","pname":"上海市","hotFlag":1,"firstLetter":"S"},{"id":320500,"brief":"苏州","pname":"江苏省","hotFlag":0,"firstLetter":"S"},{"id":321300,"brief":"宿迁","pname":"江苏省","hotFlag":0,"firstLetter":"S"},{"id":330600,"brief":"绍兴","pname":"浙江省","hotFlag":0,"firstLetter":"S"},{"id":341300,"brief":"宿州","pname":"安徽省","hotFlag":0,"firstLetter":"S"},{"id":350400,"brief":"三明","pname":"福建省","hotFlag":0,"firstLetter":"S"},{"id":361100,"brief":"上饶","pname":"江西省","hotFlag":0,"firstLetter":"S"},{"id":411200,"brief":"三门峡","pname":"河南省","hotFlag":0,"firstLetter":"S"},{"id":411400,"brief":"商丘","pname":"河南省","hotFlag":0,"firstLetter":"S"},{"id":420300,"brief":"十堰","pname":"湖北省","hotFlag":0,"firstLetter":"S"},{"id":421300,"brief":"随州","pname":"湖北省","hotFlag":0,"firstLetter":"S"},{"id":429021,"brief":"神农架林区","pname":"湖北省","hotFlag":0,"firstLetter":"S"},{"id":430500,"brief":"邵阳","pname":"湖南省","hotFlag":0,"firstLetter":"S"},{"id":440200,"brief":"韶关","pname":"广东省","hotFlag":0,"firstLetter":"S"},{"id":440300,"brief":"深圳","pname":"广东省","hotFlag":1,"firstLetter":"S"},{"id":440500,"brief":"汕头","pname":"广东省","hotFlag":0,"firstLetter":"S"},{"id":441500,"brief":"汕尾","pname":"广东省","hotFlag":0,"firstLetter":"S"},{"id":460200,"brief":"三亚","pname":"海南省","hotFlag":0,"firstLetter":"S"},{"id":460300,"brief":"三沙","pname":"海南省","hotFlag":0,"firstLetter":"S"},{"id":510900,"brief":"遂宁","pname":"四川省","hotFlag":0,"firstLetter":"S"},{"id":540500,"brief":"山南","pname":"西藏自治区","hotFlag":0,"firstLetter":"S"},{"id":611000,"brief":"商洛","pname":"陕西省","hotFlag":0,"firstLetter":"S"},{"id":640200,"brief":"石嘴山","pname":"宁夏回族自治区","hotFlag":0,"firstLetter":"S"},{"id":659001,"brief":"石河子","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"S"},{"id":659007,"brief":"双河","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"S"}],"T":[{"id":120100,"brief":"天津","pname":"天津市","hotFlag":0,"firstLetter":"T"},{"id":130200,"brief":"唐山","pname":"河北省","hotFlag":0,"firstLetter":"T"},{"id":140100,"brief":"太原","pname":"山西省","hotFlag":0,"firstLetter":"T"},{"id":150500,"brief":"通辽","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"T"},{"id":211200,"brief":"铁岭","pname":"辽宁省","hotFlag":0,"firstLetter":"T"},{"id":220500,"brief":"通化","pname":"吉林省","hotFlag":0,"firstLetter":"T"},{"id":321200,"brief":"泰州","pname":"江苏省","hotFlag":0,"firstLetter":"T"},{"id":331000,"brief":"台州","pname":"浙江省","hotFlag":0,"firstLetter":"T"},{"id":340700,"brief":"铜陵","pname":"安徽省","hotFlag":0,"firstLetter":"T"},{"id":370900,"brief":"泰安","pname":"山东省","hotFlag":0,"firstLetter":"T"},{"id":429006,"brief":"天门","pname":"湖北省","hotFlag":0,"firstLetter":"T"},{"id":469022,"brief":"屯昌","pname":"海南省","hotFlag":0,"firstLetter":"T"},{"id":520600,"brief":"铜仁","pname":"贵州省","hotFlag":0,"firstLetter":"T"},{"id":610200,"brief":"铜川","pname":"陕西省","hotFlag":0,"firstLetter":"T"},{"id":620500,"brief":"天水","pname":"甘肃省","hotFlag":0,"firstLetter":"T"},{"id":650400,"brief":"吐鲁番","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"T"},{"id":654200,"brief":"塔城","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"T"},{"id":659003,"brief":"图木舒克","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"T"},{"id":659006,"brief":"铁门关","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"T"},{"id":710100,"brief":"台北","pname":"台湾省","hotFlag":0,"firstLetter":"T"},{"id":710400,"brief":"台中","pname":"台湾省","hotFlag":0,"firstLetter":"T"},{"id":710500,"brief":"台南","pname":"台湾省","hotFlag":0,"firstLetter":"T"},{"id":710600,"brief":"桃园","pname":"台湾省","hotFlag":0,"firstLetter":"T"},{"id":719012,"brief":"台东","pname":"台湾省","hotFlag":0,"firstLetter":"T"}],"W":[{"id":150300,"brief":"乌海","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"W"},{"id":150900,"brief":"乌兰察布","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"W"},{"id":320200,"brief":"无锡","pname":"江苏省","hotFlag":0,"firstLetter":"W"},{"id":330300,"brief":"温州","pname":"浙江省","hotFlag":0,"firstLetter":"W"},{"id":340200,"brief":"芜湖","pname":"安徽省","hotFlag":0,"firstLetter":"W"},{"id":370700,"brief":"潍坊","pname":"山东省","hotFlag":0,"firstLetter":"W"},{"id":371000,"brief":"威海","pname":"山东省","hotFlag":0,"firstLetter":"W"},{"id":420100,"brief":"武汉","pname":"湖北省","hotFlag":1,"firstLetter":"W"},{"id":450400,"brief":"梧州","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"W"},{"id":469001,"brief":"五指山","pname":"海南省","hotFlag":0,"firstLetter":"W"},{"id":469005,"brief":"文昌","pname":"海南省","hotFlag":0,"firstLetter":"W"},{"id":469006,"brief":"万宁","pname":"海南省","hotFlag":0,"firstLetter":"W"},{"id":532600,"brief":"文山","pname":"云南省","hotFlag":0,"firstLetter":"W"},{"id":610500,"brief":"渭南","pname":"陕西省","hotFlag":0,"firstLetter":"W"},{"id":620600,"brief":"武威","pname":"甘肃省","hotFlag":0,"firstLetter":"W"},{"id":640300,"brief":"吴忠","pname":"宁夏回族自治区","hotFlag":0,"firstLetter":"W"},{"id":650100,"brief":"乌鲁木齐","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"W"},{"id":659004,"brief":"五家渠","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"W"}],"X":[{"id":130500,"brief":"邢台","pname":"河北省","hotFlag":0,"firstLetter":"X"},{"id":140900,"brief":"忻州","pname":"山西省","hotFlag":0,"firstLetter":"X"},{"id":152200,"brief":"兴安盟","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"X"},{"id":152500,"brief":"锡林郭勒盟","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"X"},{"id":320300,"brief":"徐州","pname":"江苏省","hotFlag":0,"firstLetter":"X"},{"id":341800,"brief":"宣城","pname":"安徽省","hotFlag":0,"firstLetter":"X"},{"id":350200,"brief":"厦门","pname":"福建省","hotFlag":0,"firstLetter":"X"},{"id":360500,"brief":"新余","pname":"江西省","hotFlag":0,"firstLetter":"X"},{"id":410700,"brief":"新乡","pname":"河南省","hotFlag":0,"firstLetter":"X"},{"id":411000,"brief":"许昌","pname":"河南省","hotFlag":0,"firstLetter":"X"},{"id":411500,"brief":"信阳","pname":"河南省","hotFlag":0,"firstLetter":"X"},{"id":420600,"brief":"襄阳","pname":"湖北省","hotFlag":0,"firstLetter":"X"},{"id":420900,"brief":"孝感","pname":"湖北省","hotFlag":0,"firstLetter":"X"},{"id":421200,"brief":"咸宁","pname":"湖北省","hotFlag":0,"firstLetter":"X"},{"id":429004,"brief":"仙桃","pname":"湖北省","hotFlag":0,"firstLetter":"X"},{"id":430300,"brief":"湘潭","pname":"湖南省","hotFlag":0,"firstLetter":"X"},{"id":433100,"brief":"湘西","pname":"湖南省","hotFlag":0,"firstLetter":"X"},{"id":532800,"brief":"西双版纳","pname":"云南省","hotFlag":0,"firstLetter":"X"},{"id":610100,"brief":"西安","pname":"陕西省","hotFlag":0,"firstLetter":"X"},{"id":610400,"brief":"咸阳","pname":"陕西省","hotFlag":0,"firstLetter":"X"},{"id":630100,"brief":"西宁","pname":"青海省","hotFlag":0,"firstLetter":"X"},{"id":710300,"brief":"新北","pname":"台湾省","hotFlag":0,"firstLetter":"X"},{"id":719002,"brief":"新竹","pname":"台湾省","hotFlag":0,"firstLetter":"X"},{"id":719004,"brief":"新竹","pname":"台湾省","hotFlag":0,"firstLetter":"X"},{"id":810100,"brief":"香港","pname":"香港特别行政区","hotFlag":0,"firstLetter":"X"}],"Y":[{"id":140300,"brief":"阳泉","pname":"山西省","hotFlag":0,"firstLetter":"Y"},{"id":140800,"brief":"运城","pname":"山西省","hotFlag":0,"firstLetter":"Y"},{"id":210800,"brief":"营口","pname":"辽宁省","hotFlag":0,"firstLetter":"Y"},{"id":222400,"brief":"延边","pname":"吉林省","hotFlag":0,"firstLetter":"Y"},{"id":230700,"brief":"伊春","pname":"黑龙江省","hotFlag":0,"firstLetter":"Y"},{"id":320900,"brief":"盐城","pname":"江苏省","hotFlag":0,"firstLetter":"Y"},{"id":321000,"brief":"扬州","pname":"江苏省","hotFlag":0,"firstLetter":"Y"},{"id":360600,"brief":"鹰潭","pname":"江西省","hotFlag":0,"firstLetter":"Y"},{"id":360900,"brief":"宜春","pname":"江西省","hotFlag":0,"firstLetter":"Y"},{"id":370600,"brief":"烟台","pname":"山东省","hotFlag":0,"firstLetter":"Y"},{"id":420500,"brief":"宜昌","pname":"湖北省","hotFlag":0,"firstLetter":"Y"},{"id":430600,"brief":"岳阳","pname":"湖南省","hotFlag":0,"firstLetter":"Y"},{"id":430900,"brief":"益阳","pname":"湖南省","hotFlag":0,"firstLetter":"Y"},{"id":431100,"brief":"永州","pname":"湖南省","hotFlag":0,"firstLetter":"Y"},{"id":441700,"brief":"阳江","pname":"广东省","hotFlag":0,"firstLetter":"Y"},{"id":445300,"brief":"云浮","pname":"广东省","hotFlag":0,"firstLetter":"Y"},{"id":450900,"brief":"玉林","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"Y"},{"id":511500,"brief":"宜宾","pname":"四川省","hotFlag":0,"firstLetter":"Y"},{"id":511800,"brief":"雅安","pname":"四川省","hotFlag":0,"firstLetter":"Y"},{"id":530400,"brief":"玉溪","pname":"云南省","hotFlag":0,"firstLetter":"Y"},{"id":610600,"brief":"延安","pname":"陕西省","hotFlag":0,"firstLetter":"Y"},{"id":610800,"brief":"榆林","pname":"陕西省","hotFlag":0,"firstLetter":"Y"},{"id":632700,"brief":"玉树","pname":"青海省","hotFlag":0,"firstLetter":"Y"},{"id":640100,"brief":"银川","pname":"宁夏回族自治区","hotFlag":0,"firstLetter":"Y"},{"id":654000,"brief":"伊犁哈萨","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"Y"},{"id":719005,"brief":"宜兰","pname":"台湾省","hotFlag":0,"firstLetter":"Y"},{"id":719008,"brief":"云林","pname":"台湾省","hotFlag":0,"firstLetter":"Y"}],"Z":[{"id":130700,"brief":"张家口","pname":"河北省","hotFlag":0,"firstLetter":"Z"},{"id":211300,"brief":"朝阳","pname":"辽宁省","hotFlag":0,"firstLetter":"Z"},{"id":321100,"brief":"镇江","pname":"江苏省","hotFlag":0,"firstLetter":"Z"},{"id":330900,"brief":"舟山","pname":"浙江省","hotFlag":0,"firstLetter":"Z"},{"id":350600,"brief":"漳州","pname":"福建省","hotFlag":0,"firstLetter":"Z"},{"id":370300,"brief":"淄博","pname":"山东省","hotFlag":0,"firstLetter":"Z"},{"id":370400,"brief":"枣庄","pname":"山东省","hotFlag":0,"firstLetter":"Z"},{"id":410100,"brief":"郑州","pname":"河南省","hotFlag":0,"firstLetter":"Z"},{"id":411600,"brief":"周口","pname":"河南省","hotFlag":0,"firstLetter":"Z"},{"id":411700,"brief":"驻马店","pname":"河南省","hotFlag":0,"firstLetter":"Z"},{"id":430200,"brief":"株洲","pname":"湖南省","hotFlag":0,"firstLetter":"Z"},{"id":430800,"brief":"张家界","pname":"湖南省","hotFlag":0,"firstLetter":"Z"},{"id":440400,"brief":"珠海","pname":"广东省","hotFlag":0,"firstLetter":"Z"},{"id":440800,"brief":"湛江","pname":"广东省","hotFlag":0,"firstLetter":"Z"},{"id":441200,"brief":"肇庆","pname":"广东省","hotFlag":0,"firstLetter":"Z"},{"id":442000,"brief":"中山","pname":"广东省","hotFlag":0,"firstLetter":"Z"},{"id":510300,"brief":"自贡","pname":"四川省","hotFlag":0,"firstLetter":"Z"},{"id":512000,"brief":"资阳","pname":"四川省","hotFlag":0,"firstLetter":"Z"},{"id":520300,"brief":"遵义","pname":"贵州省","hotFlag":0,"firstLetter":"Z"},{"id":530600,"brief":"昭通","pname":"云南省","hotFlag":0,"firstLetter":"Z"},{"id":620700,"brief":"张掖","pname":"甘肃省","hotFlag":0,"firstLetter":"Z"},{"id":640500,"brief":"中卫","pname":"宁夏回族自治区","hotFlag":0,"firstLetter":"Z"},{"id":719007,"brief":"彰化","pname":"台湾省","hotFlag":0,"firstLetter":"Z"}]},"cityName":"北京","cityId":110100,"bgImg":"https://alipic.lanhuapp.com/SketchPng687334a453aca34095c253fd48dad833cb209a935776d5fae0f185c0a0a5e267"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }
    @Keep
    public static class DataBean {
        /**
         * channelName : AI智慧导览
         * tripStandard : 高管-一线城市800,其他城市600
         * hotCityList : [{"id":110100,"brief":"北京","pname":"北京市","hotFlag":1,"firstLetter":"B"},{"id":210100,"brief":"沈阳","pname":"辽宁省","hotFlag":1,"firstLetter":"S"},{"id":210200,"brief":"大连","pname":"辽宁省","hotFlag":1,"firstLetter":"D"},{"id":220100,"brief":"长春","pname":"吉林省","hotFlag":1,"firstLetter":"C"},{"id":310100,"brief":"上海","pname":"上海市","hotFlag":1,"firstLetter":"S"},{"id":320100,"brief":"南京","pname":"江苏省","hotFlag":1,"firstLetter":"N"},{"id":420100,"brief":"武汉","pname":"湖北省","hotFlag":1,"firstLetter":"W"},{"id":440300,"brief":"深圳","pname":"广东省","hotFlag":1,"firstLetter":"S"}]
         * firstLetterList : ["A","B","C","D","E","F","G","H","J","K","L","M","N","P","Q","R","S","T","W","X","Y","Z"]
         * cityList : {"A":[{"id":152900,"brief":"阿拉善盟","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"A"},{"id":210300,"brief":"鞍山","pname":"辽宁省","hotFlag":0,"firstLetter":"A"},{"id":340800,"brief":"安庆","pname":"安徽省","hotFlag":0,"firstLetter":"A"},{"id":410500,"brief":"安阳","pname":"河南省","hotFlag":0,"firstLetter":"A"},{"id":513200,"brief":"阿坝","pname":"四川省","hotFlag":0,"firstLetter":"A"},{"id":520400,"brief":"安顺","pname":"贵州省","hotFlag":0,"firstLetter":"A"},{"id":542500,"brief":"阿里","pname":"西藏自治区","hotFlag":0,"firstLetter":"A"},{"id":610900,"brief":"安康","pname":"陕西省","hotFlag":0,"firstLetter":"A"},{"id":652900,"brief":"阿克苏","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"A"},{"id":654300,"brief":"阿勒泰","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"A"},{"id":659002,"brief":"阿拉尔","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"A"},{"id":820100,"brief":"澳门","pname":"澳门特别行政区","hotFlag":0,"firstLetter":"A"}],"B":[{"id":110100,"brief":"北京","pname":"北京市","hotFlag":1,"firstLetter":"B"},{"id":130600,"brief":"保定","pname":"河北省","hotFlag":0,"firstLetter":"B"},{"id":150200,"brief":"包头","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"B"},{"id":150800,"brief":"巴彦淖尔","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"B"},{"id":210500,"brief":"本溪","pname":"辽宁省","hotFlag":0,"firstLetter":"B"},{"id":220600,"brief":"白山","pname":"吉林省","hotFlag":0,"firstLetter":"B"},{"id":220800,"brief":"白城","pname":"吉林省","hotFlag":0,"firstLetter":"B"},{"id":340300,"brief":"蚌埠","pname":"安徽省","hotFlag":0,"firstLetter":"B"},{"id":341600,"brief":"亳州","pname":"安徽省","hotFlag":0,"firstLetter":"B"},{"id":371600,"brief":"滨州","pname":"山东省","hotFlag":0,"firstLetter":"B"},{"id":450500,"brief":"北海","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"B"},{"id":451000,"brief":"百色","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"B"},{"id":469025,"brief":"白沙","pname":"海南省","hotFlag":0,"firstLetter":"B"},{"id":469029,"brief":"保亭","pname":"海南省","hotFlag":0,"firstLetter":"B"},{"id":511900,"brief":"巴中","pname":"四川省","hotFlag":0,"firstLetter":"B"},{"id":520500,"brief":"毕节","pname":"贵州省","hotFlag":0,"firstLetter":"B"},{"id":530500,"brief":"保山","pname":"云南省","hotFlag":0,"firstLetter":"B"},{"id":610300,"brief":"宝鸡","pname":"陕西省","hotFlag":0,"firstLetter":"B"},{"id":620400,"brief":"白银","pname":"甘肃省","hotFlag":0,"firstLetter":"B"},{"id":652700,"brief":"博尔塔拉","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"B"},{"id":652800,"brief":"巴音郭楞","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"B"},{"id":659005,"brief":"北屯","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"B"}],"C":[{"id":130800,"brief":"承德","pname":"河北省","hotFlag":0,"firstLetter":"C"},{"id":130900,"brief":"沧州","pname":"河北省","hotFlag":0,"firstLetter":"C"},{"id":140400,"brief":"长治","pname":"山西省","hotFlag":0,"firstLetter":"C"},{"id":150400,"brief":"赤峰","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"C"},{"id":220100,"brief":"长春","pname":"吉林省","hotFlag":1,"firstLetter":"C"},{"id":320400,"brief":"常州","pname":"江苏省","hotFlag":0,"firstLetter":"C"},{"id":341100,"brief":"滁州","pname":"安徽省","hotFlag":0,"firstLetter":"C"},{"id":341700,"brief":"池州","pname":"安徽省","hotFlag":0,"firstLetter":"C"},{"id":430100,"brief":"长沙","pname":"湖南省","hotFlag":0,"firstLetter":"C"},{"id":430700,"brief":"常德","pname":"湖南省","hotFlag":0,"firstLetter":"C"},{"id":431000,"brief":"郴州","pname":"湖南省","hotFlag":0,"firstLetter":"C"},{"id":445100,"brief":"潮州","pname":"广东省","hotFlag":0,"firstLetter":"C"},{"id":451400,"brief":"崇左","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"C"},{"id":469023,"brief":"澄迈","pname":"海南省","hotFlag":0,"firstLetter":"C"},{"id":469026,"brief":"昌江","pname":"海南省","hotFlag":0,"firstLetter":"C"},{"id":500100,"brief":"重庆","pname":"重庆市","hotFlag":0,"firstLetter":"C"},{"id":500200,"brief":"重庆郊","pname":"重庆市","hotFlag":0,"firstLetter":"C"},{"id":510100,"brief":"成都","pname":"四川省","hotFlag":0,"firstLetter":"C"},{"id":532300,"brief":"楚雄","pname":"云南省","hotFlag":0,"firstLetter":"C"},{"id":540300,"brief":"昌都","pname":"西藏自治区","hotFlag":0,"firstLetter":"C"},{"id":652300,"brief":"昌吉","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"C"}],"D":[{"id":140200,"brief":"大同","pname":"山西省","hotFlag":0,"firstLetter":"D"},{"id":210200,"brief":"大连","pname":"辽宁省","hotFlag":1,"firstLetter":"D"},{"id":210600,"brief":"丹东","pname":"辽宁省","hotFlag":0,"firstLetter":"D"},{"id":230600,"brief":"大庆","pname":"黑龙江省","hotFlag":0,"firstLetter":"D"},{"id":232700,"brief":"大兴安岭","pname":"黑龙江省","hotFlag":0,"firstLetter":"D"},{"id":370500,"brief":"东营","pname":"山东省","hotFlag":0,"firstLetter":"D"},{"id":371400,"brief":"德州","pname":"山东省","hotFlag":0,"firstLetter":"D"},{"id":441900,"brief":"东莞","pname":"广东省","hotFlag":0,"firstLetter":"D"},{"id":460400,"brief":"儋州","pname":"海南省","hotFlag":0,"firstLetter":"D"},{"id":469007,"brief":"东方","pname":"海南省","hotFlag":0,"firstLetter":"D"},{"id":469021,"brief":"定安","pname":"海南省","hotFlag":0,"firstLetter":"D"},{"id":510600,"brief":"德阳","pname":"四川省","hotFlag":0,"firstLetter":"D"},{"id":511700,"brief":"达州","pname":"四川省","hotFlag":0,"firstLetter":"D"},{"id":532900,"brief":"大理","pname":"云南省","hotFlag":0,"firstLetter":"D"},{"id":533100,"brief":"德宏","pname":"云南省","hotFlag":0,"firstLetter":"D"},{"id":533400,"brief":"迪庆","pname":"云南省","hotFlag":0,"firstLetter":"D"},{"id":621100,"brief":"定西","pname":"甘肃省","hotFlag":0,"firstLetter":"D"}],"E":[{"id":150600,"brief":"鄂尔多斯","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"E"},{"id":420700,"brief":"鄂州","pname":"湖北省","hotFlag":0,"firstLetter":"E"},{"id":422800,"brief":"恩施","pname":"湖北省","hotFlag":0,"firstLetter":"E"}],"F":[{"id":210400,"brief":"抚顺","pname":"辽宁省","hotFlag":0,"firstLetter":"F"},{"id":210900,"brief":"阜新","pname":"辽宁省","hotFlag":0,"firstLetter":"F"},{"id":341200,"brief":"阜阳","pname":"安徽省","hotFlag":0,"firstLetter":"F"},{"id":350100,"brief":"福州","pname":"福建省","hotFlag":0,"firstLetter":"F"},{"id":361000,"brief":"抚州","pname":"江西省","hotFlag":0,"firstLetter":"F"},{"id":440600,"brief":"佛山","pname":"广东省","hotFlag":0,"firstLetter":"F"},{"id":450600,"brief":"防城港","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"F"}],"G":[{"id":360700,"brief":"赣州","pname":"江西省","hotFlag":0,"firstLetter":"G"},{"id":440100,"brief":"广州","pname":"广东省","hotFlag":0,"firstLetter":"G"},{"id":450300,"brief":"桂林","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"G"},{"id":450800,"brief":"贵港","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"G"},{"id":510800,"brief":"广元","pname":"四川省","hotFlag":0,"firstLetter":"G"},{"id":511600,"brief":"广安","pname":"四川省","hotFlag":0,"firstLetter":"G"},{"id":513300,"brief":"甘孜","pname":"四川省","hotFlag":0,"firstLetter":"G"},{"id":520100,"brief":"贵阳","pname":"贵州省","hotFlag":0,"firstLetter":"G"},{"id":623000,"brief":"甘南","pname":"甘肃省","hotFlag":0,"firstLetter":"G"},{"id":632600,"brief":"果洛","pname":"青海省","hotFlag":0,"firstLetter":"G"},{"id":640400,"brief":"固原","pname":"宁夏回族自治区","hotFlag":0,"firstLetter":"G"},{"id":710200,"brief":"高雄","pname":"台湾省","hotFlag":0,"firstLetter":"G"}],"H":[{"id":130400,"brief":"邯郸","pname":"河北省","hotFlag":0,"firstLetter":"H"},{"id":131100,"brief":"衡水","pname":"河北省","hotFlag":0,"firstLetter":"H"},{"id":150100,"brief":"呼和浩特","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"H"},{"id":150700,"brief":"呼伦贝尔","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"H"},{"id":211400,"brief":"葫芦岛","pname":"辽宁省","hotFlag":0,"firstLetter":"H"},{"id":230100,"brief":"哈尔滨","pname":"黑龙江省","hotFlag":0,"firstLetter":"H"},{"id":230400,"brief":"鹤岗","pname":"黑龙江省","hotFlag":0,"firstLetter":"H"},{"id":231100,"brief":"黑河","pname":"黑龙江省","hotFlag":0,"firstLetter":"H"},{"id":320800,"brief":"淮安","pname":"江苏省","hotFlag":0,"firstLetter":"H"},{"id":330100,"brief":"杭州","pname":"浙江省","hotFlag":0,"firstLetter":"H"},{"id":330500,"brief":"湖州","pname":"浙江省","hotFlag":0,"firstLetter":"H"},{"id":340100,"brief":"合肥","pname":"安徽省","hotFlag":0,"firstLetter":"H"},{"id":340400,"brief":"淮南","pname":"安徽省","hotFlag":0,"firstLetter":"H"},{"id":340600,"brief":"淮北","pname":"安徽省","hotFlag":0,"firstLetter":"H"},{"id":341000,"brief":"黄山","pname":"安徽省","hotFlag":0,"firstLetter":"H"},{"id":371700,"brief":"菏泽","pname":"山东省","hotFlag":0,"firstLetter":"H"},{"id":410600,"brief":"鹤壁","pname":"河南省","hotFlag":0,"firstLetter":"H"},{"id":420200,"brief":"黄石","pname":"湖北省","hotFlag":0,"firstLetter":"H"},{"id":421100,"brief":"黄冈","pname":"湖北省","hotFlag":0,"firstLetter":"H"},{"id":430400,"brief":"衡阳","pname":"湖南省","hotFlag":0,"firstLetter":"H"},{"id":431200,"brief":"怀化","pname":"湖南省","hotFlag":0,"firstLetter":"H"},{"id":441300,"brief":"惠州","pname":"广东省","hotFlag":0,"firstLetter":"H"},{"id":441600,"brief":"河源","pname":"广东省","hotFlag":0,"firstLetter":"H"},{"id":451100,"brief":"贺州","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"H"},{"id":451200,"brief":"河池","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"H"},{"id":460100,"brief":"海口","pname":"海南省","hotFlag":0,"firstLetter":"H"},{"id":532500,"brief":"红河","pname":"云南省","hotFlag":0,"firstLetter":"H"},{"id":610700,"brief":"汉中","pname":"陕西省","hotFlag":0,"firstLetter":"H"},{"id":630200,"brief":"海东","pname":"青海省","hotFlag":0,"firstLetter":"H"},{"id":632200,"brief":"海北","pname":"青海省","hotFlag":0,"firstLetter":"H"},{"id":632300,"brief":"黄南","pname":"青海省","hotFlag":0,"firstLetter":"H"},{"id":632500,"brief":"海南","pname":"青海省","hotFlag":0,"firstLetter":"H"},{"id":632800,"brief":"海西","pname":"青海省","hotFlag":0,"firstLetter":"H"},{"id":650500,"brief":"哈密","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"H"},{"id":653200,"brief":"和田","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"H"},{"id":659010,"brief":"胡杨河","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"H"},{"id":719013,"brief":"花莲","pname":"台湾省","hotFlag":0,"firstLetter":"H"}],"J":[{"id":140500,"brief":"晋城","pname":"山西省","hotFlag":0,"firstLetter":"J"},{"id":140700,"brief":"晋中","pname":"山西省","hotFlag":0,"firstLetter":"J"},{"id":210700,"brief":"锦州","pname":"辽宁省","hotFlag":0,"firstLetter":"J"},{"id":220200,"brief":"吉林","pname":"吉林省","hotFlag":0,"firstLetter":"J"},{"id":230300,"brief":"鸡西","pname":"黑龙江省","hotFlag":0,"firstLetter":"J"},{"id":230800,"brief":"佳木斯","pname":"黑龙江省","hotFlag":0,"firstLetter":"J"},{"id":330400,"brief":"嘉兴","pname":"浙江省","hotFlag":0,"firstLetter":"J"},{"id":330700,"brief":"金华","pname":"浙江省","hotFlag":0,"firstLetter":"J"},{"id":360200,"brief":"景德镇","pname":"江西省","hotFlag":0,"firstLetter":"J"},{"id":360400,"brief":"九江","pname":"江西省","hotFlag":0,"firstLetter":"J"},{"id":360800,"brief":"吉安","pname":"江西省","hotFlag":0,"firstLetter":"J"},{"id":370100,"brief":"济南","pname":"山东省","hotFlag":0,"firstLetter":"J"},{"id":370800,"brief":"济宁","pname":"山东省","hotFlag":0,"firstLetter":"J"},{"id":410800,"brief":"焦作","pname":"河南省","hotFlag":0,"firstLetter":"J"},{"id":419001,"brief":"济源","pname":"河南省","hotFlag":0,"firstLetter":"J"},{"id":420800,"brief":"荆门","pname":"湖北省","hotFlag":0,"firstLetter":"J"},{"id":421000,"brief":"荆州","pname":"湖北省","hotFlag":0,"firstLetter":"J"},{"id":440700,"brief":"江门","pname":"广东省","hotFlag":0,"firstLetter":"J"},{"id":445200,"brief":"揭阳","pname":"广东省","hotFlag":0,"firstLetter":"J"},{"id":620200,"brief":"嘉峪关","pname":"甘肃省","hotFlag":0,"firstLetter":"J"},{"id":620300,"brief":"金昌","pname":"甘肃省","hotFlag":0,"firstLetter":"J"},{"id":620900,"brief":"酒泉","pname":"甘肃省","hotFlag":0,"firstLetter":"J"},{"id":712000,"brief":"嘉义","pname":"台湾省","hotFlag":0,"firstLetter":"J"},{"id":719001,"brief":"基隆","pname":"台湾省","hotFlag":0,"firstLetter":"J"},{"id":719010,"brief":"嘉义","pname":"台湾省","hotFlag":0,"firstLetter":"J"}],"K":[{"id":410200,"brief":"开封","pname":"河南省","hotFlag":0,"firstLetter":"K"},{"id":530100,"brief":"昆明","pname":"云南省","hotFlag":0,"firstLetter":"K"},{"id":650200,"brief":"克拉玛依","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"K"},{"id":653000,"brief":"克孜勒苏","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"K"},{"id":653100,"brief":"喀什","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"K"},{"id":659008,"brief":"可克达拉","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"K"},{"id":659009,"brief":"昆玉","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"K"}],"L":[{"id":131000,"brief":"廊坊","pname":"河北省","hotFlag":0,"firstLetter":"L"},{"id":141000,"brief":"临汾","pname":"山西省","hotFlag":0,"firstLetter":"L"},{"id":141100,"brief":"吕梁","pname":"山西省","hotFlag":0,"firstLetter":"L"},{"id":211000,"brief":"辽阳","pname":"辽宁省","hotFlag":0,"firstLetter":"L"},{"id":220400,"brief":"辽源","pname":"吉林省","hotFlag":0,"firstLetter":"L"},{"id":320700,"brief":"连云港","pname":"江苏省","hotFlag":0,"firstLetter":"L"},{"id":331100,"brief":"丽水","pname":"浙江省","hotFlag":0,"firstLetter":"L"},{"id":341500,"brief":"六安","pname":"安徽省","hotFlag":0,"firstLetter":"L"},{"id":350800,"brief":"龙岩","pname":"福建省","hotFlag":0,"firstLetter":"L"},{"id":371300,"brief":"临沂","pname":"山东省","hotFlag":0,"firstLetter":"L"},{"id":371500,"brief":"聊城","pname":"山东省","hotFlag":0,"firstLetter":"L"},{"id":410300,"brief":"洛阳","pname":"河南省","hotFlag":0,"firstLetter":"L"},{"id":411100,"brief":"漯河","pname":"河南省","hotFlag":0,"firstLetter":"L"},{"id":431300,"brief":"娄底","pname":"湖南省","hotFlag":0,"firstLetter":"L"},{"id":450200,"brief":"柳州","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"L"},{"id":451300,"brief":"来宾","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"L"},{"id":469024,"brief":"临高","pname":"海南省","hotFlag":0,"firstLetter":"L"},{"id":469027,"brief":"乐东","pname":"海南省","hotFlag":0,"firstLetter":"L"},{"id":469028,"brief":"陵水","pname":"海南省","hotFlag":0,"firstLetter":"L"},{"id":510500,"brief":"泸州","pname":"四川省","hotFlag":0,"firstLetter":"L"},{"id":511100,"brief":"乐山","pname":"四川省","hotFlag":0,"firstLetter":"L"},{"id":513400,"brief":"凉山","pname":"四川省","hotFlag":0,"firstLetter":"L"},{"id":520200,"brief":"六盘水","pname":"贵州省","hotFlag":0,"firstLetter":"L"},{"id":530700,"brief":"丽江","pname":"云南省","hotFlag":0,"firstLetter":"L"},{"id":530900,"brief":"临沧","pname":"云南省","hotFlag":0,"firstLetter":"L"},{"id":540100,"brief":"拉萨","pname":"西藏自治区","hotFlag":0,"firstLetter":"L"},{"id":540400,"brief":"林芝","pname":"西藏自治区","hotFlag":0,"firstLetter":"L"},{"id":620100,"brief":"兰州","pname":"甘肃省","hotFlag":0,"firstLetter":"L"},{"id":621200,"brief":"陇南","pname":"甘肃省","hotFlag":0,"firstLetter":"L"},{"id":622900,"brief":"临夏","pname":"甘肃省","hotFlag":0,"firstLetter":"L"}],"M":[{"id":231000,"brief":"牡丹江","pname":"黑龙江省","hotFlag":0,"firstLetter":"M"},{"id":340500,"brief":"马鞍山","pname":"安徽省","hotFlag":0,"firstLetter":"M"},{"id":440900,"brief":"茂名","pname":"广东省","hotFlag":0,"firstLetter":"M"},{"id":441400,"brief":"梅州","pname":"广东省","hotFlag":0,"firstLetter":"M"},{"id":510700,"brief":"绵阳","pname":"四川省","hotFlag":0,"firstLetter":"M"},{"id":511400,"brief":"眉山","pname":"四川省","hotFlag":0,"firstLetter":"M"},{"id":719006,"brief":"苗栗","pname":"台湾省","hotFlag":0,"firstLetter":"M"}],"N":[{"id":320100,"brief":"南京","pname":"江苏省","hotFlag":1,"firstLetter":"N"},{"id":320600,"brief":"南通","pname":"江苏省","hotFlag":0,"firstLetter":"N"},{"id":330200,"brief":"宁波","pname":"浙江省","hotFlag":0,"firstLetter":"N"},{"id":350700,"brief":"南平","pname":"福建省","hotFlag":0,"firstLetter":"N"},{"id":350900,"brief":"宁德","pname":"福建省","hotFlag":0,"firstLetter":"N"},{"id":360100,"brief":"南昌","pname":"江西省","hotFlag":0,"firstLetter":"N"},{"id":411300,"brief":"南阳","pname":"河南省","hotFlag":0,"firstLetter":"N"},{"id":450100,"brief":"南宁","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"N"},{"id":511000,"brief":"内江","pname":"四川省","hotFlag":0,"firstLetter":"N"},{"id":511300,"brief":"南充","pname":"四川省","hotFlag":0,"firstLetter":"N"},{"id":533300,"brief":"怒江","pname":"云南省","hotFlag":0,"firstLetter":"N"},{"id":540600,"brief":"那曲","pname":"西藏自治区","hotFlag":0,"firstLetter":"N"},{"id":719009,"brief":"南投","pname":"台湾省","hotFlag":0,"firstLetter":"N"}],"P":[{"id":211100,"brief":"盘锦","pname":"辽宁省","hotFlag":0,"firstLetter":"P"},{"id":350300,"brief":"莆田","pname":"福建省","hotFlag":0,"firstLetter":"P"},{"id":360300,"brief":"萍乡","pname":"江西省","hotFlag":0,"firstLetter":"P"},{"id":410400,"brief":"平顶山","pname":"河南省","hotFlag":0,"firstLetter":"P"},{"id":410900,"brief":"濮阳","pname":"河南省","hotFlag":0,"firstLetter":"P"},{"id":510400,"brief":"攀枝花","pname":"四川省","hotFlag":0,"firstLetter":"P"},{"id":530800,"brief":"普洱","pname":"云南省","hotFlag":0,"firstLetter":"P"},{"id":620800,"brief":"平凉","pname":"甘肃省","hotFlag":0,"firstLetter":"P"},{"id":719011,"brief":"屏东","pname":"台湾省","hotFlag":0,"firstLetter":"P"},{"id":719014,"brief":"澎湖","pname":"台湾省","hotFlag":0,"firstLetter":"P"}],"Q":[{"id":130300,"brief":"秦皇岛","pname":"河北省","hotFlag":0,"firstLetter":"Q"},{"id":230200,"brief":"齐齐哈尔","pname":"黑龙江省","hotFlag":0,"firstLetter":"Q"},{"id":230900,"brief":"七台河","pname":"黑龙江省","hotFlag":0,"firstLetter":"Q"},{"id":330800,"brief":"衢州","pname":"浙江省","hotFlag":0,"firstLetter":"Q"},{"id":350500,"brief":"泉州","pname":"福建省","hotFlag":0,"firstLetter":"Q"},{"id":370200,"brief":"青岛","pname":"山东省","hotFlag":0,"firstLetter":"Q"},{"id":429005,"brief":"潜江","pname":"湖北省","hotFlag":0,"firstLetter":"Q"},{"id":441800,"brief":"清远","pname":"广东省","hotFlag":0,"firstLetter":"Q"},{"id":450700,"brief":"钦州","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"Q"},{"id":469002,"brief":"琼海","pname":"海南省","hotFlag":0,"firstLetter":"Q"},{"id":469030,"brief":"琼中","pname":"海南省","hotFlag":0,"firstLetter":"Q"},{"id":522300,"brief":"黔西","pname":"贵州省","hotFlag":0,"firstLetter":"Q"},{"id":522600,"brief":"黔东","pname":"贵州省","hotFlag":0,"firstLetter":"Q"},{"id":522700,"brief":"黔南","pname":"贵州省","hotFlag":0,"firstLetter":"Q"},{"id":530300,"brief":"曲靖","pname":"云南省","hotFlag":0,"firstLetter":"Q"},{"id":621000,"brief":"庆阳","pname":"甘肃省","hotFlag":0,"firstLetter":"Q"}],"R":[{"id":371100,"brief":"日照","pname":"山东省","hotFlag":0,"firstLetter":"R"},{"id":540200,"brief":"日喀则","pname":"西藏自治区","hotFlag":0,"firstLetter":"R"}],"S":[{"id":130100,"brief":"石家庄","pname":"河北省","hotFlag":0,"firstLetter":"S"},{"id":140600,"brief":"朔州","pname":"山西省","hotFlag":0,"firstLetter":"S"},{"id":210100,"brief":"沈阳","pname":"辽宁省","hotFlag":1,"firstLetter":"S"},{"id":220300,"brief":"四平","pname":"吉林省","hotFlag":0,"firstLetter":"S"},{"id":220700,"brief":"松原","pname":"吉林省","hotFlag":0,"firstLetter":"S"},{"id":230500,"brief":"双鸭山","pname":"黑龙江省","hotFlag":0,"firstLetter":"S"},{"id":231200,"brief":"绥化","pname":"黑龙江省","hotFlag":0,"firstLetter":"S"},{"id":310100,"brief":"上海","pname":"上海市","hotFlag":1,"firstLetter":"S"},{"id":320500,"brief":"苏州","pname":"江苏省","hotFlag":0,"firstLetter":"S"},{"id":321300,"brief":"宿迁","pname":"江苏省","hotFlag":0,"firstLetter":"S"},{"id":330600,"brief":"绍兴","pname":"浙江省","hotFlag":0,"firstLetter":"S"},{"id":341300,"brief":"宿州","pname":"安徽省","hotFlag":0,"firstLetter":"S"},{"id":350400,"brief":"三明","pname":"福建省","hotFlag":0,"firstLetter":"S"},{"id":361100,"brief":"上饶","pname":"江西省","hotFlag":0,"firstLetter":"S"},{"id":411200,"brief":"三门峡","pname":"河南省","hotFlag":0,"firstLetter":"S"},{"id":411400,"brief":"商丘","pname":"河南省","hotFlag":0,"firstLetter":"S"},{"id":420300,"brief":"十堰","pname":"湖北省","hotFlag":0,"firstLetter":"S"},{"id":421300,"brief":"随州","pname":"湖北省","hotFlag":0,"firstLetter":"S"},{"id":429021,"brief":"神农架林区","pname":"湖北省","hotFlag":0,"firstLetter":"S"},{"id":430500,"brief":"邵阳","pname":"湖南省","hotFlag":0,"firstLetter":"S"},{"id":440200,"brief":"韶关","pname":"广东省","hotFlag":0,"firstLetter":"S"},{"id":440300,"brief":"深圳","pname":"广东省","hotFlag":1,"firstLetter":"S"},{"id":440500,"brief":"汕头","pname":"广东省","hotFlag":0,"firstLetter":"S"},{"id":441500,"brief":"汕尾","pname":"广东省","hotFlag":0,"firstLetter":"S"},{"id":460200,"brief":"三亚","pname":"海南省","hotFlag":0,"firstLetter":"S"},{"id":460300,"brief":"三沙","pname":"海南省","hotFlag":0,"firstLetter":"S"},{"id":510900,"brief":"遂宁","pname":"四川省","hotFlag":0,"firstLetter":"S"},{"id":540500,"brief":"山南","pname":"西藏自治区","hotFlag":0,"firstLetter":"S"},{"id":611000,"brief":"商洛","pname":"陕西省","hotFlag":0,"firstLetter":"S"},{"id":640200,"brief":"石嘴山","pname":"宁夏回族自治区","hotFlag":0,"firstLetter":"S"},{"id":659001,"brief":"石河子","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"S"},{"id":659007,"brief":"双河","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"S"}],"T":[{"id":120100,"brief":"天津","pname":"天津市","hotFlag":0,"firstLetter":"T"},{"id":130200,"brief":"唐山","pname":"河北省","hotFlag":0,"firstLetter":"T"},{"id":140100,"brief":"太原","pname":"山西省","hotFlag":0,"firstLetter":"T"},{"id":150500,"brief":"通辽","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"T"},{"id":211200,"brief":"铁岭","pname":"辽宁省","hotFlag":0,"firstLetter":"T"},{"id":220500,"brief":"通化","pname":"吉林省","hotFlag":0,"firstLetter":"T"},{"id":321200,"brief":"泰州","pname":"江苏省","hotFlag":0,"firstLetter":"T"},{"id":331000,"brief":"台州","pname":"浙江省","hotFlag":0,"firstLetter":"T"},{"id":340700,"brief":"铜陵","pname":"安徽省","hotFlag":0,"firstLetter":"T"},{"id":370900,"brief":"泰安","pname":"山东省","hotFlag":0,"firstLetter":"T"},{"id":429006,"brief":"天门","pname":"湖北省","hotFlag":0,"firstLetter":"T"},{"id":469022,"brief":"屯昌","pname":"海南省","hotFlag":0,"firstLetter":"T"},{"id":520600,"brief":"铜仁","pname":"贵州省","hotFlag":0,"firstLetter":"T"},{"id":610200,"brief":"铜川","pname":"陕西省","hotFlag":0,"firstLetter":"T"},{"id":620500,"brief":"天水","pname":"甘肃省","hotFlag":0,"firstLetter":"T"},{"id":650400,"brief":"吐鲁番","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"T"},{"id":654200,"brief":"塔城","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"T"},{"id":659003,"brief":"图木舒克","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"T"},{"id":659006,"brief":"铁门关","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"T"},{"id":710100,"brief":"台北","pname":"台湾省","hotFlag":0,"firstLetter":"T"},{"id":710400,"brief":"台中","pname":"台湾省","hotFlag":0,"firstLetter":"T"},{"id":710500,"brief":"台南","pname":"台湾省","hotFlag":0,"firstLetter":"T"},{"id":710600,"brief":"桃园","pname":"台湾省","hotFlag":0,"firstLetter":"T"},{"id":719012,"brief":"台东","pname":"台湾省","hotFlag":0,"firstLetter":"T"}],"W":[{"id":150300,"brief":"乌海","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"W"},{"id":150900,"brief":"乌兰察布","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"W"},{"id":320200,"brief":"无锡","pname":"江苏省","hotFlag":0,"firstLetter":"W"},{"id":330300,"brief":"温州","pname":"浙江省","hotFlag":0,"firstLetter":"W"},{"id":340200,"brief":"芜湖","pname":"安徽省","hotFlag":0,"firstLetter":"W"},{"id":370700,"brief":"潍坊","pname":"山东省","hotFlag":0,"firstLetter":"W"},{"id":371000,"brief":"威海","pname":"山东省","hotFlag":0,"firstLetter":"W"},{"id":420100,"brief":"武汉","pname":"湖北省","hotFlag":1,"firstLetter":"W"},{"id":450400,"brief":"梧州","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"W"},{"id":469001,"brief":"五指山","pname":"海南省","hotFlag":0,"firstLetter":"W"},{"id":469005,"brief":"文昌","pname":"海南省","hotFlag":0,"firstLetter":"W"},{"id":469006,"brief":"万宁","pname":"海南省","hotFlag":0,"firstLetter":"W"},{"id":532600,"brief":"文山","pname":"云南省","hotFlag":0,"firstLetter":"W"},{"id":610500,"brief":"渭南","pname":"陕西省","hotFlag":0,"firstLetter":"W"},{"id":620600,"brief":"武威","pname":"甘肃省","hotFlag":0,"firstLetter":"W"},{"id":640300,"brief":"吴忠","pname":"宁夏回族自治区","hotFlag":0,"firstLetter":"W"},{"id":650100,"brief":"乌鲁木齐","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"W"},{"id":659004,"brief":"五家渠","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"W"}],"X":[{"id":130500,"brief":"邢台","pname":"河北省","hotFlag":0,"firstLetter":"X"},{"id":140900,"brief":"忻州","pname":"山西省","hotFlag":0,"firstLetter":"X"},{"id":152200,"brief":"兴安盟","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"X"},{"id":152500,"brief":"锡林郭勒盟","pname":"内蒙古自治区","hotFlag":0,"firstLetter":"X"},{"id":320300,"brief":"徐州","pname":"江苏省","hotFlag":0,"firstLetter":"X"},{"id":341800,"brief":"宣城","pname":"安徽省","hotFlag":0,"firstLetter":"X"},{"id":350200,"brief":"厦门","pname":"福建省","hotFlag":0,"firstLetter":"X"},{"id":360500,"brief":"新余","pname":"江西省","hotFlag":0,"firstLetter":"X"},{"id":410700,"brief":"新乡","pname":"河南省","hotFlag":0,"firstLetter":"X"},{"id":411000,"brief":"许昌","pname":"河南省","hotFlag":0,"firstLetter":"X"},{"id":411500,"brief":"信阳","pname":"河南省","hotFlag":0,"firstLetter":"X"},{"id":420600,"brief":"襄阳","pname":"湖北省","hotFlag":0,"firstLetter":"X"},{"id":420900,"brief":"孝感","pname":"湖北省","hotFlag":0,"firstLetter":"X"},{"id":421200,"brief":"咸宁","pname":"湖北省","hotFlag":0,"firstLetter":"X"},{"id":429004,"brief":"仙桃","pname":"湖北省","hotFlag":0,"firstLetter":"X"},{"id":430300,"brief":"湘潭","pname":"湖南省","hotFlag":0,"firstLetter":"X"},{"id":433100,"brief":"湘西","pname":"湖南省","hotFlag":0,"firstLetter":"X"},{"id":532800,"brief":"西双版纳","pname":"云南省","hotFlag":0,"firstLetter":"X"},{"id":610100,"brief":"西安","pname":"陕西省","hotFlag":0,"firstLetter":"X"},{"id":610400,"brief":"咸阳","pname":"陕西省","hotFlag":0,"firstLetter":"X"},{"id":630100,"brief":"西宁","pname":"青海省","hotFlag":0,"firstLetter":"X"},{"id":710300,"brief":"新北","pname":"台湾省","hotFlag":0,"firstLetter":"X"},{"id":719002,"brief":"新竹","pname":"台湾省","hotFlag":0,"firstLetter":"X"},{"id":719004,"brief":"新竹","pname":"台湾省","hotFlag":0,"firstLetter":"X"},{"id":810100,"brief":"香港","pname":"香港特别行政区","hotFlag":0,"firstLetter":"X"}],"Y":[{"id":140300,"brief":"阳泉","pname":"山西省","hotFlag":0,"firstLetter":"Y"},{"id":140800,"brief":"运城","pname":"山西省","hotFlag":0,"firstLetter":"Y"},{"id":210800,"brief":"营口","pname":"辽宁省","hotFlag":0,"firstLetter":"Y"},{"id":222400,"brief":"延边","pname":"吉林省","hotFlag":0,"firstLetter":"Y"},{"id":230700,"brief":"伊春","pname":"黑龙江省","hotFlag":0,"firstLetter":"Y"},{"id":320900,"brief":"盐城","pname":"江苏省","hotFlag":0,"firstLetter":"Y"},{"id":321000,"brief":"扬州","pname":"江苏省","hotFlag":0,"firstLetter":"Y"},{"id":360600,"brief":"鹰潭","pname":"江西省","hotFlag":0,"firstLetter":"Y"},{"id":360900,"brief":"宜春","pname":"江西省","hotFlag":0,"firstLetter":"Y"},{"id":370600,"brief":"烟台","pname":"山东省","hotFlag":0,"firstLetter":"Y"},{"id":420500,"brief":"宜昌","pname":"湖北省","hotFlag":0,"firstLetter":"Y"},{"id":430600,"brief":"岳阳","pname":"湖南省","hotFlag":0,"firstLetter":"Y"},{"id":430900,"brief":"益阳","pname":"湖南省","hotFlag":0,"firstLetter":"Y"},{"id":431100,"brief":"永州","pname":"湖南省","hotFlag":0,"firstLetter":"Y"},{"id":441700,"brief":"阳江","pname":"广东省","hotFlag":0,"firstLetter":"Y"},{"id":445300,"brief":"云浮","pname":"广东省","hotFlag":0,"firstLetter":"Y"},{"id":450900,"brief":"玉林","pname":"广西壮族自治区","hotFlag":0,"firstLetter":"Y"},{"id":511500,"brief":"宜宾","pname":"四川省","hotFlag":0,"firstLetter":"Y"},{"id":511800,"brief":"雅安","pname":"四川省","hotFlag":0,"firstLetter":"Y"},{"id":530400,"brief":"玉溪","pname":"云南省","hotFlag":0,"firstLetter":"Y"},{"id":610600,"brief":"延安","pname":"陕西省","hotFlag":0,"firstLetter":"Y"},{"id":610800,"brief":"榆林","pname":"陕西省","hotFlag":0,"firstLetter":"Y"},{"id":632700,"brief":"玉树","pname":"青海省","hotFlag":0,"firstLetter":"Y"},{"id":640100,"brief":"银川","pname":"宁夏回族自治区","hotFlag":0,"firstLetter":"Y"},{"id":654000,"brief":"伊犁哈萨","pname":"新疆维吾尔自治区","hotFlag":0,"firstLetter":"Y"},{"id":719005,"brief":"宜兰","pname":"台湾省","hotFlag":0,"firstLetter":"Y"},{"id":719008,"brief":"云林","pname":"台湾省","hotFlag":0,"firstLetter":"Y"}],"Z":[{"id":130700,"brief":"张家口","pname":"河北省","hotFlag":0,"firstLetter":"Z"},{"id":211300,"brief":"朝阳","pname":"辽宁省","hotFlag":0,"firstLetter":"Z"},{"id":321100,"brief":"镇江","pname":"江苏省","hotFlag":0,"firstLetter":"Z"},{"id":330900,"brief":"舟山","pname":"浙江省","hotFlag":0,"firstLetter":"Z"},{"id":350600,"brief":"漳州","pname":"福建省","hotFlag":0,"firstLetter":"Z"},{"id":370300,"brief":"淄博","pname":"山东省","hotFlag":0,"firstLetter":"Z"},{"id":370400,"brief":"枣庄","pname":"山东省","hotFlag":0,"firstLetter":"Z"},{"id":410100,"brief":"郑州","pname":"河南省","hotFlag":0,"firstLetter":"Z"},{"id":411600,"brief":"周口","pname":"河南省","hotFlag":0,"firstLetter":"Z"},{"id":411700,"brief":"驻马店","pname":"河南省","hotFlag":0,"firstLetter":"Z"},{"id":430200,"brief":"株洲","pname":"湖南省","hotFlag":0,"firstLetter":"Z"},{"id":430800,"brief":"张家界","pname":"湖南省","hotFlag":0,"firstLetter":"Z"},{"id":440400,"brief":"珠海","pname":"广东省","hotFlag":0,"firstLetter":"Z"},{"id":440800,"brief":"湛江","pname":"广东省","hotFlag":0,"firstLetter":"Z"},{"id":441200,"brief":"肇庆","pname":"广东省","hotFlag":0,"firstLetter":"Z"},{"id":442000,"brief":"中山","pname":"广东省","hotFlag":0,"firstLetter":"Z"},{"id":510300,"brief":"自贡","pname":"四川省","hotFlag":0,"firstLetter":"Z"},{"id":512000,"brief":"资阳","pname":"四川省","hotFlag":0,"firstLetter":"Z"},{"id":520300,"brief":"遵义","pname":"贵州省","hotFlag":0,"firstLetter":"Z"},{"id":530600,"brief":"昭通","pname":"云南省","hotFlag":0,"firstLetter":"Z"},{"id":620700,"brief":"张掖","pname":"甘肃省","hotFlag":0,"firstLetter":"Z"},{"id":640500,"brief":"中卫","pname":"宁夏回族自治区","hotFlag":0,"firstLetter":"Z"},{"id":719007,"brief":"彰化","pname":"台湾省","hotFlag":0,"firstLetter":"Z"}]}
         * cityName : 北京
         * cityId : 110100
         * bgImg : https://alipic.lanhuapp.com/SketchPng687334a453aca34095c253fd48dad833cb209a935776d5fae0f185c0a0a5e267
         */

        private String channelName;
        private String tripStandard;
        private CityListBean cityList;
        private String cityName;
        private int cityId;
        private String bgImg;
        private List<HotCityListBean> hotCityList;
        private List<String> firstLetterList;

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }

        public String getTripStandard() {
            return tripStandard;
        }

        public void setTripStandard(String tripStandard) {
            this.tripStandard = tripStandard;
        }

        public CityListBean getCityList() {
            return cityList;
        }

        public void setCityList(CityListBean cityList) {
            this.cityList = cityList;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public String getBgImg() {
            return bgImg;
        }

        public void setBgImg(String bgImg) {
            this.bgImg = bgImg;
        }

        public List<HotCityListBean> getHotCityList() {
            return hotCityList;
        }

        public void setHotCityList(List<HotCityListBean> hotCityList) {
            this.hotCityList = hotCityList;
        }

        public List<String> getFirstLetterList() {
            return firstLetterList;
        }

        public void setFirstLetterList(List<String> firstLetterList) {
            this.firstLetterList = firstLetterList;
        }
        @Keep
        public static class CityListBean {
            private List<ABean> A;
            private List<BBean> B;
            private List<CBean> C;
            private List<DBean> D;
            private List<EBean> E;
            private List<FBean> F;
            private List<GBean> G;
            private List<HBean> H;
            private List<JBean> J;
            private List<KBean> K;
            private List<LBean> L;
            private List<MBean> M;
            private List<NBean> N;
            private List<PBean> P;
            private List<QBean> Q;
            private List<RBean> R;
            private List<SBean> S;
            private List<TBean> T;
            private List<WBean> W;
            private List<XBean> X;
            private List<YBean> Y;
            private List<ZBean> Z;

            public List<ABean> getA() {
                return A;
            }

            public void setA(List<ABean> A) {
                this.A = A;
            }

            public List<BBean> getB() {
                return B;
            }

            public void setB(List<BBean> B) {
                this.B = B;
            }

            public List<CBean> getC() {
                return C;
            }

            public void setC(List<CBean> C) {
                this.C = C;
            }

            public List<DBean> getD() {
                return D;
            }

            public void setD(List<DBean> D) {
                this.D = D;
            }

            public List<EBean> getE() {
                return E;
            }

            public void setE(List<EBean> E) {
                this.E = E;
            }

            public List<FBean> getF() {
                return F;
            }

            public void setF(List<FBean> F) {
                this.F = F;
            }

            public List<GBean> getG() {
                return G;
            }

            public void setG(List<GBean> G) {
                this.G = G;
            }

            public List<HBean> getH() {
                return H;
            }

            public void setH(List<HBean> H) {
                this.H = H;
            }

            public List<JBean> getJ() {
                return J;
            }

            public void setJ(List<JBean> J) {
                this.J = J;
            }

            public List<KBean> getK() {
                return K;
            }

            public void setK(List<KBean> K) {
                this.K = K;
            }

            public List<LBean> getL() {
                return L;
            }

            public void setL(List<LBean> L) {
                this.L = L;
            }

            public List<MBean> getM() {
                return M;
            }

            public void setM(List<MBean> M) {
                this.M = M;
            }

            public List<NBean> getN() {
                return N;
            }

            public void setN(List<NBean> N) {
                this.N = N;
            }

            public List<PBean> getP() {
                return P;
            }

            public void setP(List<PBean> P) {
                this.P = P;
            }

            public List<QBean> getQ() {
                return Q;
            }

            public void setQ(List<QBean> Q) {
                this.Q = Q;
            }

            public List<RBean> getR() {
                return R;
            }

            public void setR(List<RBean> R) {
                this.R = R;
            }

            public List<SBean> getS() {
                return S;
            }

            public void setS(List<SBean> S) {
                this.S = S;
            }

            public List<TBean> getT() {
                return T;
            }

            public void setT(List<TBean> T) {
                this.T = T;
            }

            public List<WBean> getW() {
                return W;
            }

            public void setW(List<WBean> W) {
                this.W = W;
            }

            public List<XBean> getX() {
                return X;
            }

            public void setX(List<XBean> X) {
                this.X = X;
            }

            public List<YBean> getY() {
                return Y;
            }

            public void setY(List<YBean> Y) {
                this.Y = Y;
            }

            public List<ZBean> getZ() {
                return Z;
            }

            public void setZ(List<ZBean> Z) {
                this.Z = Z;
            }
            @Keep
            public static class ABean {
                /**
                 * id : 152900
                 * brief : 阿拉善盟
                 * pname : 内蒙古自治区
                 * hotFlag : 0
                 * firstLetter : A
                 */

                private int id;
                private String brief;
                private String pname;
                private int hotFlag;
                private String firstLetter;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getPname() {
                    return pname;
                }

                public void setPname(String pname) {
                    this.pname = pname;
                }

                public int getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(int hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }
            }
            @Keep
            public static class BBean {
                /**
                 * id : 110100
                 * brief : 北京
                 * pname : 北京市
                 * hotFlag : 1
                 * firstLetter : B
                 */

                private int id;
                private String brief;
                private String pname;
                private int hotFlag;
                private String firstLetter;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getPname() {
                    return pname;
                }

                public void setPname(String pname) {
                    this.pname = pname;
                }

                public int getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(int hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }
            }
            @Keep
            public static class CBean {
                /**
                 * id : 130800
                 * brief : 承德
                 * pname : 河北省
                 * hotFlag : 0
                 * firstLetter : C
                 */

                private int id;
                private String brief;
                private String pname;
                private int hotFlag;
                private String firstLetter;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getPname() {
                    return pname;
                }

                public void setPname(String pname) {
                    this.pname = pname;
                }

                public int getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(int hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }
            }
            @Keep
            public static class DBean {
                /**
                 * id : 140200
                 * brief : 大同
                 * pname : 山西省
                 * hotFlag : 0
                 * firstLetter : D
                 */

                private int id;
                private String brief;
                private String pname;
                private int hotFlag;
                private String firstLetter;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getPname() {
                    return pname;
                }

                public void setPname(String pname) {
                    this.pname = pname;
                }

                public int getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(int hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }
            }
            @Keep
            public static class EBean {
                /**
                 * id : 150600
                 * brief : 鄂尔多斯
                 * pname : 内蒙古自治区
                 * hotFlag : 0
                 * firstLetter : E
                 */

                private int id;
                private String brief;
                private String pname;
                private int hotFlag;
                private String firstLetter;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getPname() {
                    return pname;
                }

                public void setPname(String pname) {
                    this.pname = pname;
                }

                public int getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(int hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }
            }
            @Keep
            public static class FBean {
                /**
                 * id : 210400
                 * brief : 抚顺
                 * pname : 辽宁省
                 * hotFlag : 0
                 * firstLetter : F
                 */

                private int id;
                private String brief;
                private String pname;
                private int hotFlag;
                private String firstLetter;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getPname() {
                    return pname;
                }

                public void setPname(String pname) {
                    this.pname = pname;
                }

                public int getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(int hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }
            }
            @Keep
            public static class GBean {
                /**
                 * id : 360700
                 * brief : 赣州
                 * pname : 江西省
                 * hotFlag : 0
                 * firstLetter : G
                 */

                private int id;
                private String brief;
                private String pname;
                private int hotFlag;
                private String firstLetter;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getPname() {
                    return pname;
                }

                public void setPname(String pname) {
                    this.pname = pname;
                }

                public int getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(int hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }
            }
            @Keep
            public static class HBean {
                /**
                 * id : 130400
                 * brief : 邯郸
                 * pname : 河北省
                 * hotFlag : 0
                 * firstLetter : H
                 */

                private int id;
                private String brief;
                private String pname;
                private int hotFlag;
                private String firstLetter;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getPname() {
                    return pname;
                }

                public void setPname(String pname) {
                    this.pname = pname;
                }

                public int getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(int hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }
            }
            @Keep
            public static class JBean {
                /**
                 * id : 140500
                 * brief : 晋城
                 * pname : 山西省
                 * hotFlag : 0
                 * firstLetter : J
                 */

                private int id;
                private String brief;
                private String pname;
                private int hotFlag;
                private String firstLetter;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getPname() {
                    return pname;
                }

                public void setPname(String pname) {
                    this.pname = pname;
                }

                public int getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(int hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }
            }
            @Keep
            public static class KBean {
                /**
                 * id : 410200
                 * brief : 开封
                 * pname : 河南省
                 * hotFlag : 0
                 * firstLetter : K
                 */

                private int id;
                private String brief;
                private String pname;
                private int hotFlag;
                private String firstLetter;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getPname() {
                    return pname;
                }

                public void setPname(String pname) {
                    this.pname = pname;
                }

                public int getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(int hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }
            }
            @Keep
            public static class LBean {
                /**
                 * id : 131000
                 * brief : 廊坊
                 * pname : 河北省
                 * hotFlag : 0
                 * firstLetter : L
                 */

                private int id;
                private String brief;
                private String pname;
                private int hotFlag;
                private String firstLetter;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getPname() {
                    return pname;
                }

                public void setPname(String pname) {
                    this.pname = pname;
                }

                public int getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(int hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }
            }
            @Keep
            public static class MBean {
                /**
                 * id : 231000
                 * brief : 牡丹江
                 * pname : 黑龙江省
                 * hotFlag : 0
                 * firstLetter : M
                 */

                private int id;
                private String brief;
                private String pname;
                private int hotFlag;
                private String firstLetter;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getPname() {
                    return pname;
                }

                public void setPname(String pname) {
                    this.pname = pname;
                }

                public int getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(int hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }
            }
            @Keep
            public static class NBean {
                /**
                 * id : 320100
                 * brief : 南京
                 * pname : 江苏省
                 * hotFlag : 1
                 * firstLetter : N
                 */

                private int id;
                private String brief;
                private String pname;
                private int hotFlag;
                private String firstLetter;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getPname() {
                    return pname;
                }

                public void setPname(String pname) {
                    this.pname = pname;
                }

                public int getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(int hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }
            }
            @Keep
            public static class PBean {
                /**
                 * id : 211100
                 * brief : 盘锦
                 * pname : 辽宁省
                 * hotFlag : 0
                 * firstLetter : P
                 */

                private int id;
                private String brief;
                private String pname;
                private int hotFlag;
                private String firstLetter;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getPname() {
                    return pname;
                }

                public void setPname(String pname) {
                    this.pname = pname;
                }

                public int getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(int hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }
            }
            @Keep
            public static class QBean {
                /**
                 * id : 130300
                 * brief : 秦皇岛
                 * pname : 河北省
                 * hotFlag : 0
                 * firstLetter : Q
                 */

                private int id;
                private String brief;
                private String pname;
                private int hotFlag;
                private String firstLetter;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getPname() {
                    return pname;
                }

                public void setPname(String pname) {
                    this.pname = pname;
                }

                public int getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(int hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }
            }
            @Keep
            public static class RBean {
                /**
                 * id : 371100
                 * brief : 日照
                 * pname : 山东省
                 * hotFlag : 0
                 * firstLetter : R
                 */

                private int id;
                private String brief;
                private String pname;
                private int hotFlag;
                private String firstLetter;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getPname() {
                    return pname;
                }

                public void setPname(String pname) {
                    this.pname = pname;
                }

                public int getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(int hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }
            }
            @Keep
            public static class SBean {
                /**
                 * id : 130100
                 * brief : 石家庄
                 * pname : 河北省
                 * hotFlag : 0
                 * firstLetter : S
                 */

                private int id;
                private String brief;
                private String pname;
                private int hotFlag;
                private String firstLetter;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getPname() {
                    return pname;
                }

                public void setPname(String pname) {
                    this.pname = pname;
                }

                public int getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(int hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }
            }
            @Keep
            public static class TBean {
                /**
                 * id : 120100
                 * brief : 天津
                 * pname : 天津市
                 * hotFlag : 0
                 * firstLetter : T
                 */

                private int id;
                private String brief;
                private String pname;
                private int hotFlag;
                private String firstLetter;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getPname() {
                    return pname;
                }

                public void setPname(String pname) {
                    this.pname = pname;
                }

                public int getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(int hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }
            }
            @Keep
            public static class WBean {
                /**
                 * id : 150300
                 * brief : 乌海
                 * pname : 内蒙古自治区
                 * hotFlag : 0
                 * firstLetter : W
                 */

                private int id;
                private String brief;
                private String pname;
                private int hotFlag;
                private String firstLetter;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getPname() {
                    return pname;
                }

                public void setPname(String pname) {
                    this.pname = pname;
                }

                public int getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(int hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }
            }
            @Keep
            public static class XBean {
                /**
                 * id : 130500
                 * brief : 邢台
                 * pname : 河北省
                 * hotFlag : 0
                 * firstLetter : X
                 */

                private int id;
                private String brief;
                private String pname;
                private int hotFlag;
                private String firstLetter;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getPname() {
                    return pname;
                }

                public void setPname(String pname) {
                    this.pname = pname;
                }

                public int getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(int hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }
            }
            @Keep
            public static class YBean {
                /**
                 * id : 140300
                 * brief : 阳泉
                 * pname : 山西省
                 * hotFlag : 0
                 * firstLetter : Y
                 */

                private int id;
                private String brief;
                private String pname;
                private int hotFlag;
                private String firstLetter;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getPname() {
                    return pname;
                }

                public void setPname(String pname) {
                    this.pname = pname;
                }

                public int getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(int hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }
            }
            @Keep
            public static class ZBean {
                /**
                 * id : 130700
                 * brief : 张家口
                 * pname : 河北省
                 * hotFlag : 0
                 * firstLetter : Z
                 */

                private int id;
                private String brief;
                private String pname;
                private int hotFlag;
                private String firstLetter;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getPname() {
                    return pname;
                }

                public void setPname(String pname) {
                    this.pname = pname;
                }

                public int getHotFlag() {
                    return hotFlag;
                }

                public void setHotFlag(int hotFlag) {
                    this.hotFlag = hotFlag;
                }

                public String getFirstLetter() {
                    return firstLetter;
                }

                public void setFirstLetter(String firstLetter) {
                    this.firstLetter = firstLetter;
                }
            }
        }
        @Keep
        public static class HotCityListBean {
            /**
             * id : 110100
             * brief : 北京
             * pname : 北京市
             * hotFlag : 1
             * firstLetter : B
             */

            private int id;
            private String brief;
            private String pname;
            private int hotFlag;
            private String firstLetter;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getBrief() {
                return brief;
            }

            public void setBrief(String brief) {
                this.brief = brief;
            }

            public String getPname() {
                return pname;
            }

            public void setPname(String pname) {
                this.pname = pname;
            }

            public int getHotFlag() {
                return hotFlag;
            }

            public void setHotFlag(int hotFlag) {
                this.hotFlag = hotFlag;
            }

            public String getFirstLetter() {
                return firstLetter;
            }

            public void setFirstLetter(String firstLetter) {
                this.firstLetter = firstLetter;
            }
        }
    }
}
