package lotto.domain

import java.util.ArrayList

class Lotto(
    generator: LottoNumberGenerator = LottoNumberRandomGenerator()
) {

    private val _numbers: MutableSet<LottoNumber> = mutableSetOf()
    val numbers: Set<LottoNumber>
        get() = _numbers

    init {
        while (_numbers.size < LOTTO_NUMBER_COUNT) {
            _numbers.add(LottoNumber(generator.number))
        }
    }

    fun matchByWonNumber(wonNumber: ArrayList<LottoNumber>): Rank {
        val wonNumberCount: Int = numbers.count { wonNumber.contains(it) }
        return Rank.getRankByCount(wonNumberCount)
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
    }
}
