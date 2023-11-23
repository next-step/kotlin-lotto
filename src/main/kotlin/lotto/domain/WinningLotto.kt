package lotto.domain

class WinningLotto(
    val lotto: Lotto,
    val bonusNumber: Int
) {

    init {
        require(!lotto.contains(LottoNumber(bonusNumber))) { "Duplicated number is in lotto!" }
        require(LottoPolicy.LOTTO_NUMBER_POOL.contains(bonusNumber)) { "Invalidate bonus number!" }
    }

    fun getCountOfMatch(targetLotto: Lotto) = targetLotto.numbers.count { contains(it) }

    private fun contains(lottoNumber: LottoNumber) = lotto.numbers.contains(lottoNumber)
}
