package android.fuzzingDroid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Random;

import android.app.ActivityManagerNative;
import android.app.IActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageParser;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.Parcelable;
import android.util.Slog;

public class FuzzingDroid {
    public static Random randomGenerator = new Random();
    public static boolean getBooleanValue() {
        boolean[] candidates = {true, false};
        int index = randomGenerator.nextInt(candidates.length);
        return candidates[index];
    }

    public static boolean[] getBooleanArrayValue() {
        boolean[][] candidates = {{true,false}, {}, null};
        int index = randomGenerator.nextInt(candidates.length);
        return candidates[index];
    }

    public static char getCharValue() {
        char[] candidates = {'\0', 'A', 'a', '*', '0', (char)1, (char)255};
        int index = randomGenerator.nextInt(candidates.length);
        return candidates[index];
    }

    public static char[] getCharArrayValue() {
        char[][] candidates = {{'1','0','0','8','6'}, {'!','@','#','$','%','^','&','*','(',')','\"'}, {}, null};
        int index = randomGenerator.nextInt(candidates.length);
        return candidates[index];
    }

    public static byte getByteValue() {
        byte[] candidates = {(byte)1, (byte)8, (byte)255};
        int index = randomGenerator.nextInt(candidates.length);
        return candidates[index];
    }

    public static byte[] getByteArrayValue() {
        byte[][] candidates = {{(byte)1, (byte)8, (byte)255}, {}, null};
        int index = randomGenerator.nextInt(candidates.length);
        return candidates[index];
    }

    public static double getDoubleValue() {
        double[] candidates = {Double.MAX_VALUE, Double.MIN_VALUE, Double.NaN};
        int index = randomGenerator.nextInt(candidates.length);
        return candidates[index];
    }

    public static double[] getDoubleArrayValue() {
        double[][] candidates = {{Double.MAX_VALUE, Double.MIN_VALUE, Double.NaN}, {}, null};
        int index = randomGenerator.nextInt(candidates.length);
        return candidates[index];
    }

    public static float getFloatValue() {
        float[] candidates = {Float.MAX_VALUE, Float.MIN_VALUE, Float.NaN};
        int index = randomGenerator.nextInt(candidates.length);
        return candidates[index];
    }

    public static float[] getFloatArrayValue() {
        float[][] candidates = {{Float.MAX_VALUE, Float.MIN_VALUE, Float.NaN}, {}, null};
        int index = randomGenerator.nextInt(candidates.length);
        return candidates[index];
    }

    public static int getIntValue() {
        int[] candidates = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int index = randomGenerator.nextInt(candidates.length);
        return candidates[index];
    }

    public static int[] getIntArrayValue() {
        int[][] candidates = {{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}, {}, null};
        int index = randomGenerator.nextInt(candidates.length);
        return candidates[index];
    }

    public static ArrayList<Integer> getIntegerArrayListValue() {
        ArrayList<ArrayList<Integer>> candidates = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(Integer.MAX_VALUE);list1.add(Integer.MIN_VALUE);list1.add(0);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        candidates.add(list1);
        candidates.add(list2);
        candidates.add(null);
        int index = randomGenerator.nextInt(candidates.size());
        return candidates.get(index);
    }

    public static CharSequence getCharSequenceValue() {
        CharSequence[] candidates = {"asdf!@#$%^&*()[]{}<>123?\"\'", ""};
        int index = randomGenerator.nextInt(candidates.length);
        return candidates[index];
    }

    public static CharSequence[] getCharSequenceArrayValue() {
        CharSequence[][] candidates = {{"asdf!@#$%^&*()[]{}<>123?\"\'", ""}, {}, null};
        int index = randomGenerator.nextInt(candidates.length);
        return candidates[index];
    }

    public static ArrayList<CharSequence> getCharSequenceArrayListValue() {
        ArrayList<ArrayList<CharSequence>> candidates = new ArrayList<ArrayList<CharSequence>>();
        ArrayList<CharSequence> list1 = new ArrayList<CharSequence>();
        list1.add("asdf!@#$%^&*()[]{}<>123?\"\'");list1.add("");
        ArrayList<CharSequence> list2 = new ArrayList<CharSequence>();
        candidates.add(list1);
        candidates.add(list2);
        candidates.add(null);
        int index = randomGenerator.nextInt(candidates.size());
        return candidates.get(index);
    }

    public static long getLongValue() {
        long[] candidates = {Long.MAX_VALUE, Long.MIN_VALUE, (long) 0};
        int index = randomGenerator.nextInt(candidates.length);
        return candidates[index];
    }

    public static long[] getLongArrayValue() {
        long[][] candidates = {{Long.MAX_VALUE, Long.MIN_VALUE, (long) 0}, {}, null};
        int index = randomGenerator.nextInt(candidates.length);
        return candidates[index];
    }

    public static short getShortValue() {
        short[] candidates = {Short.MAX_VALUE, Short.MIN_VALUE, (short) 0};
        int index = randomGenerator.nextInt(candidates.length);
        return candidates[index];
    }

    public static short[] getShortArrayValue() {
        short[][] candidates = {{Short.MAX_VALUE, Short.MIN_VALUE, (short) 0}, {}, null};
        int index = randomGenerator.nextInt(candidates.length);
        return candidates[index];
    }
    
    public static String getStringValue() {
        String[] candidates = {"214-499-6577", "yanxu90@tamu.edu", "07/01/1990", ""};
        int index = randomGenerator.nextInt(candidates.length);
        return candidates[index];
    }

    public static String[] getStringArrayValue() {
        String[][] candidates = {{"214-499-6577", "yanxu90@tamu.edu", "07/01/1990", ""}, {}, null};
        int index = randomGenerator.nextInt(candidates.length);
        return candidates[index];
    }

    public static ArrayList<String> getStringArrayListValue() {
        ArrayList<ArrayList<String>> candidates = new ArrayList<ArrayList<String>>();
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("asdf!@#$%^&*()[]{}<>123?\"\'");list1.add("214-499-6577");list1.add("yanxu90@tamu.edu");list1.add("07/01/1990");list1.add("");
        ArrayList<String> list2 = new ArrayList<String>();
        candidates.add(list1);
        candidates.add(list2);
        candidates.add(null);
        int index = randomGenerator.nextInt(candidates.size());
        return candidates.get(index);
    }

    public static Parcelable[] getParcelableArrayValue() {
        Parcelable[][] candidates = {{null, null, null, null}, {}, null};
        int index = randomGenerator.nextInt(candidates.length);
        return candidates[index];
    }

    public static <T extends Parcelable> ArrayList<T> getParcelableArrayListValue() {
        ArrayList<ArrayList<T>> candidates = new ArrayList<ArrayList<T>>();
        ArrayList<T> list1 = new ArrayList<T>();
        list1.add(null);list1.add(null);list1.add(null);list1.add(null);
        ArrayList<T> list2 = new ArrayList<T>();
        candidates.add(list1);
        candidates.add(list2);
        candidates.add(null);
        int index = randomGenerator.nextInt(candidates.size());
        return candidates.get(index);
    }

}
