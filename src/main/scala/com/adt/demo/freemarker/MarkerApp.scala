package com.adt.demo.freemarker

import java.io.{File, FileWriter}
import java.util.Locale

import freemarker.template.Configuration

import scala.util.Try

object MarkerApp {
  def main(args: Array[String]): Unit = {
    val config = new Configuration(Configuration.VERSION_2_3_0)
    config.setDirectoryForTemplateLoading(new File(Thread.currentThread().getContextClassLoader.getResource("").getPath + "pdf_resources/"))
    config.setEncoding(Locale.CHINA, "utf-8")
    val template = config.getTemplate("jingzhengu.ftl", "utf-8")
    val writer = new FileWriter("/tmp/jzg.html")
    Try {
      val data = com.alibaba.fastjson.JSON.parseObject(_json)
      template.process(data, writer)
    } recover {
      case e: Throwable =>
        println(e)
    }
    writer.flush()
  }


  final val _json =
    """
      |{
      |  "accident": "有",
      |  "accidentImg": "http://kanche-template.kanche.com/order/wrong.png",
      |  "carDate": "2018-1-1",
      |  "carName": "2018款 奥迪A4L 30周年年型 30 TFSI 进取型",
      |  "carPic": "http://img.chaboshi.cn/02cbbaeb60f44e8fbdd37a595441b331",
      |  "carVin": "LVGBE40K58G273583",
      |  "logoImg": "http://kanche-template.kanche.com/order/logo.png",
      |  "mileage": "1.2345万公里",
      |  "reportDetails": [
      |    {
      |      "itemCountImg": "http://kanche-template.kanche.com/order/wrong.png",
      |      "itemName": "车身加强件检测",
      |      "malfunctionCount": 14,
      |      "normalCount": 0,
      |      "partDetails": [
      |        {
      |          "checkRlt": "破损(10cm~20cm)",
      |          "partName": "前防撞钢梁"
      |        },
      |        {
      |          "checkRlt": "修复",
      |          "partName": "行李箱框架边缘"
      |        },
      |        {
      |          "checkRlt": "划痕",
      |          "partName": "左下边梁"
      |        },
      |        {
      |          "checkRlt": "划痕(>10cm)",
      |          "partName": "左上边梁"
      |        },
      |        {
      |          "checkRlt": "修复",
      |          "partName": "右下边梁"
      |        },
      |        {
      |          "checkRlt": "划痕(3cm~10cm)",
      |          "partName": "右上边梁"
      |        },
      |        {
      |          "checkRlt": "划痕",
      |          "partName": "左前门框边缘"
      |        },
      |        {
      |          "checkRlt": "划痕(>10cm)",
      |          "partName": "左前轮旋"
      |        },
      |        {
      |          "checkRlt": "划痕",
      |          "partName": "右前门框边缘"
      |        },
      |        {
      |          "checkRlt": "划痕(5cm~10cm)",
      |          "partName": "右前轮旋"
      |        },
      |        {
      |          "checkRlt": "褶皱",
      |          "partName": "左后门框边缘"
      |        },
      |        {
      |          "checkRlt": "变形",
      |          "partName": "后围板"
      |        },
      |        {
      |          "checkRlt": "褶皱",
      |          "partName": "右后门框边缘"
      |        },
      |        {
      |          "checkRlt": "破损(<10cm)",
      |          "partName": "水箱框架"
      |        }
      |      ]
      |    },
      |    {
      |      "itemCountImg": "http://kanche-template.kanche.com/order/wrong.png",
      |      "itemName": "车身链接件检测",
      |      "malfunctionCount": 11,
      |      "normalCount": 0,
      |      "partDetails": [
      |        {
      |          "checkRlt": "掉漆",
      |          "partName": "左前门合页"
      |        },
      |        {
      |          "checkRlt": "变形(轻微)",
      |          "partName": "左前门锁柱"
      |        },
      |        {
      |          "checkRlt": "拆卸痕迹",
      |          "partName": "右前门合页"
      |        },
      |        {
      |          "checkRlt": "变形(轻微)",
      |          "partName": "右前门锁柱"
      |        },
      |        {
      |          "checkRlt": "变形(轻微)",
      |          "partName": "左后门锁柱"
      |        },
      |        {
      |          "checkRlt": "变形",
      |          "partName": "右后门合页"
      |        },
      |        {
      |          "checkRlt": "变形(严重)",
      |          "partName": "右后门锁柱"
      |        },
      |        {
      |          "checkRlt": "掉漆(轻微)",
      |          "partName": "行李箱合页"
      |        },
      |        {
      |          "checkRlt": "划痕(<5cm)",
      |          "partName": "左前梁头"
      |        },
      |        {
      |          "checkRlt": "掉漆(轻微)",
      |          "partName": "发动机舱盖合页"
      |        },
      |        {
      |          "checkRlt": "划痕(5cm~10cm)",
      |          "partName": "右前梁头"
      |        }
      |      ]
      |    },
      |    {
      |      "itemCountImg": "http://kanche-template.kanche.com/order/wrong.png",
      |      "itemName": "内部检测",
      |      "malfunctionCount": 6,
      |      "normalCount": 0,
      |      "partDetails": [
      |        {
      |          "checkRlt": "划痕",
      |          "partName": "左前门内衬板"
      |        },
      |        {
      |          "checkRlt": "划痕",
      |          "partName": "右前门内衬板"
      |        },
      |        {
      |          "checkRlt": "划痕",
      |          "partName": "左后门内衬板"
      |        },
      |        {
      |          "checkRlt": "修复",
      |          "partName": "右后门内衬板"
      |        },
      |        {
      |          "checkRlt": "拆卸痕迹(拆卸痕迹)",
      |          "partName": "安全气囊系统"
      |        },
      |        {
      |          "checkRlt": "拆卸痕迹(拆卸痕迹)",
      |          "partName": "安全带涨紧器"
      |        }
      |      ]
      |    }
      |  ]
      |}
    """.stripMargin
}
