package lotto

sealed class LottoResult {
    sealed class SuccessStep<out T>(val data: T) : LottoResult() {
        data class InputAmountStep(val amount: ViewAmount) : SuccessStep<ViewAmount>(amount)

        data class InputManualStep(val manual: ViewManual) : SuccessStep<ViewManual>(manual)

        data class InputLastWeekNumbersStep(val lastWeekNumbers: ViewLastWeekNumbers) : SuccessStep<ViewLastWeekNumbers>(lastWeekNumbers)

        data class InputBonusNumberStep(val bonusNumber: ViewBonusNumber) : SuccessStep<ViewBonusNumber>(bonusNumber)
    }

    sealed class Error(val message: String) : LottoResult() {
        data class CustomError(val errorDetails: String) : Error(errorDetails)
    }
}
