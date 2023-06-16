package com.dicoding.md_herbalens

import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.dicoding.md_herbalens.ml.Model
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer
import java.nio.ByteOrder

object TensorFlowHelper {
    const val imageSize = 256

    @Composable
    fun classifyImage(image: Bitmap, callback : (plant : Int) -> Unit) {
        val model: Model = Model.newInstance(LocalContext.current)

        // Creates inputs for reference.
        val inputFeature0 =
            TensorBuffer.createFixedSize(intArrayOf(1, imageSize, imageSize, 3), DataType.FLOAT32)
        val byteBuffer: ByteBuffer = ByteBuffer.allocateDirect(4 * imageSize * imageSize * 3)
        byteBuffer.order(ByteOrder.nativeOrder())

        val intValues = IntArray(imageSize * imageSize)
        image.getPixels(intValues, 0, image.width, 0, 0, image.width, image.height)
        var pixel = 0
        //iterate over each pixel and extract R, G, and B values. Add those values individually to the byte buffer.
        for (i in 0 until imageSize) {
            for (j in 0 until imageSize) {
                val `val` = intValues[pixel++] // RGB
                byteBuffer.putFloat((`val` shr 16 and 0xFF) / 255f)
                byteBuffer.putFloat((`val` shr 8 and 0xFF) / 255f)
                byteBuffer.putFloat((`val` and 0xFF) / 255f)
            }
        }
        inputFeature0.loadBuffer(byteBuffer)

        // Runs model inference and gets result.
        val outputs: Model.Outputs = model.process(inputFeature0)
        val outputFeature0: TensorBuffer = outputs.getOutputFeature0AsTensorBuffer()
        val confidences = outputFeature0.floatArray

        // find the index of the class with the biggest confidence.
        var maxPos = 0
        var maxConfidence = Float.MIN_VALUE
        for (i in confidences.indices) {
            if (confidences[i] > maxConfidence) {
                maxConfidence = confidences[i]
                maxPos = i
            }
        }
        val plants = arrayOf(
            "Alang-alang", "Belimbing Wuluh", "Daun Encok", "Daun Gedi", "Daun Jintan",
            "Daun Kari", "Daun Mint", "Jahe", "Jambu Biji", "Jeruk Lemon", "Jeruk Nipis",
            "Kelengkeng", "Kenanga", "Kencur", "Ketumbar", "Krisan / Bunga Seruni",
            "Kumis Kucing", "Kunyit", "Lengkuas", "Lidah Buaya", "Mengkudu", "Murbai",
            "Nangka", "Pacar Air", "Pandan", "Patikan Kebo", "Pir", "Plum", "Rosela",
            "Rosemary", "Serai", "Sirih", "Sirsak", "Srikaya", "Suji", "Zaitun"
        )
        callback.invoke(maxPos)


        // Releases model resources if no longer used.
        model.close()

    }
}

