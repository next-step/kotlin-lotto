package calculator

import java.lang.RuntimeException

@JvmInline
value class Operand(
    private val number: Int
) {
    operator fun plus(other: Operand) = Operand(this.number + other.number)
    operator fun compareTo(other: Operand): Int =
        when {
            this.number == other.number -> 0
            this.number > other.number -> 1
            else -> -1
        }

    companion object {
        val ZERO = Operand(0)

        fun valueOf(content: String): Operand {
            val number = runCatching { content.toInt() }
                .onFailure { throw RuntimeException("${it.message} 정수와 구분자만 입력하여 주세요.") }
                .getOrThrow()
            return Operand(number)
        }
    }
}
