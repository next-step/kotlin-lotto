package lotto

import lotto.model.Lotto
import lotto.service.LottoTicketCountCalculator


fun main() {
    println("구매 금액을 입력해주세요.")
    val purchaseAmount = readLine()!!.toInt()
    val ticketCount = LottoTicketCountCalculator.getCount(purchaseAmount)
    println("$ticketCount 개를 구매했습니다.")

    val winningLottos: MutableList<Lotto> = mutableListOf()
    repeat(ticketCount) {
        val winningLotto = Lotto()
        winningLottos.add(winningLotto)
        println(winningLotto.winningNumber.toString())
    }

    println("지난 주 당첨 번호를 입력해 주세요.")
    val lastWeekWinningString = readLine()
    val lastWeekWinningNumbers: List<Int> = lastWeekWinningString?.split(",")?.map { it.trim().toInt() } ?: emptyList()

    winningLottos.forEach { it.setLottoPrize(lastWeekWinningNumbers) }

    val winningRatio = getWinningRatio(purchaseAmount, winningLottos)

    println("당첨 통계")
    println("---------")

    println("3개 일치 (5000원)- ${staticPrize(winningLottos, 5000)}")
    println("4개 일치 (50000원)- ${staticPrize(winningLottos, 50000)}")
    println("5개 일치 (1500000원)- ${staticPrize(winningLottos, 1500000)}")
    println("6개 일치 (2000000000원)-${staticPrize(winningLottos, 2000000000)}")

    println()
    println(
        "총 수익률은 ${
            String.format(
                "%.2f", winningRatio
            )
        } 입니다.(기준이 1이기 때문에 결과적으로 ${if (winningRatio >= 1) "이득" else "손해"}라는 의미임)"
    )
}

fun getWinningRatio(
    purchaseAmount: Int, winningLottos: List<Lotto>): Double {
    return getTotalWinningPrize(winningLottos) / purchaseAmount.toDouble()
}

private fun getTotalWinningPrize(winningLottos: List<Lotto>): Long =
    winningLottos.sumOf { it.lottoPrize.prizeAmount }

fun staticPrize(winningLottos: List<Lotto>, prize: Long): Int =
    winningLottos.count { it.lottoPrize.prizeAmount == prize }

