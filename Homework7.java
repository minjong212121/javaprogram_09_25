abstract class Printer {
    protected String model;        // 모델명
    protected int printedCount;    // 지금까지 출력한 매수
    protected int availableCount;  // 앞으로 출력 가능한 매수

    public Printer(String model, int availableCount) {
        this.model = model;
        this.availableCount = availableCount;
        this.printedCount = 0;
    }


    public abstract boolean print();
}


class InkjetPrinter extends Printer {

    public InkjetPrinter(String model, int availableCount) {
        super(model, availableCount);
    }

    @Override
    public boolean print() {
        if (availableCount == 0) {
            // 실패 메시지 출력 후 false 리턴
            System.out.println(
                    model + ": " + (printedCount + 1) + "매째 인쇄 실패 - 잉크 부족."
            );
            return false;
        } else {
            // 정상 인쇄: 카운트 조정 후 true 리턴
            printedCount++;
            availableCount--;
            return true;
        }
    }
}

// 레이저 프린터
class LaserPrinter extends Printer {

    public LaserPrinter(String model, int availableCount) {
        super(model, availableCount);
    }

    @Override
    public boolean print() {
        if (availableCount == 0) {
            // 실패 메시지 출력 후 false 리턴
            System.out.println(
                    model + ": " + (printedCount + 1) + "매째 인쇄 실패 - 토너 부족."
            );
            return false;
        } else {
            // 정상 인쇄: 카운트 조정 후 true 리턴
            printedCount++;
            availableCount--;
            return true;
        }
    }
}

// 메인 클래스
public class Homework7 {
    public static void main(String[] args) {
        InkjetPrinter inkjet =
                new InkjetPrinter("Brother DCP-T730DW", 7500);
        LaserPrinter laser =
                new LaserPrinter("Canon MFC643Cdw", 1500);

        while (inkjet.print()) {
            // 잉크가 떨어질 때까지 반복
        }

        while (laser.print()) {
            // 토너가 떨어질 때까지 반복
        }
    }
}