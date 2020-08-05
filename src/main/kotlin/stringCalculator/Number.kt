package stringCalculator

class Number(private val _number: Int = 0) {
    constructor(_number: String) : this(_number.toInt())

    var number: Int = 0
        private set

    init {
        require(number >= 0) { "number 값은 0 이상의 값만 가능합니다." }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Number

        if (_number != other._number) return false
        if (number != other.number) return false

        return true
    }

    override fun hashCode(): Int {
        var result = _number
        result = 31 * result + number
        return result
    }
}
