package be.thmbc.samplevrapp.program.shader.fragment;

import be.thmbc.samplevrapp.R;
import be.thmbc.samplevrapp.util.ProgramHelper;

/**
 * Created by maarten on 24/05/16.
 */
public class GridFragmentShader extends FragmentShader {

    public GridFragmentShader(ProgramHelper programHelper) {
        super(programHelper);
    }

    @Override
    public int getRawRes() {
        return R.raw.grid_fragment;
    }
}
