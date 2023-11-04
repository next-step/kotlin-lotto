package calcuator

import java.lang.IllegalArgumentException

@JvmInline
value class AddOperand private constructor(
    val value: Int
) {
    companion object {
        private const val MIN_VALUE = 0
        fun of(stringNumber: String): AddOperand =
            stringNumber
                .toIntOrNull()
                ?.takeIf { it >= MIN_VALUE }
                ?.let { AddOperand(it) }
                ?: throw IllegalArgumentException("피연산자는 양수여야 합니다")
    }
}
