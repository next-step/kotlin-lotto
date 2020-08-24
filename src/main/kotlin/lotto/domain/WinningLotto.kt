package lotto.domain

class WinningLotto(val prizeLotto: Lotto, val bonusNumber: LottoNumber) {
    init {
        checkValidation()
    }

    constructor(prizeLotto: String, bonusNumber: String) : this(
        Lotto.from(prizeLotto),
        LottoNumber.from(bonusNumber)
    )

    private fun checkValidation() {
        require(!prizeLotto.isContainNumber(bonusNumber)) { "당첨번호에 포함되지 않는 보너스 볼을 입력해주세요." }
    }
}
