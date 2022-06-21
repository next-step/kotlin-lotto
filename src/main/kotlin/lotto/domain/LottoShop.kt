package lotto.domain

class LottoShop {
    fun buyLotto(money: Long): LottoTickets {
        val lottoCount = numOfPurchases(money)
        return LottoVendor.generate(lottoCount)
    }

    private fun numOfPurchases(money: Long): Int {
        require(money >= LOTTO_PRICE) { "구입가능한 로또가 없어요. 1000원 이상의 금액만 입력해주세요." }
        require(money % LOTTO_PRICE == 0L) { "1000원 단위로 입력해주세요." }
        return (money / LOTTO_PRICE).toInt()
    }

    companion object {
        private const val LOTTO_PRICE = 1000L
    }
}
