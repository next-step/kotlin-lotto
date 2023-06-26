package lotto.domain

object LottoStore {
    const val LOTTO_PRICE = 1000

    fun buy(fee: Int): List<Lotto> {
        require(fee % LOTTO_PRICE == 0) { "로또 가격은 장당 $LOTTO_PRICE 입니다. 금액에 맞게 요금을 입력해 주세요." }
        val count = fee / 1000
        return (0 until count).map {
            val lottoNumbers = LottoNumber.random(6)
            Lotto.from(lottoNumbers)
        }
    }
}
