package be.thmbc.samplevrapp;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;

import com.google.vr.sdk.base.Eye;
import com.google.vr.sdk.base.GvrView;
import com.google.vr.sdk.base.HeadTransform;
import com.google.vr.sdk.base.Viewport;

import javax.microedition.khronos.egl.EGLConfig;

import be.thmbc.samplevrapp.object.FloorObject;
import be.thmbc.samplevrapp.util.ProgramHelper;

/**
 * Created by maarten on 24/05/16.
 */
public class VrRenderer implements GvrView.StereoRenderer {

    private Context context;
    private ProgramHelper programHelper;

    private FloorObject floor;

    private static final float CAMERA_Z = 0.01f;

    private static final float Z_NEAR = 0.1f;
    private static final float Z_FAR = 100.0f;

    // We keep the light always position just above the user.
    private static final float[] LIGHT_POS_IN_WORLD_SPACE = new float[] {0.0f, 2.0f, 0.0f, 1.0f};
    private final float[] lightPosInEyeSpace = new float[4];

    private float[] camera;
    private float[] view;

    public VrRenderer(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        programHelper = new ProgramHelper(context.getResources());
        camera = new float[16];
        view = new float[16];
    }

    @Override
    public void onSurfaceCreated(EGLConfig eglConfig) {
        GLES20.glClearColor(0.1f, 0.1f, 0.1f, 0.5f); // Dark background so text shows up well.
        floor = new FloorObject(programHelper);
    }

    @Override
    public void onNewFrame(HeadTransform headTransform) {
        Matrix.setLookAtM(camera, 0, 0.0f, 0.0f, CAMERA_Z, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
    }

    @Override
    public void onDrawEye(Eye eye) {
        GLES20.glEnable(GLES20.GL_DEPTH_TEST);
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

        float[] perspective = eye.getPerspective(Z_NEAR, Z_FAR);

        // Apply the eye transformation to the camera.
        Matrix.multiplyMM(view, 0, eye.getEyeView(), 0, camera, 0);

        // Set the position of the light
        Matrix.multiplyMV(lightPosInEyeSpace, 0, view, 0, LIGHT_POS_IN_WORLD_SPACE, 0);

        //draw floor
        floor.draw(lightPosInEyeSpace, view, perspective);
    }

    @Override
    public void onFinishFrame(Viewport viewport) {

    }

    @Override
    public void onSurfaceChanged(int i, int i1) {

    }

    @Override
    public void onRendererShutdown() {

    }
}
