package lotto.domain

/**
 * 입력 받은 금액 만큼의 로또를 돌려준다.
 */
class LottoPurchaser(
    private val lottoGenerator: LottoGenerator
) {

    fun purchase(inputAmount: Int): List<Lotto> {
        val numOfLotto = getPurchasableNum(inputAmount)
        return lottoGenerator.generate(numOfLotto)
    }

    fun getPurchasableNum(inputAmount: Int): Int {
        return inputAmount / Lotto.PRICE
    }
}