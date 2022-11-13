package step1

import java.lang.RuntimeException

data class Positive(
    val value: Int
) {
    init {
        if (value < 0) throw RuntimeException("계산식에 음수를 입력할 수 없습니다. 입력값 : $value")
    }

    operator fun plus(addValue: Positive): Positive {
        return Positive(value + addValue.value)
    }

    companion object {
        fun of(value: String): Positive {
            return Positive(value.toIntOrNull() ?: throw RuntimeException("계산식에 숫자 이외의 값을 입력할 수 없습니다. 입력값 : $value"))
        }
    }
}
