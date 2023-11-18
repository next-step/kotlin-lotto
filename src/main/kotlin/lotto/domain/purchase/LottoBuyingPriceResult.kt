package lotto.domain.purchase

sealed class LottoBuyingPriceResult {
    data class Success(val data: LottoBuyingPrice) : LottoBuyingPriceResult()
    data class Failure(val errorMessage: String) : LottoBuyingPriceResult()
}
