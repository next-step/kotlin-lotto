package lotto

const val LOTTO_PRINT_PREFIX = "["
const val LOTTO_PRINT_POSTFIX = "]"

object ResultView {
    fun printNumbers(lottos: List<Lotto>) {
        lottos.forEach {
            val numbers = it.numbers.joinToString(prefix = LOTTO_PRINT_PREFIX, postfix = LOTTO_PRINT_POSTFIX, separator = LOTTO_SPLIT_PATTERN)
            println(numbers)
        }
    }

    fun printPrizeStat(prizeMoneyWrappers: List<PrizeMoneyWrapper>) {
        println("당첨 통계")
        prizeMoneyWrappers.forEach {
            println("${it.prizeMoney.getEqualsCount()}개 일치 (${it.prizeMoney.getPrizeMoney()}원) - ${it.prizeCount}개")
        }
    }

    fun printProfit(rateProfit: Double) {
        println(String.format("총 수익률은 %.2f 입니다.", rateProfit))
    }
}
