class StringAddCalculator(private val inputData: String) {

    fun splitInput(): List<Int> {
        return inputData.split("[,:]".toRegex()).map {
            it.toInt()
        }
    }
}
