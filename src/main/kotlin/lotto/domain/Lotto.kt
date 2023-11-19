package lotto.domain

class Lotto(numbers: List<LottoNumber>) {
    var numbers: List<LottoNumber>
        private set

    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { "로또 번호는 ${LOTTO_NUMBER_SIZE}개입니다." }
        require(!hasDuplicatedNumber(numbers)) { "로또 번호는 중복될 수 없습니다." }
        this.numbers = numbers.sortedBy { it.number }
    }

    constructor() : this(
        generateSequence { LottoNumber() }
            .distinct()
            .take(LOTTO_NUMBER_SIZE)
            .toList()
    )

    private fun hasDuplicatedNumber(numbers: List<LottoNumber>): Boolean {
        return numbers.size != numbers.distinct().size
    }

    fun match(winningLotto: Lotto): LottoResult {
        return LottoResult.of(numbers.count { winningLotto.numbers.contains(it) })
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
    }
}