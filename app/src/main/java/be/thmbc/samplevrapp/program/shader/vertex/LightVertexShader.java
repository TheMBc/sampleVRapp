package be.thmbc.samplevrapp.program.shader.vertex;

import be.thmbc.samplevrapp.R;
import be.thmbc.samplevrapp.util.ProgramHelper;

/**
 * Created by maarten on 24/05/16.
 */
public class LightVertexShader  extends VertexShader{

    public LightVertexShader(ProgramHelper programHelper) {
        super(programHelper);
    }

    @Override
    public int getRawRes() {
        return R.raw.light_vertex;
    }
}
