package com.iub.summitpower.core.setup;

import java.io.IOException;

public class Setup {
    public void injectDependencies() throws IOException {
        Screens.loadNavigationItems();
    }

    public void createDefaultUsers() {
    }
}
