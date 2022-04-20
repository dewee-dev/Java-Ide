package com.pranav.java.ide

import android.content.SharedPreferences
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.Toolbar

import com.google.android.material.radiobutton.MaterialRadioButton

class SettingActivity : AppCompatActivity() {

	lateinit var java3: MaterialRadioButton
	lateinit var java4: MaterialRadioButton
	lateinit var java5: MaterialRadioButton
	lateinit var java6: MaterialRadioButton
	lateinit var java8: MaterialRadioButton
	lateinit var java9: MaterialRadioButton
	lateinit var java10: MaterialRadioButton
	lateinit var java11: MaterialRadioButton
	lateinit var java12: MaterialRadioButton
	lateinit var java13: MaterialRadioButton
	lateinit var java14: MaterialRadioButton
	lateinit var java15: MaterialRadioButton
	lateinit var java16: MaterialRadioButton
	lateinit var java17: MaterialRadioButton

	lateinit var classpath: AppCompatEditText

	lateinit var settings: SharedPreferences

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_setting)

		val toolbar: Toolbar = findViewById(R.id.toolbar)

		setSupportActionBar(toolbar)
    getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
    getSupportActionBar()?.setHomeButtonEnabled(true)
    toolbar.setNavigationOnClickListener { _ ->
      onBackPressed()
		}

		java3 = findViewById(R.id.java3)
		java4 = findViewById(R.id.java4)
		java5 = findViewById(R.id.java5)
		java6 = findViewById(R.id.java6)
		java8 = findViewById(R.id.java8)
		java9 = findViewById(R.id.java9)
		java10 = findViewById(R.id.java10)
		java11 = findViewById(R.id.java11)
		java12 = findViewById(R.id.java12)
		java13 = findViewById(R.id.java13)
		java14 = findViewById(R.id.java14)
		java15 = findViewById(R.id.java15)
		java16 = findViewById(R.id.java16)
		java17 = findViewById(R.id.java17)
		
		classpath = findViewById(R.id.classpath)

		val java7: MaterialRadioButton = findViewById(R.id.java7)
		settings = getSharedPreferences("compiler_settings", MODE_PRIVATE)

		when (settings.getFloat("javaVersion", 7.0f)) {

			1.3f -> java3.setChecked(true)

			1.4f -> java4.setChecked(true)

			5.0f -> java5.setChecked(true)

			6.0f -> java6.setChecked(true)

			8.0f -> java8.setChecked(true)

			9.0f -> java9.setChecked(true)

			10.0f -> java10.setChecked(true)

			11.0f -> java11.setChecked(true)

			12.0f -> java12.setChecked(true)

			13.0f -> java13.setChecked(true)

			14.0f -> java14.setChecked(true)

			15.0f -> java15.setChecked(true)

			16.0f -> java16.setChecked(true)

			17.0f -> java17.setChecked(true)

			else -> java7.setChecked(true)
		}

		classpath.setText(settings.getString("classpath", ""))
	}

	override fun onDestroy() {
	  super.onDestroy()
		var version = 1.7f

		if (java3.isChecked()) version = 1.3f
		else if (java4.isChecked()) version = 1.4f
		else if (java5.isChecked()) version = 5.0f
		else if (java6.isChecked()) version = 6.0f
		else if (java8.isChecked()) version = 8.0f
		else if (java9.isChecked()) version = 9.0f
		else if (java10.isChecked()) version = 10.0f
		else if (java11.isChecked()) version = 11.0f
		else if (java12.isChecked()) version = 12.0f
		else if (java13.isChecked()) version = 13.0f
		else if (java14.isChecked()) version = 14.0f
		else if (java15.isChecked()) version = 15.0f
		else if (java16.isChecked()) version = 16.0f
		else if (java17.isChecked()) version = 17.0f

		settings.edit().putFloat("javaVersion", version).apply()

		settings.edit().putString("classpath", classpath.getText().toString()).apply()
	}
}
