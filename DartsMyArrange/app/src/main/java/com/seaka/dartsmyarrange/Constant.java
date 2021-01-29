package com.seaka.dartsmyarrange;

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
}
