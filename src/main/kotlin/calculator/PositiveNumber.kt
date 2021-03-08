package calculator

import java.lang.RuntimeException

data class PositiveNumber(private val value: Int) {

    fun sum(positiveNumber: PositiveNumber): PositiveNumber {
        return this.copy(value = this.value + positiveNumber.value)
    }

    companion object {
        val ZERO = ofString("0")

        fun ofString(value: String): PositiveNumber {
            val positiveNumber = value.toIntOrNull() ?: throw RuntimeException("$value 숫자 이외의 값은 계산 불가능합니다.")
            if (positiveNumber < 0) {
                throw RuntimeException("$value 음수는 생성 불가능 합니다.")
            }

            return PositiveNumber(positiveNumber)
        }

    }
}