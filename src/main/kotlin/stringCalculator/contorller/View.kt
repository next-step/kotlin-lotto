package stringCalculator.contorller

interface View {
    fun getFormula(): String?

    fun showAnswer(answer: Int)

    fun showErrorMessage(message: String)
}
