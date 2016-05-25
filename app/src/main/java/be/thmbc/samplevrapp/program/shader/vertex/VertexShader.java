package be.thmbc.samplevrapp.program.shader.vertex;

import android.opengl.GLES20;

import be.thmbc.samplevrapp.program.shader.Shader;

/**
 * Created by maarten on 25/05/16.
 */
public abstract class VertexShader extends Shader {

    protected static final int TYPE = GLES20.GL_VERTEX_SHADER;
}
