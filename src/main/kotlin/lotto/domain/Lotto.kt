package lotto.domain

open class Lotto(
    val lottoNumbers: Set<LottoNumber>
) {

    init {
        isValid(lottoNumbers)
    }

    override fun toString(): String {
        return lottoNumbers.sorted().toString()
    }

    private fun isValid(nums: Set<LottoNumber>) {
        require(nums.size == COUNT_OF_LOTTO_NUMBER)
    }

    companion object {
        const val PRICE = 1000
        const val COUNT_OF_LOTTO_NUMBER = 6
    }
}
