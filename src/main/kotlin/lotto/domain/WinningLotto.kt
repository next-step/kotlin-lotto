package lotto.domain

class WinningLotto(winningNumbers: List<Int>, bonus: Int) {

    private val numbers: Set<LottoNumber>
    private val bonusNumber: LottoNumber

    init {
        numbers = winningNumbers.map { LottoNumber(it) }.toSet()
        require(numbers.size == 6) {
            "로또 번호의 수는 6개여야 합니다"
        }
        bonusNumber = LottoNumber(bonus)
        require(!numbers.contains(bonusNumber)) {
            "보너스 번호는 로또넘버와 겹치지 않아야합니다"
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
        fun byInput(numbers: String, bonusNumber: String): WinningLotto {
            val list = numbers.split(',')
            return WinningLotto(list.map { it.trim().toInt() }, bonusNumber.toInt())
        }
    }
}
