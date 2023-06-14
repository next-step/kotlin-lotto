package calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        return text.toInt()

        TODO("ch-Yoon : TDD를 위해 구현한 함수로, 현 시점에서는 무조건 에러를 발생 시킨다.")
    }
}
