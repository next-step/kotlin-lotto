package lotto.domain

class Lottos(lottos: List<Lotto>) {
    val lottos: List<Lotto> = lottos.toList()

    fun getResult(
        winningLotto: Lotto,
        bonusLottoNumber: LottoNumber,
    ): LottoResult {
        val result = lottos.groupingBy { lotto ->
            val matchCount = lotto.countMatch(winningLotto)
            Prize.of(matchCount = matchCount, bonusLottoNumber = bonusLottoNumber, lotto = lotto)
        }.eachCount()
        return LottoResult(result)
    }

    companion object {
        private const val LOTTO_PRICE = 1000

        fun buyLotto(money: Int?): Lottos {
            requireNotNull(money) {
                "구매 금액은 null이 아니어야 함"
            }
            require(money >= LOTTO_PRICE) {
                "구매 금액은 1000 보다 커야 함"
            }

            return Lottos(List(money / LOTTO_PRICE) { Lotto() })
        }
    }
}
