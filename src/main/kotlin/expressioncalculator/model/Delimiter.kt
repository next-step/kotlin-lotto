package expressioncalculator.model

@JvmInline
value class Delimiter(val value: Regex) {
    constructor(pattern: String) : this(pattern.toRegex())
}
