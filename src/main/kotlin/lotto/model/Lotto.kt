package lotto.model

import lotto.model.LottoMaker.Companion.LOTTO_NUMBER_TOTAL_COUNT

data class Lotto(val lottoNumbers: List<LottoNo>) {
    lateinit var win: Win

    init {
        require(lottoNumbers.size == LOTTO_NUMBER_TOTAL_COUNT) { "당첨 번호는 ${LOTTO_NUMBER_TOTAL_COUNT}개 입니다." }
        require(isNotRepeated(lottoNumbers)) { "로또에는 중복된 숫자가 없어야 합니다." }
    }

    private fun isNotRepeated(lottoNumbers: List<LottoNo>): Boolean {
        return lottoNumbers.distinct().size == LOTTO_NUMBER_TOTAL_COUNT
    }

    fun checkWin(winner: WinnerLotto) {
        val matchNumbers = winner.contains(lottoNumbers)
        val matchBonus = winner.containsBonus(lottoNumbers)

        win = getPrize(matchNumbers, matchBonus)
    }

    fun checkPrize(): Money {
        return win.prize
    }
}
