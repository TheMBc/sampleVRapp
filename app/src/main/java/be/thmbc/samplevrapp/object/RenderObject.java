package be.thmbc.samplevrapp.object;

import java.nio.FloatBuffer;

/**
 * Created by maarten on 25/05/16.
 */
public abstract class RenderObject {

    protected FloatBuffer vertices;
    protected FloatBuffer normals;
    protected FloatBuffer colors;

    protected float[] model;
    protected float[] modelView;
    protected float[] modelViewProjection;

    public RenderObject() {
        model = new float[16];
        modelView = new float[16];
        modelViewProjection = new float[16];
    }

    public abstract void initializeBuffers();

    public abstract void draw(float[] lightPosInEyeSpace, float[] view, float[] perspective);
}
