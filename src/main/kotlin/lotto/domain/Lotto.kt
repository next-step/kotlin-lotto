package lotto.domain

import lotto.numbermaker.RandomNumberMaker

class Lotto(private val numberList: List<Int> = generateDefaultRandomNumberList()) {
    val numbers = mutableListOf<LottoNumber>()

    init {
        numberList.forEach { it ->
            val lottoNumber = LottoNumber.from(it)
            numbers.add(lottoNumber)
        }
    }

    fun getNumberValues(): List<Int> {
        val numberList = mutableListOf<Int>()
        numbers.forEach {
            numberList.add(it.value)
        }
        return numberList
    }

    companion object {
        private fun generateDefaultRandomNumberList(): List<Int> {
            val randomNumberMaker: RandomNumberMaker = RandomNumberMaker()
            return randomNumberMaker.generate()
        }
    }
}
