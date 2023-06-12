package lotto

import lotto.config.LottoConfig

fun main() {
    val lottoController = LottoConfig.lottoController

    lottoController.issueAndGetWinningStatistics()
}
