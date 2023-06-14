package lotto.domain

@JvmInline
value class LottoMatchResult(private val countOfMatch: Int) {

    override fun toString(): String = countOfMatch.toString()
}
