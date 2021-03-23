package lotto.domain

class LottoNumber private constructor(private val value: Int) {

    override fun equals(other: Any?): Boolean {
        return other.hashCode() == this.hashCode()
    }

    override fun hashCode(): Int {
        return value
    }

    override fun toString(): String {
        return value.toString()
    }

    companion object {
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45

        fun from(value: Int): LottoNumber {
            return (MINIMUM_NUMBER..MAXIMUM_NUMBER).associateWith(::LottoNumber)[value]
                ?: throw IllegalArgumentException("$value 로또 번호에 포함되지 않는 숫자 입니다")
        }
    }
}
