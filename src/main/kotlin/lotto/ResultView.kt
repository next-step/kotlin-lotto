package lotto

const val LOTTO_PRINT_PREFIX = "["
const val LOTTO_PRINT_POSTFIX = "]"

object ResultView {
    fun printNumbers(lottoes: List<Lotto>) {
        lottoes.forEach {
            val numbers = it.numbers
                .sorted()
                .joinToString(prefix = LOTTO_PRINT_PREFIX, postfix = LOTTO_PRINT_POSTFIX, separator = LOTTO_SPLIT_PATTERN)
            println(numbers)
        }
    }

    fun printPrizeStat(prizeMoneyWrappers: List<Pair<PrizeMoney, Int>>) {
        println("당첨 통계")
        prizeMoneyWrappers.forEach {
            println("${it.first.equalsCount}개 일치 (${it.first.money}원) - ${it.second}개")
        }
    }

    fun printProfit(rateProfit: Double) {
        println(String.format("총 수익률은 %.2f 입니다.", rateProfit))
    }
}
