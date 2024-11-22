package lotto.domain

class Lotto(private val numbers: List<Number>) {
    init {
        require(numbers.size == LOTTO_SIZE) { LOTTO_SIZE_EXCEPTION_MESSAGE }
        require(!existDuplicateNumber(numbers)) { LOTTO_DUPLICATE_EXCEPTION_MESSAGE }
    }

    fun match(winningLotto: Lotto): LottoRank {
        val matchCount = numbers.count { it in winningLotto.numbers }
        return LottoRank.from(matchCount)
    }

    override fun toString(): String = "[${numbers.joinToString(", ") { it.value.toString() }}]"

    private fun existDuplicateNumber(numbers: List<Number>): Boolean = numbers.toSet().size != numbers.size

    companion object {
        private const val LOTTO_SIZE_EXCEPTION_MESSAGE = "로또는 6개의 숫자가 있어야 합니다."
        private const val LOTTO_DUPLICATE_EXCEPTION_MESSAGE = "로또의 숫자들은 중복되지 않아야 합니다."
        const val LOTTO_SIZE = 6
    }
}
