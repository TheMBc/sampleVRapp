package be.thmbc.samplevrapp.shape;

/**
 * Created by maarten on 24/05/16.
 */
public class Brick extends Shape {

    public static final float[] COORDS = new float[] {
            // Front face
            -.5f, .25f, .125f,
            -.5f, -.25f, .125f,
            .5f, .25f, .125f,
            -.5f, -.25f, .125f,
            .5f, -.25f, .125f,
            .5f, .25f, .125f,

            // Right face
            .5f, .25f, .125f,
            .5f, -.25f, .125f,
            .5f, .25f, -.125f,
            .5f, -.25f, .125f,
            .5f, -.25f, -.125f,
            .5f, .25f, -.125f,

            // Back face
            .5f, .25f, -.125f,
            .5f, -.25f, -.125f,
            -.5f, .25f, -.125f,
            .5f, -.25f, -.125f,
            -.5f, -.25f, -.125f,
            -.5f, .25f, -.125f,

            // Left face
            -.5f, .25f, -.125f,
            -.5f, -.25f, -.125f,
            -.5f, .25f, .125f,
            -.5f, -.25f, -.125f,
            -.5f, -.25f, .125f,
            -.5f, .25f, .125f,

            // Top face
            -.5f, .25f, -.125f,
            -.5f, .25f, .125f,
            .5f, .25f, -.125f,
            -.5f, .25f, .125f,
            .5f, .25f, .125f,
            .5f, .25f, -.125f,

            // Bottom face
            .5f, -.25f, -.125f,
            .5f, -.25f, .125f,
            -.5f, -.25f, -.125f,
            .5f, -.25f, .125f,
            -.5f, -.25f, .125f,
            -.5f, -.25f, -.125f,
    };

    public static final float[] COLORS = new float[] {
            // front, green
            0f, 0.5273f, 0.2656f, 1.0f,
            0f, 0.5273f, 0.2656f, 1.0f,
            0f, 0.5273f, 0.2656f, 1.0f,
            0f, 0.5273f, 0.2656f, 1.0f,
            0f, 0.5273f, 0.2656f, 1.0f,
            0f, 0.5273f, 0.2656f, 1.0f,

            // right, blue
            0.0f, 0.3398f, 0.9023f, 1.0f,
            0.0f, 0.3398f, 0.9023f, 1.0f,
            0.0f, 0.3398f, 0.9023f, 1.0f,
            0.0f, 0.3398f, 0.9023f, 1.0f,
            0.0f, 0.3398f, 0.9023f, 1.0f,
            0.0f, 0.3398f, 0.9023f, 1.0f,

            // back, also green
            0f, 0.5273f, 0.2656f, 1.0f,
            0f, 0.5273f, 0.2656f, 1.0f,
            0f, 0.5273f, 0.2656f, 1.0f,
            0f, 0.5273f, 0.2656f, 1.0f,
            0f, 0.5273f, 0.2656f, 1.0f,
            0f, 0.5273f, 0.2656f, 1.0f,

            // left, also blue
            0.0f, 0.3398f, 0.9023f, 1.0f,
            0.0f, 0.3398f, 0.9023f, 1.0f,
            0.0f, 0.3398f, 0.9023f, 1.0f,
            0.0f, 0.3398f, 0.9023f, 1.0f,
            0.0f, 0.3398f, 0.9023f, 1.0f,
            0.0f, 0.3398f, 0.9023f, 1.0f,

            // top, red
            0.8359375f,  0.17578125f,  0.125f, 1.0f,
            0.8359375f,  0.17578125f,  0.125f, 1.0f,
            0.8359375f,  0.17578125f,  0.125f, 1.0f,
            0.8359375f,  0.17578125f,  0.125f, 1.0f,
            0.8359375f,  0.17578125f,  0.125f, 1.0f,
            0.8359375f,  0.17578125f,  0.125f, 1.0f,

            // bottom, also red
            0.8359375f,  0.17578125f,  0.125f, 1.0f,
            0.8359375f,  0.17578125f,  0.125f, 1.0f,
            0.8359375f,  0.17578125f,  0.125f, 1.0f,
            0.8359375f,  0.17578125f,  0.125f, 1.0f,
            0.8359375f,  0.17578125f,  0.125f, 1.0f,
            0.8359375f,  0.17578125f,  0.125f, 1.0f,
    };

    public static final float[] NORMALS = new float[] {
            // Front face
            0.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f,

            // Right face
            1.0f, 0.0f, 0.0f,
            1.0f, 0.0f, 0.0f,
            1.0f, 0.0f, 0.0f,
            1.0f, 0.0f, 0.0f,
            1.0f, 0.0f, 0.0f,
            1.0f, 0.0f, 0.0f,

            // Back face
            0.0f, 0.0f, -1.0f,
            0.0f, 0.0f, -1.0f,
            0.0f, 0.0f, -1.0f,
            0.0f, 0.0f, -1.0f,
            0.0f, 0.0f, -1.0f,
            0.0f, 0.0f, -1.0f,

            // Left face
            -1.0f, 0.0f, 0.0f,
            -1.0f, 0.0f, 0.0f,
            -1.0f, 0.0f, 0.0f,
            -1.0f, 0.0f, 0.0f,
            -1.0f, 0.0f, 0.0f,
            -1.0f, 0.0f, 0.0f,

            // Top face
            0.0f, 1.0f, 0.0f,
            0.0f, 1.0f, 0.0f,
            0.0f, 1.0f, 0.0f,
            0.0f, 1.0f, 0.0f,
            0.0f, 1.0f, 0.0f,
            0.0f, 1.0f, 0.0f,

            // Bottom face
            0.0f, -1.0f, 0.0f,
            0.0f, -1.0f, 0.0f,
            0.0f, -1.0f, 0.0f,
            0.0f, -1.0f, 0.0f,
            0.0f, -1.0f, 0.0f,
            0.0f, -1.0f, 0.0f
    };
}
