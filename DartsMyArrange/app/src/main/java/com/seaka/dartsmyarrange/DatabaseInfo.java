package com.seaka.dartsmyarrange;


/**
 * データベース情報、SQLを管理するクラス
 */
public class DatabaseInfo {


    /**
     * DB情報
     */
    public static final String DATABASE_NAME    = "app.db"; // データベース
    public static final int    DATABASE_VERSION = 1;        // バージョン

    /**
     * テーブル・カラム名
     */
    public static final String SGL_TABLE_NAME       = "arrange_single_out"; // シングルアウトテーブル
    public static final String DBL_TABLE_NAME       = "arrange_double_out"; // ダブルアウトテーブル
    public static final String MST_TABLE_NAME       = "arrange_master_out"; // マスタアウトテーブル
    public static final String COL_ID               = "id";                 // ユニークID
    public static final String COL_TOTAL_POINT      = "total_point";        // 合計得点
    public static final String COL_FIRST_TYPE       = "first_type";         // 一本目の倍率
    public static final String COL_FIRST_NUMBER     = "first_number";       // 一本目のナンバー
    public static final String COL_SECOND_TYPE      = "second_type";        // 二本目の倍率
    public static final String COL_SECOND_NUMBER    = "second_number";      // 二本目のナンバー
    public static final String COL_THIRD_TYPE       = "third_type";         // 三本目の倍率
    public static final String COL_THIRD_NUMBER     = "third_number";       // 三本目のナンバー
    public static final String COL_IS_CHANGED       = "is_changed";         // 変更有無


    /**
     * シングルアウトテーブルの作成SQL
     */
    public static final String CREATE_SGL_TABLE = "CREATE TABLE " + SGL_TABLE_NAME  + "("
            + COL_ID            + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_TOTAL_POINT   + " INTEGER,"
            + COL_FIRST_TYPE    + " INTEGER,"
            + COL_FIRST_NUMBER  + " INTEGER,"
            + COL_SECOND_TYPE   + " INTEGER,"
            + COL_SECOND_NUMBER + " INTEGER,"
            + COL_THIRD_TYPE    + " INTEGER,"
            + COL_THIRD_NUMBER  + " INTEGER,"
            + COL_IS_CHANGED    + " BOOLEAN);";


    /**
     * ダブルアウトテーブルの作成SQL
     */
    public static final String CREATE_DBL_TABLE = "CREATE TABLE " + DBL_TABLE_NAME  + "("
            + COL_ID            + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_TOTAL_POINT   + " INTEGER,"
            + COL_FIRST_TYPE    + " INTEGER,"
            + COL_FIRST_NUMBER  + " INTEGER,"
            + COL_SECOND_TYPE   + " INTEGER,"
            + COL_SECOND_NUMBER + " INTEGER,"
            + COL_THIRD_TYPE    + " INTEGER,"
            + COL_THIRD_NUMBER  + " INTEGER,"
            + COL_IS_CHANGED    + " BOOLEAN);";


    /**
     * マスタアウトテーブルの作成SQL
     */
    public static final String CREATE_MST_TABLE = "CREATE TABLE " + MST_TABLE_NAME  + "("
            + COL_ID            + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_TOTAL_POINT   + " INTEGER,"
            + COL_FIRST_TYPE    + " INTEGER,"
            + COL_FIRST_NUMBER  + " INTEGER,"
            + COL_SECOND_TYPE   + " INTEGER,"
            + COL_SECOND_NUMBER + " INTEGER,"
            + COL_THIRD_TYPE    + " INTEGER,"
            + COL_THIRD_NUMBER  + " INTEGER,"
            + COL_IS_CHANGED    + " BOOLEAN);";


    /**
     * シングルアウトテーブルの削除SQL
     */
    public static final String DROP_SGL_TABLE = "DROP TABLE " + SGL_TABLE_NAME + ";";


    /**
     * ダブルアウトテーブルの削除SQL
     */
    public static final String DROP_DBL_TABLE = "DROP TABLE " + DBL_TABLE_NAME + ";";


    /**
     * マスタアウトテーブルの削除SQL
     */
    public static final String DROP_MST_TABLE = "DROP TABLE " + MST_TABLE_NAME + ";";


