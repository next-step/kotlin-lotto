package lotto.domain

class LottoTicket(
    lottoNumbers: List<LottoNumber>
) {
    private val lottoNumbers: Set<LottoNumber>

    init {
        validateLottoNumbers(lottoNumbers)
        this.lottoNumbers = lottoNumbers.toSet()
    }

    constructor(vararg numbers: Int) : this(numbers.map { LottoNumber.of(it) })

    private fun validateLottoNumbers(lottoNumbers: List<LottoNumber>) {
        require(lottoNumbers.size == LOTTO_NUMBER_COUNT) { "로또 번호는 반드시 6개 입니다." }
        require(lottoNumbers.toSet().size == LOTTO_NUMBER_COUNT) { "로또 번호는 중복될 수 없습니다." }
    }

    fun getMatchCountWith(otherTicket: LottoTicket): Int {
        return this.lottoNumbers
            .count { otherTicket.has(it) }
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
