package dev.diamond.smes.registry;

import com.google.gson.Gson;
import net.diamonddev.libgenetics.common.api.v1.interfaces.RegistryInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitResourceManager implements RegistryInitializer {

    private static final Logger RESOURCE_MANAGER_LOGGER = LoggerFactory.getLogger("DDV Minigames  - Resource Manager");
    private static final Gson GSON_READER = new Gson();

    @Override
    public void register() {
    }

}
