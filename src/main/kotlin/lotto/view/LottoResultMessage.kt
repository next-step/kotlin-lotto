package lotto.view

enum class LottoResultMessage(private val message: String) {
    PROFIT("이득이"),
    PRINCIPAL("본전이"),
    LOSS("손해");

    companion object {
        private const val PRINCIPAL_RATE = 1
        fun message(rateOfReturn: Float): String {
            if (rateOfReturn > PRINCIPAL_RATE) {
                return PROFIT.message
            }
            return if (rateOfReturn == PRINCIPAL_RATE.toFloat()) {
                PRINCIPAL.message
            } else LOSS.message
        }
    }
}
