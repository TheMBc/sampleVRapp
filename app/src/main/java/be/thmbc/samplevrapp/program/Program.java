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

    private int positionParam;
    private int normalParam;
    private int colorParam;
    private int modelParam;
    private int modelViewParam;
    private int modelViewProjectionParam;
    private int lightPosParam;

    protected ProgramHelper programHelper;

    protected VertexShader vertexShader;
    protected FragmentShader fragmentShader;

    protected abstract VertexShader loadVertexShader();

    protected abstract FragmentShader loadFragmentShader();

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

    protected void setPointers() {
        int currentProgram = getProgram();

        modelParam = GLES20.glGetUniformLocation(currentProgram, "u_Model");
        modelViewParam = GLES20.glGetUniformLocation(currentProgram, "u_MVMatrix");
        modelViewProjectionParam = GLES20.glGetUniformLocation(currentProgram, "u_MVP");
        lightPosParam = GLES20.glGetUniformLocation(currentProgram, "u_LightPos");

        positionParam = GLES20.glGetAttribLocation(currentProgram, "a_Position");
        normalParam = GLES20.glGetAttribLocation(currentProgram, "a_Normal");
        colorParam = GLES20.glGetAttribLocation(currentProgram, "a_Color");
    }

    public int getPositionParam() {
        return positionParam;
    }

    public int getNormalParam() {
        return normalParam;
    }

    public int getColorParam() {
        return colorParam;
    }

    public int getModelParam() {
        return modelParam;
    }

    public int getModelViewParam() {
        return modelViewParam;
    }

    public int getModelViewProjectionParam() {
        return modelViewProjectionParam;
    }

    public int getLightPosParam() {
        return lightPosParam;
    }

    public int getProgram() {
        return program;
    }
}
