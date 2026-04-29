package dev.diamond.smes.math;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class Conversion {
    public static Vec3i toVec3i(Vec3d vec) {
        return new Vec3i((int)vec.x, (int)vec.y, (int)vec.z);
    }

    public static BlockPos toBlockPos(Vec3d vec) {
        return new BlockPos((int)vec.x, (int)vec.y, (int)vec.z);
    }
}
