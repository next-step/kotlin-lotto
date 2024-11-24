package lotto

data class Lotto(
    val numbers: List<Int>,
) {
    init {
        require(numbers.size == 6) { "로또 번호는 6개여야 합니다." }
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