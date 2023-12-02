package lotto.domain

data class WinningLotto(
    val lotto: Lotto,
    val bonusNumber: LottoNumber,
) {
    init {
        require(!lotto.numbers.contains(bonusNumber)) {
            "보너스 번호는 로또 번호에 포함되면 안됩니다."
        }
    }
}
