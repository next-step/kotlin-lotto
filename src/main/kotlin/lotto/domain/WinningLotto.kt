package lotto.domain

class WinningLotto(winningNumbers: List<Int>) {

    private val numbers: Set<LottoNumber>

    init {
        require(winningNumbers.size == 6)
        numbers = winningNumbers.map { LottoNumber(it) }.toSet()
        require(numbers.size == 6)
    }

    fun compareWith(lotto: Lotto): LottoResult {
        return when (numbers.intersect(lotto.numbers).size) {
            6 -> LottoResult.FirstWin
            5 -> LottoResult.SecondWin
            4 -> LottoResult.ThirdWin
            3 -> LottoResult.FourthWin
            else -> LottoResult.NotWin
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WinningLotto

        if (numbers != other.numbers) return false

        return true
    }

    override fun hashCode(): Int {
        return numbers.hashCode()
    }

    companion object {
        fun byInput(input: String): WinningLotto {
            val list = input.split(',')
            return WinningLotto(list.map { it.trim().toInt() })
        }
    }
}
