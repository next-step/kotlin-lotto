package adder.view

private const val QUESTION_FOR_DEFAULT = "덧셈할 문자열을 쉼표(,) 또는 콜론(;)으로 구분하여 입력하세요. "
private const val EXPLANATION_FOR_CUSTOM = "사용자 지정 구분자를 사용하려면 문자열 가장 앞부분에 //와 \\n 사이에 해당 구분자를 입력 후 사용하세요"

object InputView {
    fun printQuestion() {
        println(buildQuestion())
    }

    private fun buildQuestion(): String {
        return "$QUESTION_FOR_DEFAULT$EXPLANATION_FOR_CUSTOM"
    }
}
