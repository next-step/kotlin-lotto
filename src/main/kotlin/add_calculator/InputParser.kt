package add_calculator

class InputParser {

    fun parse(text: String?): List<String> {
        return text!!.split(",|:".toRegex())
    }
}
