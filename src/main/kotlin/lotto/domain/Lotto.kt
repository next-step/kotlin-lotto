package lotto.domain

import lotto.numbermaker.RandomNumberMaker

class Lotto(val numbers: List<LottoNumber>) {
    init {
        validateSetSize()
    }

    constructor(numberList: Set<Int> = generateDefaultRandomNumberList()) : this(
        numberList.map {
            LottoNumber.from(it)
        }.toList(),
    )

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
        if (numbers.size != DEFAULT_LOTTO_SIZE) {
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
