package lotto.model

import lotto.model.LottoMaker.Companion.LOTTO_NUMBER_TOTAL_COUNT
import lotto.view.WINNER_NUMBER_DELIMITER

data class Lotto constructor(val lottoNumbers: Set<LottoNo>) {
    lateinit var win: Win

    init {
        require(lottoNumbers.size == LOTTO_NUMBER_TOTAL_COUNT) { "로또 번호는 ${LOTTO_NUMBER_TOTAL_COUNT}개 입니다." }
    }

    fun checkWin(winner: WinnerLotto) {
        val matchNumbers = winner.contains(lottoNumbers)
        val matchBonus = winner.containsBonus(lottoNumbers)

        win = winner.getPrize(matchNumbers, matchBonus)
    }

    fun checkPrize(): Money {
        return win.prize
    }

    fun isIn(bonusNumber: LottoNo): Boolean {
        return lottoNumbers.contains(bonusNumber)
    }

    companion object {
        fun make(numbers: String): Lotto {
            val lotto = numbers.split(WINNER_NUMBER_DELIMITER)

            return Lotto(lotto.map { LottoNo.from(it.toInt()) }.toSet())
        }
    }
}
