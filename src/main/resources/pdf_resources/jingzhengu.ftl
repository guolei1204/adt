<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title>查博士检测报告</title>
    <style type="text/css">
        * {
            font-family: "Microsoft YaHei", "SimSun";
            font-weight: 450;
        }

        html {
            height: 100%;
        }

        body, div, ul, ol, li, h1, h2, h3, h4, h5, h6, p {
            margin: 0;
            padding: 0;
            color: #686868;
            font-size: 12px;
        }

        h1, h2, h3, h4, h5, h6 {
            margin: 0;
            font-weight: normal;
        }

        ul, li {
            margin: 0;
            padding: 0;
        }

        li {
            list-style-type: none;
        }

        .page {
            width: 640px;
            padding-top: 30px;
            margin: 0 auto;
        }

        h2 {
            font-size: 22px;
            text-align: center;
        }

        .f14 {
            font-size: 14px;
        }

        .color_333 {
            color: #333;
        }

        .color_E34C4C {
            color: #E34C4C;
        }

        .right {
            text-align: right;
        }

        .line {
            height: 1px;
            line-height: 1px;
            display: inline-block;
            background: #000;
        }

        .l20 {
            line-height: 20px;
        }

        .l30 {
            line-height: 30px;
        }

        .mb10 {
            margin-bottom: 10px;
        }

        .mb20 {
            margin-bottom: 20px;
        }

        .mb5 {
            margin-bottom: 5px;
        }

        .mb30 {
            margin-bottom: 30px;
        }

        .mt20 {
            margin-top: 20px;
        }

        .table, .table1, .table2 {
            border-collapse: collapse;
        }

        .table tr th, .table1 tr th {
            height: 30px;
            background: #FAFAFA;
            border: 1px solid #E5E5E5;
        }

        .table tr td {
            height: 30px;
            border: 1px solid #E5E5E5;
            text-align: center;
        }

        .table1 tr td {
            height: 44px;
            border: 1px solid #E5E5E5;
            text-align: center;
        }

        .table2 tr th {
            height: 30px;
            background: #f6f5f5;
            text-align: left;
            padding-left: 5px;
            border-bottom: 1px solid #E5E5E5;
        }

        .table2 tr td {
            height: 30px;
            text-align: center;
            background: #FAFAFA;
            border-bottom: 1px solid #E5E5E5;
        }

        .subtitle {
            text-align: center;
            background: #FF6402;
            font-size: 12px;
            color: #fff;
            line-height: 30px;
            width: 640px;
            margin: 0 auto;
        }

        .subtitle-1 {
            border-bottom: 1px solid #E5E5E5;
            line-height: 40px;
        }

        .title {
            text-align: center;
            font-size: 26px;
            color: #333;
        }

        .title span {
            display: inline-block;
            border-bottom: 2px solid #FF6402;
            padding-bottom: 3px;
        }

        .underline {
            text-decoration: underline;
        }

        .xst {
            font-family: "NSimSun";
        }

        .car-title {
            width: 640px;
            margin: 0 auto;
            margin-top: 12px;
            margin-bottom: 20px;
        }

        .car-title .l {
            width: 184px;
            float: left;
            margin-right: 16px;
        }

        .car-title .r {
            width: 440px;
            float: left;
        }

        .clear {
            clear: both;
        }

        .img {
            margin: 0 10px;
            vertical-align: sub;
        }

        .wrap {
            width: 640px;
            margin: 0 auto;
        }

        .wrap .l, .wrap .r {
            float: left;
            width: 50%;
        }

        .wrap_title {
            width: 640px;
            text-align: center;
            border: 1px solid #E5E5E5;
            border-bottom: 0;
            line-height: 30px;
            background: #FAFAFA;
        }
    </style>
