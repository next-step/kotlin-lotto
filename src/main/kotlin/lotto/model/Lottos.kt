package lotto.model

/**
 * 로또 당첨번호 생성 클래스
 * */
class Lottos private constructor(
    private val purchasedLotto: List<Lotto>,
) {

    fun compareLottoResult(price: Price, winNumber: WinNumber): LottoStatisticFormat {
        val hashMap = hashMapOf<LottoRank, Int>()
        purchasedLotto.forEach { lotto ->
            val rank = LottoRank.findMatchRank(compareNumber(lotto, winNumber.lastWinNumber), lotto.hasNumber(winNumber.bonusNumber))
            hashMap[rank] = hashMap.getOrDefault(rank, 0) + ADD_ONE_LOTTO
        }
        return LottoStatisticFormat(price, hashMap)
    }

    companion object {
        private const val ADD_ONE_LOTTO = 1

        fun compareNumber(item: Lotto, lastWinNumber: Lotto): Int {
            var number = 0
            item.numbers
                .forEach { lottoNumber ->
                    if (lastWinNumber.hasNumber(lottoNumber)) ++number
                }
            return number
        }

        fun executeLottoComparison(
            purchasedLotto: List<Lotto>,
        ): Lottos = Lottos(purchasedLotto)
    }
}
