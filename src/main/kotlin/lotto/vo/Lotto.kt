package lotto.vo

import lotto.domain.LottoPrize

data class Lotto(val lottoNumbers: Set<LottoNumber>) {
    init {
        require(lottoNumbers.size == LOTTO_SIZE) { "하나의 로또에 로또 번호는 정확히 6개만 허용됩니다." }
    }

    companion object {
        val LOTTO_SIZE = 6
        fun of(numbers: Set<Int>): Lotto {
            return Lotto(numbers.map { LottoNumber.from(it) }.sortedBy { it.number }.toSet())
        }
    }

    fun match(winnerNumber: WinnerLotto): LottoPrize {
        var count = 0
        lottoNumbers.intersect(winnerNumber.winnerLotto).forEach {
            count++
        }
        return when (count) {
            3 -> LottoPrize.THREE_MATCH
            4 -> LottoPrize.FOUR_MATCH
            5 -> LottoPrize.FIVE_MATCH
            6 -> LottoPrize.SIX_MATCH
            else -> LottoPrize.NOT_MATCH
        }
    }

    override fun toString(): String {
        return "$lottoNumbers"
    }
}
