package stringCalculator.view

sealed class SealedResult {
    data class Failure(val msg: String, val exception: Exception) : SealedResult()
}

fun showMessage(msg: String, e: Exception) {
    SealedResult.Failure(msg = msg, exception = e)
}
