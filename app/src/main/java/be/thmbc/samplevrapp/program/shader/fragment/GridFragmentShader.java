package be.thmbc.samplevrapp.program.shader.fragment;

import be.thmbc.samplevrapp.R;
import be.thmbc.samplevrapp.util.ProgramHelper;

/**
 * Created by maarten on 24/05/16.
 */
public class GridFragmentShader extends FragmentShader {

    private int shader;

    public GridFragmentShader(ProgramHelper programHelper) {
        shader = programHelper.loadGLShader(TYPE, R.raw.grid_fragment);
    }

    public int getShader() {
        return shader;
    }
}
