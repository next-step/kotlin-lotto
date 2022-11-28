package calculator.view

object InputView {
    fun input(): String {
        println("값을 입력해주세요.")
        val text: String? = readlnOrNull()
        requireNotNull(text) {
            "입력값은 빈 문자열이거나 null일 수 없어요."
        }
        return text
    }
}
