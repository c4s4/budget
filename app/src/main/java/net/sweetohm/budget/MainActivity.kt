package net.sweetohm.budget

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate

val budgetCourses = 400
val budgetDivers = 400
val budgetLoisirs = 100

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // on cache les champs de texte des écarts
        coursesEcart.visibility = View.INVISIBLE
        diversEcart.visibility = View.INVISIBLE
        loisirsEcart.visibility = View.INVISIBLE
        totalEcart.visibility = View.INVISIBLE
        // on lie le bouton au calcul
        button.setOnClickListener {
            val now = LocalDate.now()
            val courses = coursesEdit.text.toString().toFloat()
            val divers = diversEdit.text.toString().toFloat()
            val loisirs = loisirsEdit.text.toString().toFloat()
            val day = now.dayOfMonth
            val length = now.lengthOfMonth()
            val ecartCourses = (day * budgetCourses) / length - courses
            val ecartDivers = (day * budgetDivers) / length - divers
            val ecartLoisirs = (day * budgetLoisirs) / length - loisirs
            coursesEcart.text = format(ecartCourses)
            diversEcart.text = format(ecartDivers)
            loisirsEcart.text = format(ecartLoisirs)
            val total = ecartCourses + ecartDivers + ecartLoisirs
            totalEcart.text = format(total)
            // on affiche les champs de texte des écarts
            coursesEcart.visibility = View.VISIBLE
            diversEcart.visibility = View.VISIBLE
            loisirsEcart.visibility = View.VISIBLE
            totalEcart.visibility = View.VISIBLE
        }
    }

    fun format(value: Float): String {
        return String.format("%.2f", value)
    }
}
