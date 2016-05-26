package be.thmbc.samplevrapp.object;

import android.opengl.GLES20;
import android.opengl.Matrix;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import be.thmbc.samplevrapp.program.FloorProgram;
import be.thmbc.samplevrapp.shape.Floor;
import be.thmbc.samplevrapp.util.ProgramHelper;

/**
 * Created by maarten on 24/05/16.
 */
public class FloorObject extends RenderObject {

    private FloorProgram floorProgram;

    public FloorObject(ProgramHelper programHelper) {
        floorProgram = new FloorProgram(programHelper);
    }

    @Override
    public void initializeBuffers() {
        ByteBuffer bbFloorVertices = ByteBuffer.allocateDirect(Floor.COORDS.length * 4);
        bbFloorVertices.order(ByteOrder.nativeOrder());
        vertices = bbFloorVertices.asFloatBuffer();
        vertices.put(Floor.COORDS);
        vertices.position(0);

        ByteBuffer bbFloorNormals = ByteBuffer.allocateDirect(Floor.NORMALS.length * 4);
        bbFloorNormals.order(ByteOrder.nativeOrder());
        normals = bbFloorNormals.asFloatBuffer();
        normals.put(Floor.NORMALS);
        normals.position(0);

        ByteBuffer bbFloorColors = ByteBuffer.allocateDirect(Floor.COLORS.length * 4);
        bbFloorColors.order(ByteOrder.nativeOrder());
        colors = bbFloorColors.asFloatBuffer();
        colors.put(Floor.COLORS);
        colors.position(0);

        Matrix.setIdentityM(model, 0);
        Matrix.translateM(model, 0, 0, -20f, 0); // Floor appears below user.
    }

    @Override
    public void draw(final float[] lightPosInEyeSpace, final float[] view, final float[] perspective) {
        Matrix.multiplyMM(modelView, 0, view, 0, model, 0);
        Matrix.multiplyMM(modelViewProjection, 0, perspective, 0, modelView, 0);

        GLES20.glUseProgram(floorProgram.getProgram());

        GLES20.glUniform3fv(floorProgram.getLightPosParam(), 1, lightPosInEyeSpace, 0);

        GLES20.glUniformMatrix4fv(floorProgram.getModelParam(), 1, false, model, 0);
        GLES20.glUniformMatrix4fv(floorProgram.getModelViewParam(), 1, false, modelView, 0);
        GLES20.glUniformMatrix4fv(floorProgram.getModelViewProjectionParam(), 1, false, modelViewProjection, 0);

        GLES20.glVertexAttribPointer(floorProgram.getPositionParam(), Floor.COORDS_PER_VERTEX, GLES20.GL_FLOAT, false, 0, vertices);
        GLES20.glVertexAttribPointer(floorProgram.getNormalParam(), 3, GLES20.GL_FLOAT, false, 0, normals);
        GLES20.glVertexAttribPointer(floorProgram.getColorParam(), 4, GLES20.GL_FLOAT, false, 0, colors);

        GLES20.glEnableVertexAttribArray(floorProgram.getPositionParam());
        GLES20.glEnableVertexAttribArray(floorProgram.getNormalParam());
        GLES20.glEnableVertexAttribArray(floorProgram.getColorParam());

        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, 24);
    }
}
