package lotto.domain

class WinningMachine(private val winLotto: WinLotto) {

    fun match(lottoIssueResult: LottoIssueResult): Statistics {
        return lottoIssueResult.resultStatistic(winLotto)
    }

}