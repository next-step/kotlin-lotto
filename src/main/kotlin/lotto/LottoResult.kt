package lotto

class LottoResult(
    private val winningNums: List<Int>,
    private val lottos: List<Lotto>
) {
    private val countMap = mutableMapOf<Int, Int>()
    private var rateOfReturn: Double = 0.0
    private val winningMoney = mapOf(
        FIRST_COUNT to FIRST_PRIZE,
        SECOND_COUNT to SECOND_PRIZE,
        THIRD_COUNT to THIRD_PRIZE,
        FOURTH_COUNT to FOURTH_PRIZE,
    )

    init {
        lottos.forEach {
            val num = it.numOfMatch(winningNums)
            countMap[num] = countMap.getOrDefault(num, 0) + 1
        }
        val profit = winningMoney.keys.sumOf { rank ->
            val prize = winningMoney[rank] ?: NO_PRIZE
            val count = countMap[rank] ?: 0
            prize * count
        }
        rateOfReturn = profit.toDouble() / (lottos.size * Lotto.PRICE)
    }

    override fun toString(): String {
        var result = ""
        winningMoney.keys.sorted().forEach {
            val money = winningMoney[it]
            val count = countMap.getOrDefault(it, 0)
            result += "$it" + "개 일치 ($money" + "원)- $count" + "개\n"
        }
        result += "총 수익률은 ${String.format("%.2f", rateOfReturn)}" + "입니다."
        result += if (rateOfReturn < 1) LOSS else GAIN
        return result
    }

    companion object {
        private const val FIRST_COUNT = 6
        private const val SECOND_COUNT = 5
        private const val THIRD_COUNT = 4
        private const val FOURTH_COUNT = 3
        private const val FIRST_PRIZE = 2000000000
        private const val SECOND_PRIZE = 1500000
        private const val THIRD_PRIZE = 50000
        private const val FOURTH_PRIZE = 5000
        private const val NO_PRIZE = 0
        private const val LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        private const val GAIN = "(기준이 1이기 때문에 결과적으로 이득이는 의미임)"
    }
}