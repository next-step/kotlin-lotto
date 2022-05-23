object LottoInputHandler {

    fun getNumbers(): List<Int> {
        displayInputMessage()

        val expression = Expression()
        return expression.getTokens(readln())
    }

    private fun displayInputMessage() {
        println(STANDARD_INPUT_MESSAGE)
        println(CUSTOM_SPLITTER_INPUT_MESSAGE)
    }

    const val STANDARD_INPUT_MESSAGE = "더할 숫자를 입력하세요. (구분자 : , or :)"
    const val CUSTOM_SPLITTER_INPUT_MESSAGE = "커스텀하게 구분자를 사용하고 싶은 경우, \"//\"와 \"\\n\" 문자 사이에 커스텀 구분자를 지정할 수 있습니다. ex) //;\\n1;2;3"
}
