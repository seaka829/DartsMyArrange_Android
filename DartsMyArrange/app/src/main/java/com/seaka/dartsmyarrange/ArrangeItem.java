package com.seaka.dartsmyarrange;


/**
 * アレンジ情報のクラス
 */
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


    /**
     * 得点を文字列(配列)として取得
     * String[0]...合計点数
     * String[1]...一投目の点数
     * String[2]...二投目の点数
     * String[3]...三投目の点数
     * @return String[]
     */
    public String[] getStrPoint() {
        // 合計点数
        String strTotalPoint = String.valueOf(totalPoint);

        // 一投目の点数
        String strFirstPoint;
        if (firstType==Constant.PointType.I_NULL || firstType==Constant.PointType.I_BULL) {
            strFirstPoint = Constant.PointType.getString(firstType);
        }
        else {
            strFirstPoint = Constant.PointType.getString(firstType) + String.valueOf(firstNumber);
        }

        // 二投目の
        String strSecondPoint;
        if (secondType==Constant.PointType.I_NULL || secondType==Constant.PointType.I_BULL) {
            strSecondPoint = Constant.PointType.getString(secondType);
        }
        else {
            strSecondPoint = Constant.PointType.getString(secondType) + String.valueOf(secondNumber);
        }

        // 三投目の
        String strThirdPoint;
        if (thirdType==Constant.PointType.I_NULL || thirdType==Constant.PointType.I_BULL) {
            strThirdPoint = Constant.PointType.getString(thirdType);
        }
        else {
            strThirdPoint = Constant.PointType.getString(thirdType) + String.valueOf(thirdNumber);
        }

        // 配列の生成
        String[] strPoint = {strTotalPoint, strFirstPoint, strSecondPoint, strThirdPoint};

        return strPoint;
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

        // 一投目のナンバーを0に設定
        if(firstType==Constant.PointType.I_NULL || firstType==Constant.PointType.I_BULL) {
            this.firstNumber = 0;
        }
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

        // 二投目のナンバーを0に設定
        if(secondType==Constant.PointType.I_NULL || secondType==Constant.PointType.I_BULL) {
            this.secondNumber = 0;
        }
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

        // 三投目のナンバーを0に設定
        if(thirdType==Constant.PointType.I_NULL || thirdType==Constant.PointType.I_BULL) {
            this.thirdNumber = 0;
        }
    }

    public int getThirdNumber() {
        return thirdNumber;
    }

    public void setThirdNumber(int thirdNumber) {
        this.thirdNumber = thirdNumber;
    }
}
