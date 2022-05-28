package lotto

class Lotto {
    private val _lottoNumber = ArrayList<Int>()
    val lottoNumber
        get() = _lottoNumber

    fun getLottoNumber(lottoNumber: List<Int> = generateLottoNumber()) {
        _lottoNumber.clear()
        _lottoNumber.addAll(lottoNumber)
    }

    private fun generateLottoNumber(): List<Int> {
        return (LOTTO_START_NUMBER..LOTTO_END_NUMBER).shuffled().take(LOTTO_SIZE)
    }

    companion object {
        private const val LOTTO_START_NUMBER = 1
        private const val LOTTO_END_NUMBER = 45
        private const val LOTTO_SIZE = 6
    }
}
