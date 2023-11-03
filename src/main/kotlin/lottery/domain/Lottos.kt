package lottery.domain

data class Lottos(
    val lottos: List<Lotto>
) {
    companion object {
        fun of(quantity: Int, numberGenerator: LottoNumberGenerator): Lottos {
            return Lottos(
                List(quantity) {
                    Lotto(numberGenerator.getNumbers())
                }
            )
        }
    }
}
