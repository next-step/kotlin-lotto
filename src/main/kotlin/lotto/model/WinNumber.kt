package lotto.model

/**
 * 로또 당첨 번호 관리 클래스
 * */
class WinNumber private constructor(
    private val _lastWinNumber: Lotto,
    private val _bonusNumber: LottoNumber
) {

    init {
        require(!lastWinNumber.hasNumber(bonusNumber)) { EXCEPTION_BONUS_NUMBER }
    }

    val lastWinNumber: Lotto
        get() = _lastWinNumber

    val bonusNumber: LottoNumber
        get() = _bonusNumber

    companion object {
        private const val EXCEPTION_BONUS_NUMBER = "로또 당첨 번호와 겹치는 숫자 입니다."

        fun inputWinNumber(
            lastWinNumber: String?,
            bonusNumber: Int?
        ): WinNumber {
            require(!lastWinNumber.isNullOrBlank())
            require(bonusNumber != null)

            return WinNumber(Lotto.parsingTextToLotto(lastWinNumber), LottoNumber(bonusNumber))
        }
    }
}
