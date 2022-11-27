package calculator

import java.lang.RuntimeException

class Number(value: Int) {
    init {
        if (value < 0) {
            throw RuntimeException("음수는 사용할 수 없습니다.")
        }
    }
}
