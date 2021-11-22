package lotto.domain

import lotto.domain.lotto.Lotto

object LottoShop {

    private const val LOTTO_PRICE = 1_000
    private const val LOTTO_PRICE_ERROR_MESSAGE = "로또의 구매 단위는 1000 단위 입니다."
    private const val ZERO = 0
    private const val LACK_MONEY_MESSAGE = "금액이 부족 합니다."

    private const val LOTTO_MIN_NUMBER = 1
    private const val LOTTO_MAX_NUMBER = 45
    private val LOTTO_RANGE = arrayOf(0, 6)

    fun createLottoTicket(money: Int): List<Lotto> {
        require(money % LOTTO_PRICE == 0) { IllegalArgumentException(LOTTO_PRICE_ERROR_MESSAGE) }
        require(money > ZERO) { IllegalArgumentException(LACK_MONEY_MESSAGE) }

        val lottoCount: Int = money / LOTTO_PRICE

        val lottoList = mutableListOf<Lotto>()

        repeat(lottoCount) {
            lottoList.add(Lotto(generatorLotto()))
        }

        return lottoList.toList()
    }

    private fun generatorLotto(): List<Int> = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER)
        .shuffled()
        .subList(LOTTO_RANGE[0], LOTTO_RANGE[1])
        .sorted()
}
