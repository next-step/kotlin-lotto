package domain

class LottoInput(
    val totalPrice: Int? = 0,
    val winningLotto: List<Int>? = listOf()
) {
    fun of(lottoInput: LottoInput): LottoInput {
        return LottoInput(
            totalPrice = lottoInput.totalPrice ?: this.totalPrice,
            winningLotto = lottoInput.winningLotto ?: this.winningLotto
            )
    }
}