package com.dikifebriani.recyclerview
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.dikifebriani.recyclerview.binding.ActivityMainBinding
import com.dikifebriani.recyclerview.model.Pemain


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("cortois",R.drawable.cortois,"Penjaga Gawang","1,84 m","Perez Zeledon (Costa Rica)","15 Desember 1986"))
        listPemain.add(Pemain("benzema",R.drawable.benzema,"Penyerang","1,87 m","Funchal,Madeira (Portugal)","05 Februari 1985"))
        listPemain.add(Pemain("marcello",R.drawable.marcello,"Belakang","1,74 m","Rio de Janeiro (Brasil))","12 Mei 1988"))
        listPemain.add(Pemain("ramos",R.drawable.ramos,"Belakang","1,84 m","Camas (Spanyol)","30 Maret 1986"))
        listPemain.add(Pemain("Zidan",R.drawable.zidan,"Pelatih","1,85 m","Marseille (Prancis)","23 Juni 1972"))

        binding.list.adapter = AdapterTeamBola(this,listPemain,object : AdapterTeamBola.OnClicklistener{
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)

                    val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                    val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txtTempatLahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txtTanggalLahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?: 0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }



                }.show()
            }

        })
    }
}