package string_calculator

class ResultView(private val outputMessage: String? = "") {
    fun render() {
        println(outputMessage)
    }
}
