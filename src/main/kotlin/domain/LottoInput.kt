package domain

class LottoInput(
    val purchaseCount: Int? = 0,
    val purchaseAmount: Int? = 0,
    val winningLotto: List<Int>? = listOf()
) {
    fun of(lottoInput: LottoInput): LottoInput {
        return LottoInput(
            purchaseCount = lottoInput.purchaseCount ?: this.purchaseCount,
            purchaseAmount = lottoInput.purchaseAmount ?: this.purchaseAmount,
            winningLotto = lottoInput.winningLotto ?: this.winningLotto
            )
    }
}