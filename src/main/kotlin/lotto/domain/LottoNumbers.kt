package lotto.domain

@JvmInline
value class LottoNumbers(private val numbers: List<Int> = CandidateNumbers.pick()) {
    val value: List<Int>
        get() = numbers
}
