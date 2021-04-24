package com.bruce.patterns.observer;

import com.bruce.patterns.observer.first.ObjectFor3D;
import com.bruce.patterns.observer.first.Observer;
import com.bruce.patterns.observer.first.Observer1;
import com.bruce.patterns.observer.first.Observer2;

/**
 * @author 李启岚(起冉)
 */
public class Test {

    public static void main(String[] args) {
        //模拟一个3D的服务号
//        ObjectFor3D subjectFor3d = new ObjectFor3D();
//        //客户1
//        Observer observer1 = new Observer1(subjectFor3d);
//        Observer observer2 = new Observer2(subjectFor3d);
//
//        subjectFor3d.setMsg("20140420的3D号码是：127");
//        subjectFor3d.setMsg("20140421的3D号码是：333");

        //模拟一个3D的服务号
        ObjectFor3DFinal subjectFor3dFinal = new ObjectFor3DFinal();
        ObjectForPE subjectForPE = new ObjectForPE();
        //客户1
        Observer3 observer3 = new Observer3();
        observer3.registerSubject(subjectFor3dFinal);
        Observer4 observer4 = new Observer4();
        observer4.registerSubject(subjectForPE);
        subjectFor3dFinal.setMsg("20140420的3D号码是：127");
        subjectForPE.setMsg("20140421的3D号码是：333");

    }
}
