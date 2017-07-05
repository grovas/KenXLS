package com.sdajava.kenxls.utility;

import java.io.File;
import java.io.FileNotFoundException;

public class FileService {

    // place to setup file name
    private static final String FILE_NAME_INPUT = "medella.xlsx";
    //private static final String FILE_NAME = "Stylowa2.xlsx";
    //private static final String FILE_NAME = "niezapominajka.xlsx";

    private static final String FILE_NAME_OUTPUT = "medella DAT.xlsx";
    //private static final String FILE_NAME = "Stylowa2.xlsx";
    //private static final String FILE_NAME = "niezapominajka.xlsx";

    /**
     *
     * @return reference to excel file
     * @throws FileNotFoundException
     */
    public static File getFileIn() throws FileNotFoundException {
        File file = new File(FILE_NAME_INPUT);
        return new File(file.getAbsolutePath());
    }

    public static File getFileOut() throws FileNotFoundException {
        File file = new File(FILE_NAME_OUTPUT);
        return new File(file.getAbsolutePath());
    }
}
