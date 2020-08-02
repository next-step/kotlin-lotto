package stringcalculator.view

class InputView(val input: () -> String? = { readLine() }) {
    companion object {
        private const val INPUT = "문자열을 입력하세요"
    }

    private fun showQuestion(question: String): String {
        println(question)
        return input() ?: ""
    }

    fun getInput() = showQuestion(INPUT)
}
