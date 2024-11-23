package lotto

data class Lotto(val values: Set<Int>) {
    init {
        require(values.size == LOTTO_SIZE) { "로또는 ${LOTTO_SIZE}개의 숫자로 이루어져야 합니다. 입력값: $values" }
        require(
            values.all {
                it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER
            },
        ) { "로또는 ${LOTTO_MIN_NUMBER}-${LOTTO_MAX_NUMBER} 범위의 숫자로 이루어져야 합니다. 입력값: $values" }
    }

    fun match(other: Lotto): Int {
        return values.intersect(other.values).size
    }

    companion object {
        const val LOTTO_SIZE = 6
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45

        fun from(listOf: List<Int>): Lotto {
            return Lotto(listOf.toSet())
        }
    }
}
