package lotto

sealed class LottoResult<out T> {
    sealed class SuccessStep<out T>(val data: T) : LottoResult<Nothing>() {
        data class InputAmountStep(val amount: Amount) : SuccessStep<Amount>(amount)

        data class InputManualStep(val manual: Lottos) : SuccessStep<Lottos>(manual)

        data class InputLastWeekNumbersStep(val lastWeekNumbers: Lotto) : SuccessStep<Lotto>(lastWeekNumbers)

        data class InputBonusNumberStep(val bonusNumber: LottoNumber) : SuccessStep<LottoNumber>(bonusNumber)
    }

    sealed class Error(val message: String) : LottoResult<Nothing>() {
        data class CustomError(val errorDetails: String) : Error(errorDetails)
    }
}
