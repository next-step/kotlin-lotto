package lotto.step3.domain

class Lotto private constructor(
    val numbers: List<Int>,
) {
    init {
        require(numbers.distinct().size == 6) { "로또 번호는 6개여야 합니다. [numbers=${this.numbers}]" }
    }

    companion object {
        fun of(numbers: List<Int>): Lotto {
            return Lotto(numbers = numbers)
        }
    }
}
