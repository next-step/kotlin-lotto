package lotto

class RandomNumberGenerator : NumberGenerator {
    override fun generateNumber(startNumber: Int, endNumber: Int, count: Int): Set<Int> =
        (startNumber..endNumber).shuffled().subList(0, count).toSet()
}
