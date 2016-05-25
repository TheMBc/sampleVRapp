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

    private float floorDepth = 20f;

    public FloorObject(ProgramHelper programHelper) {
        modelFloor = new float[16];
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
    public void draw(float[] lightPosInEyeSpace, float[] modelView, float[] modelViewProjection) {
        GLES20.glUseProgram(floorProgram.getProgram());

        // Set ModelView, MVP, position, normals, and color.
        GLES20.glUniform3fv(floorProgram.getFloorLightPosParam(), 1, lightPosInEyeSpace, 0);
        GLES20.glUniformMatrix4fv(floorProgram.getFloorModelParam(), 1, false, modelFloor, 0);
        GLES20.glUniformMatrix4fv(floorProgram.getFloorModelViewParam(), 1, false, modelView, 0);
        GLES20.glUniformMatrix4fv(floorProgram.getFloorModelViewProjectionParam(), 1, false, modelViewProjection, 0);
        GLES20.glVertexAttribPointer(floorProgram.getFloorPositionParam(), Floor.COORDS_PER_VERTEX, GLES20.GL_FLOAT, false, 0, floorVertices);
        GLES20.glVertexAttribPointer(floorProgram.getFloorNormalParam(), 3, GLES20.GL_FLOAT, false, 0, floorNormals);
        GLES20.glVertexAttribPointer(floorProgram.getFloorColorParam(), 4, GLES20.GL_FLOAT, false, 0, floorColors);

        GLES20.glEnableVertexAttribArray(floorProgram.getFloorPositionParam());
        GLES20.glEnableVertexAttribArray(floorProgram.getFloorNormalParam());
        GLES20.glEnableVertexAttribArray(floorProgram.getFloorColorParam());

        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, 24);
    }
}
