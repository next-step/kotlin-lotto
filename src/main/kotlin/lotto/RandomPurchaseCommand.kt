package lotto

import lotto.vo.LottoNumber

object RandomPurchaseCommand : LottoPurchaseCommand {

    override fun fetchPurchaseLottoByCount(count: Int): List<Lotto> {
        return List(count) { createRandomLotto() }
    }

    private fun createRandomLotto(): Lotto {
        val lottoNums = (1..45)
            .map(LottoNumber::from)
            .shuffled()
            .subList(0, 6)

        return Lotto.from(lottoNums)
    }
}
