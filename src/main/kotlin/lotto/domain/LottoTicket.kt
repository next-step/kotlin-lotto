package lotto.domain

class LottoTicket(private val lottoNumbers: Set<LottoNumber>) {

    constructor() : this(LottoNumber.generateNumbers())

    fun getLottoNumbers(): Set<LottoNumber> {
        return lottoNumbers
    }

    override fun toString(): String {
        return lottoNumbers.joinToString(",")
    }

    companion object {
        const val PRICE: Int = 1000
    }
}
