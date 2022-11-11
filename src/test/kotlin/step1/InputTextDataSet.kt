package step1

class InputTextDataSet {
    companion object {
        private val NUMBER_LIST = (0..25)

        fun testValidNumberDataList(): List<Int> = NUMBER_LIST.toList()

        fun testValidSingleDataList(): List<String> = (NUMBER_LIST.map { it.toString() })

        fun testValidSingleDataListWithNullOrBlank(): List<String?> =
            (NUMBER_LIST.map { it.toString() }) + listOf("", null)

        fun testValidDataList(): List<String> = testValidSingleDataList().flatMap { left ->
            testValidSingleDataList().map { right ->
                "$left${StringAddCalculator.DEFAULT_DELIMITER}$right"
            }
        }
    }
}
