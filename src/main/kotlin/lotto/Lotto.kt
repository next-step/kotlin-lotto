package lotto

class Lotto(
    numbers: List<Int>,
) {
    val numbers: List<LottoNumber>

    init {
        require(numbers.size == 6) { "로또 번호는 6개여야 합니다." }
        require(setOf(*numbers.toTypedArray()).size == 6) { "중복된 로또 번호가 존재합니다." }
        this.numbers = numbers.map { LottoNumber(it) }
    }

    companion object Factory {
        fun auto(): Lotto {
            val numbers = (1..45)
                .shuffled()
                .take(6)
                .sorted()
            return Lotto(numbers)
        }
    }
}
