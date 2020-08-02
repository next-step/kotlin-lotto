package lotto.domain

class LottoItems(count: Int) {
    private val lottos: List<Lotto> = List(count) { Lotto() }

    fun getLottoItems() = lottos

    override fun toString() = "LottoItems(items=${lottos.joinToString()})"

    fun getWinLottos(winningNumbers: List<LottoNumber>): List<WinLotto> {
        lottos.forEach {
            val a = it.getWinCount(winningNumbers)
            WinLotto.plusCount(a)
        }
        return WinLotto.resultList()
    }
}
