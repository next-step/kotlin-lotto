package step2Lotto.domain

data class Lotto(
    val numbers: List<LottoNumber>
) {
    constructor(numbers: Array<Int>) : this(numbers.map { LottoNumber(it) })

    fun getLottoNumbers(): List<Int> {
        return numbers.map { it.value }
    }
}
