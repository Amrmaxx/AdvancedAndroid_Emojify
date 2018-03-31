package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class Emojifier {

    public static int detectFaces(Context context, Bitmap sourceImage) {

        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        Frame frame = new Frame.Builder().setBitmap(sourceImage).build();
        SparseArray<Face> faces = detector.detect(frame);

        Toast.makeText(context, "Number of faces = " + faces.size(), Toast.LENGTH_SHORT).show();

        detector.release();
        return faces.size();
    }
}
