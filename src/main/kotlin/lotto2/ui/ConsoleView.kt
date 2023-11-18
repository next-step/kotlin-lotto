package lotto2.ui

import lotto2.domain.LottoRanking
import lotto2.domain.LottoTickets

object ConsoleView {

    object Input {
        private const val PURCHASE_AMOUNT_PROMPT = "구입 금액을 입력해 주세요."
        private const val RECENT_LOTTO_WINNING_NUMBERS_PROMPT = "지난 주 당첨 번호를 입력해 주세요."
        private const val RECENT_LOTTO_BONUS_NUMBER_PROMPT = "보너스 볼을 입력해 주세요."

        fun printPurchaseAmountPrompt() {
            println(PURCHASE_AMOUNT_PROMPT)
        }

        fun getUserInput(): String {
            return readln()
        }

        fun getPurchaseAmount(): Int {
            val purchaseAmount = getUserInput().toIntOrNull()
                ?: throw IllegalArgumentException("구입 금액은 숫자로 입력해주세요.")

            LottoInputValidation.validatePurchaseAmount(purchaseAmount)

            return purchaseAmount
        }

        fun printWinningNumbersPrompt() {
            println(RECENT_LOTTO_WINNING_NUMBERS_PROMPT)
        }

        fun getLottoWinningNumbers(): List<Int> {
            return getUserInput().split(",")
                .map { it.trim().toInt() }.sorted()
        }

        fun printBonusNumbersPrompt() {
            println(RECENT_LOTTO_BONUS_NUMBER_PROMPT)
        }

        fun getLottoBonusNumber(): Int {
            return getUserInput().toIntOrNull()
                ?: throw IllegalArgumentException("보너스 볼은 숫자로 입력해주세요.")
        }
    }

    object Output {
        fun printLottoGameResults(lottoTickets: LottoTickets) {
            println("${lottoTickets.size()}개를 구매했습니다.")

            val lottoNumbers = lottoTickets.getAllLottoNumbers()
            lottoNumbers.forEach { println(it) }
        }

        fun printWinningStatistics(winningStatistics: Map<LottoRanking, Int>) {
            println("\n당첨 통계\n---------")

            winningStatistics.filter { it.key != LottoRanking.MISS }
                .forEach {
                    println("${it.key.matchingCount}개 일치 (${it.key.prize}원)- ${it.value}개")
                }
        }

        fun printProfitRate(profitRate: Double) {
            print("\n총 수익률은 ${String.format("%.2f", profitRate)}입니다.")

            if (profitRate < 1) {
                println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
            }
        }
    }
}
