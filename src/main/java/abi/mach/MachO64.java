package abi.mach;

import abi.generic.ABIType;

/**
 * Created by jamesrichardson on 2/10/16.
 */
public class MachO64 extends Mach{

    private static final ABIType ABI_TYPE = ABIType.MACH_64;

    public MachO64(byte[] binary) {
        super(binary);
    }

    @Override
    public ABIType getArch() {
        return ABI_TYPE;
    }

    @Override
    public byte[] getRaw() {
        return raw;
    }

}
