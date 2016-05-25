package be.thmbc.samplevrapp.program.shader.vertex;

import be.thmbc.samplevrapp.R;
import be.thmbc.samplevrapp.util.ProgramHelper;

/**
 * Created by maarten on 24/05/16.
 */
public class LightVertexShader  extends VertexShader{

    private int shader;

    public LightVertexShader(ProgramHelper programHelper) {
        shader = programHelper.loadGLShader(TYPE, R.raw.light_vertex);
    }

    public int getShader() {
        return shader;
    }
}
