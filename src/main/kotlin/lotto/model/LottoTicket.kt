package lotto.model

class LottoTicket {
    private val lottoNumbers = mutableListOf<Int>()

    fun make(): List<Int> {
        while (isContinuable()) {
            selectNumbers()
        }
        return lottoNumbers
    }

    private fun isContinuable(): Boolean {
        return lottoNumbers.size < LOTTO_NUMBER_SIZE
    }

    private fun selectNumbers() {
        var number = (LOTTO_WINNER_NUMBER_RANGE).random()
        if (!isDuplicate(number)) {
            lottoNumbers.add(number)
        }
    }

    private fun isDuplicate(number: Int): Boolean {
        return lottoNumbers.contains(number)
    }

    companion object {
        val LOTTO_WINNER_NUMBER_RANGE = 1..45
        const val LOTTO_NUMBER_SIZE = 6
    }
}
