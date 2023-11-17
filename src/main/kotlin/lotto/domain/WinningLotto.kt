package lotto.domain

class WinningLotto(
    val lotto: Lotto,
    val bonusNumber: Int
) {

    init {
        require(!lotto.contains(bonusNumber)) { "Duplicated number is in lotto!" }
    }

    fun getCountOfMatch(lotto: Lotto) = lotto.numbers.count { contains(it) }

    private fun contains(number: Int) = lotto.numbers.contains(number)
}
