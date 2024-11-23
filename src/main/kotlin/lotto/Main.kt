package lotto

import lotto.client.LottoClient
import lotto.statistics.WinningStatistics

fun main() {
    val lottoClient = LottoClient(LottoMachine(), WinningStatistics())
    lottoClient.run()
}
