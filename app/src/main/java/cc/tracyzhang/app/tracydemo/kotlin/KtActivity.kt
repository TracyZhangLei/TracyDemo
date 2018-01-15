package cc.tracyzhang.app.tracydemo.kotlin

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import cc.tracyzhang.app.tracydemo.R
import kotlinx.android.synthetic.main.activity_kt.*
import kotlinx.android.synthetic.main.content_kt.*

class KtActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kt)
        setSupportActionBar(toolbar)

        tv.text = "This is"
        tv.textSize = 20F
        tv.setTextColor(Color.BLUE)
        tv.setOnClickListener {
            log(tv.textSize.toString())
            log(sum(1,2).toString())
        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", {
                        log("SnackBar Action ClickListener invoke")
                    }
                    ).show()
        }
    }

    fun log(msg: String?){
        Log.v("test", msg)
    }

    override fun onResume() {
        super.onResume()
        log("onResume")
    }

    private fun sum(a:Int, b:Int): Int{
        println(" $a + $b = ${a+b} ")
        log("max number is: " + max(a,b).toString())
        log("min number is: " + min(a,b).toString())
        return a+b
    }

    fun max(a:Int, b:Int):Int{
        return if (a>b) a else b
    }

    fun min(a:Int,b:Int) = if (a<b) a else b

}
