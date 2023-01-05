package lotto.domain

class PublishLotto(val manualLottos: List<Lotto>, val autoLottos: List<Lotto>) {
    val allLotto: List<Lotto> = manualLottos + autoLottos

    fun getWinningResult(winningLotto: WinningLotto): WinningResult = WinningResult(allLotto, winningLotto)
}
