package com.seaka.dartsmyarrange;

public class ArrangeItem {

    // 変数
    private int id;             // ユニークID
    private int totalPoint;     // 合計得点
    private int firstType;      // 一投目の倍率
    private int firstNumber;    // 一投目のナンバー
    private int secondType;     // 二投目の倍率
    private int secondNumber;   // 二投目のナンバー
    private int thirdType;      // 三投目の倍率
    private int thirdNumber;    // 三投目のナンバー

    /**
     * コンストラクタ
     * @param id
     * @param totalPoint
     * @param firstType
     * @param firstNumber
     * @param secondType
     * @param secondNumber
     * @param thirdType
     * @param thirdNumber
     */
    public ArrangeItem(int id,         int totalPoint,
                       int firstType,  int firstNumber,
                       int secondType, int secondNumber,
                       int thirdType,  int thirdNumber) {
        setId(id);
        setTotalPoint(totalPoint);
        setFirstType(firstType);
        setFirstNumber(firstNumber);
        setSecondType(secondType);
        setSecondNumber(secondNumber);
        setThirdType(thirdType);
        setThirdNumber(thirdNumber);
    }


    /** 以下getter, setter **/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    public int getFirstType() {
        return firstType;
    }

    public void setFirstType(int firstType) {
        this.firstType = firstType;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondType() {
        return secondType;
    }

    public void setSecondType(int secondType) {
        this.secondType = secondType;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getThirdType() {
        return thirdType;
    }

    public void setThirdType(int thirdType) {
        this.thirdType = thirdType;
    }

    public int getThirdNumber() {
        return thirdNumber;
    }

    public void setThirdNumber(int thirdNumber) {
        this.thirdNumber = thirdNumber;
    }
}
