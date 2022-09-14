package common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(GlobalConstant.PROJECT_PATH + "/extentV5/ExtentReport.html");
        reporter.config().setReportName("LiveGuru HTML Report");
        reporter.config().setDocumentTitle("LiveGuru HTML Report");
        reporter.config().setTimelineEnabled(true);
        reporter.config().setEncoding("utf-8");
        reporter.config().setTheme(Theme.DARK);

        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Company", "Automation FC");
        extentReports.setSystemInfo("Project", "LiveGuru");
        extentReports.setSystemInfo("Team", "VN team");
        extentReports.setSystemInfo("JDK version", GlobalConstant.JAVA_VERSION);
        return extentReports;
    }
}