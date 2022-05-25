package lotto.domain

import lotto.domain.enums.LottoRank
import lotto.exception.DuplicateLottoNumberException

class WinningLotto(private val lottoNumbers: LottoNumbers, private val bonusNumber: LottoNumber) {

    init {
        if (bonusNumber in lottoNumbers) throw DuplicateLottoNumberException()
    }

    fun match(lotto: Lotto): LottoRank {
        return LottoRank.of(matchingCount(lotto), isMatchBonusNumber(lotto))
    }

    fun match(lottoList: List<Lotto>): List<LottoRank> {
        return lottoList.map { match(it) }
    }

    private fun matchingCount(lotto: Lotto): Int {
        return matchingNumbers(lotto).size
    }

    private fun matchingNumbers(lotto: Lotto): List<LottoNumber> {
        return lottoNumbers.matchingNumbers(lotto.numbers)
    }

    private fun isMatchBonusNumber(lotto: Lotto): Boolean {
        return bonusNumber in lotto
    }

    companion object {
        class Builder(private val lottoNumbers: LottoNumbers) {

            constructor(vararg numbers: Int) : this(LottoNumbers(*numbers))

            fun bonus(bonusNumber: LottoNumber): WinningLotto {
                return WinningLotto(lottoNumbers, bonusNumber)
            }

            fun bonus(number: Int): WinningLotto {
                return bonus(LottoNumber(number))
            }
        }

        fun winningLottoOf(vararg numbers: Int): Builder {
            return Builder(*numbers)
        }

        fun winningLottoOf(lottoNumbers: LottoNumbers): Builder {
            return Builder(lottoNumbers)
        }
    }
}
