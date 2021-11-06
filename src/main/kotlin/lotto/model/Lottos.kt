package lotto.model

/**
 * 로또 당첨번호 생성 클래스
 * */
class Lottos private constructor(
    private val price: Price,
    private val purchasedLotto: List<Lotto>,
    private val lastWinNumber: Lotto,
    private val bonusNumber: Int,
) {

    fun compareLottoResult(): LottoStatisticFormat {
        val hashMap = hashMapOf<LottoRank, Int>()
        purchasedLotto.forEach { lotto ->
            val rank = LottoRank.findMatchRank(compareNumber(lotto, lastWinNumber), lotto.hasNumber(bonusNumber))
            hashMap[rank] = hashMap.getOrDefault(rank, 0) + ADD_ONE_LOTTO
        }
        return LottoStatisticFormat(price, hashMap)
    }

    companion object {
        private const val DELIMITER = ","
        private const val ERROR_INT = -1
        private const val ADD_ONE_LOTTO = 1
        private const val EXCEPTION_BONUS_NUMBER = "로또 당첨 번호와 겹치는 숫자 입니다."
        const val EXCEPTION_INPUT_NUMBER_NULL = "입력된 숫자가 없습니다."

        fun compareNumber(item: Lotto, lastWinNumber: Lotto): Int {
            var number = 0
            item.numbers
                .forEach { lottoNumber ->
                    if (lastWinNumber.numbers.contains(lottoNumber)) ++number
                }
            return number
        }

        fun inputWinNumber(
            price: Price,
            purchasedLotto: List<Lotto>,
            numbers: String?,
            bonusNumber: Int?,
        ): Lottos {
            require(numbers != null) { EXCEPTION_INPUT_NUMBER_NULL }
            require(bonusNumber != null)

            val list = numbers
                .split(DELIMITER)
                .map { LottoNumber(it.toIntOrNull() ?: ERROR_INT) }

            require(!list.map { it.number }.contains(bonusNumber)) { EXCEPTION_BONUS_NUMBER }
            return Lottos(price, purchasedLotto, Lotto(list), bonusNumber)
        }
    }
}
