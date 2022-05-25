package lotto

class Machine(private val purchasePrice: Int) {
    val lottoCount = purchasePrice / LOTTO_PRICE
    val lottoList = (1..lottoCount).toList().map { Lotto(Extractor.getAutoNumbers()) }

    var lottoResultList = emptyList<LottoResult>()
        private set

    private fun List<Lotto>.checkResult(winningValue: String): List<LottoResult> {
        return this.map { LottoResult(winningValue, it) }
    }

    fun run(winningValue: String) {
        lottoResultList = lottoList.checkResult(winningValue)
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
