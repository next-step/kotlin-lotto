package lotto.domain

object InputValidateChecker {
    private val unsignedNumberRegex = "\\d*".toRegex()

    fun isUnsignedInt(numberOfString: String) = numberOfString.matches(unsignedNumberRegex)
}
