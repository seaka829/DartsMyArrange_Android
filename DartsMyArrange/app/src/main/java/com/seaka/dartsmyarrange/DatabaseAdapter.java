package com.seaka.dartsmyarrange;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.seaka.dartsmyarrange.DatabaseInfo.*;

public class DatabaseAdapter {

    protected final Context context;
    protected DatabaseHelper databaseHelper;
    protected SQLiteDatabase sqLiteDatabase;

    /**
     * コンストラクタ
     * @param context
     */
    public DatabaseAdapter(Context context) {
        this.context = context;
        databaseHelper = new DatabaseHelper(this.context);
    }

    /**
     * データベースアクセスクラス
     */
    private static class DatabaseHelper extends SQLiteOpenHelper {

        /**
         * コンストラクタ
         * @param context
         */
        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            // 初回のみテーブル作成
            sqLiteDatabase.execSQL(CREATE_SGL_TABLE);
            sqLiteDatabase.execSQL(CREATE_DBL_TABLE);
            sqLiteDatabase.execSQL(CREATE_MST_TABLE);

            // 初回のみデフォルトデータをインサート
            sqLiteDatabase.execSQL(INSERT_SGL_TABLE_DEF_DATA);
            sqLiteDatabase.execSQL(INSERT_DBL_TABLE_DEF_DATA);
            sqLiteDatabase.execSQL(INSERT_MST_TABLE_DEF_DATA);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    /**
     * データベースとの接続
     * @return DatabaseAdapter
     */
    public DatabaseAdapter open() {
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        return this;
    }

    /**
     * データベースとの切断
     */
    public void close(){
        databaseHelper.close();
    }

    /**
     * 選択したルールのアレンジ情報を初期化
     * @param rule
     */
    public void initTable(int rule) {
        if(rule == Constant.Rule.I_SINGLE_OUT) {
            sqLiteDatabase.execSQL(DROP_SGL_TABLE);
            sqLiteDatabase.execSQL(CREATE_SGL_TABLE);
            sqLiteDatabase.execSQL(INSERT_SGL_TABLE_DEF_DATA);
        }
        else if(rule == Constant.Rule.I_DOUBLE_OUT) {
            sqLiteDatabase.execSQL(DROP_DBL_TABLE);
            sqLiteDatabase.execSQL(CREATE_DBL_TABLE);
            sqLiteDatabase.execSQL(INSERT_DBL_TABLE_DEF_DATA);
        }
        else if(rule == Constant.Rule.I_MASTER_OUT) {
            sqLiteDatabase.execSQL(DROP_MST_TABLE);
            sqLiteDatabase.execSQL(CREATE_MST_TABLE);
            sqLiteDatabase.execSQL(INSERT_MST_TABLE_DEF_DATA);
        }
    }

    /**
     * 指定したルールのアレンジ一覧を取得
     * @param rule
     * @return Cursor
     */
    public Cursor getAll(int rule) {
        // ルールよりテーブルの選択
        String table = null;
        if(rule == Constant.Rule.I_SINGLE_OUT) {
            table = SGL_TABLE_NAME;
        }
        else if(rule == Constant.Rule.I_DOUBLE_OUT) {
            table = DBL_TABLE_NAME;
        }
        else if(rule == Constant.Rule.I_MASTER_OUT) {
            table = MST_TABLE_NAME;
        }

        // 選択したテーブルの全データを取得
        return sqLiteDatabase.query(table, null, null, null, null, null, COL_TOTAL_POINT + " DESC");
    }

    /**
     * アレンジ情報の新規登録
     * 成功・失敗をBOOLEANで返却
     * @param rule
     * @param item
     */
    public void register(int rule, ArrangeItem item) {
        // ルールよりテーブルの選択
        String table = null;
        if(rule == Constant.Rule.I_SINGLE_OUT) {
            table = SGL_TABLE_NAME;
        }
        else if(rule == Constant.Rule.I_DOUBLE_OUT) {
            table = DBL_TABLE_NAME;
        }
        else if(rule == Constant.Rule.I_MASTER_OUT) {
            table = MST_TABLE_NAME;
        }

        // アレンジ情報をインサート
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_TOTAL_POINT, item.getTotalPoint());
        contentValues.put(COL_FIRST_TYPE, item.getFirstType());
        contentValues.put(COL_FIRST_NUMBER, item.getFirstNumber());
        contentValues.put(COL_SECOND_TYPE, item.getSecondType());
        contentValues.put(COL_SECOND_NUMBER, item.getSecondNumber());
        contentValues.put(COL_THIRD_TYPE, item.getThirdType());
        contentValues.put(COL_THIRD_NUMBER, item.getThirdNumber());
        contentValues.put(COL_IS_CHANGED, item.isChanged());
        sqLiteDatabase.insert(table, null, contentValues);
    }

    /**
     * アレンジ情報の更新
     * @param rule
     * @param item
     */
    public void update(int rule, ArrangeItem item) {
        // ルールよりテーブルの選択
        String table = null;
        if(rule == Constant.Rule.I_SINGLE_OUT) {
            table = SGL_TABLE_NAME;
        }
        else if(rule == Constant.Rule.I_DOUBLE_OUT) {
            table = DBL_TABLE_NAME;
        }
        else if(rule == Constant.Rule.I_MASTER_OUT) {
            table = MST_TABLE_NAME;
        }

        // アレンジ情報をアップデート
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID, item.getId());
        contentValues.put(COL_TOTAL_POINT, item.getTotalPoint());
        contentValues.put(COL_FIRST_TYPE, item.getFirstType());
        contentValues.put(COL_FIRST_NUMBER, item.getFirstNumber());
        contentValues.put(COL_SECOND_TYPE, item.getSecondType());
        contentValues.put(COL_SECOND_NUMBER, item.getSecondNumber());
        contentValues.put(COL_THIRD_TYPE, item.getThirdType());
        contentValues.put(COL_THIRD_NUMBER, item.getThirdNumber());
        contentValues.put(COL_IS_CHANGED, item.isChanged());
        sqLiteDatabase.update(table, contentValues, COL_ID + " = " + item.getId(), null);
    }

    /**
     * アレンジ情報の削除
     * @param rule
     * @param item
     */
    public void delete(int rule, ArrangeItem item) {
        // ルールよりテーブルの選択
        String table = null;
        if(rule == Constant.Rule.I_SINGLE_OUT) {
            table = SGL_TABLE_NAME;
        }
        else if(rule == Constant.Rule.I_DOUBLE_OUT) {
            table = DBL_TABLE_NAME;
        }
        else if(rule == Constant.Rule.I_MASTER_OUT) {
            table = MST_TABLE_NAME;
        }

        // アレンジ情報を削除
        sqLiteDatabase.delete(table, COL_ID + " = " + item.getId(), null);
    }
}
