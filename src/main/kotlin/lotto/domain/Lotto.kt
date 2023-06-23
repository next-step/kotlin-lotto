package lotto.domain

@JvmInline
value class Lotto(
    val lottoNumbers: List<LottoNumber>,
) {
    init {
        require(lottoNumbers.size == lottoNumbers.distinct().size) { "로또번호는 중복이 없어야 합니다." }
        require(lottoNumbers.size == LOTTO_NUMBER_COUNT) { "로또번호는 ${LOTTO_NUMBER_COUNT}개 이어야 합니다." }
    }

    constructor(vararg numbers: Int) : this(numbers.map { LottoNumber(it) })

    fun matchPrize(winningLotto: WinningLotto): Prize {
        val matchedLottoNumbers = lottoNumbers.filter { winningLotto.contains(it) }
        val bonusMatched = lottoNumbers.any { it == winningLotto.bonusLottoNumber }
        return Prize.match(matchedLottoNumbers.size, bonusMatched)
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6

        fun draw(lottoGenerator: LottoGenerator, numbers: List<Int> = emptyList()): Lotto =
            lottoGenerator.generate(numbers)
    }
}
