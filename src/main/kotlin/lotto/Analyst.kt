package lotto

class Analyst(private val lastWeekWinningNumbers: List<Int>) {
    lateinit var result: Map<String, Any>

    fun analyze(purchaseAmount: Int, lottos: List<List<Int>>) {


        var res = mutableListOf<Int>()

        lottos.forEach {
            val numberOfCorrect = it
                .mapIndexed { index, value -> lastWeekWinningNumbers[index] == value }
                .count{ value -> value }

            res.add(numberOfCorrect)
        }

        val winningAmount =
            FOURTH_PRIZE_PRICE * res.count{ value -> value == 3 } +
            THIRD_PRIZE_PRICE * res.count{ value -> value == 4 } +
            SECOND_PRIZE_PRICE * res.count{ value -> value == 5 } +
            FIRST_PRIZE_PRICE * res.count{ value -> value == 6 }

        result = mutableMapOf(
            "3" to listOf(FOURTH_PRIZE_PRICE, res.count{ value -> value == 3 }),
            "4" to listOf(THIRD_PRIZE_PRICE, res.count{ value -> value == 4 }),
            "5" to listOf(SECOND_PRIZE_PRICE, res.count{ value -> value == 5 }),
            "6" to listOf(FIRST_PRIZE_PRICE, res.count{ value -> value == 6 }),
            "bf" to String.format("%.2f", winningAmount / purchaseAmount.toDouble()),
        )
    }

    companion object {
        private const val FOURTH_PRIZE_PRICE = 5000
        private const val THIRD_PRIZE_PRICE = 50000
        private const val SECOND_PRIZE_PRICE = 1500000
        private const val FIRST_PRIZE_PRICE = 2000000000
    }
}

