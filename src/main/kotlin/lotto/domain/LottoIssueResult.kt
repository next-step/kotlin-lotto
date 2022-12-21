package lotto.domain

data class LottoIssueResult(val manualLottos: List<Lotto>, val autoLottos: List<Lotto>) {

    fun countOfManual(): Int = manualLottos.size
    fun countOfAuto(): Int = autoLottos.size

    fun getAsLottos(): List<Lotto> {
        return manualLottos + autoLottos
    }

    fun resultStatistic(winLotto: WinLotto): Statistics {
        val lottos = getAsLottos()
        val statistic = Statistics()

        for(lotto in lottos) {
            val rank = winLotto.correspondLottoResult(lotto)
            statistic.add(rank, lotto)
        }
        return statistic
    }

}