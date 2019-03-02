package dev.id.bariscode.submisi1footballclub

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class DetailFootballClubActivity : AppCompatActivity() {

    private var namaclubFootballget: String = ""
    private var deskclubFootballget: String = ""
    private var gambarFootballget: Int? = null

    lateinit var namaClubFootballClub: TextView
    lateinit var deskripsiClubFootballClub: TextView
    lateinit var logoFootballClub: ImageView

    private val context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Detail Informasi Club"

        verticalLayout {

            logoFootballClub = imageView(R.drawable.logo_parma).lparams(width = wrapContent, height = 150) {
                gravity = Gravity.CENTER
                padding = dip(20)
                margin = dip(15)
            }

             namaClubFootballClub = textView {
                gravity = Gravity.CENTER
                text = context.getString(R.string.nameclub_loading)
            }

            deskripsiClubFootballClub = textView {
                gravity = Gravity.CENTER
                text = context.getString(R.string.descclub_loading)
            }
        }

        val intent = intent
        namaclubFootballget = intent.getStringExtra("NAMA_CLUB")
        deskclubFootballget = intent.getStringExtra("DESK_CLUB")
        gambarFootballget = intent.getIntExtra("PICS_CLUB", 0)

        namaClubFootballClub.text = namaclubFootballget
        deskripsiClubFootballClub.text = deskclubFootballget
        Picasso.get().load(gambarFootballget!!).into(logoFootballClub)

    }
}


