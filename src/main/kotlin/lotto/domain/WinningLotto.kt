package lotto.domain

class WinningLotto(lottoNumber: String) {

    private val winningLottoNumberList: List<Int>

    init {
        winningLottoNumberList = lottoNumber.split(",").map { lottoValidCheck(it.trim().toInt()) }.distinct().sorted()
        require(winningLottoNumberList.size == 6) { IllegalArgumentException(LOTTO_NUMBER_OVERLAP) }
    }

    private fun lottoValidCheck(number: Int): Int {
        require(number in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX) { IllegalArgumentException(LOTTO_NUMBER_OUT_RAGE) }
        return number
    }

    fun getWinningLottoNumberList(): List<Int> {
        return winningLottoNumberList
    }

    fun containsLottoNumber(lottoNumber: Int): Boolean {
        return winningLottoNumberList.contains(lottoNumber)
    }

    companion object {
        private const val LOTTO_NUMBER_MIN = 1
        private const val LOTTO_NUMBER_MAX = 45
        private const val LOTTO_NUMBER_OUT_RAGE =
            "로또 번호의 범위는 ${lotto.domain.WinningLotto.Companion.LOTTO_NUMBER_MIN} ~ ${lotto.domain.WinningLotto.Companion.LOTTO_NUMBER_MAX} 만 가능합니다."
        private const val LOTTO_NUMBER_OVERLAP = "로또 번호는 중복 될수 없고 로또 번호는 6개여야 합니다."
    }
}
