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
        private const val DELIMITER = ","
        private const val ERROR_INT = -1

        fun parsingTextToLotto(text: String): Lotto {
            val list = text
                .split(DELIMITER)
                .map { LottoNumber(it.toIntOrNull() ?: ERROR_INT) }
            return Lotto(list)
        }

        fun inputWinNumber(
            lastWinNumber: String?,
            bonusNumber: Int?
        ): WinNumber {
            require(!lastWinNumber.isNullOrBlank())
            require(bonusNumber != null)

            return WinNumber(parsingTextToLotto(lastWinNumber), LottoNumber(bonusNumber))
        }
    }
}
