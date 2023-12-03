package lotto2.ui

import lotto2.domain.LottoMoney
import lotto2.domain.LottoNumber
import lotto2.domain.LottoNumbers
import lotto2.domain.LottoRanking
import lotto2.domain.LottoTicket

object ConsoleView {

    object Input {
        private const val PURCHASE_AMOUNT_PROMPT = "구입 금액을 입력해 주세요."
        private const val RECENT_LOTTO_WINNING_NUMBERS_PROMPT = "지난 주 당첨 번호를 입력해 주세요."
        private const val LOTTO_WINNING_NUMBERS_DELIMITERS = ","
        private const val RECENT_LOTTO_BONUS_NUMBER_PROMPT = "보너스 볼을 입력해 주세요."
        private const val MANUAL_TICKET_QUANTITY_PROMPT = "수동으로 구매할 로또 수를 입력해 주세요."
        private const val MANUAL_TICKET_NUMBERS_PROMPT = "수동으로 구매할 번호를 입력해 주세요."
        private const val MANUAL_TICKET_NUMBERS_DELIMITERS = ","

        fun printPurchaseAmountPrompt() {
            println(PURCHASE_AMOUNT_PROMPT)
        }

        fun getUserInput(): String {
            return readln()
        }

        fun getPurchaseAmount(): LottoMoney {
            val purchaseAmount = getUserInput().toIntOrNull()
                ?: throw IllegalArgumentException("구입 금액은 숫자로 입력해주세요.")

            LottoInputValidation.validatePurchaseAmount(purchaseAmount)

            return LottoMoney(purchaseAmount)
        }

        fun printManualTicketQuantityPrompt() {
            println(MANUAL_TICKET_QUANTITY_PROMPT)
        }

        fun getManualTicketQuantity(): Int {
            val manualTicketQuantity = getUserInput().toIntOrNull()
                ?: throw IllegalArgumentException("수동으로 구매할 로또 수는 숫자로 입력해주세요.")

            LottoInputValidation.validateManualTicketQuantity(manualTicketQuantity)

            return manualTicketQuantity
        }

        fun printManualTicketNumbersPrompt() {
            println(MANUAL_TICKET_NUMBERS_PROMPT)
        }

        fun getManualTicketNumbers(manualTicketQuantity: Int): List<LottoNumbers> {
            return List(manualTicketQuantity) {
                LottoNumbers(
                    getUserInput().split(MANUAL_TICKET_NUMBERS_DELIMITERS)
                        .map { it.trim().toInt() }
                        .map { LottoNumber(it) }
                )
            }
        }

        fun printWinningNumbersPrompt() {
            println(RECENT_LOTTO_WINNING_NUMBERS_PROMPT)
        }

        fun getLottoWinningNumbers(): List<LottoNumber> {
            val userInput = getUserInput()
            return userInput.split(LOTTO_WINNING_NUMBERS_DELIMITERS)
                .map { LottoNumber(it.trim().toInt()) }
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
        fun printLottoGameResults(lottoTickets: List<LottoTicket>) {
            println("${lottoTickets.size}개를 구매했습니다.")

            lottoTickets.forEach { println(it.numbers) }
        }

        fun printWinningStatistics(winningStatistics: Map<LottoRanking, Int>) {
            println("\n당첨 통계\n---------")

            winningStatistics.filter { it.key != LottoRanking.MISS }
                .forEach { (ranking, count) ->
                    val resultDescription = when (ranking) {
                        LottoRanking.SECOND -> "5개 일치, 보너스 볼 일치(${ranking.prize}원)"
                        else -> "${ranking.matchingCount}개 일치 (${ranking.prize}원)"
                    }

                    println("$resultDescription- ${count}개")
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
