package lotto

interface NumberGenerator {
    fun generateNumber(startNumber: Int, endNumber: Int, count: Int): Set<Int>
}
