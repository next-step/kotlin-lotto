package lotto.domain

data class WinningLotto(
    val lotto: Lotto,
    val bonusNumber: Int,
) {
    init {
        require(!lotto.numbers.contains(bonusNumber)) {
            "보너스 번호는 로또 번호에 포함되면 안됩니다."
        }

        require(bonusNumber in Lotto.MIN_NUMBER..Lotto.MAX_NUMBER) {
            "보너스 번호는 항상 ${Lotto.MIN_NUMBER}에서 ${Lotto.MAX_NUMBER}사이 값이어야 합니다."
        }
    }
}
