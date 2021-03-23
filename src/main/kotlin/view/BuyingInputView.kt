package view

object BuyingInputView {
    fun receiveAmount(directiveSentence: String): BuyingInput {
        printDirectiveSentence(directiveSentence)
        return BuyingInput(readLine()!!)
    }

    private fun printDirectiveSentence(sentence: String) {
        println(sentence)
    }
}
