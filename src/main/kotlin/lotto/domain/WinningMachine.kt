package lotto.domain

class WinningMachine(private val winLotto: WinLotto) {

    fun match(lottoIssueResult: LottoIssueResult): Statistics {

        val lottos = lottoIssueResult.getAsLottos()
        val statistic = Statistics()

        for(lotto in lottos) {
            val rank = match(lotto)
            statistic.add(rank, lotto)
        }
        return statistic
    }

    private fun match(lotto: Lotto): Rank {
        return winLotto.correspondLottoResult(lotto)
    }

}