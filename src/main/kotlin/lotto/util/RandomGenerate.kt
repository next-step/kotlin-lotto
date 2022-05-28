package lotto.util

interface RandomGenerate {
    fun makeRandomUniqueIntList(listSize: Int, randomRange: IntRange): List<Int>
}
