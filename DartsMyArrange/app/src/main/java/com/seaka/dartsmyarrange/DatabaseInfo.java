package com.seaka.dartsmyarrange;


/**
 * データベース情報
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
            + COL_THIRD_NUMBER  + " INTEGER);";


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
            + COL_THIRD_NUMBER  + " INTEGER);";


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
            + COL_THIRD_NUMBER  + " INTEGER);";


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
}
