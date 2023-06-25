package lotto.domain

open class Lotto(
    val lottoNumbers: Set<LottoNumber>
) {

    init {
        require(lottoNumbers.size == COUNT_OF_LOTTO_NUMBER)
    }

    override fun toString(): String {
        return lottoNumbers.sorted().toString()
    }

    companion object {
        const val PRICE = 1000
        const val COUNT_OF_LOTTO_NUMBER = 6
    }
}
