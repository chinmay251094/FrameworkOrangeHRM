package com.chinmay.listeners;

import com.chinmay.reports.ExtentReport;
import com.chinmay.reports.ExtentReportLogger;
import lombok.SneakyThrows;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class Listeners implements ITestListener, ISuiteListener {
    @SneakyThrows
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @SneakyThrows
    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTests(result.getMethod().getDescription());
    }

    @SneakyThrows
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportLogger.pass(result.getMethod().getDescription() + " has passed successfully.", false);
    }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            ExtentReportLogger.fail(result.getMethod().getDescription() + " has failed.", true);
            ExtentReportLogger.fail(result.getThrowable().toString());
            ExtentReportLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SneakyThrows
    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportLogger.pass(result.getMethod().getDescription() + " has been skipped.", false);
    }
}
