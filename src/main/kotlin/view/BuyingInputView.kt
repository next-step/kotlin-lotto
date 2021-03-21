package view

class BuyingInputView {
    fun receiveAmount(directiveSentence: String): BuyingInput {
        printDirectiveSentence(directiveSentence)
        return BuyingInput(readAmount())
    }

    private fun printDirectiveSentence(sentence: String) {
        println(sentence)
    }

    private fun readAmount(): Int {
        return readLine()!!.toInt()
    }
}
