package umi.example.myintent

import android.Manifest
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlinpermissions.KotlinPermissions
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        KotlinPermissions.with(this) // where this is an FragmentActivity instance
            .permissions(Manifest.permission.CAMERA)
            .onAccepted { permissions ->
                //List of accepted permissions
            }
            .onDenied { permissions ->
                //List of denied permissions
            }
            .onForeverDenied { permissions ->
                //List of forever denied permissions
            }
            .ask()
        btnPindahActivityExplisit.setOnClickListener {
            startActivity(Intent(this, ExplisitIntentActivity::class.java))
        }
        btnPindahActivityImplisit.setOnClickListener {
            startActivity(Intent (this,ImplisitIntentActivity::class.java ))
        }
        btnPindahActivityIntentBundle.setOnClickListener {
            val intent: Intent = Intent(this, IntentBundleActivity::class.java)
            intent.putExtra("NAMA", " NAMA : UMI KHOTIMATUS SA'ADAH")
            intent.putExtra("NPM", "NPM : 16670008")
            intent.putExtra("KELAS", "KELAS : INFORMATIKA 6A")
            intent.putExtra("FOTO", R.drawable.umi_mobile)
            intent.putExtra("IG", "IG : umi_khotimatuss")

            startActivity(intent)

        }
    }

}


