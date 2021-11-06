package stringcalculator.utils

val MatchResult.getCustomDelimiter: String
    get() = groupValues[1]

val MatchResult.getInput: String
    get() = groupValues[2]
