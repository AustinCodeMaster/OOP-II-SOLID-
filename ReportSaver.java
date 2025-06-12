public class ReportSaver {
    // ReportSaver class follows the Single Responsibility Principle (SRP):
    // - It only handles saving a report string to a file.
    // - It does NOT generate or store report data.
    // - If you want to change how reports are saved, you only modify this class.
    
    public void saveToFile(String report) {
        System.out.println("Saving report: " + report);
    }
}
// This class now has a single responsibility: saving reports to a file.
// To use this class, you would create a separate class for generating reports, like this: