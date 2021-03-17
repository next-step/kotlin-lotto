package lotto.domain

import lotto.vo.LottoNumber
import lotto.vo.WinningLotto

class Lotto(val lottoNumbers: Set<LottoNumber>) {
    init {
        require(lottoNumbers.size == LOTTO_SIZE) { "하나의 로또에 로또 번호는 정확히 6개만 허용됩니다." }
    }

    fun match(winningNumber: WinningLotto): LottoPrize {
        var isBonusMatch = false
        val count = lottoNumbers.intersect(winningNumber.winningLotto).size
        if (winningNumber.bonusNumber in lottoNumbers) isBonusMatch = true
        return LottoPrize.from(count, isBonusMatch)
    }

    override fun toString(): String {
        return "$lottoNumbers"
    }

    companion object {
        val LOTTO_SIZE = 6
        fun of(numbers: Set<Int>): Lotto {
            return Lotto(numbers.map { LottoNumber.from(it) }.sortedBy { it.number }.toSet())
        }
    }
}
