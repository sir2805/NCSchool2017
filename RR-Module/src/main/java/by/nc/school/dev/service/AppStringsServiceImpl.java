package by.nc.school.dev.service;

import by.nc.school.dev.utils.Constants;

import java.util.ResourceBundle;

class AppStringsServiceImpl implements AppStringsService {

    protected ResourceBundle bundle;

    private AppStringsServiceImpl() {
        // TODO add multilingual support based on user profile
        bundle = ResourceBundle.getBundle(Constants.STRINGS_BUNDLE);
    }

    @Override
    public String getString(String key) {
        return bundle.getString(key);
    }

    @Override
    public String getString(String key, Object... substitution) {
        return String.format(bundle.getString(key), substitution);
    }
}
