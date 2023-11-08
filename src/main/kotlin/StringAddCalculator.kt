class StringAddCalculator(private val inputData: String?) {

    fun splitInput(): List<String> {
        if (inputData == null) {
            return listOf("0")
        }
        return inputData.split("[,:]".toRegex()).filter { it.isNotBlank() }
    }

    fun addString(splitString: List<String>): Int {
        var result = 0
        splitString.forEach { result += it.toInt() }
        return result
    }
}
