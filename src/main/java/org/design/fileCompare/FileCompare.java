package org.design.fileCompare;

import org.design.fileCompare.domain.Employee;
import org.design.fileCompare.source.CSVFileSource;
import org.design.fileCompare.source.Source;

import java.util.Iterator;

//Using source package to read data from file and domain package to create employee object
public class FileCompare {

    //Declre 2 instance fields for the 2 files to compare
    //Create a separate method to compare the 2 files and print the differences. This method should be called from main method.

    private Source<Employee> source1;
    private Source<Employee> source2;

    public FileCompare(String filePath1, String filePath2) throws Exception {
        this.source1 = new CSVFileSource(filePath1);
        this.source2 = new CSVFileSource(filePath2);
    }

    public void compareFiles() {
        Iterator<Employee> iterator1 = source1.execute();
        Iterator<Employee> iterator2 = source2.execute();

        while (iterator1.hasNext() && iterator2.hasNext()) {
            Employee emp1 = iterator1.next();
            Employee emp2 = iterator2.next();

            if (!emp1.id().equals(emp2.id())) {
                System.out.println("Difference found: " + emp1.id() + " vs " + emp2.id());
            }
        }

        if (iterator1.hasNext() || iterator2.hasNext()) {
            System.out.println("Files have different number of records.");
        }
    }
}
