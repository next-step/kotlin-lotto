package stringcalculator

class ResultView(private val outputMessage: String? = "") {
    fun render() {
        println(outputMessage)
    }
}
