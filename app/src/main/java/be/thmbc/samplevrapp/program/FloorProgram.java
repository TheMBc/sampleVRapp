package be.thmbc.samplevrapp.program;

import be.thmbc.samplevrapp.program.shader.fragment.FragmentShader;
import be.thmbc.samplevrapp.program.shader.fragment.GridFragmentShader;
import be.thmbc.samplevrapp.program.shader.vertex.LightVertexShader;
import be.thmbc.samplevrapp.program.shader.vertex.VertexShader;
import be.thmbc.samplevrapp.util.ProgramHelper;

/**
 * Created by maarten on 24/05/16.
 */
public class FloorProgram extends Program {

    public FloorProgram(ProgramHelper programHelper) {
        super(programHelper);
    }

    @Override
    protected VertexShader loadVertexShader() {
        return new LightVertexShader(programHelper);
    }

    @Override
    protected FragmentShader loadFragmentShader() {
        return new GridFragmentShader(programHelper);
    }


}
