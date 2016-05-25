package be.thmbc.samplevrapp.program;

import android.opengl.GLES20;

import be.thmbc.samplevrapp.program.shader.fragment.FragmentShader;
import be.thmbc.samplevrapp.program.shader.fragment.GridFragmentShader;
import be.thmbc.samplevrapp.program.shader.vertex.LightVertexShader;
import be.thmbc.samplevrapp.program.shader.vertex.VertexShader;
import be.thmbc.samplevrapp.util.ProgramHelper;

/**
 * Created by maarten on 24/05/16.
 */
public class FloorProgram extends Program {

    private int floorPositionParam;
    private int floorNormalParam;
    private int floorColorParam;
    private int floorModelParam;
    private int floorModelViewParam;
    private int floorModelViewProjectionParam;
    private int floorLightPosParam;

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

    @Override
    protected void setPointers() {
        int currentProgram = getProgram();

        floorModelParam = GLES20.glGetUniformLocation(currentProgram, "u_Model");
        floorModelViewParam = GLES20.glGetUniformLocation(currentProgram, "u_MVMatrix");
        floorModelViewProjectionParam = GLES20.glGetUniformLocation(currentProgram, "u_MVP");
        floorLightPosParam = GLES20.glGetUniformLocation(currentProgram, "u_LightPos");

        floorPositionParam = GLES20.glGetAttribLocation(currentProgram, "a_Position");
        floorNormalParam = GLES20.glGetAttribLocation(currentProgram, "a_Normal");
        floorColorParam = GLES20.glGetAttribLocation(currentProgram, "a_Color");
    }

    public int getFloorPositionParam() {
        return floorPositionParam;
    }

    public int getFloorNormalParam() {
        return floorNormalParam;
    }

    public int getFloorColorParam() {
        return floorColorParam;
    }

    public int getFloorModelParam() {
        return floorModelParam;
    }

    public int getFloorModelViewParam() {
        return floorModelViewParam;
    }

    public int getFloorModelViewProjectionParam() {
        return floorModelViewProjectionParam;
    }

    public int getFloorLightPosParam() {
        return floorLightPosParam;
    }
}
