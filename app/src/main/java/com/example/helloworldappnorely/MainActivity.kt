package com.example.helloworldappnorely

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textEditorRef = findViewById<EditText>(R.id.textEditor)
        val textViewRef = findViewById<TextView>(R.id.textView)
        val backgroundViewRef = findViewById<ConstraintLayout>(R.id.backgroundView)


        // Updates the text label with the typed-in text, unless it is blank, in
        // which case the label will just return to its default text
        findViewById<Button>(R.id.textEditorButton).setOnClickListener(){
            if (textEditorRef.text.isBlank()){
                textViewRef.text = "Hello from Norely"
            }
            else {
                textViewRef.text = textEditorRef.text
            }
            textEditorRef.text.clear()
        }


        // Changes text color from black to white and vice versa
        findViewById<Button>(R.id.changeTextColorButton).setOnClickListener() {
            val textColor: Int
            if (textViewRef.currentTextColor == getColor(R.color.black)){
                textColor = getColor(R.color.white)
            }
            else {
                textColor = getColor(R.color.black)
            }
            textViewRef.setTextColor(textColor)
        }


        // Allows user to change the background color sequentially from the color list
        val colorList = arrayOf<Int>(getColor(R.color.lilac), getColor(R.color.baby_blue),
            getColor(R.color.light_green), getColor(R.color.light_yellow), getColor(R.color.light_orange),
            getColor(R.color.coral))

        var i = -1
        findViewById<Button>(R.id.changeBackgroundColorButton).setOnClickListener() {
            if (i == colorList.size - 1){
                i = -1
            }
            i += 1
            backgroundViewRef.setBackgroundColor(colorList[i])
        }


        // Set all views to their default values if background is clicked
        backgroundViewRef.setOnClickListener(){
            backgroundViewRef.setBackgroundColor(getColor(R.color.wine))
            textViewRef.setTextColor(getColor(R.color.black))
            textViewRef.text = "Hello from Norely"
            textEditorRef.text.clear()
        }
    }
}