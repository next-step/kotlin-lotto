package lotto

import lotto.client.LottoClient
import lotto.statistics.WinningStatistics

fun main() {
    val lottoClient = LottoClient(Generator(), WinningStatistics())
    lottoClient.run()
}
