package com.chinmay.constants;

import com.chinmay.enums.Config;
import com.chinmay.utils.DateTimeUtils;
import com.chinmay.utils.ConfigReaderUtils;

public final class FrameworkConstants {
    private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/java/com/chinmay/resources/";
    private static final String CONFIGFILEPATH = RESOURCESPATH + "config.properties";
    private static final String DATAPATH = RESOURCESPATH + "Data.xlsx";
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
    private static final int WAITTIME = 10;
    private static String extentReportFilePath = "";
    private static final String RUNMANAGERSHEETNAME = "RUNMANAGER";
    private static final String DATAMANAGERNAME = "DATAMANAGER";

    private FrameworkConstants() {
    }

    public static String getExtentReportFilePath() throws Exception {
        if (extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    private static String createReportPath() throws Exception {
        if (ConfigReaderUtils.get(Config.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
            return EXTENTREPORTFOLDERPATH + DateTimeUtils.getDateTime() + " Test Report.html";
        } else {
            return EXTENTREPORTFOLDERPATH + "/index.html";
        }
    }

    public static String getPropertyFilePath() {
        return CONFIGFILEPATH;
    }

    public static int getWaitTime() {
        return WAITTIME;
    }

    public static String getDataPath() {
        return DATAPATH;
    }

    public static String getRunManagerSheetName() {
        return RUNMANAGERSHEETNAME;
    }

    public static String getDataManagerSheetName() {
        return DATAMANAGERNAME;
    }
}
