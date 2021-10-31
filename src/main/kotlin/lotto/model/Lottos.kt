package lotto.model

/**
 * 로또 당첨번호 생성 클래스
 * */
class Lottos private constructor(private val price: Price, private val purchasedLotto: List<Lotto>, private val lastWinNumber: Lotto) {

    fun compareLottoList(): LottoStatisticFormat {
        val hashMap = hashMapOf<LottoRank, Int>()
        purchasedLotto.forEach { lotto ->
            val rank = LottoRank.findMatchRank(compareNumber(lotto))
            hashMap[rank] = hashMap.getOrDefault(rank, 0) + 1
        }
        return LottoStatisticFormat(price, hashMap)
    }

    private fun compareNumber(item: Lotto): Int {
        var number = 0
        item.numbers
            .forEach { lottoNumber ->
                if (lastWinNumber.numbers.contains(lottoNumber)) ++number
            }
        return number
    }

    companion object {
        fun inputWinNumber(price: Price, purchasedLotto: List<Lotto>, numbers: String?): Lottos {
            require(numbers != null) { EXCEPTION_INPUT_NUMBER_NULL }

            val list = numbers
                .split(DELIMITER)
                .map { LottoNumber(it.toIntOrNull() ?: -1) }
            return Lottos(price, purchasedLotto, Lotto(list))
        }

        private const val DELIMITER = ","
        const val EXCEPTION_INPUT_NUMBER_NULL = "입력된 숫자가 없습니다."
    }
}
