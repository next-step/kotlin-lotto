package simulator.lotto

import java.util.*

data class Number(val values: SortedSet<Int>) {
    init {
        require(values.size == NUMBERS_COUNT) {
            "로또 번호는 ${NUMBERS_COUNT}개의 숫자로 구성되어야 합니다"
        }

        require(values.maxOf { it } <= MAX_NUMBER) {
            "로또 번호는 ${MAX_NUMBER}이하이어야 합니다"
        }

        require(values.minOf { it } >= MIN_NUMBER) {
            "로또 번호는 ${MIN_NUMBER}이상이어야 합니다"
        }
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val NUMBERS_COUNT = 6
    }
}
