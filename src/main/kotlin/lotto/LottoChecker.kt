package lotto

class LottoChecker {

    fun lottoCheck(winningNumber: String, lottoBundle: List<List<Int>>): List<Int> {

        val numbers = winningNumber.replace("\\s".toRegex(), "").split(",").map { it.toInt() }

        lottoInputNumberValidation(numbers)

        val result = mutableListOf<Int>()
        lottoBundle.forEach { lotto ->
            var count = 0
            lotto.forEach { number ->
                if (numbers.contains(number)) {
                    count++
                }
            }
            result.add(count)
        }
        return result.toList()
    }

    private fun lottoInputNumberValidation(numbers: List<Int>) {
        require(numbers.size == COLLECT_LOTTO_SIZE) { "로또 입력 숫자는 총 6개여야 합니다" }
    }

    fun winningMoneyCheck(collectCounts: List<Int>): Int {
        var winningMoney = 0
        collectCounts.forEach { count ->
            winningMoney += LottoEnum.values().find { it.count == count }?.prizeMoney ?: NONE_PRIZE_MONEY
        }
        return winningMoney
    }

    fun lottoResultGroup(collectCounts: List<Int>): Map<Int, Int> {
        return collectCounts.sorted().groupingBy { it }.eachCount()
    }

    companion object {
        private const val NONE_PRIZE_MONEY = 0
        private const val COLLECT_LOTTO_SIZE = 6
    }
}
