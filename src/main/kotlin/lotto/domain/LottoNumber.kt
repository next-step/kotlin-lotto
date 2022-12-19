package lotto.domain

import lotto.argumentError

data class LottoNumber(
    private val value: Int
) {

    init {
        check(value in MIN_LOTTO_NUM..MAX_LOTTO_NUM) {
            argumentError("로또 숫자는 1에서 45 사이어야합니다.")
        }
    }

    override fun toString(): String {
        return value.toString()
    }

    companion object {
        const val MIN_LOTTO_NUM = 1
        const val MAX_LOTTO_NUM = 45
    }
}
