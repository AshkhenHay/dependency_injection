package com.epam.di;

import com.epam.di.model.Task;
import com.epam.di.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static String filePath = "./src/main/resources/test.xml";

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        User userBean = context.getBean("userBean", User.class);
        System.out.println(userBean.getName());
        Task taskBean = context.getBean("taskBean", Task.class);
        System.out.println(taskBean.getTitle());
        context.close();


        Task task = getTask();
        System.out.println(task);

    }

    public static Document buildDocument() {
        File file = new File(filePath);
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            document = builderFactory.newDocumentBuilder().parse(file);

        } catch (Exception e) {
            System.out.println("Parssing error" + e.toString());
        }
        return document;
    }

    public static Task getTask() {
        Task task = new Task();
        User user = new User();
        List<User> userList = new ArrayList<>();
        Document document = buildDocument();
        Element docElement = document.getDocumentElement();
        System.out.println("Root element of the document: " + docElement.getNodeName());
        NodeList titleNode = docElement.getElementsByTagName("title");
        for (int i = 0; i < titleNode.getLength(); i++) {
            if (titleNode.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            String title = titleNode.item(0).getChildNodes().item(0).getNodeValue();
            task.setTitle(title);
        }
        NodeList userNodes = docElement.getElementsByTagName("user");
        for (int i = 0; i < userNodes.getLength(); i++) {
            if (userNodes.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            Element element = (Element) userNodes.item(i);
            NodeList nodeList = element.getElementsByTagName("name");
            String userName = nodeList.item(0).getChildNodes().item(0).getNodeValue();
            user.setName(userName);
            nodeList = element.getElementsByTagName("age");
            String userAge = nodeList.item(0).getChildNodes().item(0).getNodeValue();
            user.setAge(Integer.parseInt(userAge));
            nodeList = element.getElementsByTagName("active");
            String userActive = nodeList.item(0).getChildNodes().item(0).getNodeValue();
            user.setActive(Boolean.parseBoolean(userActive));
            userList.add(user);

        }
        task.setUsers(userList);

        return task;
    }
}
