package com.example.horosclase

class horoscopoProvider {


    companion object {
        val horosList: List<horoscopoclass> = listOf(
            horoscopoclass("aries", "Aries", R.drawable.aries_s),
            horoscopoclass("tauro", "Tauro", R.drawable.tauro_s),
            horoscopoclass("geminis", "Geminis",R.drawable.geminis_s),
            horoscopoclass("cancer", "Cancer", R.drawable.cancer_s),
            horoscopoclass("leo", "Leo", R.drawable.leo_s),
            horoscopoclass("virgo", "Virgo", R.drawable.virgo_s),
            horoscopoclass("libra", "libra", R.drawable.libra_s),
            horoscopoclass("escorpio", "Escorpio", R.drawable.escorpio_s),
            horoscopoclass("sagitario", "Sagitario", R.drawable.sagitario_s),
            horoscopoclass("capricornio", "Capricornio", R.drawable.capricornio_s),
            horoscopoclass("acuario", "Acuario", R.drawable.acuario_s),
            horoscopoclass("piscis", "Piscis", R.drawable.piscis_s),
        )
    }
}