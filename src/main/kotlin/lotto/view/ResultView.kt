package lotto.view

import lotto.domain.LottoTickets

object ResultView {
    fun showLottoInfo(lottoTickets: LottoTickets) {
        val lottoCount = lottoTickets.lottoCount
        println("${lottoCount}개를 구매했습니다.")
        lottoTickets.lottos.map { lotto ->
            println(lotto.lottoNumbers.map { it })
        }
    }
}
