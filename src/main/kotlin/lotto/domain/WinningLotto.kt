package lotto.domain

import lotto.domain.enums.LottoRank
import lotto.exception.DuplicateLottoNumberException

class WinningLotto private constructor(private val lottoNumbers: LottoNumbers, private val bonusNumber: LottoNumber) {

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
        return matchingLottoNumbers(lotto).size
    }

    private fun matchingLottoNumbers(lotto: Lotto): List<LottoNumber> {
        return lottoNumbers.matchingNumbers(lotto.numbers)
    }

    private fun isMatchBonusNumber(lotto: Lotto): Boolean {
        return bonusNumber in lotto
    }

    companion object {
        fun of(lottoNumbers: LottoNumbers, bonusNumber: LottoNumber): WinningLotto {
            return WinningLotto(lottoNumbers, bonusNumber)
        }
    }
}
