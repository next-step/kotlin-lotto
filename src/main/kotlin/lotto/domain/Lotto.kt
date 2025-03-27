package lotto.domain

class Lotto(
    private val numbers: List<LottoNumber>,
) {
    companion object {
        fun fromRawNumbers(numbers: List<Int>): Lotto {
            return Lotto(
                numbers.map { LottoNumber(it) }
            )
        }
    }
}
