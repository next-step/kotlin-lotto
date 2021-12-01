package lotto.domain

class Lotto(count: Int) {
    private val lottoNumbers = LottoNumbersFactory.create(count)
    private val winningState = WinningState()

    fun checkMatchingNumbers(winningNumber: List<String>) {
        getLottoNumbers().forEach {
            recordResult(it, winningNumber)
        }
    }

    fun recordResult(lottoNumber: LottoNumber, winningNumber: List<String>) {
        Winning.getWinningResult(addMatchCount(lottoNumber, winningNumber))?.let { winning ->
            winningState.recordResult(winning)
        }
    }

    private fun addMatchCount(lottoNumber: LottoNumber, winningNumber: List<String>): Int {
        var matchCount = ZERO
        lottoNumber.numbers.forEach { number ->
            if (winningNumber.contains(number.toString())) matchCount++
        }

        return matchCount
    }

    fun getLottoNumbers() = lottoNumbers.getLottoNumbers()

    fun getWinningStatus() = winningState

    companion object {
        const val ZERO = 0
        val allNumber = 1..45
    }
}
