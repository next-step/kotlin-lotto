package lotto.model

fun interface LottoGeneratingStrategy {
    fun generateLottos(count: Int): Lottos
}
