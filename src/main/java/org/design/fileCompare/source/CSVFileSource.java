package org.design.fileCompare.source;

import org.design.fileCompare.domain.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.Iterator;

public class CSVFileSource implements Source<Employee> {

    String filePath;
    Reader reader;
    Employee nextEmployee;
    boolean hasNextEmployee;

    //Constructor takes input file path
    public CSVFileSource(String filePath) throws FileNotFoundException {
        this.filePath = filePath;

        //Initialize a buffered reader with above path and assign to reader variable.
        this.reader = new BufferedReader(new java.io.FileReader(this.filePath));
    }

    @Override
    public Iterator<Employee> execute() {
        return new Iterator<Employee>() {
            @Override
            public boolean hasNext() {
                try {
                    String line = ((BufferedReader) reader).readLine();
                    if (line != null) {
                        String[] parts = line.split(",");
                        nextEmployee = new Employee(parts[0], parts[1], parts[2], parts[3], Double.parseDouble(parts[4]));
                        hasNextEmployee = true;
                    } else {
                        hasNextEmployee = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    hasNextEmployee = false;
                }
                return hasNextEmployee;
            }

            @Override
            public Employee next() {
                return nextEmployee;
            }
        };
    }
}