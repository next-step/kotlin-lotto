package lotto.model.data

data class Lotto private constructor(val numbers: Set<LottoNumber>) {

    companion object {

        fun LottoNumbers.parseToLotto(policy: Policy): ParseResult<Lotto> =
            when (val error = policy.validateNumbers(this)) {
                null -> ParseResult.Value(Lotto(this.sorted().toSet()))
                else -> ParseResult.Error(error)
            }

        fun CommaSeparatedInt.parseToLotto(policy: Policy): ParseResult<Lotto> =
            when (val error = this.firstError) {
                null -> this.toLottoNumbers().parseToLotto(policy)
                else -> ParseResult.Error(error)
            }
    }
}

data class Lottos(val lottoList: List<Lotto> = listOf()) : List<Lotto> by lottoList {

    operator fun plus(other: Lottos) = Lottos(
        listOf(this.lottoList, other.lottoList).flatten()
    )

    companion object {
        fun of(vararg lottos: Lotto) = Lottos(lottos.toList())
    }
}

inline fun Lottos(count: Int = 1, init: (Int) -> Lotto) = Lottos(List(count, init))
