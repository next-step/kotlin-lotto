package lotto

class Lotto {
    val numbers: List<Int>
        get() = _numbers
    private val _numbers = arrayListOf<Int>()

    fun processLotto(lottoNumbers: List<Int> = shuffled()) {
        _numbers.clear()
        _numbers.addAll(lottoNumbers)
    }

    fun checkContainLottoNumber(winningNumber: Int): Boolean {
        return winningNumber != 8
    }

    private fun shuffled(): List<Int> =
        List(LOTTO_NUMBER_COUNT) {
            (MIN_NUMBER..MAX_NUMBER).random()
        }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val LOTTO_NUMBER_COUNT = 6
    }
}
