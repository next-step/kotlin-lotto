package camp.nextstep.edu.step.step2.domain.store

import camp.nextstep.edu.step.step2.domain.amount.BuyAmount
import camp.nextstep.edu.step.step2.domain.lotto.Lotto
import camp.nextstep.edu.step.step2.domain.lotto.Lottos
import camp.nextstep.edu.step.step2.domain.lotto.WinningLotto
import camp.nextstep.edu.step.step2.domain.result.LottoMatch
import camp.nextstep.edu.step.step2.domain.result.LottoResult
import camp.nextstep.edu.step.step2.generator.NumberGenerator

object LottoStore {

    private const val START_NUMBER = 1
    private const val END_NUMBER = 45

    /**
     * @description : 로또 장당의 가격은 정부에서 정해진 정책만큼 가격이 달라지듯이 해당 미션에서는 각 Store마다 가격이 다르다고 가정했다.
     */
    private const val LOTTO_TICKET_PRICE = 1000L

    /**
     * @description : 구매금액에 따른 로또 티켓 수량을 구한다.
     */
    fun buyLottoTickets(buyAmount: BuyAmount): LottoTicketAmount {
        val lottoTicketAmount = buyAmount.divideByLotteryPrice(ticketPrice = LOTTO_TICKET_PRICE)
        return LottoTicketAmount(lottoTicketAmount)
    }

    /**
     * @description : 로또 티켓 수량에 따른 로또 번호를 생성한다.
     */
    fun createNumbersByLottoTicketAmount(ticketAmount: LottoTicketAmount): Lottos {
        val lottoTickets = mutableListOf<Lotto>()

        for (i in 1..ticketAmount.lottoTicketAmount) {
            val numbers = NumberGenerator.generate(NumberGenerator.LOTTO_RANDOM, START_NUMBER, END_NUMBER)
            lottoTickets.add(Lotto(numbers = numbers))
        }

        return Lottos(lottos = lottoTickets)
    }

    /**
     * @description : 로또의 당첨결과르 확인한다. ( 보통 로또의 경우 구매처에서 용지를 넣고 확인하는 방식을 활용했다. )
     */
    fun checkLottoTicketsWinningResult(
        userLottos: Lottos,
        winningLotto: WinningLotto
    ): LottoResult {

        val totalPrice = getTotalPriceByLottoAmountAndTicketPrice(
            lottoSize = userLottos.getLottoSize(),
            ticketPrice = LOTTO_TICKET_PRICE
        )

        val matchResult = lottoWinningResults(
            userlottos = userLottos,
            winningLotto = winningLotto
        )

        return LottoResult(totalPrice, matchResult)
    }

    /**
     * @description : 로또의 수량과 가격을 곱하여 총 금액을 구한다. ( 로또 판매처에서 해당 책임이 부여가 되어야한다고 생각했다. )
     */
    private fun getTotalPriceByLottoAmountAndTicketPrice(lottoSize: Int, ticketPrice: Long): Int {
        return lottoSize * ticketPrice.toInt()
    }

    /**
     * @description : 로또의 결과를 확인합니다. ( 보통 로또 판매처에 내가 구매한 로또들을 넣고 확인하는 방식을 생각했다. )
     */
    private fun lottoWinningResults(
        userlottos: Lottos,
        winningLotto: WinningLotto
    ): List<LottoMatch> {
        val lottoMatchResults = mutableListOf<LottoMatch>()

        for (lotto in userlottos.lottos) {
            val matchNumbers = lotto.countMatch(winningLotto.winningLotto)
            val matchBonus = lotto.countMatchBonus(winningLotto.bonusNumber)
            lottoMatchResults.add(LottoMatch.of(matchNumbers, matchBonus))
        }

        return lottoMatchResults
    }

}
