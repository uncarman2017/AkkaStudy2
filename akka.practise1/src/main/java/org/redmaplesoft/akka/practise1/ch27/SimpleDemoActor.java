package org.redmaplesoft.akka.practise1.ch27;

import akka.actor.UntypedActor;
import akka.japi.Procedure;
import org.redmaplesoft.akka.practise1.Emp;

public class SimpleDemoActor extends UntypedActor {
    Procedure<Object> level1 = new Procedure<Object>() {
        public void apply(Object message) throws Exception {
            if (message instanceof String) {
                if (message.equals("end")) {
                    getContext().unbecome();
                }
            } else {
                Emp emp = (Emp) message;
                double result = emp.getSalary() * 1.8;
                System.out.println("员工" + emp.getName() + "的奖金为: " + result);
            }

            if(message.equals("become3")){
                getContext().become(level3,false);
            }

        }
    };

    Procedure<Object> level2 = new Procedure<Object>() {
        public void apply(Object message) throws Exception {
            if (message instanceof String) {
                if (message.equals("end")) {
                    getContext().unbecome();
                }
            } else {
                Emp emp = (Emp) message;
                double result = emp.getSalary() * 1.5;
                System.out.println("员工" + emp.getName() + "的奖金为: " + result);
            }

        }
    };

    Procedure<Object> level3 = new Procedure<Object>() {
        public void apply(Object message) throws Exception {
            if (message instanceof String) {
                if (message.equals("end")) {
                    getContext().unbecome();
                }
            } else {
                Emp emp = (Emp) message;
                double result = emp.getSalary() * 1.2;
                System.out.println("员工" + emp.getName() + "的奖金为: " + result);
            }

        }
    };

    @Override
    public void onReceive(Object message) throws Exception {
        String level = (String) message;
        if (level.equals("1")) {
            getContext().become(level1);
        } else if (level.equals("2")) {
            getContext().become(level2);
        }
    }
}
