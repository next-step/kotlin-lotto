package lotto.domain

import java.util.concurrent.ConcurrentHashMap

@JvmInline
value class LottoNumber private constructor(val value: Int) {

    init {
        require(value.inValidRange()) { "로또 번호는 $MINIMUM~$MAXIMUM 사이의 수여야 합니다." }
    }

    override fun toString(): String {
        return value.toString()
    }

    companion object {
        const val MINIMUM = 1
        const val MAXIMUM = 45

        private val lottoNumberMap = ConcurrentHashMap<Int, LottoNumber>()

        operator fun get(value: Int): LottoNumber {
            return lottoNumberMap.getOrPut(value) {
                LottoNumber(value)
            }
        }

        private fun Int.inValidRange(): Boolean = this in MINIMUM..MAXIMUM
    }
}
