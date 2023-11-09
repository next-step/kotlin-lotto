package lotto

class RandomNumberGenerator : NumberGenerator {
    override fun generateNumber(startNumber: Int, endNumber: Int, count: Int): Set<Int> {
        require(startNumber <= endNumber) { "시작 숫자(=${startNumber})는 종료 숫자(=${endNumber})보다 작거나 같아야 합니다" }
        return (startNumber..endNumber).shuffled().subList(0, count).toSet()
    }
}