</head>
<body>
<div class="page" style="margin-bottom:30px;">
    <img src="${logoImg}" alt="logo"/>
    <h2 class="title mb20" style="margin-top:-15px;"><span>检测报告</span></h2>
    <h2 class="subtitle">车辆基本信息</h2>
    <div class="car-title">
        <div class="l">
            <img src="${carPic}" alt="" width="184" height="138"/>
        </div>
        <div class="r">
            <h3 class="f14 l30 color_333 mb10">${carName}</h3>
            <table border="0" cellspacing="0" cellpadding="0" class="table2" width="100%">
                <tr>
                    <th width="20%">车辆VIN码</th>
                    <td width="30%">${carVin}</td>
                    <th width="25%">上牌日期</th>
                    <td width="30%">${carDate}</td>
                </tr>
                <tr>
                    <th width="20%">表显里程</th>
                    <td width="30%">${mileage}</td>
                    <th width="20%">&nbsp;</th>
                    <td width="30%">&nbsp;</td>
                </tr>
            </table>
        </div>
        <div class="clear"></div>
    </div>
    <h2 class="subtitle">事故车鉴定</h2>
    <h3 class="subtitle-1">
        鉴定结果：<img src="${accidentImg}" alt="" class="img"/> ${accident}重大事故、泡水、火烧迹象
    </h3>
    <h3 class="l30">
        重大碰撞事故鉴定
    </h3>
    <p class="mb10 l20">1、定义：碰撞事故一般指车辆因发生碰撞，造成结构性损伤，伤及车身结构件，需通过切焊、烧焊、钣金等方法进行修复的情况。</p>
    <p class="mb10 l20">2
        认定标准：对事故的判断主要查看结构性部件是否存在损伤或是否存在修复痕迹，不同的部件损伤或修复痕迹，按照其对车辆整体结构的应力影响，及综合考虑事故成因、整备成本、整备难度、修复后的安全性及舒适性等因素，进行了级别的划分。</p>
    <p class="mb10">3、具体判断部件及判断标准：</p>

    <table border="0" cellspacing="0" cellpadding="0" class="table" width="100%">
        <tr>
            <th width="50%" align="center">检测项</th>
            <th width="50%" align="center">判定标准</th>
        </tr>
        <tr>
            <td>左A柱</td>
            <td>无切焊</td>
        </tr>
        <tr>
            <td>左B柱</td>
            <td>无切焊</td>
        </tr>
        <tr>
            <td>左C柱</td>
            <td>无切焊</td>
        </tr>
        <tr>
            <td>左后减震器座</td>
            <td>无切焊</td>
        </tr>
        <tr>
            <td>右后减震器座</td>
            <td>无切焊</td>
        </tr>
    </table>
    <br/>
    <table border="0" cellspacing="0" cellpadding="0" class="table" width="100%">
        <tr>
            <th width="50%" align="center">检测项</th>
            <th width="50%" align="center">判定标准</th>
        </tr>
        <tr>
            <td>左后纵梁</td>
            <td>无切焊</td>
        </tr>
        <tr>
            <td>右后纵梁</td>
            <td>无切焊</td>
        </tr>
        <tr>
            <td>右A柱</td>
            <td>无切焊</td>
        </tr>
        <tr>
            <td>右B柱</td>
            <td>无切焊</td>
        </tr>
        <tr>
            <td>右C柱</td>
            <td>无切焊</td>
        </tr>
    </table>
    <br/>
    <table border="0" cellspacing="0" cellpadding="0" class="table" width="100%">
        <tr>
            <th width="50%" align="center">检测项</th>
            <th width="50%" align="center">判定标准</th>
        </tr>
        <tr>
            <td>左前减震器座</td>
            <td>无切焊</td>
        </tr>
        <tr>
            <td>右前减震器座</td>
            <td>无切焊</td>
        </tr>
        <tr>
            <td>左前纵梁</td>
            <td>无切焊</td>
        </tr>
        <tr>
            <td>右前纵梁</td>
            <td>无切焊</td>
        </tr>
        <tr>
            <td>防火墙</td>
            <td>无切焊</td>
        </tr>
    </table>

    <h3 class="l30">泡水车鉴定</h3>
    <p class="mb10 l20">1、定义：泡水车指车辆涉水或被水淹没后，导致整个发动机舱浸泡在水中，车内绝大部分电气设备或主要、重要的电气设备被水浸泡的情况。</p>
    <p class="mb10">2、具体判断部件及判断标准：</p>
    <table border="0" cellspacing="0" cellpadding="0" class="table1" width="100%">
        <tr>
            <th width="50%" align="center">检测项</th>
            <th width="50%" align="center">判定标准</th>
        </tr>
        <tr>
            <td>发动机</td>
            <td>无泥沙、无大面积锈蚀<br/>（超过部件面积1/2）</td>
        </tr>
        <tr>
            <td>主驾座椅</td>
            <td>无泥沙、无大面积锈蚀<br/>（超过部件面积1/2）</td>
        </tr>
        <tr>
            <td>主驾驶安全带</td>
            <td>无泥沙、无大面积锈蚀<br/>（超过部件面积1/2）</td>
        </tr>
        <tr>
            <td>副驾座椅</td>
            <td>无泥沙、无大面积锈蚀<br/>（超过部件面积1/2）</td>
        </tr>
        <tr>
            <td>副驾驶安全带</td>
            <td>无泥沙、无大面积锈蚀<br/>（超过部件面积1/2）</td>
        </tr>
        <tr>
            <td>后座安全带</td>
            <td>无泥沙、无大面积锈蚀<br/>（超过部件面积1/2）</td>
        </tr>
        <tr>
            <td>地毯</td>
            <td>无泥沙、无大面积锈蚀<br/>（超过部件面积1/2）</td>
        </tr>
        <tr>
            <td>驾驶舱异味</td>
            <td>无泥沙、无大面积锈蚀<br/>（超过部件面积1/2）</td>
        </tr>
    </table>
    <br/>
    <table border="0" cellspacing="0" cellpadding="0" class="table1" width="100%">
        <tr>
            <th width="50%" align="center">检测项</th>
            <th width="50%" align="center">判定标准</th>
        </tr>
        <tr>
            <td>驾驶舱OBD及仪表板下部接头</td>
            <td>无泥沙、无大面积锈蚀<br/>（超过部件面积1/2）</td>
        </tr>
        <tr>
            <td>其他裸露金属部件</td>
            <td>无泥沙、无大面积锈蚀<br/>（超过部件面积1/2）</td>
        </tr>
        <tr>
            <td>点烟器座</td>
            <td>无泥沙、无大面积锈蚀<br/>（超过部件面积1/2）</td>
        </tr>
        <tr>
            <td>转向管柱锈迹</td>
            <td>无泥沙、无大面积锈蚀<br/>（超过部件面积1/2）</td>
        </tr>
        <tr>
            <td>车顶棚</td>
            <td>无泥沙、无大面积锈蚀<br/>（超过部件面积1/2）</td>
        </tr>
        <tr>
            <td>车身底板</td>
            <td>无泥沙、无大面积锈蚀<br/>（超过部件面积1/2）</td>
        </tr>
        <tr>
            <td>发动机舱保险盒</td>
            <td>无泥沙、无大面积锈蚀<br/>（超过部件面积1/2）</td>
        </tr>
        <tr>
            <td>-</td>
            <td>-</td>
        </tr>
    </table>
    <h3 class="l30">火烧车鉴定</h3>
    <p class="mb10">1、定义：车辆由于自燃、外燃或炙烤等原因，造成车辆损坏的情况。</p>
    <p class="mb10">2、具体判断部件及判断标准</p>
    <table border="0" cellspacing="0" cellpadding="0" class="table" width="100%">
        <tr>
            <th width="50%" align="center">检测项</th>
            <th width="50%" align="center">判定标准</th>
        </tr>
        <tr>
            <td>左前翼子板骨架</td>
            <td>不存在过火痕迹</td>
        </tr>
        <tr>
            <td>右前翼子板骨架</td>
            <td>不存在过火痕迹</td>
        </tr>
        <tr>
            <td>发动机舱橡胶部件</td>
            <td>不存在过火痕迹</td>
        </tr>
        <tr>
            <td>左后翼子板内侧</td>
            <td>不存在过火痕迹</td>
        </tr>
    </table>
    <br/>
    <table border="0" cellspacing="0" cellpadding="0" class="table" width="100%">
        <tr>
            <th width="50%" align="center">检测项</th>
            <th width="50%" align="center">判定标准</th>
        </tr>
        <tr>
            <td>右前翼子板内侧</td>
            <td>不存在过火痕迹</td>
        </tr>
        <tr>
            <td>右后翼子板内侧</td>
            <td>不存在过火痕迹</td>
        </tr>
        <tr>
            <td>后防撞钢梁</td>
            <td>不存在过火痕迹</td>
        </tr>
        <tr>
            <td>发动机舱线束</td>
            <td>不存在过火痕迹</td>
        </tr>
    </table>
    <h2 class="subtitle" style="margin: 10px 0;">整体综合分析——车况其他件检测</h2>
    <#list reportDetails as item >
        <div class="wrap">
        <#if item.malfunctionCount == 0>
            <div class="wrap_title">
                ${item.itemName}<img src="${item.itemCountImg}" alt="" class="img"/>${item.normalCount}项
            </div>
        <#else>
            <div class="wrap_title">
                ${item.itemName}<img src="${item.itemCountImg}" alt="" class="img"/>${item.malfunctionCount}项异常
            </div>
        </#if>
            <table border="0" cellspacing="0" cellpadding="0" class="table" width="100%">
        <#list item.partDetails as itemDetail>
            <tr>
                <td width="50%">${itemDetail.partName}</td>
            <#if itemDetail.checkRlt?contains('未见异常')>
                <td width="50%" class="border-none">${itemDetail.checkRlt}</td>
            <#else >
                <td width="50%" class="color_E34C4C border-none">${itemDetail.checkRlt}</td>
            </#if>
            </tr>
        </#list>
            </table>
        </div>
    </#list>
    <p class="l20">备注：此报告仅对当日检测车况为重大事故车、泡水车、火烧车的情况做承诺，不承担检测后车辆使用过程中异常磨损及其他因素造成的车辆状况改变！</p>
    <p class="right f14 mt20">您已对以上内容知晓，请您确认签字：<span class="underline f14">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
    </p>
</div>
</body>
</html>