package com.mahagan.test;

import com.mahagan.dao.ProjectDao;
import com.mahagan.domain.Project;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Test {


    public static void main(String[] args)
    {
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("application-properties.xml");
        ProjectDao projectDao= applicationContext.getBean("ProjectDao", ProjectDao.class);

        System.out.println("For insert type-1");
        System.out.println("For Upadate type-2");


        Scanner sc=new Scanner(System.in);
        int s=sc.nextInt();
        if(s==1)
        {
            Project project=new Project();
            project.setIno(4);
            project.setName("dyaneshwar ");
            project.setCollage("AVCOE");
            project.setCity("Chalisgaon");
            project.setState("maharashtra");
            System.out.println(projectDao.insertintoproject(project));
        } else if (s==2) {
            int Intro=projectDao.UpdateProjects(2,"MAHAGAN");
            System.out.println("Records updated"+Intro);

        } else if (s==3) {


        }


    }
}