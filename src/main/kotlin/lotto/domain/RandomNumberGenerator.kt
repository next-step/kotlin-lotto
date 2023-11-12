package lotto.domain

class RandomNumberGenerator : NumberGenerator {
    override fun generateNumbers(startNumber: Int, endNumber: Int, count: Int): Set<Int> {
        require(startNumber <= endNumber) { "시작 숫자(=${startNumber})는 종료 숫자(=${endNumber})보다 작거나 같아야 합니다" }
        require(count <= endNumber - startNumber + 1) { "개수(count)는 ${startNumber}~${endNumber} 사이에 존재하는 숫자의 개수보다 작거나 같아야 합니다" }
        return (startNumber..endNumber).shuffled().subList(0, count).toSet()
    }
}
