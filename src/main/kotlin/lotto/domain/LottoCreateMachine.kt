package lotto.domain

import lotto.domain.model.vo.BuyPrice
import lotto.domain.model.Lotto

private const val DEFAULT_LOTTO_PRICE = 1000
private const val DEFAULT_LOTTO_LENGTH = 6
private const val MIN_LOTTO_NUMBER = 1
private const val MAX_LOTTO_NUMBER = 45


/**
 * 로또 생성 기계
 * */
object LottoCreateMachine {

    private val defaultNumberRange = MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER

    /**
     * 로또 리스트 구매
     * */
    fun buyLottoList(buyPrice: BuyPrice, price :Int = DEFAULT_LOTTO_PRICE): List<Lotto> {

        require(price != 0 && buyPrice.buyPrice >= price && buyPrice.buyPrice % price == 0) {
            "로또 구입 금액은 0원이 아니거나 ${price}으로 나누어 떨어져야 한다."
        }

        return createLottoList(buyPrice.buyPrice / price)
    }

    private fun createLottoList(lottoCount: Int): List<Lotto> {
        val lottoList = mutableListOf<Lotto>()
        repeat(lottoCount) {
            lottoList.add(createLotto())
        }
        return lottoList
    }

    private fun createLotto(numberRange: IntRange? = null): Lotto {
        return Lotto.from(lottoNumberList = (numberRange?: defaultNumberRange).shuffled().take(DEFAULT_LOTTO_LENGTH).sorted())
    }
}
