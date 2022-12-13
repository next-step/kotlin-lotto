package lotto.domain

data class LottoIssueResult(val manualLottos: List<Lotto>, val autoLottos: List<Lotto>) {

    fun manualCount(): Int = manualLottos.size
    fun autoCount(): Int = autoLottos.size

    fun getAsLottos(): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        lottos.addAll(manualLottos)
        lottos.addAll(autoLottos)
        return lottos.toList()
    }
}