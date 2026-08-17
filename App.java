package newa;
    import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

    public class App {
        public static void main(String[] args) {
            ArrayList<User> list = new ArrayList();
            Scanner sc = new Scanner(System.in);

            while(true) {
                System.out.println("-----------------欢迎来到学生管理系统-------------------");
                System.out.println("请输入数字选择操作：1登录 2注册 3忘记密码 4退出系统");
                switch (sc.next()) {
                    case "1":
                        login(list);
                        break;
                    case "2":
                        register(list);
                        break;
                    case "3":
                        forgetPassword(list);
                        break;
                    case "4":
                        System.out.println("谢谢使用，再见");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("没有这个选项");
                }
            }
        }

        private static void login(ArrayList<User> list) {
            Scanner sc = new Scanner(System.in);

            for(int i = 0; i < 3; ++i) {
                System.out.println("请输入用户名");
                String username = sc.next();
                boolean flag = contains(list, username);
                if (!flag) {
                    System.out.println("用户名" + username + "未注册，请先注册再登录");
                    return;
                }

                System.out.println("请输入密码");
                String password = sc.next();

                while(true) {
                    String rightCode = getCode();
                    System.out.println("系统生成的验证码为：" + rightCode);
                    System.out.println("请输入验证码");
                    String code = sc.next();
                    if (code.equalsIgnoreCase(rightCode)) {
                        System.out.println("验证码正确");
                        User useInfo = new User(username, password, (String)null, (String)null);
                        boolean result = checkUserInfo(list, useInfo);
                        if (result) {
                            System.out.println("登录成功，可以开始使用学生管理系统了");
                            StudentSystem ss = new StudentSystem();
                            ss.startStudentSystem();
                            return;
                        }

                        System.out.println("登录失败，用户名或密码错误");
                        if (i == 2) {
                            System.out.println("当前账号" + username + "被锁定，请联系客服：sulei-没看不回复，看了也不回复");
                            return;
                        }

                        System.out.println("用户名或密码错误，还剩下" + (2 - i) + "次机会");
                        break;
                    }

                    System.out.println("验证码错误");
                }
            }

        }
//        登录入口
//        加入三次验证机制

        private static boolean checkUserInfo(ArrayList<User> list, User useInfo) {
            for(int i = 0; i < list.size(); ++i) {
                User user = (User)list.get(i);
                if (user.getUsername().equals(useInfo.getUsername()) && user.getPassword().equals(useInfo.getPassword())) {
                    return true;
                }
            }

            return false;
        }
//        得到暂存对象useInfo，动态数组地址，验证name与password，返回哦按段结果

        private static void forgetPassword(ArrayList<User> list) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名");
            String username = sc.next();
            boolean flag = contains(list, username);
            if (!flag) {
                System.out.println("当前用户" + username + "未注册，请先注册");
            } else {
                System.out.println("请输入身份证号码");
                String idCard = sc.next();
                System.out.println("请输入手机号码");
                String phone = sc.next();
                int index = findIndex(list, username);
                User user = (User)list.get(index);
                if (user.getIdCard().equalsIgnoreCase(idCard) && user.getPhone().equals(phone)) {
                    while(true) {
                        System.out.println("请输入新的密码");
                        String password = sc.next();
                        System.out.println("请再次输入新的密码");
                        String againPassword = sc.next();
                        if (password.equals(againPassword)) {
                            System.out.println("两次密码输入一致");
                            user.setPassword(password);
                            System.out.println("密码修改成功");
                            return;
                        }

                        System.out.println("两次密码输入不一致，请重新输入");
                    }
                } else {
                    System.out.println("身份证号码或手机号码输入有误，不能修改密码");
                }
            }
        }

        private static int findIndex(ArrayList<User> list, String username) {
            for(int i = 0; i < list.size(); ++i) {
                User user = (User)list.get(i);
                if (user.getUsername().equals(username)) {
                    return i;
                }
            }

            return -1;
        }

        private static void register(ArrayList<User> list) {
            Scanner sc = new Scanner(System.in);

            while(true) {
                System.out.println("请输入用户名");
                String username = sc.next();
                boolean flag1 = checkUsername(username);
                if (!flag1) {
                    System.out.println("用户名格式不满足条件，需要重新输入");
                } else {
                    boolean flag2 = contains(list, username);
                    if (!flag2) {
                        System.out.println("用户名" + username + "可用");

                        while(true) {
                            System.out.println("请输入要注册的密码");
                            String password = sc.next();
                            System.out.println("请再次输入要注册的密码");
                            String againPassword = sc.next();
                            if (password.equals(againPassword)) {
                                System.out.println("两次密码一致，继续录入其他数据");

                                while(true) {
                                    System.out.println("请输入身份证号码");
                                    againPassword = sc.next();
                                    boolean flag = checkIdCard(againPassword);
                                    if (flag) {
                                        System.out.println("身份证号码满足要求");

                                        while(true) {
                                            System.out.println("请输入手机号码");
                                            String phone = sc.next();
                                            boolean phoneFlag = checkPhoneNumber(phone);
                                            if (phoneFlag) {
                                                System.out.println("手机号码格式正确");
                                                User u = new User(username, password, againPassword, phone);
                                                list.add(u);
                                                System.out.println("注册成功");
                                                printList(list);
                                                return;
                                            }

                                            System.out.println("手机号码格式有误，请重新输入");
                                        }
                                    }

                                    System.out.println("身份证号码格式有误，请重新输入");
                                }
                            }

                            System.out.println("两次密码输入不一致，请重新输入");
                        }
                    }

                    System.out.println("用户名" + username + "已存在，请重新输入");
                }
            }
        }
