package br.com.leonardobarral.application_06.calculos

import kotlin.math.pow


fun calcJurosSimples(
    capitaljsp: String,
    taxajsp:String,
    periodojsp: String
):Double {
    val capitaljs = capitaljsp.replace(",",".").toDouble()
    val taxajs = taxajsp.replace(",",".").toDouble()/100
    val periodojs = periodojsp.toDouble()

    return capitaljs * taxajs * periodojs
}

fun calcMontanteSimples(
    jurosmsp: Double,
    capitalmsp: String
):Double {
    val capitalms = capitalmsp.replace(",",".").toDouble()
    return jurosmsp + capitalms
}

fun calcJurosComposto(
    capitaljcp: String,
    montantejcp: Double
):Double {
    val capitaljc = capitaljcp.replace(",",".").toDouble()
    return montantejcp - capitaljc
}

fun calcMontanteComposto(
    capitalmcp: String,
    taxamcp:String,
    periodomcp: String
):Double {
    val capitalmc = capitalmcp.replace(",",".").toDouble()
    val taxamc = taxamcp.replace(",",".").toDouble()/100
    val periodomc = periodomcp.toDouble()
    return capitalmc * (1 + taxamc).pow(periodomc)
}