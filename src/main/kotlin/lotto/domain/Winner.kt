package lotto.domain

class Winner(val lotto: Lotto, val bonusNumber: LottoNumber) {
    init {
        require(!lotto.contains(bonusNumber)) {
            "보너스 번호는 로또에 포함된 숫자가 아니어야 합니다."
        }
    }

    fun check(target: Lotto): WinnerType? {
        return WinnerType.valueOf(
            target.countMatchedNumbers(lotto),
            target.contains(bonusNumber)
        )
    }
}
