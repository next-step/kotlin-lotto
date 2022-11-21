package lotto.domain

@JvmInline
value class LottoNumber(private val numbers: List<Int> = CandidateNumbers.pick()) {
    val value: List<Int>
        get() = numbers
}
