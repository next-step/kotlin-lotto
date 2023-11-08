package lotto.view

import lotto.domain.LottoResult
import lotto.domain.LottoStorage

object OutputView {

    private const val BUYING_MESSAGE_FORMAT = "%s개를 구매했습니다. 거스름돈은 %d원입니다."
    private const val LOTTO_FORMAT = "[%s]"
    private const val WINNING_STATISTICS_MESSAGE_FORMAT = """
        당첨 통계
        ---------
        3개 일치 (5000원)- %d개
        4개 일치 (50000원)- %d개
        5개 일치 (1500000원)- %d개
        6개 일치 (2000000000원)- %d개
    """

    fun printLottos(lottoStorage: LottoStorage, change: Int) {
        val lottoCount = lottoStorage.getLottoCount()
        println(String.format(BUYING_MESSAGE_FORMAT, lottoCount, change))
        lottoStorage.lottos.forEach {
            val lottoNumbers = it.numbers.joinToString(", ")
            println(String.format(LOTTO_FORMAT, lottoNumbers))
        }
    }

    fun printLottoStatistics(lottoResult: LottoResult) {
        println(
            String.format(System.lineSeparator() + WINNING_STATISTICS_MESSAGE_FORMAT.trimIndent(),
            lottoResult.result[LottoResult.LottoMatchCount.THREE],
            lottoResult.result[LottoResult.LottoMatchCount.FOUR],
            lottoResult.result[LottoResult.LottoMatchCount.FIVE],
            lottoResult.result[LottoResult.LottoMatchCount.SIX])
        )
    }
}
