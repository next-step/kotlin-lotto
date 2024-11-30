package lotto

import lotto.domain.*

fun main() {
    println("구입금액을 입력해 주세요.")
    val amount = ConsoleReader.readLine().trim().toIntOrNull()
    requireNotNull(amount) { "입력 금액은 숫자만 입력해야 합니다." }

    val lottos = LottoStore.buy(amount)
    println("${lottos.getPurchaseLottoCount()}개를 구매했습니다.")
    println(lottos)

    println("지난 주 당첨 번호를 입력해 주세요.")
    val numbers = ConsoleReader.readLine().split(",")
        .map { number -> number.trim().toIntOrNull() ?: throw IllegalArgumentException("당첨 번호는 숫자만 입력해야 합니다.") }
        .toSet()
    val winningLotto = WinningLotto(numbers)

    val lottoResults = LottoResultChecker.check(lottos, winningLotto)

    println("""
        당첨 통계
        ---------
    """.trimIndent())
    // 역순 정렬된 리스트
    val sortedLottoRanks = LottoRank.entries
        .sortedBy { lottoRank -> lottoRank.prizeAmount }

    // 당첨된 로또
    sortedLottoRanks.forEach { lottoRank ->
        val winningLottoCount = lottoResults.getWinningLottoCountBy(lottoRank)
        println("${lottoRank.matchCount}개 일치 (${lottoRank.prizeAmount}원) - ${winningLottoCount}개")
    }

    val profitRate = LottoProfitRateCalculator.calculate(lottos, lottoResults)
    println("총 수익률은 ${profitRate}입니다.")
}