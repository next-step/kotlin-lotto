package lotto.domain

class Lotto(val numbers: List<LottoNumber>) {
    init {
        require(numbers.size == NUMBER_NUM) { "로또 번호는 6개여야 합니다." }
    }
    constructor () : this(generateLotto())

    fun matches(winningLotto: Lotto): Int {
        return numbers.intersect(winningLotto.toSet()).size
    }
    private fun toSet(): Set<LottoNumber> {
        return numbers.toSet()
    }

    override fun toString(): String {
        return "[${numbers.joinToString(", ")}]"
    }

    companion object {
        const val NUMBER_NUM = 6

        private fun generateLotto(): List<LottoNumber> {
            return LottoNumber.NUMBERS.entries
                .shuffled()
                .take(NUMBER_NUM)
                .map { it.value }
                .sortedBy { it.number }
        }
    }
}
