package stringcalculator

data class Expression(
    val delimiter: Regex,
    val expression: String,
)
