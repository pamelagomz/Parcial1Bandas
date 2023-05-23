package com.pgomez.parcial1bandas.data

import com.pgomez.parcial1bandas.data.models.BandModel

//band 1 data
val name= "Arctic Monkeys"
val genre= "Indie rock"

//band 2 data
val name1= "soda stereo"
val genre1= "Rock"

var bands = mutableListOf(
    BandModel(name, genre),
    BandModel(name1, genre1)
)