    /**
     * シングルアウトテーブルへのデフォルトデータのインサートSQL
     */
    public static final String INSERT_SGL_TABLE_DEF_DATA = "INSERT INTO " + SGL_TABLE_NAME + "("
            + COL_TOTAL_POINT   + ","
            + COL_FIRST_TYPE    + "," + COL_FIRST_NUMBER  + ","
            + COL_SECOND_TYPE   + "," + COL_SECOND_NUMBER + ","
            + COL_THIRD_TYPE    + "," + COL_THIRD_NUMBER + ","
            + COL_IS_CHANGED    + ") VALUES"
            + "(180,3,20,3,20,3,20,false),"
            + "(119,4,0,4,0,1,19,false),"
            + "(118,4,0,4,0,1,18,false),"
            + "(117,4,0,4,0,1,17,false),"
            + "(116,4,0,4,0,1,16,false),"
            + "(115,4,0,4,0,1,15,false),"
            + "(114,4,0,4,0,1,14,false),"
            + "(113,4,0,4,0,1,13,false),"
            + "(112,4,0,4,0,1,12,false),"
            + "(111,4,0,4,0,1,11,false),"
            + "(110,4,0,4,0,1,10,false),"
            + "(109,4,0,4,0,1,4,false),"
            + "(108,4,0,4,0,1,8,false),"
            + "(107,4,0,4,0,1,7,false),"
            + "(106,4,0,4,0,1,6,false),"
            + "(105,4,0,4,0,1,5,false),"
            + "(104,4,0,4,0,1,4,false),"
            + "(103,4,0,4,0,1,3,false),"
            + "(102,4,0,4,0,1,2,false),"
            + "(101,4,0,4,0,1,1,false),"
            + "(100,4,0,4,0,0,0,false)";


    /**
     * ダブルアウトテーブルへのデフォルトデータのインサートSQL
     */
    public static final String INSERT_DBL_TABLE_DEF_DATA = "INSERT INTO " + DBL_TABLE_NAME + "("
            + COL_TOTAL_POINT   + ","
            + COL_FIRST_TYPE    + "," + COL_FIRST_NUMBER  + ","
            + COL_SECOND_TYPE   + "," + COL_SECOND_NUMBER + ","
            + COL_THIRD_TYPE    + "," + COL_THIRD_NUMBER + ","
            + COL_IS_CHANGED    + ") VALUES"
            + "(150,4,0,4,0,4,0,false),"
            + "(118,4,0,4,0,1,18,false),"
            + "(117,4,0,4,0,1,17,false),"
            + "(116,4,0,4,0,1,16,false),"
            + "(115,4,0,4,0,1,15,false),"
            + "(114,4,0,4,0,1,14,false),"
            + "(113,4,0,4,0,1,13,false),"
            + "(112,4,0,4,0,1,12,false),"
            + "(111,4,0,4,0,1,11,false),"
            + "(110,4,0,4,0,1,10,false),"
            + "(109,4,0,4,0,1,4,false),"
            + "(108,4,0,4,0,1,8,false),"
            + "(107,4,0,4,0,1,7,false),"
            + "(106,4,0,4,0,1,6,false),"
            + "(105,4,0,4,0,1,5,false),"
            + "(104,4,0,4,0,1,4,false),"
            + "(103,4,0,4,0,1,3,false),"
            + "(102,4,0,4,0,1,2,false),"
            + "(101,4,0,4,0,1,1,false),"
            + "(100,4,0,4,0,0,0,false)";


    /**
     * マスタアウトテーブルへのデフォルトデータのインサートSQL
     */
    public static final String INSERT_MST_TABLE_DEF_DATA = "INSERT INTO " + MST_TABLE_NAME + "("
            + COL_TOTAL_POINT   + ","
            + COL_FIRST_TYPE    + "," + COL_FIRST_NUMBER  + ","
            + COL_SECOND_TYPE   + "," + COL_SECOND_NUMBER + ","
            + COL_THIRD_TYPE    + "," + COL_THIRD_NUMBER + ","
            + COL_IS_CHANGED    + ") VALUES"
            + "(120,4,0,4,0,1,20,false),"
            + "(118,4,0,4,0,1,18,false),"
            + "(117,4,0,4,0,1,17,false),"
            + "(116,4,0,4,0,1,16,false),"
            + "(115,4,0,4,0,1,15,false),"
            + "(114,4,0,4,0,1,14,false),"
            + "(113,4,0,4,0,1,13,false),"
            + "(112,4,0,4,0,1,12,false),"
            + "(111,4,0,4,0,1,11,false),"
            + "(110,4,0,4,0,1,10,false),"
            + "(109,4,0,4,0,1,4,false),"
            + "(108,4,0,4,0,1,8,false),"
            + "(107,4,0,4,0,1,7,false),"
            + "(106,4,0,4,0,1,6,false),"
            + "(105,4,0,4,0,1,5,false),"
            + "(104,4,0,4,0,1,4,false),"
            + "(103,4,0,4,0,1,3,false),"
            + "(102,4,0,4,0,1,2,false),"
            + "(101,4,0,4,0,1,1,false),"
            + "(100,4,0,4,0,0,0,false)";
}
