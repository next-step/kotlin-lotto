package lotto.domain

import lotto.model.Lotto

class LottoResultManager(
    private val winningLotto: Lotto,
    private val lottoList: List<Lotto>,
) {
    private val resultMap = mutableMapOf<Int, Int>()

    fun getResult(): LottoResult {
        lottoList.forEach {
            val count = it.value.count { number -> winningLotto.value.contains(number) }
            if (count >= MIN_WINNING_COUNT) {
                val prev = resultMap.getOrPut(count) { 0 }
                resultMap[count] = prev + 1
            }
        }
        return LottoResult(resultMap)
    }

    fun calculateWinningRate(): Float {
        val totalLottoSize = lottoList.size.toFloat()
        val totalWin = resultMap.values.sumOf { it }.toFloat()
        return totalWin / totalLottoSize
    }

    companion object {
        private const val MIN_WINNING_COUNT = 3
    }
}

data class LottoResult(
    val lottoResultMap: Map<Int, Int>,
)
