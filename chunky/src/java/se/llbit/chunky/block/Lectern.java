package se.llbit.chunky.block;

import se.llbit.chunky.entity.Entity;
import se.llbit.chunky.renderer.scene.Scene;
import se.llbit.chunky.resources.Texture;
import se.llbit.math.Ray;
import se.llbit.math.Vector3;
import se.llbit.nbt.CompoundTag;

public class Lectern extends MinecraftBlockTranslucent {
    private final String facing;
    private final boolean hasBook;

    public Lectern(String facing, boolean hasBook) {
        super("lectern", Texture.lecternFront);
        this.facing = facing;
        this.hasBook = hasBook;
        invisible = true;
        opaque = false;
        localIntersect = true;
    }

    @Override
    public boolean intersect(Ray ray, Scene scene) {
        return false;
    }

    @Override
    public boolean isBlockEntity() {
        return true;
    }

    @Override
    public Entity toBlockEntity(Vector3 position, CompoundTag entityTag) {
        return new se.llbit.chunky.entity.Lectern(position, this.facing, this.hasBook);
    }
}
