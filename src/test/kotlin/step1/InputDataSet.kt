package step1

class InputDataSet {
    companion object {
        private val NUMBER_LIST = (0..25)

        fun testValidNumberDataList(): List<Int> = NUMBER_LIST.toList()

        fun testValidNumberPairDataList(): List<Pair<Int, Int>> =
            NUMBER_LIST.flatMap { left ->
                NUMBER_LIST.map { right ->
                    Pair(left, right)
                }
            }
    }
}
