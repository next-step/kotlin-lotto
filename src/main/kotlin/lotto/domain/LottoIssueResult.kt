package lotto.domain

data class LottoIssueResult(val manualLottos: List<Lotto>, val autoLottos: List<Lotto>) {

    fun countOfManual(): Int = manualLottos.size
    fun countOfAuto(): Int = autoLottos.size

    fun getAsLottos(): List<Lotto> {
        return manualLottos + autoLottos
    }

    fun driveStatistic(winLotto: WinLotto): Statistics {
        val lottos = getAsLottos()
        return Statistics.drive(lottos, winLotto)
    }

}