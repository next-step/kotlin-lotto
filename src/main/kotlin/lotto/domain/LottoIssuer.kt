package lotto.domain

class LottoIssuer(
    private val lottoPrice: Long = Lotto.LOTTO_PRICE
) {

    fun issueLottoByAuto(money: Long): List<Lotto> {
        val lottoAmount = (money / lottoPrice).toInt()
        return List(lottoAmount) { Lotto.issueByAuto() }
    }
}
