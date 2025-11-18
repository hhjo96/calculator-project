package precampCalculator;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public double add(double val1, double val2) {
        return val1 + val2;
    }

    public double sub(double val1, double val2) {
        return val1 - val2;
    }

    public double mul(double val1, double val2) {
        return val1 * val2;
    }

    public double div(double val1, double val2) {
            return val1 / val2;
    }

    public double rem(double val1, double val2){
            return val1 % val2;
    }

    public double pow(double val1, double val2){
        return Math.pow(val1, val2);
    }

    public double squareRoot(double val1, double val2){
        return Math.sqrt(val1);
    }

    public double findOpAndCalc(double val1, double val2, double result, String operator) {
        double tempResult = result;
        Scanner scanner = new Scanner(System.in);

        switch(operator){
            case "+":
                tempResult = this.add(val1, val2);
                break;

            case "-":
                tempResult = this.sub(val1, val2);
                break;

            case "*":
                tempResult = this.mul(val1, val2);
                break;

            case "/":
                tempResult = this.div(val1, val2);
                break;

            case "%":
                tempResult = this.rem(val1, val2);
                break;

            case "^":
                tempResult = this.pow(val1, val2);
                break;

            case "sqrt":
                tempResult = this.squareRoot(val1, val2);
                break;

            default:
                System.out.println("정해진 연산자를 입력해주세요.");
                scanner.nextLine(); // 잘못된 입력 제거
        }

        return tempResult;
    }

    public static void main(String[] args) {
        double val1 = 0.0;
        double val2 = 0.0;
        double result = 0.0;
        String operator = "";
        String finishOp = "";
//        String previousUse = "";
        String answer = ""; // 메뉴 번호 입력받기
        int i = 0; //historyArrList의 인덱스

        ArrayList<String> historyArrList = new ArrayList<>();

        Calculator calculator = new Calculator();
        Scanner scanner= new Scanner(System.in);

        while(!answer.equals("0")) {
            System.out.println("=== 계산기 메뉴 ===");
            System.out.println("1. 계산하기");
            System.out.println("2. 계산 이력 보기");
            System.out.println("3. 이력 지우기");
            System.out.println("0. 종료");

            System.out.print("선택: ");
            answer = scanner.nextLine();
            if(!answer.equals("0") && !answer.equals("1") && !answer.equals("2") && !answer.equals("3")) {
                System.out.println("해당하는 메뉴가 없습니다. 다시 입력해주세요 ");
                continue;
            }
            switch(answer) {
                case "1":
                    System.out.println("=== JAVA 계산기 ===");

                    while (!finishOp.equals("n") && !finishOp.equals("N")) {
            /*            System.out.print("이전 결과를 사용하시겠습니까? (y/n): ");
            previousUse = scanner.nextLine();

            if(previousUse.equals("y") || previousUse.equals("Y")) {
                System.out.print("연산자를 입력하세요 (+, -, *, /): ");
                operator = scanner.nextLine();

                System.out.print("숫자를 입력하세요: ");
                val2 = scanner.nextDouble();
                scanner.nextLine();//엔터 없애기

                result = calculator.findOpAndCalc(result, val2, result, operator);

                System.out.print("결과: ");
                System.out.println(result);

                System.out.print("계속 계산하시겠습니까? (y/n): ");
                finishOp = scanner.nextLine();

                if(finishOp.equals("n") || finishOp.equals("N")) {
                    break;

                }
            }else {//기존 결과를 사용하지 않을 경우*/
                        try {
                            System.out.print("첫 번째 숫자를 입력하세요: ");
                            val1 = scanner.nextDouble();
                            scanner.nextLine();//엔터 없애기
                        } catch (InputMismatchException e) {
                            System.out.println("숫자를 입력해주세요.");
                            scanner.nextLine(); // 잘못된 입력 제거
                            continue;
                        }

                        System.out.print("연산자를 입력하세요 (+, -, *, /, %, ^, sqrt): ");
                        operator = scanner.nextLine();

                        //연산자가 + = * / % ^ sqrt 가 아닌 경우 검사
                        if (!(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") ||
                                operator.equals("%") || operator.equals("^") || operator.equals("sqrt"))) {
                            System.out.println("지원하지 않는 연산자입니다. ");
                            continue;
                        }

                        //연산자가 제곱근이 아닐 경우 두번째 숫자 입력받음
                        if (!operator.equals("sqrt")) {
                            try {
                                System.out.print("두 번째 숫자를 입력하세요: ");
                                val2 = scanner.nextDouble();
                                scanner.nextLine();//엔터 없애기
                            } catch (InputMismatchException e) {
                                System.out.println("숫자를 입력해주세요.");
                                scanner.nextLine(); // 잘못된 입력 제거
                                continue;
                            }
                        }

                        //나누기나 나머지 연산에 0 금지
                        if ((operator.equals("/") && val2 == 0.0) || (operator.equals("%") && val2 == 0.0)) {
                            System.out.println("0으로 나누는 연산을 할 수 없습니다.");
                            continue;
                        }

                        result = calculator.findOpAndCalc(val1, val2, result, operator);
                        historyArrList.add(Double.toString(val1) + " " + operator + " " + Double.toString(val2) + " " + '=' + " " + Double.toString(result));

                        System.out.print("결과: ");
                        System.out.println(historyArrList.get(i));
                        System.out.println();
                        i++;

                        System.out.print("계속 계산하시겠습니까? (y/n): ");
                        finishOp = scanner.nextLine();
                        if(!(finishOp.equals("n") || finishOp.equals("N") || finishOp.equals("y") || finishOp.equals("Y"))) {
                            System.out.println("y 또는 n을 입력해주세요. ");
                            continue;
                        }
//            }
                    }
                    System.out.println();
                    break;

                case "2":
                    System.out.println("계산 이력을 출력합니다.");
                    if(!historyArrList.isEmpty()) {
                        System.out.println(historyArrList);
                        System.out.println();
                    } else {
                        System.out.println("계산 이력이 없습니다.");
                    }
                    break;
                case "3":
                    String tempAnswer = "N";
                    System.out.print("계산 이력을 삭제하시겠습니까? (y/n): ");
                    tempAnswer = scanner.nextLine();
                    if(tempAnswer.equals("Y") || tempAnswer.equals("y")) {
                        historyArrList.clear();
                        System.out.println("계산 이력이 삭제되었습니다.");
                    }
                    else {
                        System.out.println("삭제를 취소하고 처음으로 돌아갑니다.");
                    }
                    System.out.println();
                    break;
                case "0":
                    System.out.println("계산기를 종료합니다.");
                    break;
                }
            }
        scanner.close();
        }
    }

