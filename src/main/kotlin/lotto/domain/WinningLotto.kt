package lotto.domain

class WinningLotto(private val winningNumbers: Lotto, private val bonusNumber: LottoNumber) {

    init {
        require(!winningNumbers.contains(bonusNumber)) { "보너스 볼은 당첨 번호랑 같을 수 없습니다." }
    }

    fun getMatchResult(lottos: Lottos): Map<Rank, Int> {
        val countOfMatchRank = getCountOfMatchRank(lottos)
        return Rank.values()
            .associateWith { countOfMatchRank[it] ?: 0 }
    }

    private fun getCountOfMatchRank(lottos: Lottos): Map<Rank, Int> {
        return lottos.lottoList.groupingBy { Rank.valueOf(getCountOfMatch(it), matchBonus(it)) }.eachCount()
    }

    private fun getCountOfMatch(lotto: Lotto): Int = lotto.matchingCount(winningNumbers)
    private fun matchBonus(lotto: Lotto): Boolean = lotto.contains(bonusNumber)
}
