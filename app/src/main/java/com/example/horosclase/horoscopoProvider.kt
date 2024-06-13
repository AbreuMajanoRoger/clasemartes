package com.example.horosclase

class horoscopoProvider {


    companion object {
        private val horosList: List<horoscopoclass> = listOf(
            horoscopoclass("aries", R.string.horoscope_name_aries, R.string.horoscope_date_aries,R.drawable.aries_s, R.color.purple_500, "fuego"),
            horoscopoclass("tauro", R.string.horoscope_name_taurus,R.string.horoscope_date_taurus,R.drawable.tauro_s, R.color.purple_500,"tierra"),
            horoscopoclass("geminis", R.string.horoscope_name_gemini,R.string.horoscope_date_gemini,R.drawable.geminis_s,R.color.purple_500,"aire"),
            horoscopoclass("cancer", R.string.horoscope_name_cancer,R.string.horoscope_date_cancer ,R.drawable.cancer_s,R.color.verdeChillon,"agua"),
            horoscopoclass("leo", R.string.horoscope_name_leo,R.string.horoscope_date_leo ,R.drawable.leo_s,R.color.claro,"fuego"),
            horoscopoclass("virgo", R.string.horoscope_name_virgo,R.string.horoscope_date_virgo,R.drawable.virgo_s,R.color.olivo,"tierra"),
            horoscopoclass("libra", R.string.horoscope_name_libra,R.string.horoscope_date_libra ,R.drawable.libra_s,R.color.tierra,"aire"),
            horoscopoclass("escorpio",R.string.horoscope_name_scorpio,R.string.horoscope_date_scorpio ,R.drawable.escorpio_s,R.color.tierraDos,"agua"),
            horoscopoclass("sagitario", R.string.horoscope_name_sagittarius,R.string.horoscope_date_sagittarius ,R.drawable.sagitario_s,R.color.claro,"fuego"),
            horoscopoclass("capricornio", R.string.horoscope_name_capricorn,R.string.horoscope_date_capricorn ,R.drawable.capricornio_s,R.color.tierraDos,"tierra"),
            horoscopoclass("acuario", R.string.horoscope_name_aquarius,R.string.horoscope_date_aquarius ,R.drawable.acuario_s,R.color.olivo,"aire"),
            horoscopoclass("piscis", R.string.horoscope_name_pisces,R.string.horoscope_date_pisces ,R.drawable.piscis_s,R.color.verdeChillon,"agua"),
        )


        fun findAll() : List<horoscopoclass>{
            return horosList
        }
        fun     findById(id: String) : horoscopoclass?{
            return horosList.find {it.id==id}
        }


    }
}