package com.seaka.dartsmyarrange;


/**
 * 定数クラス
 */
public class Constant {

    public static class ColorType {
        public  static final int    I_MAIN_COLOR   = 0;
        public  static final int    I_BASE_COLOR   = 1;
        public  static final int    I_ACCENT_COLOR = 2;
        public  static final String S_MAIN_COLOR   = "MAIN";
        public  static final String S_BASE_COLOR   = "BASE";
        public  static final String S_ACCENT_COLOR = "ACCENT";
        private static final String[] LIST         = {S_MAIN_COLOR, S_BASE_COLOR, S_ACCENT_COLOR};
        public  static final String getString(int i) {
            return LIST[i];
        }
        public static final int getIndex(String s) {
            int i = 0;
            for(String item: LIST) {
                if(item == s) {
                    return i;
                }
                i++;
            }
            return -1;
        }
    }

    public static class Mode {
        public  static final int    I_GAME = 0;
        public  static final int    I_EDIT = 1;
        public  static final String S_GAME = "GAME";
        public  static final String S_EDIT = "EDIT";
        private static final String[] LIST = {S_GAME, S_EDIT};
        public  static final String getString(int i) {
            return LIST[i];
        }
        public static final int getIndex(String s) {
            int i = 0;
            for(String item: LIST) {
                if(item == s) {
                    return i;
                }
                i++;
            }
            return -1;
        }
    }

    public static class Rule {
        public  static final int    I_SINGLE_OUT = 0;
        public  static final int    I_DOUBLE_OUT = 1;
        public  static final int    I_MASTER_OUT = 2;
        public  static final String S_SINGLE_OUT = "SINGLE_OUT";
        public  static final String S_DOUBLE_OUT = "DOUBLE_OUT";
        public  static final String S_MASTER_OUT = "MASTER_OUT";
        private static final String[] LIST       = {S_SINGLE_OUT, S_DOUBLE_OUT, S_MASTER_OUT};
        public  static final String getString(int i) {
            return LIST[i];
        }
        public static final int getIndex(String s) {
            int i = 0;
            for(String item: LIST) {
                if(item == s) {
                    return i;
                }
                i++;
            }
            return -1;
        }
    }

    public static class InputType {
        public  static final int    I_CREATE = 0;
        public  static final int    I_UPDATE = 1;
        public  static final String S_CREATE = "CREATE";
        public  static final String S_UPDATE = "UPDATE";
        private static final String[] LIST   = {S_CREATE, S_UPDATE};
        public  static final String getString(int i) {
            return LIST[i];
        }
        public static final int getIndex(String s) {
            int i = 0;
            for(String item: LIST) {
                if(item == s) {
                    return i;
                }
                i++;
            }
            return -1;
        }
    }


    public static class PointType {
        public  static final int    I_NULL   = 0;
        public  static final int    I_SINGLE = 1;
        public  static final int    I_DOUBLE = 2;
        public  static final int    I_TRIPLE = 3;
        public  static final int    I_BULL   = 4;
        public  static final String S_NULL   = "NULL";
        public  static final String S_SINGLE = "S";
        public  static final String S_DOUBLE = "D";
        public  static final String S_TRIPLE = "T";
        public  static final String S_BULL   = "BULL";
        private static final String[] LIST   = {S_NULL, S_SINGLE, S_DOUBLE, S_TRIPLE, S_BULL};
        public  static final String getString(int i) {
            return LIST[i];
        }
        public static final int getIndex(String s) {
            int i = 0;
            for(String item: LIST) {
                if(item == s) {
                    return i;
                }
                i++;
            }
            return -1;
        }
    }
}
