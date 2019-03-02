package dev.id.bariscode.projectiimembuatlayoutdenganankokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)

    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout{

                imageView(R.drawable.dicoding).
                    lparams(width= matchParent) {
                        padding = dip(20)
                        margin = dip(15)
                    }

                val name = editText(){
                    hint = "What's your name?"
                    gravity = Gravity.CENTER;
                }

                val btnSay = button() {
                    text = "Push Me"
                    onClick {
                        onClick {
                            ctx.toast("Hello, ${name.text}!")
                        }
                    }
                }
            }
        }
    }

}
