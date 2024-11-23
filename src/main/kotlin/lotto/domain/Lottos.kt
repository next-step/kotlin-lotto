package lotto.domain

data class Lottos(
    val lottos: List<Lotto>,
) {
    val quantity: Int = lottos.size

    fun match(winningNumbers: Set<LottoNumber>): Results = Results(lottos.map { Result.of(it.match(winningNumbers)) })
}
