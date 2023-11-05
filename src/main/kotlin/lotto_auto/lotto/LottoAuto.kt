package lotto_auto.lotto

object LottoAuto {
    /**
     * 구매한 로또 총 당첨 금액
     */
    fun sumOfWonLottoList(lottoList: List<Lotto>, lastWeekLottoNumber: Lotto): Int {
        return eachLottoMatchCount(lottoList, lastWeekLottoNumber).sumOf {
            replaceMatchCountToMoney(it)
        }
    }

    /**
     * 각각 구매한 로또 마다 당첨 번호와 대조 하여 맞은 개수를 판별 합니다.
     */
    private fun eachLottoMatchCount(
        lottoList: List<Lotto>,
        lastWeekLottoNumber: Lotto
    ): List<Int> {
        return lottoList.map { myLotto ->
            lastWeekLottoNumber.number.mapNotNull {
                if (myLotto.number.contains(it)) it else null
            }.count()
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

    fun matchCountList(lottoList: List<Lotto>, lastWeekLottoNumber: Lotto): List<Int> {
        val three = eachLottoMatchCount(lottoList, lastWeekLottoNumber).count { it == 3 }
        val four = eachLottoMatchCount(lottoList, lastWeekLottoNumber).count { it == 4 }
        val five = eachLottoMatchCount(lottoList, lastWeekLottoNumber).count { it == 5 }
        val six = eachLottoMatchCount(lottoList, lastWeekLottoNumber).count { it == 6 }
        return listOf(three, four, five, six)
    }

    fun earningRate(sumOfWonLotto: Int, inputAmount: Int): Float {
        return sumOfWonLotto.toFloat() / inputAmount.toFloat()
    }
}
