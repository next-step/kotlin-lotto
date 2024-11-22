package stringcalculator

data class StringCalculateRequest(
    val delimiter: Delimiter,
    val payload: String,
)
