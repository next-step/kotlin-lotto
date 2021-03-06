package calculator

class Number(private val value: Int) {

    constructor(value: String) : this(
        value.toIntOrNull() ?: throw IllegalArgumentException("허용하지 않는 문자열입니다. value: $value")
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Number

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value
    }
}
