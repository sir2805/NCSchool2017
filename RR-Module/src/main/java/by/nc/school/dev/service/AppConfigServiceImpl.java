package by.nc.school.dev.service;

import by.nc.school.dev.utils.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class AppConfigServiceImpl implements AppConfigService {

    protected Properties properties;

    private AppConfigServiceImpl() throws IOException {
        properties = new Properties();
        try (InputStream input = AppConfigServiceImpl.class.getClassLoader().getResourceAsStream(Constants.PROPERTY_FILE)) {
            properties.load(input);
        }
    }

    @Override
    public String getPropertyValue(String key) {
        return properties.getProperty(key);
    }
}
