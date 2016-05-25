package be.thmbc.samplevrapp.program.shader.vertex;

import android.opengl.GLES20;

import be.thmbc.samplevrapp.program.shader.Shader;
import be.thmbc.samplevrapp.util.ProgramHelper;

/**
 * Created by maarten on 25/05/16.
 */
public abstract class VertexShader extends Shader {

    protected static final int TYPE = GLES20.GL_VERTEX_SHADER;

    public VertexShader(ProgramHelper programHelper) {
        super(programHelper);
    }

    @Override
    public int getType() {
        return TYPE;
    }
}
