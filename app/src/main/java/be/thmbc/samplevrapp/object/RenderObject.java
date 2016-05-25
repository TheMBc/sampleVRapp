package be.thmbc.samplevrapp.object;

/**
 * Created by maarten on 25/05/16.
 */
public abstract class RenderObject {

    // Convenience vector for extracting the position from a matrix via multiplication.
    protected static final float[] POS_MATRIX_MULTIPLY_VEC = {0, 0, 0, 1.0f};

    public abstract void initializeBuffers();

    public abstract float[] getModel();

    public abstract void draw(float[] lightPosInEyeSpace, float[] modelView, float[] modelViewProjection);
}
