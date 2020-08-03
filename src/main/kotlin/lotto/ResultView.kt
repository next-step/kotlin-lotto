package lotto

const val LOTTO_PRINT_PREFIX = "["
const val LOTTO_PRINT_POSTFIX = "]"

class ResultView {
    fun printNumbers(lottoNumbers: List<LottoNumber>) {
        lottoNumbers.forEach {
            val numbers = it.numbers.joinToString(prefix = LOTTO_PRINT_PREFIX, postfix = LOTTO_PRINT_POSTFIX, separator = LOTTO_SPLIT_PATTERN)
            println(numbers)
        }
    }

    fun printPrizeStat(prizeMoneyWrappers: List<PrizeMoneyWrapper>) {
        println("당첨 통계")
        prizeMoneyWrappers.forEach {
            println("${it.prizeMoney.name}개 일치 (${it.prizeMoney.getPrizeMoney()}원) - ${it.prizeCount}개")
        }
    }

    fun printProfit(totalPrizeMoney: Int, buyMoney: Int) {
        println("총 수익률은 ${totalPrizeMoney / buyMoney} 입니다.")
    }
}
