package lotto

class Machine(private val purchasePrice: Int) {
    val lottoCount = purchasePrice / LOTTO_PRICE
    val lottoList = (1..lottoCount).toList().map { Lotto(Extractor.getAutoNumbers()) }

    var lottoResultList = emptyList<LottoResult>()
        private set

    fun checkResult(winningValue: String) {
        lottoResultList = lottoList.map { LottoResult(winningValue, it) }
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
