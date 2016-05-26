package be.thmbc.samplevrapp.object;

import android.opengl.GLES20;
import android.opengl.Matrix;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import be.thmbc.samplevrapp.program.ColorProgram;
import be.thmbc.samplevrapp.shape.Brick;
import be.thmbc.samplevrapp.util.ProgramHelper;

/**
 * Created by maarten on 25/05/16.
 */
public class BrickObject extends RenderObject {

    private ColorProgram colorProgram;

    private float[] position;

    public BrickObject(ProgramHelper programHelper, float[] position) {
        this.colorProgram = new ColorProgram(programHelper);
        this.position = position;
        initializeBuffers();
    }

    public BrickObject(ProgramHelper programHelper) {
        this.colorProgram = new ColorProgram(programHelper);
        this.position = new float[]{-2f, -2f, -2f};
        initializeBuffers();
    }

    @Override
    public void initializeBuffers() {

        ByteBuffer bbFloorVertices = ByteBuffer.allocateDirect(Brick.COORDS.length * 4);
        bbFloorVertices.order(ByteOrder.nativeOrder());
        vertices = bbFloorVertices.asFloatBuffer();
        vertices.put(Brick.COORDS);
        vertices.position(0);

        ByteBuffer bbFloorNormals = ByteBuffer.allocateDirect(Brick.NORMALS.length * 4);
        bbFloorNormals.order(ByteOrder.nativeOrder());
        normals = bbFloorNormals.asFloatBuffer();
        normals.put(Brick.NORMALS);
        normals.position(0);

        ByteBuffer bbFloorColors = ByteBuffer.allocateDirect(Brick.COLORS.length * 4);
        bbFloorColors.order(ByteOrder.nativeOrder());
        colors = bbFloorColors.asFloatBuffer();
        colors.put(Brick.COLORS);
        colors.position(0);

        Matrix.setIdentityM(model, 0);
        Matrix.translateM(model, 0, position[0], position[1], position[2]);
    }

    @Override
    public void draw(final float[] lightPosInEyeSpace, final float[] view, final float[] perspective) {
        Matrix.multiplyMM(modelView, 0, view, 0, model, 0);
        Matrix.multiplyMM(modelViewProjection, 0, perspective, 0, modelView, 0);

        GLES20.glUseProgram(colorProgram.getProgram());

        GLES20.glUniform3fv(colorProgram.getLightPosParam(), 1, lightPosInEyeSpace, 0);

        GLES20.glUniformMatrix4fv(colorProgram.getModelParam(), 1, false, model, 0);
        GLES20.glUniformMatrix4fv(colorProgram.getModelViewParam(), 1, false, modelView, 0);
        GLES20.glUniformMatrix4fv(colorProgram.getModelViewProjectionParam(), 1, false, modelViewProjection, 0);

        GLES20.glVertexAttribPointer(colorProgram.getPositionParam(), Brick.COORDS_PER_VERTEX, GLES20.GL_FLOAT, false, 0, vertices);
        GLES20.glVertexAttribPointer(colorProgram.getNormalParam(), 3, GLES20.GL_FLOAT, false, 0, normals);
        GLES20.glVertexAttribPointer(colorProgram.getColorParam(), 4, GLES20.GL_FLOAT, false, 0, colors);

        GLES20.glEnableVertexAttribArray(colorProgram.getPositionParam());
        GLES20.glEnableVertexAttribArray(colorProgram.getNormalParam());
        GLES20.glEnableVertexAttribArray(colorProgram.getColorParam());

        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, 36);
    }
}
