package be.thmbc.samplevrapp.program.shader.fragment;

import be.thmbc.samplevrapp.R;
import be.thmbc.samplevrapp.util.ProgramHelper;

/**
 * Created by maarten on 25/05/16.
 */
public class PassthroughFragmentShader extends FragmentShader {

    public PassthroughFragmentShader(ProgramHelper programHelper) {
        super(programHelper);
    }

    @Override
    public int getRawRes() {
        return R.raw.passthrough_fragment;
    }
}
