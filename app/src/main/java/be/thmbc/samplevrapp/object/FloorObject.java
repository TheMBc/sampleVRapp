package be.thmbc.samplevrapp.object;

import android.opengl.GLES20;
import android.opengl.Matrix;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import be.thmbc.samplevrapp.program.FloorProgram;
import be.thmbc.samplevrapp.shape.Floor;
import be.thmbc.samplevrapp.util.ProgramHelper;

/**
 * Created by maarten on 24/05/16.
 */
public class FloorObject extends RenderObject {

    private FloatBuffer floorVertices;
    private FloatBuffer floorColors;
    private FloatBuffer floorNormals;

    private FloorProgram floorProgram;

    private float[] modelFloor;
    private float[] modelView;
    private float[] modelViewProjection;


    private float floorDepth = 20f;

    public FloorObject(ProgramHelper programHelper) {
        modelFloor = new float[16];
        modelViewProjection = new float[16];
        modelView = new float[16];
        floorProgram = new FloorProgram(programHelper);
        initializeBuffers();
    }

    public void initializeBuffers() {
        ByteBuffer bbFloorVertices = ByteBuffer.allocateDirect(Floor.COORDS.length * 4);
        bbFloorVertices.order(ByteOrder.nativeOrder());
        floorVertices = bbFloorVertices.asFloatBuffer();
        floorVertices.put(Floor.COORDS);
        floorVertices.position(0);

        ByteBuffer bbFloorNormals = ByteBuffer.allocateDirect(Floor.NORMALS.length * 4);
        bbFloorNormals.order(ByteOrder.nativeOrder());
        floorNormals = bbFloorNormals.asFloatBuffer();
        floorNormals.put(Floor.NORMALS);
        floorNormals.position(0);

        ByteBuffer bbFloorColors = ByteBuffer.allocateDirect(Floor.COLORS.length * 4);
        bbFloorColors.order(ByteOrder.nativeOrder());
        floorColors = bbFloorColors.asFloatBuffer();
        floorColors.put(Floor.COLORS);
        floorColors.position(0);

        Matrix.setIdentityM(modelFloor, 0);
        Matrix.translateM(modelFloor, 0, 0, -floorDepth, 0); // Floor appears below user.
    }

    @Override
    public float[] getModel() {
        return modelFloor;
    }

    @Override
    public void draw(float[] lightPosInEyeSpace, float[] view, float[] perspective) {
        Matrix.multiplyMM(modelView, 0, view, 0, modelFloor, 0);
        Matrix.multiplyMM(modelViewProjection, 0, perspective, 0, modelView, 0);

        GLES20.glUseProgram(floorProgram.getProgram());

        GLES20.glUniform3fv(floorProgram.getLightPosParam(), 1, lightPosInEyeSpace, 0);
        GLES20.glUniformMatrix4fv(floorProgram.getModelParam(), 1, false, modelFloor, 0);
        GLES20.glUniformMatrix4fv(floorProgram.getModelViewParam(), 1, false, modelView, 0);
        GLES20.glUniformMatrix4fv(floorProgram.getModelViewProjectionParam(), 1, false, modelViewProjection, 0);
        GLES20.glVertexAttribPointer(floorProgram.getPositionParam(), Floor.COORDS_PER_VERTEX, GLES20.GL_FLOAT, false, 0, floorVertices);
        GLES20.glVertexAttribPointer(floorProgram.getNormalParam(), 3, GLES20.GL_FLOAT, false, 0, floorNormals);
        GLES20.glVertexAttribPointer(floorProgram.getColorParam(), 4, GLES20.GL_FLOAT, false, 0, floorColors);

        GLES20.glEnableVertexAttribArray(floorProgram.getPositionParam());
        GLES20.glEnableVertexAttribArray(floorProgram.getNormalParam());
        GLES20.glEnableVertexAttribArray(floorProgram.getColorParam());

        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, 24);
    }
}
