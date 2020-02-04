package android.example.com

import android.content.Context
import android.example.com.databinding.ActivityMainBinding
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil


/**
 * Main Activity of the AboutMe app. This app demonstrates:
 *     * LinearLayout with TextViews, ImageView, Button, EditText, and ScrollView
 *     * ScrollView to display scrollable text
 *     * Getting user input with an EditText.
 *     * Click handler for a Button to retrieve text from an EditText and set it in a TextView.
 *     * Setting the visibility status of a view.
 *     * Data binding between MainActivity and activity_main.xml. How to remove findViewById,
 *       and how to display data in views using the data binding object.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val myName: MyName= MyName("Alex Sorokin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName=myName

        //findViewById<Button>(R.id.done_button).setOnClickListener {
          //  addNickname(it)
        //}
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

    }

    private fun addNickname(view: View) {

        binding.apply {
        //nicknameText.text =binding.nicknameEdit.text
            myName?.nickname=nicknameEdit.text.toString()
            invalidateAll()
        binding.nicknameEdit.visibility= View.GONE
        binding.doneButton.visibility= View.GONE
        binding.nicknameText.visibility = View.VISIBLE

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

}