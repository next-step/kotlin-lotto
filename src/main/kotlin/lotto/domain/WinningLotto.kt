package lotto.domain

import lotto.dto.MatchResultDto

class WinningLotto(val winningNumbers: Lotto, private val bonusNumber: LottoNumber) {

    init {
        require(!winningNumbers.numbers.contains(bonusNumber)) { "보너스 볼은 당첨 번호랑 같을 수 없습니다." }
    }

    fun getMatchResult(lotto: Lotto): MatchResultDto =
        MatchResultDto(getCountOfMatch(lotto), matchBonus(lotto))

    fun getMatchResult(lottos: List<Lotto>): List<MatchResultDto> =
        lottos.map { getMatchResult(it) }

    private fun getCountOfMatch(lotto: Lotto): Int = lotto.matchingCount(winningNumbers)
    private fun matchBonus(lotto: Lotto): Boolean = lotto.numbers.contains(bonusNumber)
}
