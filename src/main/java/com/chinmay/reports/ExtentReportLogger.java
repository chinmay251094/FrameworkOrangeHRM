package com.chinmay.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.chinmay.enums.Config;
import com.chinmay.utils.ConfigReaderUtils;
import com.chinmay.utils.ScreenshotUtils;

public final class ExtentReportLogger {
    private ExtentReportLogger() {
    }

    public static void pass(String message) {
        ExtentReportManager.getReport().pass(message);
    }

    public static void fail(String message) {
        ExtentReportManager.getReport().fail(message);
    }

    public static void skip(String message) {
        ExtentReportManager.getReport().skip(message);
    }

    public static void pass(String message, boolean requireScreenshot) throws Exception {
        if (ConfigReaderUtils.get(Config.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes")
                && requireScreenshot == true) {
            ExtentReportManager.getReport().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64()).build());

        } else {
            pass(message);
        }
    }

    public static void fail(String message, boolean requireScreenshot) throws Exception {
        if (ConfigReaderUtils.get(Config.FAILEDSTEPSCREENSHOT).equalsIgnoreCase("yes")
                && requireScreenshot == true) {
            ExtentReportManager.getReport().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64()).build());

        } else {
            fail(message);
        }
    }

    public static void skip(String message, boolean requireScreenshot) throws Exception {
        if (ConfigReaderUtils.get(Config.SKIPPEDSTEPSCREENSHOT).equalsIgnoreCase("yes")
                && requireScreenshot == true) {
            ExtentReportManager.getReport().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64()).build());

        } else {
            skip(message);
        }
    }


}
