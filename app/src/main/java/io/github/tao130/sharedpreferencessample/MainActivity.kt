package io.github.tao130.sharedpreferencessample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getSharedPreferencesメソッドでSharedPreferencesオブジェクトを取得
        val sharedPref = getSharedPreferences("プリファレンスファイル名", Context.MODE_PRIVATE)

        // getString()を呼び出して保存されている文字列を読み込む
        // まだ保存されていない場合はデフォルトの文字列を返す
        val savedText = sharedPref.getString("key名", "デフォルト文字列")

        val editText = findViewById<EditText>(R.id.editText)
        editText.setText(savedText)

        val button = findViewById<Button>(R.id.saveButton)
        button.setOnClickListener {
            // テキストボックスに入力されている文字列を取得
            val inputText = editText.text.toString()
            // プリファレンスに書き込む
            sharedPref.edit().putString("key名", inputText).apply()
        }
    }
}