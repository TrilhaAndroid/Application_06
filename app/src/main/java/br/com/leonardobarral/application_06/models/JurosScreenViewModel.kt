package br.com.leonardobarral.application_06.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.leonardobarral.application_06.calculos.calcJurosComposto
import br.com.leonardobarral.application_06.calculos.calcJurosSimples
import br.com.leonardobarral.application_06.calculos.calcMontanteComposto
import br.com.leonardobarral.application_06.calculos.calcMontanteSimples


class JurosScreenViewModel:ViewModel() {

    private val _valorInvestido = MutableLiveData<String>()
    val valorInvestido: LiveData<String> = _valorInvestido


    private val _taxa = MutableLiveData<String>()
    val taxa: LiveData<String> = _taxa


    private val _periodo = MutableLiveData<String>()
    val periodo: LiveData<String> = _periodo


    private val _jurosSimples = MutableLiveData<Double>()
    val jurosSimples: LiveData<Double> = _jurosSimples

    private val _montanteSimples = MutableLiveData<Double>()
    val montanteSimples: LiveData<Double> = _montanteSimples

    private val _jurosCompostos = MutableLiveData<Double>()
    val jurosCompostos: LiveData<Double> = _jurosCompostos

    private val _montanteComposto = MutableLiveData<Double>()
    val montanteComposto: LiveData<Double> = _montanteComposto



    fun updateValorInvestimento(novoValor:String){
        _valorInvestido.value = novoValor
    }

    fun updateTaxa(novoValor:String){
        _taxa.value = novoValor
    }

    fun updatePerioro(novoValor:String){
        _periodo.value = novoValor
    }

    fun calcularjurosSimples(){
        _jurosSimples.value = calcJurosSimples(
            capitaljsp = _valorInvestido.value!!,
            taxajsp = _taxa.value!!,
            periodojsp =_periodo.value!!
        )
    }

    fun calcularMontanteSimples(){
        _montanteSimples.value = calcMontanteSimples(
            jurosmsp = _jurosSimples.value!!,
            capitalmsp = _valorInvestido.value!!
        )
    }

    fun calcularJurosCompostos(){
        _jurosCompostos.value = calcJurosComposto(
            capitaljcp =  _valorInvestido.value!!,
            montantejcp = _montanteComposto.value!!
        )
    }

    fun calcularMontanteComposto(){
        _montanteComposto.value = calcMontanteComposto(
            capitalmcp = _valorInvestido.value!!,
            taxamcp = _taxa.value!!,
            periodomcp =_periodo.value!!
        )
    }


}