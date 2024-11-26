package lotto.domain

import lotto.model.Lotto

class LottoResultManager(
    private val winningLotto: Lotto,
    private val lottoList: List<Lotto>
) {
    fun isWinResult(): LottoResult {
        return LottoResult.Success(1, 1, 1, 1)
    }

    fun calculateWinningRate(): Float {
        return 0f
    }
}

sealed class LottoResult {
    data class Success(
        val winThreeCount: Int,
        val winFourCount: Int,
        val winFiveCount: Int,
        val winSixCount: Int,
    ) : LottoResult()

    class Failure : LottoResult()
}