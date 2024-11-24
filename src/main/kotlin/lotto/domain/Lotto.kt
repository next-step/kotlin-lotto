package lotto.domain

class Lotto(private val numbers: List<Number>) {
    init {
        require(numbers.size == LOTTO_SIZE) { LOTTO_SIZE_EXCEPTION_MESSAGE }
        require(!existDuplicateNumber(numbers)) { LOTTO_DUPLICATE_EXCEPTION_MESSAGE }
    }

    fun match(
        winningLotto: Lotto,
        bonus: Number,
    ): LottoRank {
        check(!winningLotto.numbers.contains(bonus)) { LOTTO_DUPLICATE_BONUS_EXCEPTION_MESSAGE }

        val containBonus = numbers.contains(bonus)
        val matchCount = numbers.count { it in winningLotto.numbers } + if (containBonus) 1 else 0
        return LottoRank.from(matchCount, containBonus)
    }

    fun getNumbersRawValues(): List<Int> = numbers.map { it.value }

    private fun existDuplicateNumber(numbers: List<Number>): Boolean = numbers.toSet().size != numbers.size

    companion object {
        private const val LOTTO_SIZE_EXCEPTION_MESSAGE = "로또는 6개의 숫자가 있어야 합니다."
        private const val LOTTO_DUPLICATE_EXCEPTION_MESSAGE = "로또의 숫자들은 중복되지 않아야 합니다."
        private const val LOTTO_DUPLICATE_BONUS_EXCEPTION_MESSAGE = "보너스 번호는 로또와 중복될 수 없습니다."
        const val LOTTO_SIZE = 6

        fun createLottos(
            amount: Int,
            lottoGenerator: LottoGenerator,
        ): List<Lotto> = List(amount) { lottoGenerator.generate(LOTTO_SIZE) }
    }
}
