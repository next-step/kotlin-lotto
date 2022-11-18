package lotto.view

import lotto.domain.LottoTicket

object LottoOutputView {
    /**
     * 구입한 로또의 수를 출력한다.
     */
    fun printPurchaseLottoCount(lottoTicket: LottoTicket) = println("${lottoTicket.lottoCount}개를 구매했습니다.")

    /**
     * 로또 티켓의 번호들을 출력한다.
     */
    fun printLottoTicket(lottoTicket: LottoTicket) =
        lottoTicket.lottoList.map { lotto -> println("${lotto.numbers.toList()}") }
}
