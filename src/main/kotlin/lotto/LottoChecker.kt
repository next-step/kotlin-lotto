package lotto

class LottoChecker {

    fun lottoCheck(winningNumber: String, lottoBundle: List<List<Int>>): List<Int> {

        val numberList = winningNumber.replace("\\s".toRegex(), "").split(",").map { it.toInt() }

        val result = mutableListOf<Int>()
        lottoBundle.forEach { lotto ->
            var count = 0
            lotto.forEach { number ->
                if (numberList.contains(number)) {
                    count++
                }
            }
            result.add(count)
        }
        return result.toList()
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
    }
}
