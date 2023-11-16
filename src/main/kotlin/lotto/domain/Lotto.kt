package lotto.domain

import lotto.numbermaker.RandomNumberMaker

class Lotto(private val numberList: Set<Int> = generateDefaultRandomNumberList()) {
    val numbers: List<LottoNumber>

    init {
        validateSetSize()
        numbers = numberList.map { LottoNumber.from(it) }
    }

    fun getNumberValues(): List<Int> {
        return numbers.map {
            it.value
        }.toList()
    }

    fun countMatchNumber(winLotto: Lotto): Int {
        return numbers.count {
            winLotto.hasLottoNumber(it)
        }
    }

    fun hasLottoNumber(lottoNumber: LottoNumber): Boolean {
        return numbers.contains(lottoNumber)
    }

    private fun validateSetSize() {
        if (numberList.size != DEFAULT_LOTTO_SIZE) {
            throw IllegalArgumentException()
        }
    }

    companion object {
        private const val DEFAULT_LOTTO_SIZE = 6
        private fun generateDefaultRandomNumberList(): Set<Int> {
            val randomNumberMaker: RandomNumberMaker = RandomNumberMaker()
            val random6NumList = randomNumberMaker.generate()
            return random6NumList.toSet()
        }
    }
}
