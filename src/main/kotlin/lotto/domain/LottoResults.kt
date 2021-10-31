package lotto.domain

@JvmInline
value class LottoResults(private val purchasedLottos: List<Lotto>) {

    fun result(winningNumber: List<Int>): List<LottoResult> =
        LottoPrize.toList().map { LottoResult(it, matchingToList(winningNumber)) }

    private fun matchingToList(winningNumber: List<Int>): List<Int> =
        purchasedLottos.map {
            it.toNumberList().intersect(winningNumber).count()
        }
}
