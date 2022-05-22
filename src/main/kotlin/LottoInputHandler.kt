import Constants.CUSTOM_SPLITTER_INPUT_MESSAGE
import Constants.STANDARD_INPUT_MESSAGE

object LottoInputHandler {

    fun display(): List<Int> {
        displayInputMessage()

        val expression = Expression()
        return expression.getTokens(readln())
    }

    private fun displayInputMessage() {
        println(STANDARD_INPUT_MESSAGE)
        println(CUSTOM_SPLITTER_INPUT_MESSAGE)
    }
}
