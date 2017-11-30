package by.nc.school.dev.service;

public interface AppConfigService {

    String KEY_INMEMORY_STORAGE_FILE = "storage.file";

    String getPropertyValue(String property);

}
