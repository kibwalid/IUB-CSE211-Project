package com.iub.summitpower.features.unlogged.login.services;

import com.iub.summitpower.core.enums.UserType;

public interface ILoginServices {
    boolean login(String username, String password, UserType userType) throws Exception;
}
