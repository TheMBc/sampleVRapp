package be.thmbc.samplevrapp.program.shader;

import be.thmbc.samplevrapp.util.ProgramHelper;

/**
 * Created by maarten on 24/05/16.
 */
public abstract class Shader {

    private int shader;

    public Shader(ProgramHelper programHelper) {
        shader = programHelper.loadGLShader(getType(), getRawRes());
    }

    public int getShader() {
        return shader;
    }

    public abstract int getType();


    public abstract int getRawRes();
}
