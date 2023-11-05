package lotto_auto.lotto

class LottoAuto(
    private val lottoList: List<Lotto>,
    private val lastWeekLottoNumber: Lotto,
) {
    /**
     * 구매한 로또 총 당첨 금액
     */
    fun sumOfWonLottoList(): Int {
        return eachLottoMatchCount().sumOf {
            replaceMatchCountToMoney(it)
        }
    }

    /**
     * 각각 구매한 로또 마다 당첨 번호와 대조 하여 맞은 개수를 판별 합니다.
     */
    private fun eachLottoMatchCount(): List<Int> {
        return lottoList.map { myLotto ->
            lastWeekLottoNumber.number.mapNotNull { number ->
                if (myLottoNumberContainsNumberOrNull(myLotto, number)) number else null
            }.count()
        }
    }

    private fun myLottoNumberContainsNumberOrNull(myLotto: Lotto, number: Int): Boolean {
        return myLotto.number.contains(number)
    }

    /**
     * match 개수 만큼 금액 으로 변경
     */
    private fun replaceMatchCountToMoney(it: Int): Int = when (it) {
        3 -> 5_000
        4 -> 50_000
        5 -> 1_500_000
        6 -> 2_000_000_000
        else -> 0
    }

    fun matchCountList(): List<Int> {
        return eachLottoMatchCount().filter { it > 2 }.let { matchList ->
            val three = matchList.count { it == 3 }
            val four = matchList.count { it == 4 }
            val five = matchList.count { it == 5 }
            val six = matchList.count { it == 6 }
            listOf(three, four, five, six)
        }
    }

    fun earningRate(sumOfWonLotto: Int, inputAmount: Int): Float {
        return sumOfWonLotto.toFloat() / inputAmount.toFloat()
    }
}
