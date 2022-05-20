package expressioncalculator.validator

sealed interface ValidateResult {
    object Success : ValidateResult
    object Failed : ValidateResult
}