//        注册入口

        private static void printList(ArrayList<User> list) {
            for(int i = 0; i < list.size(); ++i) {
                User user = (User)list.get(i);
                PrintStream var10000 = System.out;
                String var10001 = user.getUsername();
                var10000.println(var10001 + ", " + user.getPassword() + ", " + user.getIdCard() + ", " + user.getPhone());
            }

        }

        private static boolean checkPhoneNumber(String phoneNumber) {
            if (phoneNumber.length() != 11) {
                return false;
            } else if (phoneNumber.startsWith("0")) {
                return false;
            } else {
                for(int i = 0; i < phoneNumber.length(); ++i) {
                    char c = phoneNumber.charAt(i);
                    if (c < '0' || c > '9') {
                        return false;
                    }
                }

                return true;
            }
        }
//        手机号格式检测

        private static boolean checkIdCard(String idCard) {
            if (idCard.length() != 18) {
                return false;
            } else {
                for(int i = 0; i < idCard.length() - 1; ++i) {
                    char c = idCard.charAt(i);
                    if (c < '0' || c > '9') {
                        return false;
                    }
                }

                char lastChar = idCard.charAt(idCard.length() - 1);
                if ((lastChar < '0' || lastChar > '9') && lastChar != 'X' && lastChar != 'x') {
                    return false;
                } else {
                    return true;
                }
            }
        }
//        身份证格式检测

        private static boolean contains(ArrayList<User> list, String username) {
            for(int i = 0; i < list.size(); ++i) {
                User user = (User)list.get(i);
                String rightUsername = user.getUsername();
                if (rightUsername.equals(username)) {
                    return true;
                }
            }

            return false;
        }
//        对照所有数据集提取的name，验证存在性

        private static boolean checkUsername(String username) {
            if (username.length() >= 3 && username.length() <= 15) {
                boolean hasLetter = false;

                for(int i = 0; i < username.length(); ++i) {
                    char c = username.charAt(i);
                    if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
                        if (c < '0' || c > '9') {
                            return false;
                        }
                    } else {
                        hasLetter = true;
                    }
                }

                return hasLetter;
            } else {
                return false;
            }
        }
//        注册-账户格式判断

        private static String getCode() {
            ArrayList<Character> list = new ArrayList();

            for(int i = 0; i < 26; ++i) {
                list.add((char)(97 + i));
                list.add((char)(65 + i));
            }

            StringBuilder sb = new StringBuilder();
            Random r = new Random();

            for(int i = 0; i < 4; ++i) {
                int index = r.nextInt(list.size());
                char c = (Character)list.get(index);
                sb.append(c);
            }

            int number = r.nextInt(10);
            sb.append(number);
            char[] arr = sb.toString().toCharArray();
            int randomIndex = r.nextInt(arr.length);
            char temp = arr[randomIndex];
            arr[randomIndex] = arr[arr.length - 1];
            arr[arr.length - 1] = temp;
            return new String(arr);
        }
//        随机数生成验证码，

    }

