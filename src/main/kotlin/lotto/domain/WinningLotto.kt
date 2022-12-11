package lotto.domain

class WinningLotto(winningNumbers: List<Int>) {

    private val numbers: Set<LottoNumber>

    init {
        numbers = winningNumbers.map { LottoNumber(it) }.toSet()
        require(numbers.size == 6) {
            "로또 번호의 수는 6개여야 합니다"
        }
    }

    fun compareWith(lotto: Lotto): Rank {
        val result = MatchResult(numbers.intersect(lotto.numbers).size)
        return Rank.valueOf(matchResult = result)
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
