package com.example.horosclase.data

import com.example.horosclase.R

class horoscopoProvider {


    companion object {
        private val horosList: List<horoscopoclass> = listOf(
            horoscopoclass(
                "aries",
                R.string.horoscope_name_aries,
                R.string.horoscope_date_aries,
                R.drawable.aries_s,
                R.color.fuego, "fuego"
            ),
            horoscopoclass(
                "taurus",
                R.string.horoscope_name_taurus,
                R.string.horoscope_date_taurus,
                R.drawable.tauro_s,
                R.color.tierraDos, "tierra"
            ),
            horoscopoclass(
                "gemini",
                R.string.horoscope_name_gemini,
                R.string.horoscope_date_gemini,
                R.drawable.geminis_s,
                R.color.aire, "aire"
            ),
            horoscopoclass(
                "cancer",
                R.string.horoscope_name_cancer,
                R.string.horoscope_date_cancer,
                R.drawable.cancer_s,
                R.color.agua, "agua"
            ),
            horoscopoclass(
                "leo",
                R.string.horoscope_name_leo,
                R.string.horoscope_date_leo,
                R.drawable.leo_s,
                R.color.fuego, "fuego"
            ),
            horoscopoclass(
                "virgo",
                R.string.horoscope_name_virgo,
                R.string.horoscope_date_virgo,
                R.drawable.virgo_s,
                R.color.tierra, "tierra"
            ),
            horoscopoclass(
                "libra",
                R.string.horoscope_name_libra,
                R.string.horoscope_date_libra,
                R.drawable.libra_s,
                R.color.aire, "aire"
            ),
            horoscopoclass(
                "scorpio",
                R.string.horoscope_name_scorpio,
                R.string.horoscope_date_scorpio,
                R.drawable.escorpio_s,
                R.color.agua, "agua"
            ),
            horoscopoclass(
                "sagittarius",
                R.string.horoscope_name_sagittarius,
                R.string.horoscope_date_sagittarius,
                R.drawable.sagitario_s,
                R.color.fuego, "fuego"
            ),
            horoscopoclass(
                "capricorn",
                R.string.horoscope_name_capricorn,
                R.string.horoscope_date_capricorn,
                R.drawable.capricornio_s,
                R.color.tierraDos, "tierra"
            ),
            horoscopoclass(
                "aquarius",
                R.string.horoscope_name_aquarius,
                R.string.horoscope_date_aquarius,
                R.drawable.acuario_s,
                R.color.aire, "aire"
            ),
            horoscopoclass(
                "pisces",
                R.string.horoscope_name_pisces,
                R.string.horoscope_date_pisces,
                R.drawable.piscis_s,
                R.color.agua, "agua"
            ),
        )


        fun findAll(): List<horoscopoclass> {
            return horosList
        }

        fun findById(id: String): horoscopoclass? {
            return horosList.find { it.id == id }
        }


    }
}