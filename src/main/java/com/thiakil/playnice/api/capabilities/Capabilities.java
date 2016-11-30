package com.thiakil.playnice.api.capabilities;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class Capabilities {

    @CapabilityInject(IWrench.class)
    public static Capability<IWrench> WRENCH_HANDLER = null;
}
