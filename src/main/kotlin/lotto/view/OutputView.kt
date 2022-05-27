package lotto.view

import lotto.domain.LottoPurchase.Companion.LOTTO_PRICE
import lotto.domain.LottoTicket

class OutputView {
    fun cannotPurchaseLotto() {
        println("로또 한개의 가격은 $LOTTO_PRICE 입니다. 그 이상을 입력해 주세요.")
    }

    fun resultPurchaseLotto(lottoCount: Int) {
        println("${lottoCount}개를 구매했습니다.")
    }

    fun resultLottoTickets(lottoTickets: List<LottoTicket>) {
        lottoTickets.forEach(::println)
    }
}
