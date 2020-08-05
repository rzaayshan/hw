package hw13;

import hw13.Family.FileFamilyDao;
import hw13.Logger.LogDAO;
import hw13.Logger.Logger;

import java.io.File;

public class DataBase {
    LogDAO logDAO = new LogDAO("families.log");
    Logger logger = new Logger(logDAO);
    FileFamilyDao familyDao = new FileFamilyDao("families",logger);

}
