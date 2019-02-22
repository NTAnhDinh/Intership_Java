package me.learning.robotmovement;

import java.util.Scanner;
import java.util.StringTokenizer;

public class RobotMovement {
    Robot robot;
    TableTop table ;


    public RobotMovement() {
        this.table = new TableTop();
        this.robot = new RobotImpl();
    }

    String comand;
    int x = 0, y = 0;

    public void movement() {

        String f = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Hey boss!! Please enter where you want me to go");
        String request2 = sc.nextLine();
        while (true) {
            StringTokenizer st = new StringTokenizer(request2.trim(), " ");
            if (st.countTokens() == 2) {
                String location = "";
                comand = st.nextToken().trim();
                location = st.nextToken().trim();
                StringTokenizer st1 = new StringTokenizer(location, ",");
                while (st1.hasMoreTokens()) {
                    x = Integer.parseInt(st1.nextToken().trim());
                    y = Integer.parseInt(st1.nextToken().trim());
                    f = st1.nextToken().trim();
                }

                   if( !this.robot.go(x, y, f,comand))System.out.println("Sorry");

            } else {
                if (st.countTokens() == 1) {
                    comand = st.nextToken().trim().toUpperCase();

                    Command c = Command.valueOf(comand);
                    switch (c) {
                        case MOVE:
                            if (!robot.move(table)) {
                                System.out.println("Sorry, I cant move !");
                            }
                            break;

                        case LEFT:
                            robot.turnLeft();
                            break;
                        case RIGHT:
                            robot.turnRight();
                            break;
                        case REPORT:
                            robot.reportMovement();
                            break;
                        case STOP:
                            System.out.println("Exit !");
                            return;

                        default:
                            System.out.println("Sorry! Command is wrong");
                            break;
                    }
                } else {
                    System.out.println(st.countTokens());
                    System.out.println("Sorry, I dont understand !");
                }
            }
            request2 = sc.nextLine();
        }
    }

    public static void main(String[] args) {
        RobotMovement robot = new RobotMovement();
        robot.movement();
    }

}
