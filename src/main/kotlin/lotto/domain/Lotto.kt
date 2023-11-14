package lotto.domain

import lotto.numbermaker.RandomNumberMaker

class Lotto(private val numberList: List<Int> = generateDefaultRandomNumberList()) {
    private val _numbers = mutableListOf<LottoNumber>()

    val numbers: List<LottoNumber>
        get() = _numbers.toList()

    init {
        numberList.forEach { it ->
            val lottoNumber = LottoNumber.from(it)
            _numbers.add(lottoNumber)
        }
    }

    fun getNumberValues(): List<Int> {
        val numberList = mutableListOf<Int>()
        _numbers.forEach {
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
