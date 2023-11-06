package lotto.domain

class LottoShop {

    fun buyLotto(money: Int): Lotto {
        val lottoNumbers = IntRange(1, getQuantity(money))
            .map { LottoGenerator.generate() }
        return Lotto(lottoNumbers)
    }

    private fun getQuantity(money: Int) = money / LOTTO_FEE

    companion object {
        const val LOTTO_FEE: Int = 1_000
    }
}
