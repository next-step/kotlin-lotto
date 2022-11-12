package step1

import io.kotest.core.Tuple3

class InputDataSet {
    companion object {
        private val NUMBER_LIST = (0..100)

        fun testValidNumberDataList(): List<Int> = NUMBER_LIST.toList()

        fun testValidNumberPairDataList(): List<Pair<Int, Int>> =
            NUMBER_LIST.flatMap { left ->
                NUMBER_LIST.map { right ->
                    Pair(left, right)
                }
            }

        fun testValidNumberTuple3DataList(): List<Tuple3<Int, Int, Int>> =
            NUMBER_LIST.flatMap { number ->
                testValidNumberPairDataList().map {
                    Tuple3(number, it.first, it.second)
                }
            }
    }
}
