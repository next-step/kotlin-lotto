package lotto.domain

import lotto.domain.LottoNumber.Companion.LOTTO_SIZE
import lotto.exception.InvalidWinningNumberException
import lotto.exception.InvalidWinningNumberException.Companion.INVALID_WINNING_NUMBER_MESSAGE

class WinningNumber private constructor(
    private val lotto: Lotto,
    private val bonusNumber: LottoNumber,
) {
    fun containsLottoNumber(lottoNumber: LottoNumber): Boolean {
        return lotto.value.contains(lottoNumber)
    }

    fun containsBonusNumber(lottoNumber: LottoNumber): Boolean {
        return bonusNumber == lottoNumber
    }

    fun getLottoNumbers() = lotto.value

    companion object {
        fun of(value: List<String>, bonusNumber: Int): WinningNumber {
            if (value.isEmpty() || value.size != LOTTO_SIZE) {
                throw InvalidWinningNumberException(INVALID_WINNING_NUMBER_MESSAGE)
            }

            val defensiveCopyLottoNumbers = value.map {
                LottoNumber.valueOf(it.toInt())
            }
            val bonusLottoNumber = LottoNumber.valueOf(bonusNumber)
            return WinningNumber(Lotto(defensiveCopyLottoNumbers), bonusLottoNumber)
        }
    }
}
