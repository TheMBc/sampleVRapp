package be.thmbc.samplevrapp.program;

import android.opengl.GLES20;

import be.thmbc.samplevrapp.program.shader.fragment.FragmentShader;
import be.thmbc.samplevrapp.program.shader.vertex.VertexShader;
import be.thmbc.samplevrapp.util.ProgramHelper;

/**
 * Created by maarten on 24/05/16.
 */
public abstract class Program {

    protected int program;

    protected ProgramHelper programHelper;

    protected VertexShader vertexShader;
    protected FragmentShader fragmentShader;

    protected abstract VertexShader loadVertexShader();

    protected abstract FragmentShader loadFragmentShader();

    protected abstract void setPointers();

    public Program(ProgramHelper programHelper) {
        this.programHelper = programHelper;
        vertexShader = loadVertexShader();
        fragmentShader = loadFragmentShader();

        constructProgram();
    }

    private void constructProgram() {
        program = GLES20.glCreateProgram();
        GLES20.glAttachShader(program, vertexShader.getShader());
        GLES20.glAttachShader(program, fragmentShader.getShader());
        GLES20.glLinkProgram(program);
        GLES20.glUseProgram(program);
        setPointers();
    }

    public int getProgram() {
        return program;
    }
}
