package lotto.step4.domain

class Lotto private constructor(
    val numbers: List<LottoNumber>,
) {
    init {
        require(numbers.distinct().size == 6) { "로또 번호는 6개여야 합니다. [numbers=${this.numbers}]" }
    }

    companion object {
        fun of(numbers: List<LottoNumber>): Lotto {
            return Lotto(numbers = numbers)
        }
    }
}
