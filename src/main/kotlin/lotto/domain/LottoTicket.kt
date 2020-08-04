package lotto.domain

class LottoTicket(
    private val lottoNumbers: List<LottoNumber>
) {
    init {
        validateLottoNumbers(lottoNumbers)
    }

    constructor(vararg numbers: Int) : this(numbers.map { LottoNumber.of(it) })

    private fun validateLottoNumbers(lottoNumbers: List<LottoNumber>) {
        require(lottoNumbers.size == LOTTO_NUMBER_COUNT) { "로또 번호는 반드시 6개 입니다." }
        require(lottoNumbers.distinct().size == LOTTO_NUMBER_COUNT) { "로또 번호는 중복될 수 없습니다." }
    }

    fun compare(lottoTicket: LottoTicket): LottoResult {
        return this.lottoNumbers
            .count { lottoTicket.has(it) }
            .let { LottoResult.findByMatch(it) }
    }

    private fun has(lottoNumber: LottoNumber): Boolean {
        return this.lottoNumbers.contains(lottoNumber)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LottoTicket

        if (lottoNumbers != other.lottoNumbers) return false

        return true
    }

    override fun hashCode(): Int {
        return lottoNumbers.hashCode()
    }

    override fun toString(): String {
        return lottoNumbers.toString()
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        const val PRICE = 1_000
    }
}
