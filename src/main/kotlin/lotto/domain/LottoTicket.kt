package lotto.domain

data class LottoTicket(
    private val lottoNumbers: Set<LottoNumber>
) {
    init {
        validateDuplicatedNumbers(lottoNumbers)
    }

    constructor(lottoNumbers: List<LottoNumber>) : this(lottoNumbers.toSet()) {
        validateNumbersSize(lottoNumbers.size)
    }

    constructor(vararg numbers: Int) : this(numbers.map { LottoNumber.of(it) })

    private fun validateDuplicatedNumbers(lottoNumbers: Set<LottoNumber>) {
        require(lottoNumbers.size == LOTTO_NUMBER_COUNT) { "로또 번호는 중복될 수 없습니다." }
    }

    private fun validateNumbersSize(size: Int) {
        require(size == LOTTO_NUMBER_COUNT) { "로또 번호는 반드시 6개 입니다." }
    }

    fun compare(lottoTicket: LottoTicket, bonusNumber: LottoNumber): LottoResult {
        val isBonusMatched = this.has(bonusNumber)
        return this.lottoNumbers
            .count { lottoTicket.has(it) }
            .let { LottoResult.findByMatch(it, isBonusMatched) }
    }

    fun has(lottoNumber: LottoNumber): Boolean {
        return this.lottoNumbers.contains(lottoNumber)
    }

    override fun toString(): String {
        return lottoNumbers.toString()
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        const val PRICE = 1_000
    }
}
