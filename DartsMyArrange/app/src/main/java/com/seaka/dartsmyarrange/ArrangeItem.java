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
     */
    public ArrangeItem() {
        setTotalPoint(0);
        setFirstType(Constant.PointType.I_NULL);
        setFirstNumber(0);
        setSecondType(Constant.PointType.I_NULL);
        setSecondNumber(0);
        setThirdType(Constant.PointType.I_NULL);
        setThirdNumber(0);
    }


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

        // 二投目の点数
        String strSecondPoint;
        if (secondType==Constant.PointType.I_NULL || secondType==Constant.PointType.I_BULL) {
            strSecondPoint = Constant.PointType.getString(secondType);
        }
        else {
            strSecondPoint = Constant.PointType.getString(secondType) + String.valueOf(secondNumber);
        }

        // 三投目の点数
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


    /**
     * 得点を数値(配列)として取得
     * int[0]...合計点数
     * int[1]...一投目の点数
     * int[2]...二投目の点数
     * int[3]...三投目の点数
     * @return int[]
     */
    public int[] getIntPoint() {
        // 合計点数
        int intTotalPoint = totalPoint;

        // 一投目の点数
        int intFirstPoint;
        if(firstType == Constant.PointType.I_BULL) {
            intFirstPoint = 50;
        }
        else {
            intFirstPoint = firstType * firstNumber;
        }

        // 二投目の点数
        int intSecondPoint;
        if(secondType == Constant.PointType.I_BULL) {
            intSecondPoint = 50;
        }
        else {
            intSecondPoint = secondType * secondNumber;
        }

        // 三投目の点数
        int intThirdPoint;
        if(thirdType == Constant.PointType.I_BULL) {
            intThirdPoint = 50;
        }
        else {
            intThirdPoint = thirdType * thirdNumber;
        }

        // 配列の生成
        int[] intPoint = {intTotalPoint, intFirstPoint, intSecondPoint, intThirdPoint};

        return intPoint;
    }


    /**
     * 登録時のチェック処理
     * @return int
     */
    public int checkReg() {

        // 範囲内チェック
        if(totalPoint<1 || totalPoint>180) {
            return Constant.ErrType.I_RANGE_ERR;
        }
        if(firstType!=Constant.PointType.I_NULL && firstType!=Constant.PointType.I_BULL) {
            if(firstNumber  < 1 || firstNumber  > 20) {
                return Constant.ErrType.I_RANGE_ERR;
            }
        }
        if(secondType!=Constant.PointType.I_NULL && secondType!=Constant.PointType.I_BULL) {
            if(secondNumber  < 1 || secondNumber  > 20) {
                return Constant.ErrType.I_RANGE_ERR;
            }
        }
        if(thirdType!=Constant.PointType.I_NULL && thirdType!=Constant.PointType.I_BULL) {
            if(thirdNumber  < 1 || thirdNumber  > 20) {
                return Constant.ErrType.I_RANGE_ERR;
            }
        }

        // 計算チェック
        int point[] = getIntPoint();
        if(point[0]-point[1]-point[2]-point[3] != 0) {
            return Constant.ErrType.I_CALC_ERR;
        };

        // エラーなし
        return Constant.ErrType.I_NONE_ERR;
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
        if(firstType==Constant.PointType.I_NULL || firstType==Constant.PointType.I_BULL) {
            setFirstNumber(0);
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
        if(secondType==Constant.PointType.I_NULL || secondType==Constant.PointType.I_BULL) {
            setSecondNumber(0);
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
        if(thirdType==Constant.PointType.I_NULL || thirdType==Constant.PointType.I_BULL) {
            setThirdNumber(0);
        }
    }

    public int getThirdNumber() {
        return thirdNumber;
    }

    public void setThirdNumber(int thirdNumber) {
        this.thirdNumber = thirdNumber;
    }
}
