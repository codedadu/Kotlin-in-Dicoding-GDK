package dev.id.bariscode.submisi1footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import dev.id.bariscode.submisi1footballclub.adapter.RecyclerViewAdapter
import dev.id.bariscode.submisi1footballclub.`object`.FootballClub
import org.jetbrains.anko.startActivity

class HomeActivity : AppCompatActivity() {

    private  var footballClub: MutableList<FootballClub> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        title = "List Football Club"

        val list = findViewById<RecyclerView>(R.id.rvListFootballClub)
        initData()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecyclerViewAdapter(this, footballClub) {

            startActivity<DetailFootballClubActivity>(
                "NAMA_CLUB" to "${it.namaClub}",
                "DESK_CLUB" to "${it.deskripsiClub}",
                "PICS_CLUB" to it.gambarClub
            )
        }
    }

    private fun initData() {
        val namaClubFootballs = resources.getStringArray(R.array.club_name)
        val descClubFootballs = resources.getStringArray(R.array.club_desc)
        val gambarClubFootballs = resources.obtainTypedArray(R.array.club_image)

        footballClub.clear()

        for (i in namaClubFootballs.indices) {
            footballClub.add(
                FootballClub(
                    namaClubFootballs[i],
                    descClubFootballs[i],
                    gambarClubFootballs.getResourceId(i, 0)
                )
            )
        }

        gambarClubFootballs.recycle()
    }
}
