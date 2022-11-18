package calculator.domain

object StringConvert {

    fun toInt(input: String): Int {
        val result = input.toInt()
        if (result < 0) {
            throw RuntimeException("음수는 입력할 수 없습니다.")
        }
        return result
    }
}
