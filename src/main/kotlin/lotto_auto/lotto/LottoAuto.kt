package lotto_auto.lotto

object LottoAuto {
    /**
     * 구매한 로또 총 당첨 금액
     */
    fun sumOfWonLottoList(eachLottoMatchList: List<Int>): Int {
        return eachLottoMatchList.sumOf {
            replaceMatchCountToMoney(it)
        }
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

    fun matchCountList(eachLottoMatchList: List<Int>): List<Int> {
        return eachLottoMatchList.filter { it > 2 }.let { matchList ->
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
