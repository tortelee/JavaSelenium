package com.xmlExample;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.xml.sax.XMLReader;

import javax.sql.rowset.spi.XmlReader;
import java.io.*;

/**
 * xml文件的读写
 * xml文件是传输数据用的
 * 采用树结构
 * 常用的方法：
 *        addAttribute(属性值，属性名) :添加属性 name="你好"
 *
 */
public class helloXml {
    public static void main(String[] args) {
        //创建文本对象
        Document doc = DocumentHelper.createDocument();
        //创建根元素对象
        Element root = doc.addElement("root");
        //跟元素下，再创建元素
        Element sub = root.addElement("sub1");
        Element sub1 = root.addElement("sub2");
        Element sub3 = root.addElement("sub3");
        root.addAttribute("name","asd");
        root.addText("Title");
        sub.addText("aaaa");
        System.out.println(doc.asXML());
        //创建写入对象
        OutputFormat of = OutputFormat.createPrettyPrint();
        of.setEncoding("gbk");

        OutputFormat of2 = OutputFormat.createCompactFormat();
        try {
            XMLWriter xmlWriter = new XMLWriter(System.out,of);//往输出流写
            XMLWriter xmlWriter1 = new XMLWriter(System.out,of2);
            xmlWriter.write(doc);
            xmlWriter1.write(doc);
            //往本地写,怎么控制流？FileWrite直接写？
            FileWriter fw = new FileWriter("C:/工作/xmlk.xml");
            XMLWriter xmlWriter2 = new XMLWriter(fw,of);
            xmlWriter2.write(doc);
            xmlWriter2.close();
            fw.close();   //close的话，就默认会flush
          //  fw.flush();  //不flush的话,流fw内的东西，就不能输出，仍然存在内存中
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建读取对象
        /**
         * 读的时候比较麻烦，先读root,然后获取root下的list集合
         * 读取输入流
         SAXReader reader = new SAXReader();
         Document document = reader.read(inputStream);
         得到xml根元素
         Element root = document.getRootElement();
         得到根元素的所有子节点
         List<Element> elementList = root.elements();

          遍历所有子节点
         for (Element e : elementList)
         map.put(e.getName(), e.getText());

          释放资源
         inputStream.close();
         inputStream = null;
         */

    }
}
