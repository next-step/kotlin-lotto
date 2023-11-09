package lotto.domain

class WinningLotto(
    val lotto: Lotto,
    val bonusNumber: Int
) {

    init {
        require(!lotto.contains(bonusNumber)) { "Duplicated number is in lotto!" }
    }

    fun contains(number: Int) = lotto.numbers.contains(number)
}
