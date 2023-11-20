package lotto.domain

class LottoShop {

    fun countBuyLotto(money: Int, manualLottoCount: Int): LottoPurchaseInfo {
        val lottoBuyTotalCount = money.div(LOTTO_PRICE)
        val autoLottoCount = lottoBuyTotalCount - manualLottoCount
        return LottoPurchaseInfo(autoLottoCount, manualLottoCount)
    }

    fun buyLotto(autoLottoBuyCount: Int, manualLottos: Lottos): Lottos {
        val autoLottos = Lottos(
            List(autoLottoBuyCount) {
                val shuffledNumbers = LottoNumber.lottoNumberRange.shuffled().take(Lotto.LOTTO_NUMBER_COUNT)
                Lotto(shuffledNumbers.map { LottoNumber(it) })
            }
        )

        return manualLottos + autoLottos
    }

    fun generateLottoNumbers(inputNumber: String, delimiters: String = ", "): Lotto {
        return Lotto(inputNumber.split(delimiters).map { LottoNumber(it.toInt()) })
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
