package step1

import java.lang.RuntimeException

class PositiveInt(
    val value: Int
) {
    init {
        if (value < 0) throw RuntimeException("계산식에 음수를 입력할 수 없습니다. 입력값 : $value")
    }

    operator fun plus(addValue: PositiveInt): PositiveInt {
        return PositiveInt(value + addValue.value)
    }

    companion object {
        fun of(value: String): PositiveInt {
            return PositiveInt(value.toIntOrNull() ?: throw RuntimeException("계산식에 숫자 이외의 값을 입력할 수 없습니다. 입력값 : $value"))
        }
    }
}
