package lotto.domain

interface NumberGenerator {
    fun generateNumber(startNumber: Int, endNumber: Int, count: Int): Set<Int>
}
