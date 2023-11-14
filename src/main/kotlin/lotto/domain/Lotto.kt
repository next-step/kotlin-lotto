package lotto.domain

import lotto.numbermaker.RandomNumberMaker

class Lotto(private val numberList: Set<Int> = generateDefaultRandomNumberList()) {
    private val _numbers = mutableListOf<LottoNumber>()

    val numbers: List<LottoNumber>
        get() = _numbers.toList()

    init {
        validateSetSize()
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

    private fun validateSetSize() {
        if (numberList.size != 6) {
            throw IllegalArgumentException()
        }
    }

    companion object {
        private fun generateDefaultRandomNumberList(): Set<Int> {
            val randomNumberMaker: RandomNumberMaker = RandomNumberMaker()
            val random6NumList = randomNumberMaker.generate()
            return random6NumList.toSet()
        }
    }
}
