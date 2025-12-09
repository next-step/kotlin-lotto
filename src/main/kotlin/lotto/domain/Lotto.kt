package lotto.domain

@JvmInline
value class Lotto(val numbers: List<LottoNumber>) {
    init {
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT) {
            "다른 숫자 6개가 아니면 안됩니다."
        }
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6

        fun createRandom(): Lotto {
            return Lotto(
                (LottoNumber.MINIMUM..LottoNumber.MAXIMUM)
                    .toList()
                    .shuffled()
                    .take(LOTTO_NUMBER_COUNT)
                    .map { LottoNumber(it) },
            )
        }
    }

    fun print() {
        val numberList = numbers.map { it.number }.sorted()
        println(numberList.joinToString(", ", "[", "]"))
    }
}
