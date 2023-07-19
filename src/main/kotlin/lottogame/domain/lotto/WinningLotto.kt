package lottogame.domain.lotto

import lottogame.domain.rank.Rank

data class WinningLotto(
    private val lottoNumbers: LottoNumbers,
    private val bonusNumber: LottoNumber
) {
    init {
        require(!lottoNumbers.value.contains(bonusNumber)) { "보너스 번호는 당첨 번호에 포함될 수 없습니다. [${lottoNumbers.value}, $bonusNumber]" }
    }

    fun match(otherLottoNumbers: LottoNumbers): Rank? {
        val matchCount = otherLottoNumbers.match(lottoNumbers)
        val bonusMatch = otherLottoNumbers.contains(bonusNumber)
        return Rank.from(matchCount, bonusMatch)
    }

    companion object {
        fun from(winningNumbers: List<Int>, bonusNumber: Int): WinningLotto {
            return WinningLotto(
                LottoNumbers.of(winningNumbers),
                LottoNumber(bonusNumber)
            )
        }
    }
}
