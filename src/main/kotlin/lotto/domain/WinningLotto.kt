package lotto.domain

class WinningLotto(
    val lotto: Lotto,
    val bonusNumber: Int
) {

    init {
        require(!lotto.contains(bonusNumber)) { "Duplicated number is in lotto!" }
        require(Lotto.MIN_LOTTO_NUMBER <= bonusNumber && bonusNumber <= Lotto.MAX_LOTTO_NUMBER) { "Invalidate bonus number!" }
    }

    fun getCountOfMatch(lotto: Lotto) = lotto.numbers.count { contains(it) }

    private fun contains(number: Int) = lotto.numbers.contains(number)
}
